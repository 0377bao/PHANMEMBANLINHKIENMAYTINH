package model;

import java.time.LocalDate;

public class Case extends SanPham {
	private String chatLieu;
	private String mau;
	private String tuongThich;

	public Case() {
		
	}

	public Case(String maSanPham, String tenSanPham, double giaBan, int soLuongTonKho, String nhaSanXuat,
			LocalDate ngaySanXuat, int baoHanh, double giaNhap, int giamGia, String chatLieu, String mau,
			String tuongThich) {
		super(maSanPham, tenSanPham, giaBan, soLuongTonKho, nhaSanXuat, ngaySanXuat, baoHanh, giaNhap, giamGia);
		this.chatLieu = chatLieu;
		this.mau = mau;
		this.tuongThich = tuongThich;
	}


	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getMau() {
		return mau;
	}

	public void setMau(String mau) {
		this.mau = mau;
	}

	public String getTuongThich() {
		return tuongThich;
	}

	public void setTuongThich(String tuongThich) {
		this.tuongThich = tuongThich;
	}
    
	@Override
	public String toString() {
		String str = String.format(" %20s %20s %20s", getChatLieu(), getMau(), getTuongThich());
		return super.toString() + str;
	}
}
