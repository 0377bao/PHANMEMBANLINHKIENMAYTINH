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
	
	public boolean themNhanVien(NhanVien them) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sqlCN = "insert into" + " ConNguoi values(?,?,?,?,?,?)";
		String sqlNV = "insert into" + " NhanVien values(?,?,?,?)";
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
			statementNV.setString(1, them.getChucVu());
			statementNV.setString(2, them.getCmnd());
			statementNV.setString(3, them.getMatkhau());
			statementNV.setString(4, them.getMa());
			n = statementCN.executeUpdate();
			m = statementNV.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statementCN.close();
				statementNV.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n > 0 && m > 0 ? true : false;
	}
}
