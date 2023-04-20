package BUS;

import java.util.ArrayList;

import DAO.KhachHang_DAO;
import model.KhachHang;


public class KhachHang_BUS {
	public KhachHang_BUS() {
		// TODO Auto-generated constructor stub
	}
	KhachHang_DAO kh_DAO = new KhachHang_DAO();
	public static String mes = "a";
	public ArrayList<KhachHang> getDSKhachHang(){
		return kh_DAO.getAllKhachHang();
	}
	public boolean valiData( String tenKH, String sDT, String emailKH,String diaChi) {
		String ten = tenKH.trim();
		String sdt = sDT.trim();
		String email = emailKH.trim();
		String diachi = diaChi.trim();
		
		if(ten.equals("")||!ten.matches("\\+")) {
			mes = "Lỗi tên khách hàng phải là chữ và không được để rỗng";
			return false;
		}
		if(sdt.equals("")||!sdt.matches("^0[379]\\d{8}$")) {
			mes = "Lỗi số điện thoại phải 10 số và bắt đầu bằng 03 hoặc 09 hoặc 07 và không được để rỗng";
			return false;
		}
		if(email.equals("")||!email.matches("^(.+)@(\\S+)$")) {
			mes = "Lỗi email không đúng định dạng và không được để rỗng";
			return false;
		}
		if(diachi.equals("")||!diachi.matches("[A-Za-z0-9\\-\\./]+")) {
			mes = "Lỗi địa chỉ không đúng định dạng và không được để rỗng";
			return false;
		}
		
		return true;
	}
	

	public boolean themKhachHang (KhachHang kh) {
		kh_DAO.themKhachHang(kh);
		return true;
	}
}
