package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import model.KhachHang;

public class KhachHang_DAO {
	public KhachHang_DAO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<KhachHang> getAllKhachHang(){
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement statement = con.createStatement();
			String sql = "Select * from KhachHang kh join ConNguoi cn on kh.ma = cn.ma ";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString("ma").trim();
				String ten = rs.getString("ten").trim();
				String sdt = rs.getString("sdt").trim();
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String email = rs.getString("email").trim();
				String diaChi = rs.getString("diaChi").trim();
				double diemTichLuy = rs.getDouble("diemTichLuy");
				KhachHang kh = new KhachHang(ma, ten, sdt, gioiTinh, email, diaChi, diemTichLuy);
				ds.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return ds;
	}
	public boolean themKhachHang(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sqlCN = "insert into" + " ConNguoi values(?,?,?,?,?,?,?)";
		String sqlKH = "insert into" +" KhachHang values(?,?) ";
		int n = 0;
		int m =0;
		PreparedStatement statementCN = null;
		PreparedStatement statementKH = null;
		try {
			statementCN = con.prepareStatement(sqlCN);
			statementKH = con.prepareStatement(sqlKH);
			statementCN.setString(1, kh.getMa());
			statementCN.setString(2, kh.getTen());
			statementCN.setString(3, kh.getSDT());
			statementCN.setBoolean(4, kh.isGioiTinh());
			statementCN.setString(5, kh.getEmail());
			statementCN.setString(6, kh.getDiaChi());
			statementCN.setString(7, kh.getClass().getSimpleName());
			statementKH.setString(1, kh.getMa());
			statementKH.setDouble(2, kh.getDiemTichLuy());
			n = statementCN.executeUpdate();
			m = statementKH.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statementCN.close();
				statementKH.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return (n>0&&m>0);
	}
	
	public String getMaKhachHangMax() {
		String ma = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
<<<<<<< HEAD
            Statement statement = con.createStatement();			
=======
			Statement statement = con.createStatement();
>>>>>>> 278de0af19ab204884cb6324ebac63950df3fdf9
			String sql = "Select top 1 * from KhachHang order by ma desc";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ma = rs.getString("ma");
			}
<<<<<<< HEAD
		}catch(SQLException e) {
=======
		} catch (SQLException e) {
			// TODO Auto-generated catch block
>>>>>>> 278de0af19ab204884cb6324ebac63950df3fdf9
			e.printStackTrace();
		}
		return ma;
	}
<<<<<<< HEAD
=======
	
	public void capNhatDiemTichLuyKhachHang(String ma, double CapNhat) {
    	try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection con = ConnectDB.getConnection();
    	String sql = "update KhachHang set diemTichLuy=? where ma = ?";
    	try {
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setDouble(1, CapNhat);
    		stmt.setString(2, ma);
    		stmt.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
>>>>>>> 278de0af19ab204884cb6324ebac63950df3fdf9
}
