package view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.MyButton;

public class ViewThemKhachHang extends JFrame{
	private JLabel lblMa, lblTen, lblGioiTinh, lblSDT, lblEmail, lblDiaChi;
	private JTextField txtMa, txtTen, txtSDT, txtEmail;
	private JTextArea txtDiaChi;
	private JRadioButton radNam, radNu;
	private ButtonGroup grbt;
	private MyButton btnThem, btnLamMoi;
	public ViewThemKhachHang() {
		this.setTitle("Thêm khách hàng");
		this.setSize(600, 465);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		Font font = new Font("Arial", Font.BOLD, 13);
		//xét hình nền cho giao diện
		ImageIcon logoFrame = new ImageIcon(new ImageIcon("Image\\logodangnhap\\logoFrame.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		this.setIconImage(logoFrame.getImage());
		//thêm component
		int x = 80, y = 30, width = 120, height = 25;
		lblMa = new JLabel("Mã khách hàng: ");
		lblMa.setBounds(x, y, width, height);
		lblMa.setFont(font);
		y += 45;
		lblTen = new JLabel("Tên khách hàng: ");
		lblTen.setBounds(x, y, width, height);
		lblTen.setFont(font);
		y += 45;
		lblGioiTinh = new JLabel("Giới tính: ");
		lblGioiTinh.setBounds(x, y, width, height);
		lblGioiTinh.setFont(font);
		y += 45;
		lblSDT = new JLabel("Số điện thoại: ");
		lblSDT.setBounds(x, y, width, height);
		lblSDT.setFont(font);
		y += 45;
		lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(x, y, width, height);
		lblEmail.setFont(font);
		y += 45;
		lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setBounds(x, y, width, height);
		lblDiaChi.setFont(font);
		
		x += 130;
		y = 30;
		width = 310;
		txtMa = new JTextField();
		txtMa.setBounds(x, y, width, height);
		y += 45;
		txtTen = new JTextField();
		txtTen.setBounds(x, y, width, height);
		y += 45;
		radNam = new JRadioButton("Nam");
		radNam.setBounds(x, y, 70, height);
		radNam.setFont(font);
		radNu = new JRadioButton("Nữ");
		radNu.setBounds(x + 70, y, 100, height);
		radNu.setFont(font);
		grbt = new ButtonGroup();
		grbt.add(radNam);
		grbt.add(radNu);
		y += 45;
		txtSDT = new JTextField();
		txtSDT.setBounds(x, y, width, height);
		y += 45;
		txtEmail = new JTextField();
		txtEmail.setBounds(x, y, width, height);
		y += 45;
		txtDiaChi = new JTextArea(4, 20);
		JScrollPane src = new JScrollPane(txtDiaChi);
		src.setBounds(x, y, width, 100);
		
		y += 120;
		btnLamMoi = new MyButton("Làm mới");
		btnLamMoi.setBounds(190, y, 100, 30);
		btnThem = new MyButton("Thêm");
		btnThem.setBounds(320, y, 100, 30);
		
		this.add(lblMa);
		this.add(lblTen);
		this.add(lblGioiTinh);
		this.add(lblSDT);
		this.add(lblEmail);
		this.add(lblDiaChi);
		this.add(txtMa);
		this.add(txtTen);
		this.add(radNam);
		this.add(radNu);
		this.add(txtSDT);
		this.add(txtEmail);
		this.add(src);
		this.add(btnThem);
		this.add(btnLamMoi);
	}
}
