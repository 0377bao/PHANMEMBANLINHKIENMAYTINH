package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class DanhSachHoaDon {
	private ArrayList<HoaDon> ds;

	public DanhSachHoaDon() {
		ds = new ArrayList<HoaDon>();
	}
	
	public int timViTriHoaDon(HoaDon tim) {
		return ds.indexOf(tim);
	}
	
	public boolean themHoaDon(HoaDon them) {
		if(ds.contains(them)) return false;
		ds.add(them);
		return true;
	}
	
	public boolean xoaHoaDon(HoaDon xoa) {
		if(!ds.contains(xoa)) return false;	
		ds.remove(timViTriHoaDon(xoa));
		return true;
	}
	
	public void suaHoaDon(int index, HoaDon sua) {
		ds.set(index, sua);
	}
	
	public HoaDon timKiemHoaDon(HoaDon tim) {
		return ds.get(timViTriHoaDon(tim));
	}
	
	public ArrayList<HoaDon> xuatDanhSachHoaDonLapBoiNhanVien(NhanVien nv) {
		ArrayList<HoaDon> dstemp = new ArrayList<HoaDon>();
		for (HoaDon hoaDon : ds) {
			if(hoaDon.getNhanVien().equals(nv)) dstemp.add(hoaDon);
		}
		return dstemp;
	}
	
	public ArrayList<HoaDon> xuatDanhSachHoaDonCuaKhachHang(KhachHang kh) {
		ArrayList<HoaDon> dstemp = new ArrayList<HoaDon>();
		for (HoaDon hoaDon : ds) {
			if(hoaDon.getKhachHang().equals(kh)) dstemp.add(hoaDon);
		}
		return dstemp;
	}
	
	public ArrayList<HoaDon> xuatDanhSachHoaDonLapVaoNgay(LocalDate date) {
		ArrayList<HoaDon> dstemp = new ArrayList<HoaDon>();
		for (HoaDon hoaDon : ds) {
			if(hoaDon.getNgayLapHoaDon().isEqual(date)) dstemp.add(hoaDon);
		}
		return dstemp;
	}
	
	public ArrayList<HoaDon> xuatDanhSachHoaDonLapTrongNam(int nam) {
		ArrayList<HoaDon> dstemp = new ArrayList<HoaDon>();
		for (HoaDon hoaDon : ds) {
			int namlap = hoaDon.getNgayLapHoaDon().getYear();
			if(namlap == nam) dstemp.add(hoaDon);
		}
		return dstemp;
	}
	
	public ArrayList<HoaDon> xuatDanhSachHoaDonLapTrongThang(int thang, int nam) {
		ArrayList<HoaDon> dstemp = new ArrayList<HoaDon>();
		for (HoaDon hoaDon : this.xuatDanhSachHoaDonLapTrongNam(nam)) {
			int thanglap = hoaDon.getNgayLapHoaDon().getMonthValue();
			if(thanglap == thang) dstemp.add(hoaDon);
		}
		return dstemp;
	}
	
	public double doanhThuTrongThang(int thang, int nam) {
		double doanhthu = 0;
		for (HoaDon hoaDon : this.xuatDanhSachHoaDonLapTrongThang(thang, nam)) {
			doanhthu += hoaDon.tinhTienCanThanhToan();
		}
		return doanhthu;
	}
	
	public int demSoHoaDon() {
		return ds.size();
	}
}
