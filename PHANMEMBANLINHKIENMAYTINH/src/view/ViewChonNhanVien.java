package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHang_BUS;
import BUS.NhanVien_BUS;
import controller.XuLySuKienChoChonNhanVien;
import controller.XuLySuKienChonKhachHang;
import model.HoaDon;
import model.KhachHang;
import model.MyButton;
import model.MyTable;
import model.NhanVien;

public class ViewChonNhanVien extends JFrame{
	private ViewTrangChu view;
	private JTextField txtTen, txtSDT;
	private DefaultTableModel model;
	private MyTable table;
	private MyButton btnChon;
	private NhanVien nhanvien;
	private NhanVien_BUS nhanvienbus = new NhanVien_BUS();
	public ViewChonNhanVien(NhanVien nv, ViewTrangChu viewhome) {
		view = viewhome;
		nhanvien = nv;
		this.setTitle("Thông tin nhân viên");
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		//xét hình nền cho giao diện
		ImageIcon logoFrame = new ImageIcon(new ImageIcon("Image\\logodangnhap\\logoFrame.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		this.setIconImage(logoFrame.getImage());
		//Phần north
		JPanel pnlNorth = new JPanel();
		pnlNorth.setLayout(new GridLayout(0, 2, 20, 0));
		Box bleft = Box.createHorizontalBox();
		bleft.add(Box.createHorizontalStrut(20));
		bleft.add(new JLabel("Tên nhân viên: ")); bleft.add(txtTen = new JTextField());
		txtTen.setPreferredSize(new Dimension(0, 25));
		Box bright = Box.createHorizontalBox();
		bright.add(new JLabel("SDT nhân viên: ")); bright.add(txtSDT = new JTextField());
		bright.add(Box.createHorizontalStrut(20));
		txtSDT.setPreferredSize(new Dimension(0, 25));
		pnlNorth.add(Box.createVerticalStrut(20));
		pnlNorth.add(Box.createVerticalStrut(20));
		pnlNorth.add(bleft); 
		pnlNorth.add(bright);
		pnlNorth.add(Box.createVerticalStrut(10));
		this.add(pnlNorth, BorderLayout.NORTH);
		//Phần center
		JPanel pnlCenter = new JPanel();
		model = new DefaultTableModel();
		model.addColumn("Mã");
		model.addColumn("Tên nhân viên");
		model.addColumn("Giới tính");
		model.addColumn("SDT");
		model.addColumn("Email");
		model.addColumn("Địa chỉ");
		model.addColumn("Chức vụ");
		table = new MyTable(model);
		JScrollPane srctb = new JScrollPane(table);
		srctb.setPreferredSize(new Dimension(650, 500));
		pnlCenter.add(srctb);
		this.add(pnlCenter);
		// phần south
		JPanel pnlSouth = new JPanel();
		pnlSouth.setPreferredSize(new Dimension(700, 80));
		pnlSouth.setLayout(null);
		btnChon = new MyButton("Chọn");
		btnChon.addActionListener(new XuLySuKienChoChonNhanVien(this));
		btnChon.setBounds(300, 25, 100, 30);
		pnlSouth.add(btnChon);
		this.add(pnlSouth, BorderLayout.SOUTH);
		// phần đỗ dữ liệu vào bảng
		doDuLieuVaoBang(nhanvienbus.getAllNhanVien());
		// phần thêm sự kiện nhập cho txt
		txtTen.addKeyListener(new XuLySuKienChoChonNhanVien(this));
		txtSDT.addKeyListener(new XuLySuKienChoChonNhanVien(this));
	}
	
	public void doDuLieuVaoBang(ArrayList<NhanVien> ds) {
		for (NhanVien nhanvien : ds) {
			model.addRow(new Object[] {
					nhanvien.getMa(),
					nhanvien.getTen(),
					nhanvien.isGioiTinh()?"Nam":"Nữ",
					nhanvien.getSDT(),
					nhanvien.getEmail(),
					nhanvien.getDiaChi(),
					nhanvien.getChucVu()
			});;
		}
	}
	
	public void xuLySuKienBtnChon() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên cần lọc");
		}else {
			ArrayList<NhanVien> ds = nhanvienbus.getAllNhanVien();
			for (NhanVien nhanVien : ds) {
				if(model.getValueAt(row, 0).toString().equals(nhanVien.getMa())) {
					nhanvien.setMa(nhanVien.getMa());
					nhanvien.setTen(nhanVien.getTen());
					nhanvien.setSDT(nhanVien.getSDT());
					nhanvien.setGioiTinh(nhanVien.isGioiTinh());
					nhanvien.setEmail(nhanVien.getEmail());
					nhanvien.setDiaChi(nhanVien.getDiaChi());
					nhanvien.setChucVu(nhanVien.getChucVu());
					nhanvien.setCmnd(nhanVien.getCmnd());
					nhanvien.setMatkhau(nhanVien.getMatkhau());
					view.locDuLieuVaoBangHoaDon();
					this.setVisible(false);
				}
			}
		}
	}
	
	public void xuLySuKienNhapTXT() {
		ArrayList<NhanVien> ds = nhanvienbus.getAllNhanVien();
		xuLyDuLieuTen(ds);
		xuLyDuLieuSDT(ds);
		model.setRowCount(0);
		doDuLieuVaoBang(ds);
	}
	
	public void xuLyDuLieuTen(ArrayList<NhanVien> ds) {
		String tenp = txtTen.getText();
		if(!tenp.equals("")) {
			ArrayList<NhanVien> tam = new ArrayList<>();
			Pattern p = Pattern.compile(tenp, Pattern.CASE_INSENSITIVE);
			for (NhanVien nhanVien : ds) {
				Matcher m = p.matcher(nhanVien.getTen());
				if(m.find()) {
					tam.add(nhanVien);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
	
	public void xuLyDuLieuSDT(ArrayList<NhanVien> ds) {
		String sdt = txtSDT.getText();
		if(!sdt.equals("")) {
			ArrayList<NhanVien> tam = new ArrayList<>();
			Pattern p = Pattern.compile(sdt);
			for (NhanVien nhanVien : ds) {
				Matcher m = p.matcher(nhanVien.getSDT());
				if(m.find()) {
					tam.add(nhanVien);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
}

