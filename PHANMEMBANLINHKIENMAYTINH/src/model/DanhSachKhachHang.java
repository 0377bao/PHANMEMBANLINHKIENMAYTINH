package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachKhachHang {
	ArrayList<KhachHang> dsKhachHang;

	public DanhSachKhachHang() {
		this.dsKhachHang = new ArrayList<KhachHang>();
	}

public boolean themKhachHang(KhachHang kH) {
	if(!dsKhachHang.contains(kH)) {
		dsKhachHang.add(kH);
		return true;
	}
	return false;
}

public boolean xoaKhachHang(String maKH) {
	KhachHang kH=new KhachHang(maKH);
	if(dsKhachHang.contains(kH)) {
		dsKhachHang.remove(kH);
		return true;
	}
	return false;
}
public boolean suaKhachHang(KhachHang kH) {
	for(int i=0;i<dsKhachHang.size();++i) {
		if(dsKhachHang.get(i).getMa().equals(kH.getMa())) {
			dsKhachHang.get(i).setDiaChi(kH.getDiaChi());
			dsKhachHang.get(i).setDiemTichLuy(kH.getDiemTichLuy());
			dsKhachHang.get(i).setEmail(kH.getEmail());
			dsKhachHang.get(i).setGioiTinh(kH.isGioiTinh());
			dsKhachHang.get(i).setSDT(kH.getSDT());
			dsKhachHang.get(i).setTen(kH.getTen());
			return true;
		}
	}return false;
}
public KhachHang timKiemKhachHang(String ma) {
	for(KhachHang temp : dsKhachHang) {
		if(temp.getMa().equals(ma)) {
			return temp;
		}
	}
	return null;
}
public ArrayList<KhachHang> getDsKhachHang(){
	return dsKhachHang;
}
public ArrayList<KhachHang> getDsKhachHangSapXepTheoDTL(){
	ArrayList<KhachHang> list = dsKhachHang;
	Collections.sort( list, new Comparator<KhachHang>() {

		@Override
		public int compare(KhachHang o1, KhachHang o2) {
			// TODO Auto-generated method stub
			
			return (int)(o1.getDiemTichLuy()-o2.getDiemTichLuy());
		}
	});
	return list;
}
}
