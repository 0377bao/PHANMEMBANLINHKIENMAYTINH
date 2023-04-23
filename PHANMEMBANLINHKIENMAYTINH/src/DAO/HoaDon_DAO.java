package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import model.ChiTietHoaDon;
import model.HoaDon;

public class HoaDon_DAO {
	public int getMaHoaDonMax() {
		int ma = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement statement = con.createStatement();
			String sql = "SELECT top 1 CAST(SUBSTRING(maHoaDon, 3, LEN(maHoaDon) - 2) as int) AS maHoaDon "
					+ "FROM HoaDon order by maHoaDon desc";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ma = rs.getInt("maHoaDon");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ma;
	}
	
	public boolean themHoaDon(HoaDon hoaDon) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		String sqlHD = "insert into" + " HoaDon values(?,?,?,?,?,?,?,?)";
		String sqlCTHD = "insert into" +" ChiTietHoaDon values(?,?,?)";
		int n = 0;
		int m =0;
		PreparedStatement statementHD = null;
		PreparedStatement statementCTHD = null;
		try {
			statementHD = con.prepareStatement(sqlHD);
			statementCTHD = con.prepareStatement(sqlCTHD);
			statementHD.setString(1, hoaDon.getMaHoaDon());
			Date date = Date.valueOf(hoaDon.getNgayLapHoaDon());
			statementHD.setDate(2, date);
			statementHD.setDouble(3, hoaDon.getTienKhachTra());
			statementHD.setString(4, hoaDon.getHinhThucThanhToan());
			statementHD.setString(5, hoaDon.getGhiChu());
			statementHD.setDouble(6, hoaDon.getThueVAT());
			statementHD.setString(7, hoaDon.getKhachHang().getMa());
			statementHD.setString(8, hoaDon.getNhanVien().getMa());
			n = statementHD.executeUpdate();
			for (ChiTietHoaDon ct : hoaDon.getDsChiTietHoaDon()) {
				statementCTHD.setInt(1, ct.getSoLuongMua());
				statementCTHD.setString(2, ct.getSanPham().getMaSanPham());
				statementCTHD.setString(3, hoaDon.getMaHoaDon());
				m = statementCTHD.executeUpdate();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statementHD.close();
				statementCTHD.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return (n>0&&m>0);
	}
}
