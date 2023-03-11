package model;

import java.time.LocalDate;

public class Vga extends SanPham {
	private int tienTrinh;
	private int TDP;
	private int cudaCores;

	public Vga() {
		
	}

	
	public Vga(String maSanPham, String tenSanPham, double giaBan, int soLuongTonKho, String nhaSanXuat,
			LocalDate ngaySanXuat, int baoHanh, double giaNhap, int giamGia, int tienTrinh, int tDP, int cudaCores) {
		super(maSanPham, tenSanPham, giaBan, soLuongTonKho, nhaSanXuat, ngaySanXuat, baoHanh, giaNhap, giamGia);
		this.tienTrinh = tienTrinh;
		TDP = tDP;
		this.cudaCores = cudaCores;
	}


	public int getTienTrinh() {
		return tienTrinh;
	}

	public void setTienTrinh(int tienTrinh) {
		this.tienTrinh = tienTrinh;
	}

	public int getTDP() {
		return TDP;
	}

	public void setTDP(int tDP) {
		TDP = tDP;
	}

	public int getCudaCores() {
		return cudaCores;
	}

	public void setCudaCores(int cudaCores) {
		this.cudaCores = cudaCores;
	}
    
	@Override
	public String toString() {
		String str = String.format(" %10d %10d %10d", getTienTrinh(), getTDP(), getCudaCores());
		return super.toString() + str;
	}
}
