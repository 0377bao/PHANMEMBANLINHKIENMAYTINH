package model;

import java.util.ArrayList;


public class DanhSachNhanVien {
    private ArrayList<NhanVien> danhSachNV;

    public DanhSachNhanVien() {
        danhSachNV = new ArrayList<>();
    }

    public boolean themNhanVien(NhanVien nv) {
        if (danhSachNV.contains(nv)) {
            return false;
        }
        danhSachNV.add(nv);
        return true;
    }

    public boolean xoaNhanVien(NhanVien nv) {
        return danhSachNV.remove(nv);
    }

    public NhanVien timNhanVien(String maNV) {
        for (NhanVien nv : danhSachNV) {
            if (nv.getMa().equals(maNV)) {
                return nv;
            }
        }
        return null;
    }

    public ArrayList<NhanVien> getDanhSachNV() {
        return danhSachNV;
    }
    public boolean suaNhanVien(NhanVien nv) {
        int index = danhSachNV.indexOf(nv);
        if (index == -1) {
            return false;
        }
        danhSachNV.set(index, nv);
        return true;
    }

}
