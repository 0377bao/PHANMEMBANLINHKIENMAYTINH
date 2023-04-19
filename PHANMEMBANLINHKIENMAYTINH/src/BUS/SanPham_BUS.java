package BUS;


import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import DAO.SanPham_DAO;
import model.Cpu;
import model.SanPham;

public class SanPham_BUS {
	 private SanPham_DAO sp_dao = new SanPham_DAO();
	
     public void DocDuLieuVaoTableSanPham(DefaultTableModel model) {
    	 ArrayList<SanPham> ds = sp_dao.getAllSanPham();
    	 for (SanPham sp : ds) {
			if(sp != null) {
				model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), sp.getGiaBan(), sp.getSoLuongTonKho(), sp.getNhaSanXuat(), sp.getNgaySanXuat(), sp.getBaoHanh(), sp.getGiaNhap(), sp.getGiamGia()});
			}
		}
     }
     
     public boolean themSanPham(Cpu them, ArrayList<SanPham> l) {
    	 boolean flag = false;
    	 for (SanPham sp : l) {
			if(sp.getMaSanPham().equals(them.getMaSanPham())) {
				return flag;
			}else {
				SanPham_DAO sp_dao = new SanPham_DAO();
				sp_dao.themSanPham_Cpu(them);			
				flag = true;
			}
         }
    	 return flag;
     }
}
