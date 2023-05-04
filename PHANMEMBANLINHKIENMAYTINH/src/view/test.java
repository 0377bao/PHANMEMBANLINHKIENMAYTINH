package view;

import java.sql.SQLException;

import BUS.ChiTietHoaDon_BUS;
import BUS.HoaDon_BUS;
import DAO.ChiTietHoaDon_DAO;
import connectDB.ConnectDB;
import model.ChiTietHoaDon;

public class test {
	public static void main(String[] args) {
		try {
			new ConnectDB().getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ChiTietHoaDon string : new ChiTietHoaDon_BUS().getAllChiTietHoaDonBoiDsHoaDon(new HoaDon_BUS().getAllHoaDon())) {
			System.out.println(string);
		}
	}
}
