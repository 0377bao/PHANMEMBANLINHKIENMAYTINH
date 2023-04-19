package model;

import java.time.LocalDate;

public class RAM extends SanPham{
	private int dungLuong;
	private int tocDo;

	public RAM() {
		
	}

	public RAM(String maSanPham, String tenSanPham, double giaBan, int soLuongTonKho, String nhaSanXuat,
			LocalDate ngaySanXuat, int baoHanh, double giaNhap, int giamGia, int dungLuong, int tocDo) {
		super(maSanPham, tenSanPham, giaBan, soLuongTonKho, nhaSanXuat, ngaySanXuat, baoHanh, giaNhap, giamGia);
		this.dungLuong = dungLuong;
		this.tocDo = tocDo;
	}


	public int getDungLuong() {
		return dungLuong;
	}

	public void setDungLuong(int dungLuong) {
		this.dungLuong = dungLuong;
	}

	public int getTocDo() {
		return tocDo;
	}

	public void setTocDo(int tocDo) {
		this.tocDo = tocDo;
	}
    
	@Override
	public String toString() {
		String str = String.format(" %10d %10d", getDungLuong(), getTocDo());
		return super.toString() + str;
	}
}
