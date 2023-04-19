package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.KhachHang;
import model.MyButton;
import model.MyTable;

public class ViewKhachHang extends JFrame{
	private JTextField txtTen, txtSDT;
	private DefaultTableModel model;
	private MyTable table;
	private MyButton btnChon;
	private KhachHang khachhang;
	public ViewKhachHang(KhachHang kh) {
		khachhang = kh;
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
		btnChon.setBounds(300, 25, 100, 30);
		pnlSouth.add(btnChon);
		this.add(pnlSouth, BorderLayout.SOUTH);
	}
}
