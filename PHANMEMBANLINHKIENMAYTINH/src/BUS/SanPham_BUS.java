package BUS;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import DAO.NhanVien_DAO;
import DAO.SanPham_DAO;
import connectDB.ConnectDB;
import model.Case;
import model.Cpu;

import model.ChiTietHoaDon;
import model.HoaDon;

import model.Main;
import model.Psu;
import model.Ram;
import model.SanPham;
import model.Vga;

public class SanPham_BUS {
     public static String message_sp="";
     public static String message_loai="";
	 private SanPham_DAO sp_dao = new SanPham_DAO();
	
	 // đọc dữ liệu vào table lúc khởi động ứng dụng
	public void DocDuLieuVaoTableSanPham(DefaultTableModel model) {
		ArrayList<SanPham> ds = sp_dao.getAllSanPham();
		for (SanPham sp : ds) {
			if(sp != null) {
				model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), String.format("%,.0f", sp.getGiaBan()), sp.getSoLuongTonKho(), sp.getNhaSanXuat(), sp.getNgaySanXuat(), sp.getBaoHanh(), String.format("%,.0f", sp.getGiaNhap()), String.format("%,.0f", Double.parseDouble(sp.getGiamGia()+""))});
			}
		}
     }
	
	public void DocDuLieuVaoTableSanPhams(DefaultTableModel model, ArrayList<SanPham> ds) {
		for (SanPham sp : ds) {
			if(sp != null) {
				model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), String.format("%,.0f", sp.getGiaBan()), sp.getSoLuongTonKho(), sp.getNhaSanXuat(), sp.getNgaySanXuat(), sp.getBaoHanh(), String.format("%,.0f", sp.getGiaNhap()), String.format("%,.0f", Double.parseDouble(sp.getGiamGia()+""))});
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
     
      // clear message
     public void xoaThongBaoLoi() {
    	 message_loai = "";
    	 message_sp = "";
     }
    
     
     // validate dữ liệu trong
     public boolean Validate_sanpham(String maSP, String tenSP, String giaBan, String slt, String baoHanh, String giaNhap, String giamGia) {
    	 int n = 0;
    	 if(maSP.equals("") || tenSP.equals("") || giaBan.equals("") || slt.equals("")
    			 || baoHanh.equals("") || giamGia.equals("") || giaNhap.equals("")) {
    		 message_sp += "Vui lòng điền đầy đủ các field của sản phẩm\n";
    		 return false;
    	 }
    	 giaBan = giaBan.replaceAll(",", "");
    	 giaNhap = giaNhap.replaceAll(",", "");
    	 giamGia = giamGia.replaceAll(",", "");
    	 if(checkSo_SP(giaBan, slt, baoHanh, giaNhap, giamGia)) {
    		 double a = Double.parseDouble(giaBan);
    		 double b = Double.parseDouble(giaNhap);
    		 if((Integer.parseInt(giamGia) < 0) || a < 0 || b < 0) {
    			 message_sp += "Giảm giá, giá nhập và giá bán không được là số âm\n";
    			 n--;
    		 }
    		 if(!maSP.matches("^(SP)\\d{1,}$")) {
    			 message_sp += "Mã sản phẩm bắt đầu bằng SP và theo sau là 3 ký số\n";
    			 n--;
    		 }
    		 if(!tenSP.matches("^[\\p{L}\\d .-/\\\\]+$")) {
    			 message_sp += "Tên sản phẩm không chứa kí tự đặc biệt\n";
    			 n--;
    		 }
    		 if(Integer.parseInt(slt) < 0) {
    			 message_sp += "Số lượng tồn phải là một số dương\n";
    			 n--;
    		 }
    		 if(Integer.parseInt(baoHanh) < 0) {
    			 message_sp += "Thời gian bảo hành phải là một số dương\n";
    			 n--;
    		 }
    	 }else {
    		 message_sp += "giá bán, số lượng tồn, giảm giá, giá nhập, bảo hành phải là kí tự số\n";
    		 n--;
    	 }
    	 return n >= 0;
     }
     
     public boolean checkSo(String soLoi, String soLuong, String tanSoCoSo, String tanSoTurbo, String boNhoDem, String boNhoToiDa) {
    	 try {
    		 int a = Integer.parseInt(soLoi);
    		 int b = Integer.parseInt(soLuong);
    		 int c = Integer.parseInt(boNhoDem);
    		 int d = Integer.parseInt(boNhoToiDa);
    		 double e = Double.parseDouble(tanSoCoSo);
    		 double f = Double.parseDouble(tanSoTurbo);
    		 return true;
    	 }catch(Exception e) {
    		 
    	 }
    	 return false;
     }
     
     public boolean checkSo_SP(String giaBan, String slt, String baoHanh, String giaNhap, String giamGia) {
    	 try {
    		  double giab = Double.parseDouble(giaBan);
    		  double gian = Double.parseDouble(giaNhap);
    		  int sluong = Integer.parseInt(slt);
    		  int baoH = Integer.parseInt(baoHanh);
    		  int giamG = Integer.parseInt(giamGia);
    		  return true;
    	 }catch(Exception e) {
    		 
    	 }
    	 return false;
     }
     
     // validate cpu
     public boolean validate_cpu(String soLoi, String soLuong, String tanSoCoSo, String tanSoTurbo, String boNhoDem, String boNhoToiDa) {
    	 int n = 0;
    	 if(soLoi.equals("") || soLuong.equals("") || tanSoCoSo.equals("") || tanSoTurbo.equals("") ||
    			 boNhoDem.equals("") || boNhoToiDa.equals("")) {
    		 message_loai += "Vui lòng điền đầy đủ chi tiết cpu\n";
    		 return false;
    	 }else {
    		 if(checkSo(soLoi, soLuong, tanSoCoSo, tanSoTurbo, boNhoDem, boNhoToiDa)) {
    			 double a = Double.parseDouble(tanSoCoSo); 
        		 double b = Double.parseDouble(tanSoTurbo);
        		 if(Integer.parseInt(soLoi) < 0 || Integer.parseInt(soLuong) < 0 || Integer.parseInt(boNhoDem) < 0 || Integer.parseInt(boNhoToiDa) < 0
        				 || a < 0 || b < 0) {
        			 message_loai += "Số lõi, số luồng, tần số cơ sở, tần số turbo, bộ nhớ đệm và bộ nhớ tối đa đều không được là số âm\n";	 
                      n--;    			 
        		 }
    		 }else {
    			 message_loai += "Số lõi, số luồng, tần số cơ sở, tần số turbo, bộ nhớ đệm và bộ nhớ tối đa phải là kí tự số";
    			 n--;
    		 }
    		
    	 }
    	 return n >= 0;
     }
     
     // validate vga
     public boolean validate_vga(String tienTrinh, String tdp, String cudaCore) {
    	 int n = 0;
    	 if(tienTrinh.equals("") || tdp.equals("") || cudaCore.equals("")) {
    		 message_loai += "Vui lòng điền đầy đủ thông tin chi tiết của Vga\n";
    		 return false;
    	 }
    	 if(tienTrinh.matches("^[\\d]+$") || tdp.matches("^[\\d]+$") || cudaCore.matches("^[\\d]+$")) {
    		 if(Integer.parseInt(cudaCore) < 0 || Integer.parseInt(tienTrinh) < 0 || Integer.parseInt(tdp) < 0) {
    			 message_loai += "Tiến trình, tdp và cudaCore đều không được là số âm\n";
    			 n--;
    		 }
    	 }else {
    		 message_loai += "Tiến trình, tdp và cudaCore phải là số\n";
    		 n--;
    	 }
    	
    	
    	 return n >= 0;
     }
     
     // validate psu
     public boolean validate_psu(String congSuat, String hieuSuat, String tuoiTho) {
    	 int n = 0;
    	 if(congSuat.equals("") || hieuSuat.equals("") || tuoiTho.equals("")) {
    		 message_loai += "Vui lòng điền đầy đủ thông tin chi tiết của Psu(cục nguồn)\n";
    		 return false;
    	 }
    	 if(hieuSuat.matches("^[\\d]+$") || congSuat.matches("^[\\d]+$") || tuoiTho.matches("^[\\d]+$") ){
    		 if(Integer.parseInt(hieuSuat) < 0 || Integer.parseInt(congSuat) < 0 || Integer.parseInt(tuoiTho) < 0) {
    			 message_loai += "Công suất, hiệu suất và tuổi thọ đều không được là số âm\n";
    			 n--;
    		 } 
    	 }else {
    		 message_loai += "Công suất, hiệu suất và tuổi thọ phải là kí tự số\n";
    		 n--;
    	 }
    	 return n >= 0;
     }
     // validate main
     public boolean validate_main(String chipSet, String ramHoTro, String cpuHoTro, String doHoa, String oCungHoTro) {

    	 int n = 0;
    	 System.out.println(doHoa);
    	 if(chipSet.equals("") || ramHoTro.equals("") || cpuHoTro.equals("") ||
    			 doHoa.equals("") || oCungHoTro.equals("")) {
    		 message_loai += "Vui lòng điền đầy đủ thông tin chi tiết của Main";
    		 return false;
    	 }
    	 if(!chipSet.matches("^[a-zA-Z0-9 ]+$")) {
    		 message_loai += "Tên ChipSet phải là chữ hoặc số, không có kí tự đặc biệt\n";
    		 n--;
    	 }
    	 if(!ramHoTro.matches("^[\\p{LD} x\\,\\:]+$")) {
    		 message_loai += "Tên Ram phải là chữ hoặc số, không có kí tự đặc biệt('/')\n";
    		 n--;
    	 }
    	 if(!cpuHoTro.matches("^[\\p{LD} \\-\\,\\.\\:]+$")) {
    		 message_loai += "Tên Cpu hỗ trợ phải là chữ hoặc số, không có kí tự ('@')\n";
    		 n--;
    	 }
    	 if(!doHoa.matches("^[\\p{LD} (x*\\.\\:\\-\\,)]+$")) {
    		 System.out.println(doHoa);
    		 message_loai += "Tên card đồ họa phải là chữ hoặc số, không có kí tự đặc biệt\n";
    		n--;
    	 }
    	 if(!oCungHoTro.trim().matches("^[\\p{LD} (a-zA-Z)/]+$")) {
    		 message_loai += "Tên của ổ cứng không chứa kí tự đặc biệt('@', '.')\n";
    		 n--;
    	 }
    	 return n >= 0;
     }
     
     //case 
     public boolean validate_case(String mauSac, String tuongThich) {
    	 int n = 0;
    	 if(mauSac.equals("") || tuongThich.equals("")) {
    		 message_loai += "Vui lòng điền đẩy đủ thông tin chi tiết của Case\n";
    		 return false;
    	 }
    	 if(!mauSac.matches("^[\\p{L} ]+$")) {
    		 message_loai += "Màu sắc chỉ gồm kí tự chữ\n";
    		 n--;
    	 }
    	 if(!tuongThich.matches("^[a-zA-Z0-9 x.]+$")) {
    		 message_loai += "Tương thích chỉ gồm kí tự chữ, kí tự số và dấu '.'\n";
    		 n--;
    	 }
    	 return n >= 0;
     }
     
     // ram
     public boolean validate_ram(String dungLuong, String tocDo) {
    	 int n = 0;
    	 if(dungLuong.equals("") || tocDo.equals("")) {
    		 message_loai += "Vui lòng điền đầy đủ thông tin chi tiết của Ram\n";
    		 return false;
    	 }
    	 if(tocDo.matches("^[\\d]+$") || dungLuong.matches("^[\\d]+$")) {
    		 if(Integer.parseInt(tocDo) < 0) {
    			 message_loai += "Tốc độ không được là số âm\n";
    			 n--;
    		 }
    		 if(Integer.parseInt(dungLuong) < 0) {
    			 message_loai += "Dung lượng không được là số âm\n";
    			 n--;
    		 
    		 }
    	 }else {
    		 message_loai += "Dung Lượng và Tốc độ phải là kí tự số\n";
    		 n--;
    	 }
    	 return n >= 0;
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
     // update vga
     public boolean update_vga(SanPham s, Vga v) {
    	 sp_dao.updateSanPham_vga(s, v);
    	 return true;
     } 
     //update case
     public boolean update_case(SanPham s, Case ca) {
    	 sp_dao.updateSanPham_Case(s, ca);
    	 return true;
     } 
     // update main
     public boolean update_main(SanPham s, Main m) {
    	 sp_dao.updateSanPham_Main(s, m);
    	 return true;
     } 
     // update ram
     public boolean update_ram(SanPham s, Ram r) {
    	 sp_dao.updateSanPham_Ram(s, r);
    	 return true;
     } 
     // update psu
     public boolean update_psu(SanPham s, Psu p) {
    	 sp_dao.updateSanPham_Psu(s, p);
    	 return true;
     } 
     
     
    // phát sinh mã tự động
     public String getMaTuDong() {
    	 return "SP" + (sp_dao.getMaSanPhamMax() + 1);
     }
     public boolean timKiemSanPham(String regex, SanPham s) {
    	 Pattern pMa = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    	 Matcher mMa = pMa.matcher(s.getMaSanPham());
    	 if(mMa.find()) {
    		 return true;
    	 }
    	 return false;
     }
     
     public ArrayList<SanPham> dsSauKhiTimKiem(String regex) {
    	 ArrayList<SanPham> ds_temp = sp_dao.getAllSanPham();
    	 ArrayList<SanPham> ds_timKiem = new ArrayList<SanPham>();
    	 for (SanPham sp : ds_temp) {
			if(timKiemSanPham(regex, sp)) {
				ds_timKiem.add(sp);
			}
		}	 
    	 return ds_timKiem;
     }

	public ArrayList<Case> getAllCase() {
		return sp_dao.getAllCase();
	}

	public ArrayList<Cpu> getAllCpu() {
		return sp_dao.getAllCpu();
	}

	public ArrayList<Main> getAllMain() {
		return sp_dao.getAllMain();
	}

	public ArrayList<Psu> getAllPsu() {
		return sp_dao.getAllPsu();
	}
	
	public ArrayList<Ram> getAllRam() {
		return sp_dao.getAllRam();
	}
	
	public ArrayList<Vga> getAllVga() {
		return sp_dao.getAllVga();
	}

	public SanPham timSanPhamTheoMa(String matim) {
		return sp_dao.timSanPhamTheoMa(matim);
	}
	
	public ArrayList<SanPham> getALLSanPhamTheoLoai(String loai) {
		return sp_dao.getALLSanPhamTheoLoai(loai);
	}

	public ArrayList<Case> dsSanPhamCaseSauKhiLoc(ArrayList<Case> ds, String regex) {
		ArrayList<Case> dsLoc = new ArrayList<>();
		for (Case sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	
	public void dsSanPhamCaseSauKhiLocNhaSX(ArrayList<Case> ds, String nhaSX) {
		ArrayList<Case> dsLoc = new ArrayList<>();
		for (Case sanPham : ds) {
			if(sanPham.getNhaSanXuat().equals(nhaSX)) dsLoc.add(sanPham);
		}
		ds.clear();
		ds.addAll(dsLoc);
	}
	
	public ArrayList<Main> dsSanPhamMainSauKhiLoc(ArrayList<Main> ds, String regex) {
		ArrayList<Main> dsLoc = new ArrayList<>();
		for (Main sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	
	public void dsSanPhamMainSauKhiLocNhaSX(ArrayList<Main> ds, String nhaSX) {
		ArrayList<Main> dsLoc = new ArrayList<>();
		for (Main sanPham : ds) {
			if(sanPham.getNhaSanXuat().equals(nhaSX)) dsLoc.add(sanPham);
		}
		ds.clear();
		ds.addAll(dsLoc);
	}
	
	public ArrayList<Cpu> dsSanPhamCpuSauKhiLoc(ArrayList<Cpu> ds, String regex) {
		ArrayList<Cpu> dsLoc = new ArrayList<>();
		for (Cpu sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	
	public void dsSanPhamCpuSauKhiLocNhaSX(ArrayList<Cpu> ds, String nhaSX) {
		ArrayList<Cpu> dsLoc = new ArrayList<>();
		for (Cpu sanPham : ds) {
			if(sanPham.getNhaSanXuat().equals(nhaSX)) dsLoc.add(sanPham);
		}
		ds.clear();
		ds.addAll(dsLoc);
	}
	
	public ArrayList<Ram> dsSanPhamRamSauKhiLoc(ArrayList<Ram> ds, String regex) {
		ArrayList<Ram> dsLoc = new ArrayList<>();
		for (Ram sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	
	public void dsSanPhamRamSauKhiLocNhaSX(ArrayList<Ram> ds, String nhaSX) {
		ArrayList<Ram> dsLoc = new ArrayList<>();
		for (Ram sanPham : ds) {
			if(sanPham.getNhaSanXuat().equals(nhaSX)) dsLoc.add(sanPham);
		}
		ds.clear();
		ds.addAll(dsLoc);
	}
	
	public ArrayList<Psu> dsSanPhamPsuSauKhiLoc(ArrayList<Psu> ds, String regex) {
		ArrayList<Psu> dsLoc = new ArrayList<>();
		for (Psu sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	
	public void dsSanPhamPsuSauKhiLocNhaSX(ArrayList<Psu> ds, String nhaSX) {
		ArrayList<Psu> dsLoc = new ArrayList<>();
		for (Psu sanPham : ds) {
			if(sanPham.getNhaSanXuat().equals(nhaSX)) dsLoc.add(sanPham);
		}
		ds.clear();
		ds.addAll(dsLoc);
	}
	
	public ArrayList<Vga> dsSanPhamVgaSauKhiLoc(ArrayList<Vga> ds, String regex) {
		ArrayList<Vga> dsLoc = new ArrayList<>();
		for (Vga sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	
	public void dsSanPhamVgaSauKhiLocNhaSX(ArrayList<Vga> ds, String nhaSX) {
		ArrayList<Vga> dsLoc = new ArrayList<>();
		for (Vga sanPham : ds) {
			if(sanPham.getNhaSanXuat().equals(nhaSX)) dsLoc.add(sanPham);
		}
		ds.clear();
		ds.addAll(dsLoc);
	}
	
	
	public boolean kiemTraMaHoacTenSanPham(SanPham sanPham, String regex) {
		Pattern pMa = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Pattern pTen = Pattern.compile(regex);
		Matcher mMa = pMa.matcher(sanPham.getMaSanPham());
		Matcher mTen = pMa.matcher(sanPham.getTenSanPham());
		if(mMa.find() || mTen.find()) return true;
		return false;
	}
	
	public void capNhatSoLuongSanPham(HoaDon hoaDon) {
		for (ChiTietHoaDon ct : hoaDon.getDsChiTietHoaDon()) {
			sp_dao.capNhatSoLuongSanPham(ct.getSanPham().getMaSanPham(), ct.getSanPham().getSoLuongTonKho() - ct.getSoLuongMua());
		}
	}
	
	public boolean checkMaTrung(String ma) {
   	 ArrayList<SanPham> ds = sp_dao.getAllSanPham();
   	 for (SanPham sp : ds) {
			if(sp.getMaSanPham().equals(ma)) {
				return false;
			}
		}
   	 return true;
    }
}
