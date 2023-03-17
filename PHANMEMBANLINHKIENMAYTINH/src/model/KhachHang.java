package model;

public class KhachHang extends ConNguoi{
	private double diemTichLuy;
public KhachHang(String ma, String ten, String sDT, boolean gioiTinh, String email, String diaChi,double diemTichLuy) {
		super(ma, ten, sDT, gioiTinh, email, diaChi);
		// TODO Auto-generated constructor stub
		this.diemTichLuy=diemTichLuy;
	}

public KhachHang(String ma) {
	super(ma);
}

public double getDiemTichLuy() {
	return diemTichLuy;
}
public void setDiemTichLuy(double diemTichLuy) {
	this.diemTichLuy = diemTichLuy;
}
@Override
public String toString() {
	return "KhachHang [diemTichLuy=" + diemTichLuy + "]"
			+super.toString();
}

}
