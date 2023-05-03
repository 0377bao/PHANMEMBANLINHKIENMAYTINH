package BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ChiTietHoaDon_DAO;
import connectDB.ConnectDB;
import model.ChiTietHoaDon;

public class ChiTietHoaDon_BUS {
	private ChiTietHoaDon_DAO cthddao = new ChiTietHoaDon_DAO();
	public ArrayList<ChiTietHoaDon> getChiTietHoaDonOfHoaDon(String maHD) {
		return cthddao.getChiTietHoaDonOfHoaDon(maHD);
	}
}
