package model;

import java.util.Objects;

public class NhanVien extends ConNguoi{
    private String chucVu;
    private String cmnd;
    private String matkhau;

    public NhanVien(String ma, String ten, String sDT, Boolean gioiTinh, String email, String diaChi, String position, String cmnd, String matkhau) {
        super(ma, ten, sDT, gioiTinh, email, diaChi);
        this.chucVu = position;
        this.cmnd = cmnd;
        this.matkhau = matkhau;
    }
    
    public NhanVien(String ma) {
		super(ma);
	}

    public String getCmnd() {
        return cmnd;
    }
    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    
    public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
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

	@Override
	public String toString() {
		return super.toString() + "NhanVien [chucVu=" + chucVu + ", cmnd=" + cmnd + ", matkhau=" + matkhau + "]";
	}

    
    
}
