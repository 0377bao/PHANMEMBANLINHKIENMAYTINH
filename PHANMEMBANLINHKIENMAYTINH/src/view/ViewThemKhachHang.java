package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BUS.KhachHang_BUS;
import connectDB.ConnectDB;
import model.KhachHang;
import model.MyButton;

public class ViewThemKhachHang extends JFrame implements ActionListener{
	private KhachHang_BUS khachhangbus = new KhachHang_BUS();
	private KhachHang khachHang;
	private JLabel lblMa, lblTen, lblGioiTinh, lblSDT, lblEmail, lblDiaChi;
	private JTextField txtMa, txtTen, txtSDT, txtEmail;
	private JTextArea txtDiaChi;
	private JRadioButton radNam, radNu;
	private ButtonGroup grbt;
	private MyButton btnThem, btnLamMoi;
	private JLabel lblmaKHMH, lbltenKHMH;
	public ViewThemKhachHang(KhachHang kh, JLabel ma, JLabel ten) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		khachHang = kh;
		lblmaKHMH = ma;
		lbltenKHMH = ten;
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
		txtMa.setEditable(false);
		txtMa.setText(khachhangbus.ranDomMaKhachHang());
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
		// phần thêm sự kiện
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnLamMoi)) {
			txtTen.setText("");
			txtSDT.setText("");
			txtEmail.setText("");
			txtDiaChi.setText("");
			grbt.clearSelection();
			txtTen.requestFocus();
		}else {
			if(!khachhangbus.valiData(txtTen.getText(), txtSDT.getText(), txtEmail.getText(), txtDiaChi.getText(), radNam.isSelected(), radNu.isSelected())) {
				JOptionPane.showMessageDialog(this, khachhangbus.mes);
			}else {
				KhachHang khachhangthem = new KhachHang(txtMa.getText(),txtTen.getText(),txtSDT.getText(),
						radNam.isSelected(),
						txtEmail.getText(),
						txtDiaChi.getText(),
						0
					);
				khachhangbus.themKhachHang(khachhangthem);
				JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
				khachHang = khachhangthem;
				lblmaKHMH.setText(khachHang.getMa());
				lbltenKHMH.setText(khachHang.getTen());
				this.setVisible(false);
			}
		}
	}
}
