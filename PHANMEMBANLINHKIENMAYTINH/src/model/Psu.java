package model;

import java.time.LocalDate;

public class Psu extends SanPham {
	private int congSuat;
	private int hieuSuat;
	private int tuoiTho;



	public Psu() {
		
	}

	public Psu(String maSanPham, String tenSanPham, double giaBan, int soLuongTonKho, String nhaSanXuat,
			LocalDate ngaySanXuat, int baoHanh, double giaNhap, int giamGia, int congSuat, int hieuSuat, int tuoiTho) {
		super(maSanPham, tenSanPham, giaBan, soLuongTonKho, nhaSanXuat, ngaySanXuat, baoHanh, giaNhap, giamGia);
		this.congSuat = congSuat;
		this.hieuSuat = hieuSuat;
		this.tuoiTho = tuoiTho;
	}

	public int getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(int congSuat) {
		this.congSuat = congSuat;
	}

	public int getHieuSuat() {
		return hieuSuat;
	}

	public void setHieuSuat(int hieuSuat) {
		this.hieuSuat = hieuSuat;
	}

	public int getTuoiTho() {
		return tuoiTho;
	}

	public void setTuoiTho(int tuoiTho) {
		this.tuoiTho = tuoiTho;
	}
    
	@Override
	public String toString() {
		String str = String.format(" %10d %10d %10d", getCongSuat(), getHieuSuat(), getTuoiTho());
		return super.toString() + str;
	}
}
