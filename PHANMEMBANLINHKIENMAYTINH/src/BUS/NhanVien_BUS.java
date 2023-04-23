package BUS;

import java.util.ArrayList;

import DAO.NhanVien_DAO;
import model.NhanVien;

public class NhanVien_BUS {
	NhanVien_DAO nvdao = new NhanVien_DAO();
	
	public ArrayList<NhanVien> getAllNhanVien() {
		return nvdao.getAllNhanVien();
	}
	
	public NhanVien kiemTraDangNhap(String user, String password) {
		ArrayList<NhanVien> ds = nvdao.getAllNhanVien();
		for (NhanVien nv : ds) {
			if(nv.getMa().equals(user)) {
				if(nv.getMatkhau().equals(password)) return nv;
				else return null;
			}
		}
		return null;
	}
}
