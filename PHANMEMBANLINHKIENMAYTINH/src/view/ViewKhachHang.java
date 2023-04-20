package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.util.ArrayList;

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
import BUS.XuLySuKienGuiKhachHang;
import model.KhachHang;
import model.MyButton;
import model.MyTable;

public class ViewKhachHang extends JFrame{
	private JTextField txtTen, txtSDT;
	private DefaultTableModel model;
	private MyTable table;
	private MyButton btnChon;
	private JLabel lblmaKHMH, lbltenKHMH;
	private KhachHang khachhang;
	private KhachHang_BUS khachhangbus = new KhachHang_BUS();
	public ViewKhachHang(KhachHang kh, JLabel ma, JLabel ten) {
		khachhang = kh;
		lblmaKHMH = ma;
		lbltenKHMH = ten;
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
		btnChon.addActionListener(new XuLySuKienGuiKhachHang(this));
		btnChon.setBounds(300, 25, 100, 30);
		pnlSouth.add(btnChon);
		this.add(pnlSouth, BorderLayout.SOUTH);
		// phần đỗ dữ liệu vào bảng
		doDuLieuVaoBang(khachhangbus.getDSKhachHang());
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
			ArrayList<KhachHang> ds = khachhangbus.getDSKhachHang();
			for (KhachHang khachHang : ds) {
				if(model.getValueAt(row, 0).toString().equals(khachHang.getMa())) {
					khachhang = khachHang;
					lblmaKHMH.setText(khachhang.getMa());
					lbltenKHMH.setText(khachhang.getTen());
					this.setVisible(false);
				}
			}
		}
	}
}
