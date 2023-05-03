package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import BUS.ChiTietHoaDon_BUS;
import BUS.KhachHang_BUS;
import BUS.NhanVien_BUS;
import connectDB.ConnectDB;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;

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
		String sqlHD = "insert into" + " HoaDon values(?,?,?,?,?,?,?,?,?)";
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
			statementHD.setDouble(9, hoaDon.getGiamgia());
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

	
	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HoaDon";
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				Date ngay = rs.getDate("ngayLapHoaDon");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLapHoaDon = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
				double tienKhachTra = rs.getDouble("tienKhachTra");
				String hinhThucThanhToan = rs.getString("hinhThucThanhToan");
				String ghiChu = rs.getString("ghiChu");
				double thueVAT = rs.getDouble("thueVAT");
				String maKH = rs.getString("maKhachHang");
				String maNV = rs.getString("maNhanVien");
				KhachHang kh = new KhachHang_BUS().getkhachHangTheoMa(maKH);
				NhanVien nv = new NhanVien_BUS().getNhanVienByMaNhanVien(maNV);
				ArrayList<ChiTietHoaDon> cthd = new ChiTietHoaDon_BUS().getChiTietHoaDonOfHoaDon(maHoaDon);
				double giamgia = rs.getDouble("giamGia");
				HoaDon hd = new HoaDon(maHoaDon, ngayLapHoaDon, tienKhachTra, hinhThucThanhToan, ghiChu, thueVAT, kh, nv, giamgia);
				hd.setDsChiTietHoaDon(cthd);
				ds.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	
	public HoaDon getHoaDonByMaHoaDon(String ma) {
		HoaDon hoadon = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HoaDon where maHoaDon = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				Date ngay = rs.getDate("ngayLapHoaDon");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLapHoaDon = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
				double tienKhachTra = rs.getDouble("tienKhachTra");
				String hinhThucThanhToan = rs.getString("hinhThucThanhToan");
				String ghiChu = rs.getString("ghiChu");
				double thueVAT = rs.getDouble("thueVAT");
				String maKH = rs.getString("maKhachHang");
				String maNV = rs.getString("maNhanVien");
				KhachHang kh = new KhachHang_BUS().getKhachHangByMaKhachHang(maKH);
				NhanVien nv = new NhanVien_BUS().getNhanVienByMaNhanVien(maNV);
				ArrayList<ChiTietHoaDon> cthd = new ChiTietHoaDon_BUS().getChiTietHoaDonOfHoaDon(maHoaDon);
				double giamgia = rs.getDouble("giamGia");
				HoaDon hd = new HoaDon(maHoaDon, ngayLapHoaDon, tienKhachTra, hinhThucThanhToan, ghiChu, thueVAT, kh, nv, giamgia);
				hd.setDsChiTietHoaDon(cthd);
				hoadon = hd;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hoadon;
	}
}
