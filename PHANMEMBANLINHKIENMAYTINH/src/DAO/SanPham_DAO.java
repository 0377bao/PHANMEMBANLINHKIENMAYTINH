package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;


import javax.swing.JComboBox;

import connectDB.ConnectDB;
import model.Case;
import model.Cpu;
import model.Main;
import model.Psu;
import model.Ram;
import model.SanPham;
import model.Vga;

import java.lang.String;

public class SanPham_DAO {
   public SanPham_DAO() {};
   
    // lấy ra danh sách tất cả các sản phẩm 
    public ArrayList<SanPham> getAllSanPham() {
    	ArrayList<SanPham> list_sp = new ArrayList<SanPham>();
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		Statement stmt = con.createStatement();
    		String sql = "Select * from SanPham";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			SanPham sp = new SanPham(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia);
    			list_sp.add(sp);
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return list_sp;
    }
    
    // lấy ra danh sách sản phẩm CPU
    public ArrayList<Cpu> getAllCpu() {
    	ArrayList<Cpu> list_cpu = new ArrayList<Cpu>();
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		Statement stmt = con.createStatement();
    		String sql = "Select * from SanPham sp join CPU c on sp.MaSanPham = c.MaSanPham";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			
    			int soLoi = rs.getInt("SoLoi");
    			int soLuong = rs.getInt("SoLuong");
    			Double tanSoCoSo = rs.getDouble("tanSoCoSo");
    			Double tanSoTurbo = rs.getDouble("tanSoTurbo");
    			int boNhoDem = rs.getInt("boNhoDem");
    			int boNhoToiDa = rs.getInt("boNhoToiDa");
    			Cpu temp = new Cpu(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia, soLoi, soLuong,tanSoCoSo,tanSoTurbo, boNhoDem, boNhoToiDa);
    			list_cpu.add(temp);
    		}
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return list_cpu;
    }
    
    // lấy ra danh sách sản phẩm VGA
    public ArrayList<Vga> getAllVga() {
    	ArrayList<Vga> list_vga = new ArrayList<Vga>();
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		Statement stmt = con.createStatement();
    		String sql = "Select * from SanPham sp join VGA v on sp.MaSanPham = v.MaSanPham";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			
    			int tienTrinh = rs.getInt("tienTrinh");
    			int TDP = rs.getInt("TDP");
    			int cudaCores = rs.getInt("cudaCores");
    		
    			Vga temp = new Vga(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia, tienTrinh, TDP, cudaCores);
    			list_vga.add(temp);
    		}
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return list_vga;
    }
    
    // lấy ra danh sách sản phẩm PSU 
    public ArrayList<Psu> getAllPsu() {
    	ArrayList<Psu> list_psu = new ArrayList<Psu>();
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		Statement stmt = con.createStatement();
    		String sql = "Select * from SanPham sp join PSU p on sp.MaSanPham = p.MaSanPham";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			
    			int congSuat = rs.getInt("congSuat");
    			int hieuSuat = rs.getInt("hieuSuat");
    			int tuoiTho = rs.getInt("tuoiTho");
    			Psu temp = new Psu(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia, congSuat, hieuSuat, tuoiTho);
    			list_psu.add(temp);
    		}
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return list_psu;
    }
    
    // lấy ra danh sách sản phẩm MAIN
    public ArrayList<Main> getAllMain() {
    	ArrayList<Main> list_main = new ArrayList<Main>();
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		Statement stmt = con.createStatement();
    		String sql = "Select * from SanPham sp join MAIN m on sp.MaSanPham = m.MaSanPham";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			
    			String chip = rs.getString("chipSet").trim();
    			String ramHoTro = rs.getString("ramHoTro").trim();
    			String cpuHoTro = rs.getString("cpuHoTro").trim();
    			String doHoa = rs.getString("doHoa").trim();
    			String oCungHoTro = rs.getString("oCungHoTro").trim();
    			Main temp = new Main(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia, chip, ramHoTro, cpuHoTro, doHoa, oCungHoTro);
    			list_main.add(temp);
    		}
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return list_main;
    }
    
    // lấy ra danh sách sản phẩm RAM
    public ArrayList<Ram> getAllRam() {
    	ArrayList<Ram> list_ram = new ArrayList<Ram>();
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		Statement stmt = con.createStatement();
    		String sql = "Select * from SanPham sp join RAM r on sp.MaSanPham = r.MaSanPham";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			
    			int dungLuong = rs.getInt("dungLuong");
    			int tocDo = rs.getInt("tocDo");
    			
    			Ram temp = new Ram(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia, dungLuong, tocDo);
    			list_ram.add(temp);
    		}
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return list_ram;
    }
    
    // lấy ra danh sách sản phẩm CASE
    public ArrayList<Case> getAllCase() {
    	ArrayList<Case> list_case = new ArrayList<Case>();
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		Statement stmt = con.createStatement();
    		String sql = "Select * from SanPham sp join [CASE] cs on sp.MaSanPham = cs.MaSanPham";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			
    			String chatLieu = rs.getString("chatLieu").trim();
    			String mau = rs.getString("mau").trim();
    			String tuongThich = rs.getString("tuongThich").trim();
    			
    			Case temp = new Case(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia, chatLieu, mau, tuongThich);
    			list_case.add(temp);
    		}
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return list_case;
    }
    
    // thêm một sản phẩm vào cơ sở dữ liệu
    public boolean themSanPham_Cpu(Cpu them) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0;
    	int m = 0;
    	PreparedStatement stmt_SP = null;
    	PreparedStatement stmt_Cpu = null;
    	String sql_sp = "Insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	String sql_Cpu = "Insert into CPU values (?, ?, ?, ?, ?, ?, ?)";
    	try {
    		stmt_SP = con.prepareStatement(sql_sp);
    		stmt_Cpu = con.prepareStatement(sql_Cpu);
    		stmt_SP.setString(1, them.getMaSanPham());
    		stmt_SP.setString(2, them.getTenSanPham());
    		stmt_SP.setDouble(3, them.getGiaBan());
    		stmt_SP.setInt(4, them.getSoLuongTonKho());
    		stmt_SP.setString(5, them.getNhaSanXuat());
    		Date t = Date.valueOf(them.getNgaySanXuat());
    		stmt_SP.setDate(6, t);
    		stmt_SP.setInt(7, them.getBaoHanh());
    		stmt_SP.setDouble(8, them.getGiaNhap());
    		stmt_SP.setInt(9, them.getGiamGia());
    		stmt_SP.setString(10, them.getClass().getSimpleName().toUpperCase());
    		
    		stmt_Cpu.setString(1, them.getMaSanPham());
    		stmt_Cpu.setInt(2, them.getSoLoi());
    		stmt_Cpu.setInt(3, them.getSoLuong());
    		stmt_Cpu.setDouble(4, them.getTanSoCoSo());
    		stmt_Cpu.setDouble(5, them.getTanSoTurbo());
    		stmt_Cpu.setInt(6, them.getBoNhoDem());
    		stmt_Cpu.setInt(7, them.getBoNhoToiDa());
    		
    		n = stmt_SP.executeUpdate();
    		m = stmt_Cpu.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return n > 0 && m > 0 ? true : false;
    }
    
    public boolean themSanPham_Vga(Vga them) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0;
    	int m = 0;
    	PreparedStatement stmt_SP = null;
    	PreparedStatement stmt_Vga = null;
    	String sql_sp = "Insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	String sql_Vga = "Insert into VGA values (?, ?, ?, ?)";
    	try {
    		stmt_SP = con.prepareStatement(sql_sp);
    		stmt_Vga = con.prepareStatement(sql_Vga);
    		stmt_SP.setString(1, them.getMaSanPham());
    		stmt_SP.setString(2, them.getTenSanPham());
    		stmt_SP.setDouble(3, them.getGiaBan());
    		stmt_SP.setInt(4, them.getSoLuongTonKho());
    		stmt_SP.setString(5, them.getNhaSanXuat());
    		Date t = Date.valueOf(them.getNgaySanXuat());
    		stmt_SP.setDate(6, t);
    		stmt_SP.setInt(7, them.getBaoHanh());
    		stmt_SP.setDouble(8, them.getGiaNhap());
    		stmt_SP.setInt(9, them.getGiamGia());
    		stmt_SP.setString(10, them.getClass().getSimpleName().toUpperCase());
    		
    		stmt_Vga.setInt(2, them.getTienTrinh());
    		stmt_Vga.setInt(3, them.getTDP());
    		stmt_Vga.setInt(4, them.getCudaCores());
    		stmt_Vga.setString(1, them.getMaSanPham());
    		
    		n = stmt_SP.executeUpdate();
    		m = stmt_Vga.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return n > 0 && m > 0 ? true : false;
    }
    
    public boolean themSanPham_Psu(Psu them) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0;
    	int m = 0;
    	PreparedStatement stmt_SP = null;
    	PreparedStatement stmt_Psu = null;
    	String sql_sp = "Insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	String sql_Psu = "Insert into PSU values (?, ?, ?, ?)";
    	try {
    		stmt_SP = con.prepareStatement(sql_sp);
    		stmt_Psu = con.prepareStatement(sql_Psu);
    		stmt_SP.setString(1, them.getMaSanPham());
    		stmt_SP.setString(2, them.getTenSanPham());
    		stmt_SP.setDouble(3, them.getGiaBan());
    		stmt_SP.setInt(4, them.getSoLuongTonKho());
    		stmt_SP.setString(5, them.getNhaSanXuat());
    		Date t = Date.valueOf(them.getNgaySanXuat());
    		stmt_SP.setDate(6, t);
    		stmt_SP.setInt(7, them.getBaoHanh());
    		stmt_SP.setDouble(8, them.getGiaNhap());
    		stmt_SP.setInt(9, them.getGiamGia());
    		stmt_SP.setString(10, them.getClass().getSimpleName().toUpperCase());
    		
    		stmt_Psu.setInt(2, them.getCongSuat());
    		stmt_Psu.setInt(3, them.getHieuSuat());
    		stmt_Psu.setInt(4, them.getTuoiTho());
    		stmt_Psu.setString(1, them.getMaSanPham());
    		
    		n = stmt_SP.executeUpdate();
    		m = stmt_Psu.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return n > 0 && m > 0 ? true : false;
    }
    
    public boolean themSanPham_Ram(Ram them) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0;
    	int m = 0;
    	PreparedStatement stmt_SP = null;
    	PreparedStatement stmt_Ram = null;
    	String sql_sp = "Insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	String sql_Ram = "Insert into RAM values (?, ?, ?)";
    	try {
    		stmt_SP = con.prepareStatement(sql_sp);
    		stmt_Ram = con.prepareStatement(sql_Ram);
    		stmt_SP.setString(1, them.getMaSanPham());
    		stmt_SP.setString(2, them.getTenSanPham());
    		stmt_SP.setDouble(3, them.getGiaBan());
    		stmt_SP.setInt(4, them.getSoLuongTonKho());
    		stmt_SP.setString(5, them.getNhaSanXuat());
    		Date t = Date.valueOf(them.getNgaySanXuat());
    		stmt_SP.setDate(6, t);
    		stmt_SP.setInt(7, them.getBaoHanh());
    		stmt_SP.setDouble(8, them.getGiaNhap());
    		stmt_SP.setInt(9, them.getGiamGia());
    		stmt_SP.setString(10, them.getClass().getSimpleName().toUpperCase());
    		
    		stmt_Ram.setInt(2, them.getDungLuong());
    		stmt_Ram.setInt(3, them.getTocDo());
    		stmt_Ram.setString(1, them.getMaSanPham());
    		
    		n = stmt_SP.executeUpdate();
    		m = stmt_Ram.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return n > 0 && m > 0 ? true : false;
    }
    
    public boolean themSanPham_Case(Case them) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0;
    	int m = 0;
    	PreparedStatement stmt_SP = null;
    	PreparedStatement stmt_Case = null;
    	String sql_sp = "Insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	String sql_Case = "Insert into [CASE] values (?, ?, ?, ?)";
    	try {
    		stmt_SP = con.prepareStatement(sql_sp);
    		stmt_SP.setString(1, them.getMaSanPham());
    		stmt_SP.setString(2, them.getTenSanPham());
    		stmt_SP.setDouble(3, them.getGiaBan());
    		stmt_SP.setInt(4, them.getSoLuongTonKho());
    		stmt_SP.setString(5, them.getNhaSanXuat());
    		Date t = Date.valueOf(them.getNgaySanXuat());
    		stmt_SP.setDate(6, t);
    		stmt_SP.setInt(7, them.getBaoHanh());
    		stmt_SP.setDouble(8, them.getGiaNhap());
    		stmt_SP.setInt(9, them.getGiamGia());
    		stmt_SP.setString(10, them.getClass().getSimpleName().toUpperCase());
    		
    		stmt_Case = con.prepareStatement(sql_Case);
    		stmt_Case.setString(1, them.getMaSanPham());
    		stmt_Case.setString(2, them.getChatLieu());
    		stmt_Case.setString(3, them.getMau());
    		stmt_Case.setString(4, them.getTuongThich());
    		
    		
    		n = stmt_SP.executeUpdate();
    		m = stmt_Case.executeUpdate();
    		
    	}catch(SQLException e) {
    		return false;
    	}
    	return n > 0 && m > 0 ? true : false;
    }
    
    public boolean themSanPham_Main(Main them) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0;
    	int m = 0;
    	PreparedStatement stmt_SP = null;
    	PreparedStatement stmt_Main = null;
    	String sql_sp = "Insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	String sql_Main = "Insert into MAIN values (?, ?, ?, ?, ?, ?)";
    	try {
    		stmt_SP = con.prepareStatement(sql_sp);
    		stmt_Main = con.prepareStatement(sql_Main);
    		stmt_SP.setString(1, them.getMaSanPham());
    		stmt_SP.setString(2, them.getTenSanPham());
    		stmt_SP.setDouble(3, them.getGiaBan());
    		stmt_SP.setInt(4, them.getSoLuongTonKho());
    		stmt_SP.setString(5, them.getNhaSanXuat());
    		Date t = Date.valueOf(them.getNgaySanXuat());
    		stmt_SP.setDate(6, t);
    		stmt_SP.setInt(7, them.getBaoHanh());
    		stmt_SP.setDouble(8, them.getGiaNhap());
    		stmt_SP.setInt(9, them.getGiamGia());
    		stmt_SP.setString(10, them.getClass().getSimpleName().toUpperCase());	
    		stmt_Main.setString(2, them.getChipSet());
    		stmt_Main.setString(3, them.getRamHoTro());
    		stmt_Main.setString(4, them.getCpuHoTro());
    		stmt_Main.setString(5, them.getDoHoa());
    		stmt_Main.setString(6, them.getoCungHoTro());
    		stmt_Main.setString(1, them.getMaSanPham());
    		
    		n = stmt_SP.executeUpdate();
    		m = stmt_Main.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return n > 0 && m > 0 ? true : false;
    }
    
    // xóa sản phẩm
    public boolean xoaSanPham_Cpu(String masp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        int m = 0;
        String sql = "delete from SanPham where MaSanPham = ?";
        String sql_cpu = "delete from Cpu where MaSanPham = ?";
        PreparedStatement stmt = null;
        PreparedStatement stmt_cpu = null;
        try {
    		stmt_cpu = con.prepareStatement(sql_cpu);
    		stmt_cpu.setString(1, masp);
    		m = stmt_cpu.executeUpdate();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, masp);
		    n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return n > 0 && m > 0 ? true : false;
    }
    
    public boolean xoaSanPham_Vga(String masp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        int m = 0;
        String sql = "delete from SanPham where MaSanPham = ?";
        String sql_vga = "delete from Vga where MaSanPham = ?";
        PreparedStatement stmt = null;
        PreparedStatement stmt_vga = null;
        try {
    		stmt_vga = con.prepareStatement(sql_vga);
    		stmt_vga.setString(1, masp);
    		m = stmt_vga.executeUpdate();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, masp);
		    n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return n > 0 && m > 0 ? true : false;
    }
  
    public SanPham timSanPhamTheoMa(String matim) {
    	SanPham tim = null;
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		String sql = "Select * from SanPham where maSanPham = ?";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, matim);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			tim = new SanPham(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia);
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return tim;
    }

    public boolean xoaSanPham_Psu(String masp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        int m = 0;
        String sql = "delete from SanPham where MaSanPham = ?";
        String sql_psu = "delete from Psu where MaSanPham = ?";
        PreparedStatement stmt = null;
        PreparedStatement stmt_psu = null;
        try {
    		stmt_psu = con.prepareStatement(sql_psu);
    		stmt_psu.setString(1, masp);
    		m = stmt_psu.executeUpdate();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, masp);
		    n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return n > 0 && m > 0 ? true : false;
    }
    
    public boolean xoaSanPham_Main(String masp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        int m = 0;
        String sql = "delete from SanPham where MaSanPham = ?";
        String sql_main = "delete from Main where MaSanPham = ?";
        PreparedStatement stmt = null;
        PreparedStatement stmt_main = null;
        try {
    		stmt_main = con.prepareStatement(sql_main);
    		stmt_main.setString(1, masp);
    		m = stmt_main.executeUpdate();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, masp);
		    n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return n > 0 && m > 0 ? true : false;
    }
    
    public boolean xoaSanPham_Case(String masp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        int m = 0;
        String sql = "delete from SanPham where MaSanPham = ?";
        String sql_case = "delete from [CASE] where MaSanPham = ?";
        PreparedStatement stmt = null;
        PreparedStatement stmt_case = null;
        try {
    		stmt_case = con.prepareStatement(sql_case);
    		stmt_case.setString(1, masp);
    		m = stmt_case.executeUpdate();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, masp);
		    n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return n > 0 && m > 0 ? true : false;
    }
    
    public boolean xoaSanPham_Ram(String masp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        int n = 0;
        int m = 0;
        String sql = "delete from SanPham where MaSanPham = ?";
        String sql_ram = "delete from Ram where MaSanPham = ?";
        PreparedStatement stmt = null;
        PreparedStatement stmt_ram = null;
        try {
    		stmt_ram = con.prepareStatement(sql_ram);
    		stmt_ram.setString(1, masp);
    		m = stmt_ram.executeUpdate();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, masp);
		    n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return n > 0 && m > 0 ? true : false;
    }
    
    public ArrayList<SanPham> getALLSanPhamTheoLoai(String loai) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	ArrayList<SanPham> temp = new ArrayList<SanPham>();
    	String sql = "select * from SanPham where LoaiSanPham = ?";
    	
    	try {
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, loai);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			String ma = rs.getString("MaSanPham").trim();
    			String ten = rs.getString("TenSanPham").trim();
    			Double giaBan = rs.getDouble("GiaBan");
    			int slt = rs.getInt("SoLuongTonKho");
    			String nhasx = rs.getString("NhaSanXuat").trim();
    			Date ngayTam = rs.getDate("NgaySanXuat");
    			Calendar cl = Calendar.getInstance();
    			cl.setTime(ngayTam);
    			LocalDate ngaysx = LocalDate.of(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));
    			int baoHanh = rs.getInt("BaoHanh");
    			Double giaNhap = rs.getDouble("GiaNhap");
    			int giamGia = rs.getInt("GiamGia");
    			SanPham sp = new SanPham(ma, ten, giaBan, slt, nhasx, ngaysx, baoHanh, giaNhap, giamGia);
    			temp.add(sp);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return temp;
    }
    

    
    public boolean updateSanPham_cpu(SanPham s, Cpu c) {
    	 ConnectDB.getInstance();
         Connection con = ConnectDB.getConnection();
         int n = 0;
         int m = 0;
         PreparedStatement stmt_sp = null;
         PreparedStatement stmt_loai = null;
         String sql_cpu = "update Cpu set soLoi=?, soLuong=?, tanSoCoSo=?, tanSoTurbo=?, boNhoDem=?, boNhoToiDa=? where MaSanPham=?";
         String sql_update = "update SanPham set TenSanPham=?, GiaBan=?, SoLuongTonKho=?, NhaSanXuat=?, NgaySanXuat=?, BaoHanh=?, GiaNhap=?, GiamGia=?, LoaiSanPham=? where MaSanPham=?";
         try {
         	stmt_sp = con.prepareStatement(sql_update);	
         	stmt_sp.setString(1,s.getTenSanPham());
         	stmt_sp.setDouble(2, s.getGiaBan());
         	stmt_sp.setInt(3, s.getSoLuongTonKho());
         	stmt_sp.setString(4, s.getNhaSanXuat());
         	Date t = Date.valueOf(s.getNgaySanXuat());
         	stmt_sp.setDate(5,t);
         	stmt_sp.setInt(6, s.getBaoHanh());
         	stmt_sp.setDouble(7, s.getGiaNhap());
         	stmt_sp.setInt(8, s.getGiamGia());
         	stmt_sp.setString(9, c.getClass().getSimpleName().toUpperCase());
         	stmt_sp.setString(10,s.getMaSanPham());
         	
         	stmt_loai = con.prepareStatement(sql_cpu);	
    		stmt_loai.setInt(1, c.getSoLoi());
    		stmt_loai.setInt(2, c.getSoLuong());
    		stmt_loai.setDouble(3, c.getTanSoCoSo());
    		stmt_loai.setDouble(4, c.getTanSoTurbo());
    		stmt_loai.setInt(5, c.getBoNhoDem());
    		stmt_loai.setInt(6, c.getBoNhoToiDa());
    		stmt_loai.setString(7, c.getMaSanPham());
         	n = stmt_sp.executeUpdate();
         	m = stmt_loai.executeUpdate();
         }catch(SQLException e) {
         	e.printStackTrace();
         }
         return n > 0 && m > 0 ? true : false;
    }
    
    public boolean updateSanPham_vga(SanPham s, Vga v) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0;
    	int m = 0;
    	String sql_vga = "update VGA set tienTrinh = ?, tdp = ?, cudaCores = ? where maSanPham = ?";
    	String sql_update = "update SanPham set TenSanPham=?, GiaBan=?, SoLuongTonKho=?, NhaSanXuat=?, NgaySanXuat=?, BaoHanh=?, GiaNhap=?, GiamGia=?, LoaiSanPham=? where maSanPham=?";
    	try {
			PreparedStatement stmt_sp = con.prepareStatement(sql_update);

         	stmt_sp.setString(1,s.getTenSanPham());
         	stmt_sp.setDouble(2, s.getGiaBan());
         	stmt_sp.setInt(3, s.getSoLuongTonKho());
         	stmt_sp.setString(4, s.getNhaSanXuat());
         	Date t = Date.valueOf(s.getNgaySanXuat());
         	stmt_sp.setDate(5,t);
         	stmt_sp.setInt(6, s.getBaoHanh());
         	stmt_sp.setDouble(7, s.getGiaNhap());
         	stmt_sp.setInt(8, s.getGiamGia());
         	stmt_sp.setString(9, v.getClass().getSimpleName().toUpperCase());
         	stmt_sp.setString(10,s.getMaSanPham());
			
         	PreparedStatement stmt_loai = con.prepareStatement(sql_vga);
    		stmt_loai.setInt(1, v.getTienTrinh());
    		stmt_loai.setInt(2, v.getTDP());
    		stmt_loai.setInt(3, v.getCudaCores());
    		stmt_loai.setString(4, v.getMaSanPham());
    		n = stmt_sp.executeUpdate();
    		m = stmt_loai.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return n > 0 && m > 0 ? true: false;
    }
    
    public boolean updateSanPham_Main(SanPham s, Main l) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0, m = 0;
    	String sql_main = "update Main set chipSet=?, ramHoTro=?, cpuHoTro=?, doHoa=?, oCungHoTro=? where maSanPham=?";
    	String sql_update = "update SanPham set TenSanPham=?, GiaBan=?, SoLuongTonKho=?, NhaSanXuat=?, NgaySanXuat=?, BaoHanh=?, GiaNhap=?, GiamGia=?, LoaiSanPham=? where maSanPham=?";
    	try {
			PreparedStatement stmt_sp = con.prepareStatement(sql_update);

         	stmt_sp.setString(1,s.getTenSanPham());
         	stmt_sp.setDouble(2, s.getGiaBan());
         	stmt_sp.setInt(3, s.getSoLuongTonKho());
         	stmt_sp.setString(4, s.getNhaSanXuat());
         	Date t = Date.valueOf(s.getNgaySanXuat());
         	stmt_sp.setDate(5,t);
         	stmt_sp.setInt(6, s.getBaoHanh());
         	stmt_sp.setDouble(7, s.getGiaNhap());
         	stmt_sp.setInt(8, s.getGiamGia());
         	stmt_sp.setString(9, l.getClass().getSimpleName().toUpperCase());
         	stmt_sp.setString(10,s.getMaSanPham());
			
         	PreparedStatement stmt_loai = con.prepareStatement(sql_main);
    		stmt_loai.setString(1, l.getChipSet());
    		stmt_loai.setString(2, l.getRamHoTro());
    		stmt_loai.setString(3, l.getCpuHoTro());
    		stmt_loai.setString(4, l.getDoHoa());
    		stmt_loai.setString(5, l.getoCungHoTro());
    		stmt_loai.setString(6, l.getMaSanPham());
    		
    		n = stmt_sp.executeUpdate();
    		m = stmt_loai.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return n > 0 && m > 0 ? true: false;
    }
    
    public boolean updateSanPham_Ram(SanPham s, Ram r) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0, m = 0;
    	String sql_ram = "update RAM set dungLuong = ?, tocDo = ? where maSanPham=?";
    	String sql_update = "update SanPham set TenSanPham=?, GiaBan=?, SoLuongTonKho=?, NhaSanXuat=?, NgaySanXuat=?, BaoHanh=?, GiaNhap=?, GiamGia=?, LoaiSanPham=? where maSanPham=?";
    	try {
			PreparedStatement stmt_sp = con.prepareStatement(sql_update);
         	stmt_sp.setString(1,s.getTenSanPham());
         	stmt_sp.setDouble(2, s.getGiaBan());
         	stmt_sp.setInt(3, s.getSoLuongTonKho());
         	stmt_sp.setString(4, s.getNhaSanXuat());
         	Date t = Date.valueOf(s.getNgaySanXuat());
         	stmt_sp.setDate(5,t);
         	stmt_sp.setInt(6, s.getBaoHanh());
         	stmt_sp.setDouble(7, s.getGiaNhap());
         	stmt_sp.setInt(8, s.getGiamGia());
         	stmt_sp.setString(9, r.getClass().getSimpleName().toUpperCase());
         	stmt_sp.setString(10,s.getMaSanPham());
			
         	PreparedStatement stmt_loai = con.prepareStatement(sql_ram);
    		stmt_loai.setInt(1, r.getDungLuong());
    		stmt_loai.setInt(2, r.getTocDo());
    		stmt_loai.setString(3, r.getMaSanPham());
    		n = stmt_sp.executeUpdate();
    		m = stmt_loai.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return n > 0 && m > 0 ? true: false;
    }
    
    public boolean updateSanPham_Case(SanPham s, Case ca) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0;
    	int m = 0;
    	String sql_case = "update [CASE] set chatLieu = ?, mau = ?, tuongThich = ? where maSanPham=?";
    	String sql_update = "update SanPham set TenSanPham=?, GiaBan=?, SoLuongTonKho=?, NhaSanXuat=?, NgaySanXuat=?, BaoHanh=?, GiaNhap=?, GiamGia=?, LoaiSanPham=? where maSanPham=?";
    	try {
			PreparedStatement stmt_sp = con.prepareStatement(sql_update);
         	stmt_sp.setString(1,s.getTenSanPham());
         	stmt_sp.setDouble(2, s.getGiaBan());
         	stmt_sp.setInt(3, s.getSoLuongTonKho());
         	stmt_sp.setString(4, s.getNhaSanXuat());
         	Date t = Date.valueOf(s.getNgaySanXuat());
         	stmt_sp.setDate(5,t);
         	stmt_sp.setInt(6, s.getBaoHanh());
         	stmt_sp.setDouble(7, s.getGiaNhap());
         	stmt_sp.setInt(8, s.getGiamGia());
         	stmt_sp.setString(9, ca.getClass().getSimpleName().toUpperCase());
         	stmt_sp.setString(10,s.getMaSanPham());
         	
         	PreparedStatement stmt_loai = con.prepareStatement(sql_case);
         	stmt_loai.setString(1, ca.getChatLieu());
         	stmt_loai.setString(2, ca.getMau());
         	stmt_loai.setString(3, ca.getTuongThich());
         	stmt_loai.setString(4, ca.getMaSanPham());
			
    		
    		n = stmt_sp.executeUpdate();
    		m = stmt_loai.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return n > 0 && m > 0 ? true: false;
    }
    
    public boolean updateSanPham_Psu(SanPham s, Psu p) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	int n = 0, m = 0;
    	String sql_Psu = "Update PSU set congSuat=?, hieuSuat=?, tuoiTho=? where MaSanPham=?";
    	String sql_update = "update SanPham set TenSanPham=?, GiaBan=?, SoLuongTonKho=?, NhaSanXuat=?, NgaySanXuat=?, BaoHanh=?, GiaNhap=?, GiamGia=?, LoaiSanPham=? where maSanPham=?";
    	try {
			PreparedStatement stmt_sp = con.prepareStatement(sql_update);
         	stmt_sp.setString(1,s.getTenSanPham());
         	stmt_sp.setDouble(2, s.getGiaBan());
         	stmt_sp.setInt(3, s.getSoLuongTonKho());
         	stmt_sp.setString(4, s.getNhaSanXuat());
         	Date t = Date.valueOf(s.getNgaySanXuat());
         	stmt_sp.setDate(5,t);
         	stmt_sp.setInt(6, s.getBaoHanh());
         	stmt_sp.setDouble(7, s.getGiaNhap());
         	stmt_sp.setInt(8, s.getGiamGia());
         	stmt_sp.setString(9, p.getClass().getSimpleName().toUpperCase());
         	stmt_sp.setString(10,s.getMaSanPham());
         	
         	PreparedStatement stmt_loai = con.prepareStatement(sql_Psu);
    		stmt_loai.setInt(1,p.getCongSuat());
    		stmt_loai.setInt(2, p.getHieuSuat());
    		stmt_loai.setInt(3, p.getTuoiTho());
    		stmt_loai.setString(4, p.getMaSanPham());
			
    		
    		n = stmt_sp.executeUpdate();
    		m = stmt_loai.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return n > 0 && m > 0 ? true: false;
    }
    public void capNhatSoLuongSanPham(String ma, int CapNhat) {
    	Connection con = ConnectDB.getConnection();
    	String sql = "update SanPham set soLuongTonKho=? where maSanPham = ?";
    	try {
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setInt(1, CapNhat);
    		stmt.setString(2, ma);
    		stmt.executeUpdate();	
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    
    
    public String timLoaiSanPhamTheoMa(String matim) {
    	String loai = "";
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	try {
    		String sql = "Select * from SanPham where maSanPham = ?";
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, matim);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			loai = rs.getString(10).trim();
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return loai;
    }
    
    public int getMaSanPhamMax() {
		int ma = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement statement = con.createStatement();
			String sql = "SELECT top 1 CAST(SUBSTRING(maSanPham, 3, LEN(maSanPham) - 2) as int) AS maSanPham "
					+ "FROM SanPham order by maSanPham desc";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ma = rs.getInt("maSanPham");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
}   

