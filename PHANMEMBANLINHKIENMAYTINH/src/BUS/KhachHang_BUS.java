package BUS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.KhachHang_DAO;

import connectDB.ConnectDB;

import model.HoaDon;

import model.KhachHang;


public class KhachHang_BUS {
	public static String mes = "";
	KhachHang_DAO kh_DAO = new KhachHang_DAO();
	public ArrayList<KhachHang> getAllKhachHang(){
		return kh_DAO.getAllKhachHang();
	}
	public boolean valiData(String tenKH, String sDT, String emailKH,String diaChi, boolean nam, boolean nu) {
		String ten = tenKH.trim();
		String sdt = sDT.trim();
		String email = emailKH.trim();
		String diachi = diaChi.trim();
		boolean phai = false;
		if(nam || nu) phai = true;
		if(ten.equals("") || sdt.equals("") || email.equals("") || diachi.equals("") || !phai) {
			mes = "Vui lòng điền đầy đủ thông tin";
			return false;
		}else if(ten.equals("")||!ten.matches("[\\p{L}\\s]+")) {
			mes = "Lỗi tên khách hàng phải là chữ";
			return false;
		}else if(sdt.equals("")||!sdt.matches("^0[379]\\d{8}$")) {
			mes = "Lỗi số điện thoại phải 10 số và bắt đầu bằng 03 hoặc 09 hoặc 07";
			return false;
		}else if(email.equals("")||!email.matches("[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			mes = "Lỗi email không đúng định dạng";
			return false;
		}else if(diachi.equals("")||!diachi.matches("[\\p{L}\\d\\s,-.?]+")) {
			mes = "Lỗi địa chỉ không đúng định dạng";
			return false;
		}else return true;
	}
	
	public String ranDomMaKhachHang() {
		String maold = kh_DAO.getMaKhachHangMax();
		int so = Integer.parseInt(maold.replace("KH", "").trim());
		so++;
		return "KH" + so;
	}

	public boolean themKhachHang (KhachHang kh) {
		kh_DAO.themKhachHang(kh);
		return true;
	}
	
	public void capNhatDiemTichLuyKhachHang(HoaDon hoaDon) {
		kh_DAO.capNhatDiemTichLuyKhachHang(hoaDon.getKhachHang().getMa(), hoaDon.getKhachHang().getDiemTichLuy());
	}
	
	
}
