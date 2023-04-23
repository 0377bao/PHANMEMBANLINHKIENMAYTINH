package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private LocalDate ngayLapHoaDon;
	private double tienKhachTra;
	private ArrayList<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<>();
	private String hinhThucThanhToan;
	private String ghiChu;
	private final double THUEVAT = 0.1;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	public HoaDon(String maHoaDon, LocalDate ngayLapHoaDon, double tienKhachTra, String hinhThucThanhToan,
			String ghiChu, double thueVAT, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tienKhachTra = tienKhachTra;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.ghiChu = ghiChu;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public double getTienKhachTra() {
		return tienKhachTra;
	}
	public void setTienKhachTra(double tienKhachTra) {
		this.tienKhachTra = tienKhachTra;
	}
	public ArrayList<ChiTietHoaDon> getDsChiTietHoaDon() {
		return dsChiTietHoaDon;
	}
	public void setDsChiTietHoaDon(ArrayList<ChiTietHoaDon> dsChiTietHoaDon) {
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public double getThueVAT() {
		return THUEVAT;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHD) {
		if(this.dsChiTietHoaDon.contains(chiTietHD)) {
			return false;
		}
		dsChiTietHoaDon.add(chiTietHD);
		return true;
	}
	
	public boolean xoaChiTietHoaDon(SanPham sanPham) {
		if(this.timVTChiTietHoaDon(sanPham) == -1) {
			return false;
		}
		dsChiTietHoaDon.remove(this.timVTChiTietHoaDon(sanPham));
		return true;
	}
	
	public void suaChiTietHoaDon(int index, ChiTietHoaDon chiTietHD) {
		dsChiTietHoaDon.set(index, chiTietHD);
	}
	
	public int timVTChiTietHoaDon(SanPham chitiet) {
		for(int i = 0; i < this.dsChiTietHoaDon.size(); i++) {
			if(dsChiTietHoaDon.get(i).getSanPham().getMaSanPham().equals(chitiet.getMaSanPham()) ) {
				return i;
			}
		}
		return -1;
	}
	
	public ChiTietHoaDon timChiTietHoaDon(String ma) {
		return this.dsChiTietHoaDon.get(timVTChiTietHoaDon(new SanPham(ma)));
	}
	
	public double tinhTongTien() {
		double tongTien = 0;
		for (ChiTietHoaDon chiTietHoaDon : dsChiTietHoaDon) {
			tongTien += chiTietHoaDon.tinhTongTien();
		}
		return tongTien;
	}
	
	public double tinhThue() {
		return this.tinhTongTien() * THUEVAT;
	}
	
	public double tinhTienCanThanhToan() {
		return this.tinhTongTien() + this.tinhThue() - this.giamGia();
	}
	
	public double tinhTienThua() {
		return this.tienKhachTra - this.tinhTienCanThanhToan();
	}
	
	public double giamGia() {
		double tienGiam = this.getKhachHang().getDiemTichLuy() / 1000 * 100000;
		if(tienGiam > this.tinhTongTien()) return 0;
		return tienGiam;
	}
	
	public void capNhatDiemTichLuyChoKhachHang() {
		if(this.giamGia() != 0) {
			this.khachHang.setDiemTichLuy(0);
		}
		congDiemKhachHang();
	}
	
	public void congDiemKhachHang() {
		// hóa đơn 1tr cộng 200 điểm
		// hóa đơn 2tr cộng 500 điểm
		// hóa đơn 5tr cộng 1300 điểm
		// hóa đơn 10tr cộng 3000 điểm
		double diemCong = 0;
		if(this.tinhTongTien() >= 30000000) diemCong = 10000;
		else if(this.tinhTongTien() >= 20000000) diemCong = 6500;
		else if(this.tinhTongTien() >= 10000000) diemCong = 3000;
		else if(this.tinhTongTien() >= 5000000) diemCong = 1300;
		else if(this.tinhTongTien() >= 2000000) diemCong = 500;
		else if(this.tinhTongTien() >= 1000000) diemCong = 200;
		else diemCong = 0;
		this.khachHang.setDiemTichLuy(this.khachHang.getDiemTichLuy() + diemCong);
	}
	
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", tienKhachTra=" + tienKhachTra
				+ ", dsChiTietHoaDon=" + dsChiTietHoaDon + ", hinhThucThanhToan=" + hinhThucThanhToan + ", ghiChu="
				+ ghiChu + ", thueVAT=" + THUEVAT + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + "]";
	}
}
