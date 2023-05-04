package BUS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;

import connectDB.ConnectDB;

import model.HoaDon;

import model.KhachHang;


public class KhachHang_BUS {
	public static String mes = "";
	KhachHang_DAO kh_DAO = new KhachHang_DAO();
	private HoaDon_BUS HD_BUS;
	public ArrayList<KhachHang> getAllKhachHang(){
		return kh_DAO.getAllKhachHang();
	}
	public KhachHang getkhachHangTheoMa(String maKH) {
		return kh_DAO.getKhachHangTheoMa(maKH);
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
		}else if(diachi.equals("")||!diachi.matches("[\\p{L}\\d\\s,-.?/]+")) {
			mes = "Lỗi địa chỉ không đúng định dạng";
			return false;
		}else return true;
	}

	public boolean themKhachHang (KhachHang kh) {
		if(kh_DAO.getKhachHangTheoMa(kh.getMa()) != null) return false;
		kh_DAO.themKhachHang(kh);
		return true;
	}
	public void addDaTaToTBKhachHang( DefaultTableModel model) {
		String phai;
		for(KhachHang kh : kh_DAO.getAllKhachHang()) {
			if(kh.isGioiTinh())
				phai = "Nam";
			else
				phai = "Nữ";
			model.addRow(new Object[]  {kh.getMa(),kh.getTen(),phai,kh.getSDT(),kh.getEmail(),kh.getDiaChi(),kh.getDiemTichLuy()});
		}
	}
	public String getMaKhachHangMax() {
		int so = kh_DAO.getMaKhachHangMax();
		so++;
		return "KH" + so;
	}
	public void inKhachHangTheoMa(String maKH,DefaultTableModel model) {
		KhachHang kh = kh_DAO.getKhachHangTheoMa(maKH);
		String phai;
		if(kh.isGioiTinh())
			phai = "Nam";
		else
			phai = "Nữ";
		model.addRow(new Object [] {kh.getMa(),kh.getTen(),phai,kh.getSDT(),kh.getEmail(),kh.getDiaChi(),kh.getDiemTichLuy()});	
	}
	public void locKhachHangTheoMa(String input, DefaultTableModel model ,ArrayList<KhachHang> dsKH) {
		for(KhachHang kh : dsKH) {
			System.out.println(kh);
			Pattern pMa = Pattern.compile(input,Pattern.CASE_INSENSITIVE);
			Pattern pSDT = Pattern.compile(input);
			Matcher mMa = pMa.matcher(kh.getMa());
			Matcher mSDT = pSDT.matcher(kh.getSDT());
			if(mMa.find() || mSDT.find()) {
				inKhachHangTheoMa(kh.getMa(), model);
			}
		}
	}
	public void locKhachHangTheoDiaChi(String input,DefaultTableModel model) {
		for(KhachHang kh : kh_DAO.getAllKhachHang()) {
			Pattern pDiaChi = Pattern.compile(input,Pattern.CASE_INSENSITIVE);
			Matcher mDiaChi = pDiaChi.matcher(input);
			if(mDiaChi.find()) {
				inKhachHangTheoMa(kh.getMa(), model);
			}
		}
	}
	public boolean suaKhachHangTheoMa(KhachHang kh) {
		return kh_DAO.updateKH(kh);
	}
	public boolean xoaKhachHangTheoMa(String maKH) {
		return kh_DAO.deleteKHTheoMa(maKH);
	}
	
	public void capNhatDiemTichLuyKhachHang(HoaDon hoaDon) {
		kh_DAO.capNhatDiemTichLuyKhachHang(hoaDon.getKhachHang().getMa(), hoaDon.getKhachHang().getDiemTichLuy());
	}

	public void layDuLieuBangLSGDTheoMa(String maKH,DefaultTableModel model) {
		HD_BUS = new HoaDon_BUS(); 
		for(HoaDon hd : HD_BUS.getAllHoaDon()) {
			if(maKH.equals(hd.getKhachHang().getMa())) {
				Object obj[] = {hd.getMaHoaDon(),hd.getKhachHang().getTen(),hd.getNgayLapHoaDon(),hd.getKhachHang().getSDT(), String.format("%,.0f", hd.tinhTongTien())};
				model.addRow(obj);
			}
		}
	}

	
}
