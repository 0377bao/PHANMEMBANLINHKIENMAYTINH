package BUS;



import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import DAO.NhanVien_DAO;
import DAO.SanPham_DAO;
import model.Case;
import model.Cpu;
import model.Main;
import model.Psu;
import model.Ram;
import model.SanPham;
import model.Vga;

public class SanPham_BUS {
	 private SanPham_DAO sp_dao = new SanPham_DAO();
	
	 // đọc dữ liệu vào table lúc khởi động ứng dụng
     public void DocDuLieuVaoTableSanPham(DefaultTableModel model) {
    	 ArrayList<SanPham> ds = sp_dao.getAllSanPham();
    	 for (SanPham sp : ds) {
			if(sp != null) {
				model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), sp.getGiaBan(), sp.getSoLuongTonKho(), sp.getNhaSanXuat(), sp.getNgaySanXuat(), sp.getBaoHanh(), sp.getGiaNhap(), sp.getGiamGia()});
			}
		}
     }
     public ArrayList<SanPham> getDSanPhams() {
    	 return sp_dao.getAllSanPham();
     }
     
     public boolean themSanPham_Cpu(Cpu them) {
    	return sp_dao.themSanPham_Cpu(them);
     }
     
     public boolean themSanPham_Vga(Vga them) {
     	return sp_dao.themSanPham_Vga(them);
      }
     
     public boolean themSanPham_Psu(Psu them) {
     	return sp_dao.themSanPham_Psu(them);
      }
     
     
     public boolean themSanPham_Main(Main them) {
     	return sp_dao.themSanPham_Main(them);
      }
     
     public boolean themSanPham_Case(Case them) {
     	return sp_dao.themSanPham_Case(them);
      }
     
     public boolean themSanPham_Ram(Ram them) {
     	return sp_dao.themSanPham_Ram(them);
     }
     
     public String getLoaiSanPham(String ma) {
    	 return sp_dao.timLoaiSanPhamTheoMa(ma);
     }
     
     public ArrayList<Cpu> getDSCPU() {
    	 return sp_dao.getAllCpu();
     }
     
     
     public ArrayList<Main> getDSMAIN() {
    	 return sp_dao.getAllMain();
     }
     
     
     public ArrayList<Vga> getDSVGA() {
    	 return sp_dao.getAllVga();
     }
     
     
     public ArrayList<Psu> getDSPSU() {
    	 return sp_dao.getAllPsu();
     }
     
     
     public ArrayList<Ram> getDSRAM() {
    	 return sp_dao.getAllRam();
     }
     
     
     public ArrayList<Case> getDSCASE() {
    	 return sp_dao.getAllCase();
     }
     
     // validate dữ liệu trong
     public boolean Validate_sanpham(String maSP, String tenSP, String giaBan, String slt, String baoHanh, String giaNhap, String giamGia) {
    	 if(maSP.equals("") || tenSP.equals("") || giaBan.equals("") || slt.equals("")
    			 || baoHanh.equals("") || giamGia.equals("") || giaNhap.equals("")) {
    		 return false;
    	 }
    	 return true;
     }
     
     // validate cpu
     public boolean validate_cpu(String soLoi, String soLuong, String tanSoCoSo, String tanSoTurbo, String boNhoDem, String boNhoToiDa) {
    	 if(soLoi.equals("") || soLuong.equals("") || tanSoCoSo.equals("") || tanSoTurbo.equals("") ||
    			 boNhoDem.equals("") || boNhoToiDa.equals("")) {
    		 return false;
    	 } 
    	 return true;
     }
     
     // validate vga
     public boolean validate_vga(String tienTrinh, String tdp, String cudaCore) {
    	 if(tienTrinh.equals("") || tdp.equals("") || cudaCore.equals("")) {
    		 return false;
    	 }
    	 return true;
     }
     
     // validate psu
     public boolean validate_psu(String congSuat, String hieuSuat, String tuoiTho) {
    	 if(congSuat.equals("") || hieuSuat.equals("") || tuoiTho.equals("")) {
    		 return false;
    	 }
    	 return true;
     }
     // validate main
     public boolean validate_main(String chipSet, String ramHoTro, String cpuHoTro, String doHoa, String oCungHoTro) {
    	 if(chipSet.equals("") || ramHoTro.equals("") || cpuHoTro.equals("") ||
    			 doHoa.equals("") || oCungHoTro.equals("")) {
    		 return false;
    	 }
    	 return true;
     }
     
     //case 
     public boolean validate_case(String mauSac, String tuongThich) {
    	 if(mauSac.equals("") || tuongThich.equals("")) {
    		 return false;
    	 }
    	 return true;
     }
     
     // ram
     public boolean validate_ram(String dungLuong, String tocDo) {
    	 if(dungLuong.equals("") || tocDo.equals("")) {
    		 return false;
    	 }
    	 return true;
     }
     
     // xóa sản phẩm
     public boolean xoaSanPhamTheoMa(String ma, String key) {
    	 switch(key) {
    	 case "CPU": {
    		 try {
    			 sp_dao.xoaSanPham_Cpu(ma);    			 
    		 }catch(Exception e) {
    			 e.printStackTrace();
    		 }
    		 return true;
    	 }
    	 case "VGA": {
    		 try {
    			 sp_dao.xoaSanPham_Vga(ma);
    		 }catch(Exception e) {
    			 e.printStackTrace();
    		 }
    		 return true;
    	 }
    	 case "MAIN": {
    		 try {
    			 sp_dao.xoaSanPham_Main(ma);
    		 }catch(Exception e) {
    			 e.printStackTrace();
    		 }
    		 return true;
    	 }
    	 case "PSU": {
    		 try {
    			 sp_dao.xoaSanPham_Psu(ma);
    		 }catch(Exception e) {
    			 e.printStackTrace();
    		 }
    		 return true;
    	 }
    	 case "CASE": {
    		 try {
    			 sp_dao.xoaSanPham_Case(ma);
    		 }catch(Exception e) {
    			 e.printStackTrace();
    		 }
    		 return true;
    	 }
    	 case "RAM": {
    		 try {
    			 sp_dao.xoaSanPham_Ram(ma);
    		 }catch(Exception e) {
    			 e.printStackTrace();
    		 }
    		 return true;
    	 }
    	 }
    	 return true;
     }
     
     // update cpu
     public boolean update_cpu(SanPham s, Cpu u) {
    	 sp_dao.updateSanPham_cpu(s, u);
    	 return true;
     } 
     
     
     // lọc theo loại sản phẩm
     public void locTheoLoaiSanPham(String loai, DefaultTableModel model) {
    	 if(loai.equals("Tất cả")) {
    		 model.setRowCount(0);
    		 DocDuLieuVaoTableSanPham(model);
    	 }else {
    		 ArrayList<SanPham> ds = sp_dao.getALLSanPhamTheoLoai(loai);
    		 model.setRowCount(0);
    		 for (SanPham sp : ds) {	
    			 model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), sp.getGiaBan(), sp.getSoLuongTonKho(), sp.getNhaSanXuat(), sp.getNgaySanXuat(), sp.getBaoHanh(), sp.getGiaNhap(), sp.getGiamGia()});
    		 }    		 
    	 }
     }
     
     // lọc theo nhà sản xuất
     public void locTheoNhaSanXuat(String key, DefaultTableModel model) {
    	 if(key.equals("Tất cả")) {
    		 model.setRowCount(0);
    		 DocDuLieuVaoTableSanPham(model);
    	 }else {
    		 ArrayList<SanPham> ds_temp = sp_dao.getAllSanPham();
    		 model.setRowCount(0);
    		 for (SanPham sp : ds_temp) {
    			 if(sp.getNhaSanXuat().equals(key)) {
    				 model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), sp.getGiaBan(), sp.getSoLuongTonKho(), sp.getNhaSanXuat(), sp.getNgaySanXuat(), sp.getBaoHanh(), sp.getGiaNhap(), sp.getGiamGia()});
    			 }
    		 }
    		 
    	 }
    	 
     }
     
     // hàm cắt chuỗi giá tiền
     public int giaTienBatDau(String gia) {
    	 String t = "";
    	 char[]c = gia.toCharArray();
    	 for (char d : c) {
			if(d == '-') {
				break;
			}else if(d == '.') {
				d = ' ';
			}else {
				t += d;
			}
			
		}
    	 int result = Integer.parseInt(t.trim());
    	 return result;
     }
     

}
