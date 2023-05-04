package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BUS.SanPham_BUS;
import connectDB.ConnectDB;
import model.ChiTietHoaDon;
import model.SanPham;

public class ChiTietHoaDon_DAO {
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() {
		ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from ChiTietHoaDon";
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int soLuongMua = rs.getInt("soLuongMua");
				String maSP = rs.getString("maSanPham").trim();
				SanPham sanPham = new SanPham_BUS().timSanPhamTheoMa(maSP);
				ds.add(new ChiTietHoaDon(soLuongMua, sanPham));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public boolean themChiTietHoaDon(ChiTietHoaDon them) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		String sql = "insert into ChiTietHoaDon values(?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
//			statement.setInt(1, them.);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<ChiTietHoaDon> getChiTietHoaDonOfHoaDon(String maHoaDon) {
		ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from ChiTietHoaDon where maHoaDon = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maHoaDon);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int soLuongMua = rs.getInt("soLuongMua");
				String maSP = rs.getString("maSanPham").trim();
				SanPham sanPham = new SanPham_BUS().timSanPhamTheoMa(maSP);
				ds.add(new ChiTietHoaDon(soLuongMua, sanPham));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public ArrayList<ChiTietHoaDon> getChiTietHoaDonOfMaSanPham(String maSanPham) {
		ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from ChiTietHoaDon where maSanPham = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maSanPham);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int soLuongMua = rs.getInt("soLuongMua");
				String maSP = rs.getString("maSanPham").trim();
				SanPham sanPham = new SanPham_BUS().timSanPhamTheoMa(maSP);
				ds.add(new ChiTietHoaDon(soLuongMua, sanPham));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
