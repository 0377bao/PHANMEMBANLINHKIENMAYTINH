package BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ChiTietHoaDon_DAO;
import connectDB.ConnectDB;
import model.ChiTietHoaDon;
import model.HoaDon;

public class ChiTietHoaDon_BUS {
	private ChiTietHoaDon_DAO cthddao = new ChiTietHoaDon_DAO();
	public ArrayList<ChiTietHoaDon> getChiTietHoaDonOfHoaDon(String maHD) {
		return cthddao.getChiTietHoaDonOfHoaDon(maHD);
	}
	
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() {
		return cthddao.getAllChiTietHoaDon();
	}
	
	// nhận vào một danh sách các chi tiết sản phẩm trả về một danh sách mà không trùng sản phẩm
	public ArrayList<ChiTietHoaDon> taoMangChiTietSanPhamKhongTrung(ArrayList<ChiTietHoaDon> ds) {
		ArrayList<ChiTietHoaDon> dstemp = new ArrayList<>();
		for(int i = 0; i < ds.size(); i++) {
			boolean flag = true;
			for(int j = i - 1; j >= 0; j--) {
				if(ds.get(i).getSanPham().getMaSanPham().equals(ds.get(j).getSanPham().getMaSanPham())){
					flag = false;
					break;
				}
			}
			if(flag) dstemp.add(ds.get(i));
		}
		return dstemp;
	}
	// tính tổng số lượng / sản phẩm
	public int tongSoLuongSanPhamDaBan(String maSanPham) {
		ArrayList<ChiTietHoaDon> ds = cthddao.getChiTietHoaDonOfMaSanPham(maSanPham);
		return ds.size();
	}
	// tính tổng doanh thu / sản phẩm
	public double tongDoanhThuSanPhamDaBan(String maSanPham) {
		double doanhthu = 0;
		ArrayList<ChiTietHoaDon> ds = cthddao.getChiTietHoaDonOfMaSanPham(maSanPham);
		for (ChiTietHoaDon chiTietHoaDon : ds) {
			doanhthu += chiTietHoaDon.tinhTongTien();
		}
		return doanhthu;
	}
	
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDonBoiDsHoaDon(ArrayList<HoaDon> ds) {
		ArrayList<ChiTietHoaDon> dsct = new ArrayList<>();
		for (HoaDon hd : ds) {
			dsct.addAll(this.getChiTietHoaDonOfHoaDon(hd.getMaHoaDon()));
		}
		return dsct;
	}
}
