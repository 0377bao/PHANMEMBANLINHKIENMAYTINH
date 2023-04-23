package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectDB.ConnectDB;
import model.ChiTietHoaDon;

public class ChiTietHoaDon_DAO {
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
}
