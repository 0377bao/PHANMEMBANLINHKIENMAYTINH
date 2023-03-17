package model;

import java.time.LocalDate;


public class test {
    public static void main(String[] args) {
    	KhachHang kh1 = new KhachHang("01", null, null, false, null, null, 10);
    	KhachHang kh2 = new KhachHang("02", null, null, false, null, null, 2000);
    	KhachHang kh3 = new KhachHang("03", null, null, false, null, null, 1000);
    	DanhSachKhachHang ds = new DanhSachKhachHang();
    	
    	System.out.println(ds.themKhachHang(kh1));    	
    	System.out.println(ds.themKhachHang(kh2));    	
    	System.out.println(ds.themKhachHang(kh3));
    	for (Object string : ds.getDsKhachHangSapXepTheoDTL()) {
			System.out.println(string);
		}
	}
}
