package BUS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.HoaDon_DAO;
import connectDB.ConnectDB;
import model.HoaDon;

public class HoaDon_BUS {
	private HoaDon_DAO hddao = new HoaDon_DAO();
	
	public boolean themHoaDon(HoaDon hoadon) {
		return hddao.themHoaDon(hoadon);
	}
	
	public String ranDomMaHoaDon() {
		int so = hddao.getMaHoaDonMax();
		so++;
		return "HD" + so;
	}
	public ArrayList<HoaDon> getAllHoaDon() {
		return hddao.getAllHoaDon();
	}
	
	public HoaDon getHoaDonByMaHoaDon(String maHoaDon) {
		return hddao.getHoaDonByMaHoaDon(maHoaDon);
	}
	
	public double tinhTongDoanhThu(ArrayList<HoaDon> ds) {
		double doanhthu = 0;
		for (HoaDon hoaDon : ds) {
			doanhthu += hoaDon.tinhTienCanThanhToan();
		}
		return doanhthu;
	}
	
	public int soHoaDon(ArrayList<HoaDon> ds) {
		return ds.size();
	}
	
	public int tongSoKhachHang(ArrayList<HoaDon> ds) {
		int soKhachHang = 0;
		for(int i = 0; i < ds.size(); i++) {
			boolean flag = true;
			for(int j = i - 1; j >= 0; j--) {
				if(ds.get(i).getKhachHang().getMa().equals(ds.get(j).getKhachHang().getMa())){
					flag = false;
					break;
				}
			}
			if(flag) soKhachHang++;
		}
		return soKhachHang;
	}
}
