package model;

import java.util.Objects;

public class ChiTietHoaDon {
	private int soLuongMua;
	private SanPham sanPham;
	public ChiTietHoaDon(int soLuongMua, SanPham sanPham) {
		super();
		this.soLuongMua = soLuongMua;
		this.sanPham = sanPham;
	}
	int getSoLuongMua() {
		return soLuongMua;
	}
	void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	SanPham getSanPham() {
		return sanPham;
	}
	void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	
	public double tinhTongTien() {
		return soLuongMua * sanPham.getGiaBan() - sanPham.getGiamGia();
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuongMua=" + soLuongMua + ", sanPham=" + sanPham + ", tinhTongTien()=" + tinhTongTien()
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(sanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(sanPham, other.sanPham);
	}
	
	
}
