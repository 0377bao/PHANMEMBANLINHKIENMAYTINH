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
	
	public boolean themHoaDon(HoaDon hoadon) {
		return hddao.themHoaDon(hoadon);
	}
	
	public String ranDomMaHoaDon() {
		int so = hddao.getMaHoaDonMax();
		so++;
		return "HD" + so;
	}
}
