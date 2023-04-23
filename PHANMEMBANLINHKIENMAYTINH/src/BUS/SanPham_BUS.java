package BUS;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import DAO.SanPham_DAO;
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
	private SanPham_DAO sp_dao = new SanPham_DAO();

	public void DocDuLieuVaoTableSanPham(DefaultTableModel model) {
		ArrayList<SanPham> ds = sp_dao.getAllSanPham();
		for (SanPham sp : ds) {
			if(sp != null) {
				model.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), sp.getGiaBan(), sp.getSoLuongTonKho(), sp.getNhaSanXuat(), sp.getNgaySanXuat(), sp.getBaoHanh(), sp.getGiaNhap(), sp.getGiamGia()});
			}
		}
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
	public boolean themSanPham_Ram(Ram them) {
		return sp_dao.themSanPham_Ram(them);
	}
	public boolean themSanPham_Case(Case them) {
		return sp_dao.themSanPham_Case(them);
	}
	public boolean themSanPham_Main(Main them) {
		return sp_dao.themSanPham_Main(them);
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

	public ArrayList<Case> dsSanPhamCaseSauKhiLoc(String regex) {
		ArrayList<Case> dsLoc = new ArrayList<>();
		ArrayList<Case> ds = sp_dao.getAllCase();
		for (Case sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	public ArrayList<Main> dsSanPhamMainSauKhiLoc(String regex) {
		ArrayList<Main> dsLoc = new ArrayList<>();
		ArrayList<Main> ds = sp_dao.getAllMain();
		for (Main sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	public ArrayList<Cpu> dsSanPhamCpuSauKhiLoc(String regex) {
		ArrayList<Cpu> dsLoc = new ArrayList<>();
		ArrayList<Cpu> ds = sp_dao.getAllCpu();
		for (Cpu sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	public ArrayList<Ram> dsSanPhamRamSauKhiLoc(String regex) {
		ArrayList<Ram> dsLoc = new ArrayList<>();
		ArrayList<Ram> ds = sp_dao.getAllRam();
		for (Ram sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	public ArrayList<Psu> dsSanPhamPsuSauKhiLoc(String regex) {
		ArrayList<Psu> dsLoc = new ArrayList<>();
		ArrayList<Psu> ds = sp_dao.getAllPsu();
		for (Psu sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
	}
	public ArrayList<Vga> dsSanPhamVgaSauKhiLoc(String regex) {
		ArrayList<Vga> dsLoc = new ArrayList<>();
		ArrayList<Vga> ds = sp_dao.getAllVga();
		for (Vga sanPham : ds) {
			if(kiemTraMaHoacTenSanPham(sanPham, regex)) dsLoc.add(sanPham);
		}
		return dsLoc;
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
}
