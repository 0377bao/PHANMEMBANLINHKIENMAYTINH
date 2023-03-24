package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;


public class test {
    public static void main(String[] args) {
    	KhachHang kh1 = new KhachHang("01", null, null, false, null, null, 10);
    	KhachHang kh2 = new KhachHang("02", null, null, false, null, null, 2000);
    	KhachHang kh3 = new KhachHang("03", null, null, false, null, null, 1000);
    	DanhSachKhachHang ds = new DanhSachKhachHang();
    	
    	NhanVien nv1 = new NhanVien("1");
    	NhanVien nv2 = new NhanVien("2");
    	System.out.println(nv1);
    	
    	SanPham sanPham = new SanPham("01", null, 0, 0, null, null, 0, 0, 0);
    	SanPham sanPham1 = new SanPham("03", null, 10, 10, null, null, 0, 0, 0);
    	SanPham sanPham2 = new SanPham("03", null, 10, 10, null, null, 0, 0, 0);
    	
    	ChiTietHoaDon ct = new ChiTietHoaDon(1, sanPham);
    	ChiTietHoaDon ct1 = new ChiTietHoaDon(1, sanPham1);
    	ChiTietHoaDon ct2 = new ChiTietHoaDon(1, sanPham2);
    	
    	LocalDate d1 = LocalDate.of(2003, 8, 16);
    	
    	LocalDate d2 = LocalDate.of(2003, 8, 17);
    	HoaDon hd = new HoaDon("01", d1, 0, null, null, 0, kh3, nv1);
    	HoaDon hd2 = new HoaDon("02", d2, 0, null, null, 0, kh3, nv1);
    	HoaDon hd3 = new HoaDon("03", d1, 0, null, null, 0, kh3, nv2);
    	DanhSachHoaDon dshd = new DanhSachHoaDon();
    	System.out.println(dshd.themHoaDon(hd));
    	System.out.println(dshd.themHoaDon(hd2));
    	System.out.println(dshd.themHoaDon(hd3));
//    	for (HoaDon string : dshd.xuatDanhSachHoaDonLapVaoNgay(d2)) {
//			System.out.println(string);
//		}
	}
}
