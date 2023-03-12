package model;

import java.time.LocalDate;


public class test {
    public static void main(String[] args) {
		SanPham sp = new SanPham("001", "Máy May", 1000f, 10, "Trường Sơn", LocalDate.of(2020, 1, 12), 12, 500f, 10);
		Cpu cp1 = new Cpu("002", "Intel i3-1105g7", 8000f, 20, "Trung Quốc", LocalDate.of(2020,1,29), 12, 7000f, 5, 2, 4, 2.5, 3.0, 6, 8);
		Main ma1 = new Main("001", "b360", 10000f, 50, "Trung Quốc", LocalDate.of(2022, 3, 15), 12, 8000f, 5, "gahg", "KingTon", "i3-1155g2", "DirectX12", "SSD");
		Vga vg1 = new Vga("002", "hjsdf", 1000f, 3, "Trsdjfh", LocalDate.of(2022, 1, 1), 12, 68934f, 2, 8, 28, 5);
		Psu ps1 = new Psu("002", "hjsdf", 1000f, 3, "Trsdjfh", LocalDate.of(2022, 1, 1), 12, 68934f, 2, 8, 28, 5);
		Case cs1 = new Case("002", "hjsdf", 1000f, 3, "Trsdjfh", LocalDate.of(2022, 1, 1), 12, 68934f, 2, "8", "28", "5");
		Ram r1 = new Ram("002", "hjsdf", 1000f, 3, "Trsdjfh", LocalDate.of(2022, 1, 1), 12, 68934f, 1, 1, 1);
		System.out.println(sp);
		System.out.println(cp1);
		System.out.println(ma1);
		System.out.println(vg1);
		System.out.println(ps1);
		System.out.println(cs1);
		System.out.println(r1);
		
		DanhSachSanPham ds = new DanhSachSanPham();
		ds.themSanPham(r1);
		ds.themSanPham(cs1);
		
		for(SanPham d:ds.getDSCase()) {
			System.out.println(d.toString());
		};
	}
}
