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
//import BUS.XuLySuKienGuiKhachHang;
//import controller.XuLySuKienChonKhachHang;
import model.HoaDon;
import model.KhachHang;
import model.MyButton;
import model.MyTable;

public class ViewKhachHang extends JFrame{
	private JTextField txtTen, txtSDT;
	private DefaultTableModel model;
	private MyTable table;
	private MyButton btnChon;
	private JLabel lblmaKHMH, lbltenKHMH, lblgiamgia, lblthanhtoan, lbltienThua;
	private HoaDon hoadon;
	private KhachHang khachhang;
	private KhachHang_BUS khachhangbus = new KhachHang_BUS();
	public ViewKhachHang(KhachHang kh, JLabel ma, JLabel ten, JLabel giamgia, JLabel toan, JLabel tienthua, HoaDon hoadon) {
		khachhang = kh;
		lblmaKHMH = ma;
		lbltenKHMH = ten;
		lblgiamgia = giamgia;
		lblthanhtoan = toan;
		lbltienThua = tienthua;
		this.hoadon = hoadon;
		this.setTitle("Thông tin khách hàng");
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
		bleft.add(new JLabel("Tên khách hàng: ")); bleft.add(txtTen = new JTextField());
		txtTen.setPreferredSize(new Dimension(0, 25));
		Box bright = Box.createHorizontalBox();
		bright.add(new JLabel("SDT khách hàng: ")); bright.add(txtSDT = new JTextField());
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
		model.addColumn("Tên khách hàng");
		model.addColumn("SDT");
		model.addColumn("Email");
		model.addColumn("Địa chỉ");
		model.addColumn("Điểm tích lũy");
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
//		btnChon.addActionListener(new XuLySuKienGuiKhachHang(this));
		btnChon.setBounds(300, 25, 100, 30);
		pnlSouth.add(btnChon);
		this.add(pnlSouth, BorderLayout.SOUTH);
		// phần đỗ dữ liệu vào bảng
		doDuLieuVaoBang(khachhangbus.getAllKhachHang());
		// phần thêm sự kiện nhập cho txt
//		txtTen.addKeyListener(new XuLySuKienChonKhachHang(this));
//		txtSDT.addKeyListener(new XuLySuKienChonKhachHang(this));
	}
	
	public void doDuLieuVaoBang(ArrayList<KhachHang> ds) {
		for (KhachHang khachHang : ds) {
			model.addRow(new Object[] {
					khachHang.getMa(),
					khachHang.getTen(),
					khachHang.getSDT(),
					khachHang.getEmail(),
					khachHang.getDiaChi(),
					khachHang.getDiemTichLuy()
,			});;
		}
	}
	
	public void xuLySuKienBtnChon() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên");
		}else {
			ArrayList<KhachHang> ds = khachhangbus.getAllKhachHang();
			for (KhachHang khachHang : ds) {
				if(model.getValueAt(row, 0).toString().equals(khachHang.getMa())) {
					khachhang = khachHang;
					lblmaKHMH.setText(khachhang.getMa());
					lbltenKHMH.setText(khachhang.getTen());
					hoadon.setKhachHang(khachHang);
					lblthanhtoan.setText(String.format("%,.0f", hoadon.tinhTienCanThanhToan()));
					lblgiamgia.setText(String.format("%,.0f", hoadon.giamGia()));
					lbltienThua.setText(String.format("%,.0f", hoadon.tinhTienThua()));
					this.setVisible(false);
				}
			}
		}
	}
	
	public void xuLySuKienNhapTXT() {
		ArrayList<KhachHang> ds = khachhangbus.getAllKhachHang();
		xuLyDuLieuTen(ds);
		xuLyDuLieuSDT(ds);
		model.setRowCount(0);
		doDuLieuVaoBang(ds);
	}
	
	public void xuLyDuLieuTen(ArrayList<KhachHang> ds) {
		String tenp = txtTen.getText();
		if(!tenp.equals("")) {
			ArrayList<KhachHang> tam = new ArrayList<>();
			Pattern p = Pattern.compile(tenp, Pattern.CASE_INSENSITIVE);
			for (KhachHang khachHang : ds) {
				Matcher m = p.matcher(khachHang.getTen());
				if(m.find()) {
					tam.add(khachHang);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
	
	public void xuLyDuLieuSDT(ArrayList<KhachHang> ds) {
		String sdt = txtSDT.getText();
		if(!sdt.equals("")) {
			ArrayList<KhachHang> tam = new ArrayList<>();
			Pattern p = Pattern.compile(sdt);
			for (KhachHang khachHang : ds) {
				Matcher m = p.matcher(khachHang.getSDT());
				if(m.find()) {
					tam.add(khachHang);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
}
