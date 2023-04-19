package BUS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.KhachHang_DAO;
import connectDB.ConnectDB;
import model.KhachHang;

public class KhachHangBUS {
	private KhachHang_DAO khdao = new KhachHang_DAO();
	public KhachHang getKhachHangLe() {
		return khdao.getKhachHangLe();
	}
}
