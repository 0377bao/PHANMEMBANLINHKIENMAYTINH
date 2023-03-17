package model;

import java.util.Objects;

public class NhanVien extends ConNguoi{
    private String name;
    private String position;
    private String cmnd;
    private String taikhoan;
    private String matkhau;

    public NhanVien(String ma, String ten, String sDT, Boolean gioiTinh, String email, String diaChi, String position, String cmnd, String taikhoan, String matkhau) {
        super(ma, ten, sDT, gioiTinh, email, diaChi);
        this.position = position;
        this.cmnd = cmnd;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) obj;
        return this.getMa().equals(other.getMa());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getMa());
    }

}
