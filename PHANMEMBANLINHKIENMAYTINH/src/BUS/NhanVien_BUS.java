package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.NhanVien_DAO;
import connectDB.ConnectDB;
import model.NhanVien;

public class NhanVien_BUS {
	NhanVien_DAO nv_dao = new NhanVien_DAO();
	
	public ArrayList<NhanVien> getAllNhanVien() {
		return nv_dao.getAllNhanVien();
	}
	
	public NhanVien kiemTraDangNhap(String user, String password) {
		ArrayList<NhanVien> ds = nv_dao.getAllNhanVien();
		for (NhanVien nv : ds) {
			if(nv.getMa().equals(user)) {
				if(nv.getMatkhau().equals(password)) return nv;
				else return null;
			}
		}
		return null;
	}
	
	public NhanVien getNhanVienByMaNhanVien(String maNhanVien) {
		return nv_dao.getNhanVienByMaNhanVien(maNhanVien);
	}
	public NhanVien_BUS() {
		nv_dao = new NhanVien_DAO();
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	

	
	public boolean themNhanVien(NhanVien nv) {
		boolean success = nv_dao.themNhanVien(nv);
		System.out.println(success);
		return success;
		
	}
	
	public ArrayList<NhanVien> timTheoMaNhanVien(String ma){
		return nv_dao.timNhanVienTheoMa(ma);
	}
//
//	public ArrayList<NhanVien> timTheoGioiTinh(boolean gioiTinh){
//		return nv_dao.timTheoGioiTinh(gioiTinh);
//	}
	public ArrayList<NhanVien> timTheoGioiTinh(ArrayList<NhanVien> danhSach, boolean gioiTinh) {
	    ArrayList<NhanVien> ketQua = new ArrayList<NhanVien>();
	    for (NhanVien nhanVien : danhSach) {
	        if (nhanVien.isGioiTinh() == gioiTinh) {
	            ketQua.add(nhanVien);
	        }
	    }
	    return ketQua;
	}

	public ArrayList<NhanVien> timTheoChucVu(ArrayList<NhanVien> danhSach, String chucVu) {
	    ArrayList<NhanVien> ketQua = new ArrayList<NhanVien>();
	    for (NhanVien nhanVien : danhSach) {
	        if (nhanVien.getChucVu().equals(chucVu)) {
	            ketQua.add(nhanVien);
	        }
	    }
	    return ketQua;
	}

//	public ArrayList<NhanVien> timTheoChucVu(String chucVu){
//		return nv_dao.timTheoChucVu(chucVu);
//	}
	public boolean xoaNhanVien(String ma) {
		boolean susess = nv_dao.xoaNhanVien(ma);
		
		
		return susess;
	}
	public boolean suaNhanVien(NhanVien nv) {
		boolean success = nv_dao.suaNhanVien(nv);
		return success;
	    
	}
	
	public String ranDomMaKhachHang() {
		String maold = nv_dao.getMaNhanVienMax();
		int so = Integer.parseInt(maold.replace("NV", "").trim());
		so++;
		return "NV" + so;
	}
	
	
}
