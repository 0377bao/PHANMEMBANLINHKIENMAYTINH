package model;

import java.util.Objects;

public class ConNguoi {
private String ma;
private String ten;
private String SDT;
private boolean gioiTinh;
private String email;
private String diaChi;
public ConNguoi(String ma, String ten, String sDT, boolean gioiTinh, String email, String diaChi) {
	this.ma = ma;
	this.ten = ten;
	this.SDT = sDT;
	this.gioiTinh = gioiTinh;
	this.email = email;
	this.diaChi = diaChi;
}

public ConNguoi(String ma) {
	this.ma = ma;
}

public String getMa() {
	return ma;
}
public void setMa(String ma) {
	this.ma = ma;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getSDT() {
	return SDT;
}
public void setSDT(String sDT) {
	SDT = sDT;
}
public boolean isGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(boolean gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
@Override
public int hashCode() {
	return Objects.hash(ma);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ConNguoi other = (ConNguoi) obj;
	return Objects.equals(ma, other.ma);
}

@Override
public String toString() {
	return "ConNguoi [ma=" + ma + ", ten=" + ten + ", SDT=" + SDT + ", gioiTinh=" + gioiTinh + ", email=" + email
			+ ", diaChi=" + diaChi + "]";
}


}
