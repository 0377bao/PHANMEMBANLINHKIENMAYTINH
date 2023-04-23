package BUS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.KhachHang_DAO;
import connectDB.ConnectDB;
import model.KhachHang;


public class KhachHang_BUS {
	public KhachHang_BUS() {
		// TODO Auto-generated constructor stub
	}
	KhachHang_DAO kh_DAO = new KhachHang_DAO();
	public ArrayList<KhachHang> getDSKhachHang(){
		return kh_DAO.getAllKhachHang();
	}
	public boolean valiData(String maKH, String tenKH, String sDT, String gioiTinh, String emailKH,String diaChi) {
		String ma = maKH.trim();
		String ten = tenKH.trim();
		String sdt = sDT.trim();
		String phai = gioiTinh.trim();
		String email = emailKH.trim();
		String diachi = diaChi.trim();
		
		
		
		return true;
	}
	public KhachHang createKhachHang(String maKH, String tenKH, String sDT, String gioiTinh, String emailKH,String diaChi) {
		boolean phai;
		if(gioiTinh.equalsIgnoreCase("Nam")) {
			phai = true;
		}else {
			phai = false;
		}
		if(valiData(maKH, tenKH, sDT, gioiTinh, emailKH, diaChi)) {
		KhachHang kh = new KhachHang(maKH, tenKH, sDT, phai, emailKH, diaChi, 0);
			return kh;
		}else {
			return null;
		}
	}
	public boolean themNhanVien (KhachHang kh) {
		
		
		return true;
	}
	
	public String ranDomMaKhachHang() {
		String maold = kh_DAO.getMaKhachHangMax();
		int so = Integer.parseInt(maold.replace("KH", "").trim());
		so++;
		return "KH" + so;
	}
}
