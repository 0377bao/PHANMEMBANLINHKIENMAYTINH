package BUS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.HoaDon_DAO;
import connectDB.ConnectDB;
import model.HoaDon;

public class HoaDon_BUS {
	private HoaDon_DAO hddao = new HoaDon_DAO();
	
	public ArrayList<HoaDon> getAllHoaDon () {
		ArrayList<HoaDon> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HoaDon";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
}
