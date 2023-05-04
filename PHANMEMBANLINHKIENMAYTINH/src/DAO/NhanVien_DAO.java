package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> ds = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien nv join ConNguoi cn on nv.ma = cn.ma";
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("ma").trim();
				String ten = rs.getString("ten").trim();
				String sdt = rs.getString("sdt").trim();
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String email = rs.getString("email").trim();
				String diaChi = rs.getString("diaChi").trim();
				String chucVu = rs.getString("chucVu").trim();
				String cmnd = rs.getString("cmnd").trim();
				String matKhau = rs.getString("matKhau").trim();
				NhanVien them = new NhanVien(ma, ten, sdt, gioiTinh, email, diaChi, chucVu, cmnd, matKhau);
				ds.add(them);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public NhanVien getNhanVienByMaNhanVien(String maNhanVien) {
		NhanVien nhanVien = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien nv join ConNguoi cn on nv.ma = cn.ma where cn.ma = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maNhanVien);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("ma").trim();
				String ten = rs.getString("ten").trim();
				String sdt = rs.getString("sdt").trim();
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String email = rs.getString("email").trim();
				String diaChi = rs.getString("diaChi").trim();
				String chucVu = rs.getString("chucVu").trim();
				String cmnd = rs.getString("cmnd").trim();
				String matKhau = rs.getString("matKhau").trim();
				nhanVien = new NhanVien(ma, ten, sdt, gioiTinh, email, diaChi, chucVu, cmnd, matKhau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanVien;
	}
	



	public boolean themNhanVien(NhanVien them) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sqlCN = "insert into ConNguoi values(?,?,?,?,?,?,?)";
		String sqlNV = "insert into NhanVien values(?,?,?,?)";
		int n = 0;
		int m = 0;
		PreparedStatement statementCN = null;
		PreparedStatement statementNV = null;
		try {
			statementCN = con.prepareStatement(sqlCN);
			statementNV = con.prepareStatement(sqlNV);
			statementCN.setString(1, them.getMa());
			statementCN.setString(2, them.getTen());
			statementCN.setString(3, them.getSDT());
			statementCN.setBoolean(4, them.isGioiTinh());
			statementCN.setString(5, them.getEmail());
			statementCN.setString(6, them.getDiaChi());
			statementCN.setString(7, "null");
			statementNV.setString(2, them.getChucVu());
			statementNV.setString(3, them.getCmnd());
			statementNV.setString(4, them.getMatkhau());
			statementNV.setString(1, them.getMa());
			n = statementCN.executeUpdate();
			m = statementNV.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}finally {
			try {
				statementCN.close();
				statementNV.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return n > 0 && m > 0 ? true : false;
	}
	public boolean xoaNhanVien(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sqlNV = "DELETE FROM NhanVien WHERE ma=?";
		String sqlCN = "DELETE FROM ConNguoi WHERE ma=?";
		int n = 0;
		PreparedStatement statementNV = null;
		PreparedStatement statementCN = null;
		try {
			statementNV = con.prepareStatement(sqlNV);
			statementNV.setString(1, ma);
			n = statementNV.executeUpdate();
			statementCN = con.prepareStatement(sqlCN);
			statementCN.setString(1, ma);
			statementCN.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statementNV != null) {
					statementNV.close();
				}
				if (statementCN != null) {
					statementCN.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0 ? true : false;
	}
	public boolean suaNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sqlCN = "UPDATE ConNguoi SET ten=?, sdt=?, gioiTinh=?, email=?, diaChi=? WHERE ma=?";
		String sqlNV = "UPDATE NhanVien SET chucVu=?, cmnd=?, matkhau=? WHERE ma=?";
		int n = 0;
		PreparedStatement statementCN = null;
		PreparedStatement statementNV = null;
		try {
			statementCN = con.prepareStatement(sqlCN);
			statementCN.setString(1, nv.getTen());
			statementCN.setString(2, nv.getSDT());
			statementCN.setBoolean(3, nv.isGioiTinh());
			statementCN.setString(4, nv.getEmail());
			statementCN.setString(5, nv.getDiaChi());
			statementCN.setString(6, nv.getMa());
			statementCN.executeUpdate();
			statementNV = con.prepareStatement(sqlNV);
			statementNV.setString(1, nv.getChucVu());
			statementNV.setString(2, nv.getCmnd());
			statementNV.setString(3, nv.getMatkhau());
			statementNV.setString(4, nv.getMa());
			n = statementNV.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statementCN != null) {
					statementCN.close();
				}
				if (statementNV != null) {
					statementNV.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0 ? true : false;
	}
	public ArrayList<NhanVien> timNhanVienTheoMa(String maNV) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM NhanVien nv JOIN ConNguoi cn ON nv.ma = cn.ma WHERE nv.ma=?";

		
		PreparedStatement statement = null;
		ResultSet rs = null;
		NhanVien nv = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			rs = statement.executeQuery();
			if (rs.next()) {
				String ma = rs.getString("ma");
				String ten = rs.getString("ten");
				String Sdt = rs.getString("sdt");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String email = rs.getString("email");
				String diaChi = rs.getString("diaChi");
				String chucVu = rs.getString("chucVu");
				String Cmnd = rs.getString("cmnd");
				String matKhau = rs.getString("matKhau");
				NhanVien nv1 = new NhanVien(ma, ten, Sdt, gioiTinh, email, diaChi, chucVu, Cmnd, matKhau);
				dsnv.add(nv1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsnv;
	}
	public ArrayList<NhanVien> timTheoGioiTinh(boolean gioiTinh) {
		ArrayList<NhanVien> ds = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM NhanVien nv JOIN ConNguoi cn ON nv.ma = cn.ma WHERE cn.gioiTinh = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setBoolean(1, gioiTinh);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("ma");
				String ten = rs.getString("ten");
				String sdt = rs.getString("sdt");
				boolean gt = rs.getBoolean("gioiTinh");
				String email = rs.getString("email");
				String diaChi = rs.getString("diaChi");
				String chucVu = rs.getString("chucVu");
				String cmnd = rs.getString("cmnd");
				String matkhau = rs.getString("matkhau");
				NhanVien nv = new NhanVien(ma, ten, sdt, gt, email, diaChi, chucVu, cmnd, matkhau);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhanVien> timTheoChucVu(String chucVu) {
	    ArrayList<NhanVien> ds = new ArrayList<>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    String sql = "SELECT * FROM NhanVien nv JOIN ConNguoi cn ON nv.ma = cn.ma WHERE nv.chucVu = ?";
	    try {
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, chucVu);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            String ma = rs.getString("ma");
	            String ten = rs.getString("ten");
	            String sdt = rs.getString("sdt");
	            boolean gt = rs.getBoolean("gioiTinh");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            String cv = rs.getString("chucVu");
	            String cmnd = rs.getString("cmnd");
	            String matkhau = rs.getString("matkhau");
	            NhanVien nv = new NhanVien(ma, ten, sdt, gt, email, diaChi, cv, cmnd, matkhau);
	            ds.add(nv);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ds;
	}
	public int getMaNhanVienMax() {
		int ma = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement statement = con.createStatement();
			String sql = "SELECT top 1 CAST(SUBSTRING(ma, 3, LEN(ma) - 2) as int) AS ma "
					+ "FROM NhanVien order by ma desc";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ma = rs.getInt("ma");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
	
}
