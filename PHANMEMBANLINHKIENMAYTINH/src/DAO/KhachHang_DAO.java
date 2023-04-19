package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import model.KhachHang;

public class KhachHang_DAO {
	public KhachHang getKhachHangLe() {
		KhachHang kh = new KhachHang(null);
		Connection con = ConnectDB.getConnection();
		String sql = "select * from ConNguoi cn join KhachHang kh on cn.ma = kh.ma";
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("ma").trim();
				String ten = rs.getString("ten").trim();
				kh.setMa(ma);
				kh.setTen(ten);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kh;
	}
}
