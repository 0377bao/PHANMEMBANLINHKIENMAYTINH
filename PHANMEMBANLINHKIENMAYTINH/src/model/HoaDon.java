package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private LocalDate ngayLapHoaDon;
	private double tienKhachTra;
	private ArrayList<ChiTietHoaDon> dsChiTietHoaDon;
	private String hinhThucThanhToan;
	private String ghiChu;
	private double thueVAT;
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
		this.thueVAT = thueVAT;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		dsChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
	}
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	String getMaHoaDon() {
		return maHoaDon;
	}
	void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	double getTienKhachTra() {
		return tienKhachTra;
	}
	void setTienKhachTra(double tienKhachTra) {
		this.tienKhachTra = tienKhachTra;
	}
	ArrayList<ChiTietHoaDon> getDsChiTietHoaDon() {
		return dsChiTietHoaDon;
	}
	void setDsChiTietHoaDon(ArrayList<ChiTietHoaDon> dsChiTietHoaDon) {
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}
	String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	String getGhiChu() {
		return ghiChu;
	}
	void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	double getThueVAT() {
		return thueVAT;
	}
	void setThueVAT(double thueVAT) {
		this.thueVAT = thueVAT;
	}
	KhachHang getKhachHang() {
		return khachHang;
	}
	void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	NhanVien getNhanVien() {
		return nhanVien;
	}
	void setNhanVien(NhanVien nhanVien) {
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
	
	public boolean xoaChiTietHoaDon(ChiTietHoaDon chiTietHD) {
		if(!this.dsChiTietHoaDon.contains(chiTietHD)) {
			return false;
		}
		dsChiTietHoaDon.remove(this.dsChiTietHoaDon.indexOf(chiTietHD));
		return true;
	}
	
	public void suaChiTietHoaDon(int index, ChiTietHoaDon chiTietHD) {
		dsChiTietHoaDon.set(index, chiTietHD);
	}
	
	public double tinhTongTien() {
		double tongTien = 0;
		for (ChiTietHoaDon chiTietHoaDon : dsChiTietHoaDon) {
			tongTien += chiTietHoaDon.tinhTongTien();
		}
		return tongTien;
	}
	
	public double tinhThue() {
		return this.tinhTongTien() * thueVAT;
	}
	
	public double tinhTienCanThanhToan() {
		return this.tinhTongTien() - this.tinhThue() - this.giamGia();
	}
	
	public double tinhTienThua() {
		return this.tienKhachTra - this.tinhTienCanThanhToan();
	}
	
	public double giamGia() {
		return this.getKhachHang().getDiemTichLuy() / 1000 * 100000;
	}
	
	public void capNhatSauKhiThanhToan(int diemTichLuy) {
		this.khachHang.setDiemTichLuy(this.khachHang.getDiemTichLuy() - diemTichLuy);
		
		congDiemKhachHang();
		capNhatSoLuongTonKho();
	}
	
	public void congDiemKhachHang() {
		// hóa đơn 1tr cộng 200 điểm
		// hóa đơn 2tr cộng 500 điểm
		// hóa đơn 5tr cộng 1300 điểm
		// hóa đơn 10tr cộng 3000 điểm
		double diemCong = 0;
		if(this.tinhTongTien() >= 10000000) diemCong = 3000; 
		else if(this.tinhTongTien() >= 5000000) diemCong = 1300;
		else if(this.tinhTongTien() >= 2000000) diemCong = 500;
		else if(this.tinhTongTien() >= 1000000) diemCong = 200;
		else diemCong = 0;
		this.khachHang.setDiemTichLuy(this.khachHang.getDiemTichLuy() + diemCong);
	}
	
	public void capNhatSoLuongTonKho() {
		for (ChiTietHoaDon chiTietHoaDon : dsChiTietHoaDon) {
			int soLuongTonKho = chiTietHoaDon.getSanPham().getSoLuongTonKho();
			int soLuongMua = chiTietHoaDon.getSoLuongMua();
			chiTietHoaDon.getSanPham().setSoLuongTonKho(soLuongTonKho - soLuongMua);
		}
	}
	
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", tienKhachTra=" + tienKhachTra
				+ ", dsChiTietHoaDon=" + dsChiTietHoaDon + ", hinhThucThanhToan=" + hinhThucThanhToan + ", ghiChu="
				+ ghiChu + ", thueVAT=" + thueVAT + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + "]";
	}
}
