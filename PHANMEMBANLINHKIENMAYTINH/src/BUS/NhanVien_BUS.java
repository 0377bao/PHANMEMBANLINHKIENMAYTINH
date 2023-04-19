package BUS;

import java.util.ArrayList;

import DAO.NhanVien_DAO;
import model.NhanVien;

public class NhanVien_BUS {
      private NhanVien_DAO nv_dao = new NhanVien_DAO();
      
      public NhanVien kiemTraDangNhap(String u, String p) {
    	  ArrayList<NhanVien> list_nv = nv_dao.getAllNhanVien();
    	  for (NhanVien nv : list_nv) {
			if(nv.getMa().equals(u) && nv.getMatkhau().equals(p)) {
				return nv;
			}
		}
    	  return null;
      }
}
