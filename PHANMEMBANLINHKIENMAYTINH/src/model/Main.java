package model;

import java.time.LocalDate;

public class Main extends SanPham {
	private String chipSet;
	private String ramHoTro;
	private String cpuHoTro;
	private String doHoa;
	private String oCungHoTro;


	public Main() {
		
	}

	public Main(String maSanPham, String tenSanPham, double giaBan, int soLuongTonKho, String nhaSanXuat,
			LocalDate ngaySanXuat, int baoHanh, double giaNhap, int giamGia, String chipSet, String ramHoTro,
			String cpuHoTro, String doHoa, String oCungHoTro) {
		super(maSanPham, tenSanPham, giaBan, soLuongTonKho, nhaSanXuat, ngaySanXuat, baoHanh, giaNhap, giamGia);
		this.chipSet = chipSet;
		this.ramHoTro = ramHoTro;
		this.cpuHoTro = cpuHoTro;
		this.doHoa = doHoa;
		this.oCungHoTro = oCungHoTro;
	}



	public String getChipSet() {
		return chipSet;
	}

	public void setChipSet(String chipSet) {
		this.chipSet = chipSet;
	}

	public String getRamHoTro() {
		return ramHoTro;
	}

	public void setRamHoTro(String ramHoTro) {
		this.ramHoTro = ramHoTro;
	}

	public String getCpuHoTro() {
		return cpuHoTro;
	}

	public void setCpuHoTro(String cpuHoTro) {
		this.cpuHoTro = cpuHoTro;
	}

	public String getDoHoa() {
		return doHoa;
	}

	public void setDoHoa(String doHoa) {
		this.doHoa = doHoa;
	}

	public String getoCungHoTro() {
		return oCungHoTro;
	}

	public void setoCungHoTro(String oCungHoTro) {
		this.oCungHoTro = oCungHoTro;
	}
    
	@Override
	public String toString() {
		String str = String.format(" %20s %20s %20s %20s %20s", getChipSet(), getRamHoTro(), getCpuHoTro(), getDoHoa(), getoCungHoTro());
		return super.toString() + str;
	}
}
