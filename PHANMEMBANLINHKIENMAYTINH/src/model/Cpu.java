package model;

import java.time.LocalDate;

public class Cpu extends SanPham {
	private int soLoi;
	private int soLuong;
	private double tanSoCoSo;
	private double tanSoTurbo;
	private int boNhoDem;
	private int boNhoToiDa;

	public Cpu() {
		
	}
	
	public Cpu(String maSanPham, String tenSanPham, double giaBan, int soLuongTonKho, String nhaSanXuat,
			LocalDate ngaySanXuat, int baoHanh, double giaNhap, int giamGia, int soLoi, int soLuong, double tanSoCoSo,
			double tanSoTurbo, int boNhoDem, int boNhoToiDa) {
		super(maSanPham, tenSanPham, giaBan, soLuongTonKho, nhaSanXuat, ngaySanXuat, baoHanh, giaNhap, giamGia);
		this.soLoi = soLoi;
		this.soLuong = soLuong;
		this.tanSoCoSo = tanSoCoSo;
		this.tanSoTurbo = tanSoTurbo;
		this.boNhoDem = boNhoDem;
		this.boNhoToiDa = boNhoToiDa;
	}


	public int getSoLoi() {
		return soLoi;
	}

	public void setSoLoi(int soLoi) {
		this.soLoi = soLoi;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getTanSoCoSo() {
		return tanSoCoSo;
	}

	public void setTanSoCoSo(double tanSoCoSo) {
		this.tanSoCoSo = tanSoCoSo;
	}

	public double getTanSoTurbo() {
		return tanSoTurbo;
	}

	public void setTanSoTurbo(double tanSoTurbo) {
		this.tanSoTurbo = tanSoTurbo;
	}

	public int getBoNhoDem() {
		return boNhoDem;
	}

	public void setBoNhoDem(int boNhoDem) {
		this.boNhoDem = boNhoDem;
	}

	public int getBoNhoToiDa() {
		return boNhoToiDa;
	}

	public void setBoNhoToiDa(int boNhoToiDa) {
		this.boNhoToiDa = boNhoToiDa;
	}
    
	@Override
	public String toString() {
			String str = String.format(" %10d %10d %10.2f %10.2f %10d %10d", getSoLoi(), getSoLuong(), getTanSoCoSo(), getTanSoTurbo(), getBoNhoDem(), getBoNhoToiDa());
		return super.toString() + str;
	}
}
