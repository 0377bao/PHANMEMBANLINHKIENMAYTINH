package model;

import java.util.ArrayList;

public class DanhSachSanPham {
    private ArrayList<SanPham> ds;
    
    // Tạo danh sách sản phẩm
    public DanhSachSanPham() {
    	ds = new ArrayList<>();
    }
    
    
    public ArrayList<SanPham> getDsSanPham() {
		return ds;
	}

	public void setDs(ArrayList<SanPham> ds) {
		this.ds = ds;
	}

	// Thêm sản phẩm vào danh sách
    public boolean themSanPham(SanPham e) {
    	if(!ds.contains(e)) {
    		ds.add(e);
    		return true;
    	}
    	return false;
    }
    
    // Xóa sản phẩm khỏi danh sách
    public boolean xoaSanPham(SanPham e) {
    	ds.remove(e);
    	return true;
    }
    
    // Sửa sản phẩm trong danh sách theo mã
    public boolean suaSanPham(SanPham e) {
    	int index = ds.indexOf(e);
    	ds.set(index, e);
    	return true;
    }
    
    // Tìm sản phẩm trong danh sách theo mã
    public SanPham timSanPham(String ma) {
    	for (SanPham sP : ds) {
			if(sP.getMaSanPham().equals(ma)) {
				return sP;
			}
		}
    	return null;
    }
    
    // lấy ra danh sách các sản phẩm hết hàng
    public ArrayList<SanPham> getDsSanPhamHetHang() {
    	ArrayList<SanPham> temp = new ArrayList<>();
    	for (SanPham sP : ds) {
			if(sP.getSoLuongTonKho() == 0) {
				temp.add(sP);
			}
		}
    	return temp;
    }
    
    // lấy về danh sách CPU
    public ArrayList<SanPham> getDSCpu() {
    	ArrayList<SanPham> dsCPU = new ArrayList<>();
    		for (SanPham sP : ds) {
				if(sP instanceof Cpu) {
					dsCPU.add(sP);
				}
			}
    	return dsCPU;
    }
    
    // lấy về danh sách Main
    public ArrayList<SanPham> getDSMain() {
    	ArrayList<SanPham> dsMain = new ArrayList<>();
    		for (SanPham sP : ds) {
				if(sP instanceof Main) {
					dsMain.add(sP);
				}
			}
    	return dsMain;
    }
    
    // lấy vè danh sách Vga
    public ArrayList<SanPham> getDSVga() {
    	ArrayList<SanPham> dsVGA = new ArrayList<>();
    		for (SanPham sP : ds) {
				if(sP instanceof Vga) {
					dsVGA.add(sP);
				}
			}
    	return dsVGA;
    }
    
    // lấy về danh sách Psu    
    public ArrayList<SanPham> getDSPsu() {
    	ArrayList<SanPham> dsPSU = new ArrayList<>();
    		for (SanPham sP : ds) {
				if(sP instanceof Psu) {
					dsPSU.add(sP);
				}
			}
    	return dsPSU;
    }
    
    // lấy về danh sách Case
    public ArrayList<SanPham> getDSCase() {
    	ArrayList<SanPham> dsCASE = new ArrayList<>();
    		for (SanPham sP : ds) {
				if(sP instanceof Case) {
					dsCASE.add(sP);
				}
			}
    	return dsCASE;
    }
    
    // lấy về danh sách Ram
    public ArrayList<SanPham> getDSRam() {
    	ArrayList<SanPham> dsRAM = new ArrayList<>();
    		for (SanPham sP : ds) {
				if(sP instanceof Ram) {
					dsRAM.add(sP);
				}
			}
    	return dsRAM;
    }
    
    
}
