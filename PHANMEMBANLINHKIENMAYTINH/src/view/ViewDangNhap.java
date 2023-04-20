package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import BUS.NhanVien_BUS;
//import BUS.NhanVien_BUS;
import connectDB.ConnectDB;
import model.MyButton;
import model.NhanVien;

public class ViewDangNhap extends JFrame implements ActionListener{
	public Color mauNenLoGin = new Color(64,64,64);
	public Color mauChuDao = new Color(255,127,80);
	private JTextField txtUserName;
	private JPasswordField txtPassWord;
	private JButton btnDangNhap;
	public Font fontLabel = new Font("Arial", Font.BOLD, 12);
	private NhanVien_BUS nvbus = new NhanVien_BUS();
	
	public ViewDangNhap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GUI();
	}
	
	public void GUI() {
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setTitle("Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		ImageIcon bgrLogin = new ImageIcon("Image\\logodangnhap\\hinhnendangnhap.jpg");
		JLabel lblbckLogin = new JLabel("");
		lblbckLogin.setIcon(bgrLogin);
		lblbckLogin.setBounds(0,0, bgrLogin.getIconWidth(), bgrLogin.getIconHeight());
		int x = 520, y = 137, width = 245, height = 30;
		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setBounds(x, y, width, height);
		lblUserName.setForeground(Color.black);
		lblUserName.setFont(fontLabel);
		txtUserName = new JTextField("NV1");
		txtUserName.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		txtUserName.setFont(fontLabel);
		y += 25;
		txtUserName.setBounds(x, y, width, height);
		
		y += 35;
		JLabel lblPassWord = new JLabel("Password: ");
		lblPassWord.setFont(fontLabel);
		lblPassWord.setForeground(Color.black);
		lblPassWord.setBounds(x, y, 200, height);
		txtPassWord = new JPasswordField("123456");
		txtPassWord.setFont(fontLabel);
		txtPassWord.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		y += 25;
		txtPassWord.setBounds(x, y, width, height);
		
		y += 40;
		btnDangNhap = new JButton("LOGIN");
		btnDangNhap.setFont(new Font("arial", Font.BOLD, 14));
		btnDangNhap.setFocusPainted(false);
		btnDangNhap.setForeground(mauNenLoGin);
		btnDangNhap.setBackground(mauChuDao);
		btnDangNhap.setBorder(BorderFactory.createRaisedBevelBorder());
		btnDangNhap.setBounds(590, y + 2, 100, 30);
		btnDangNhap.addActionListener(this);
		// add các component vào frame
		this.add(lblUserName);
		this.add(txtUserName);
		this.add(lblPassWord);
		this.add(txtPassWord);
		this.add(btnDangNhap);
		// xét backgound cho login 
		this.getContentPane().add(lblbckLogin);
		//xét hình nền cho giao diện
		ImageIcon logoFrame = new ImageIcon(new ImageIcon("Image\\logodangnhap\\logoFrame.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		this.setIconImage(logoFrame.getImage());
	}
	
	public static void main(String[] args) {
		new ViewDangNhap().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!kiemTraDuLieuRong()) {
			JOptionPane.showMessageDialog(this, "Xin lỗi bạn chưa nhập đầy đủ thông tin. Vui lòng nhập đầy đủ trước khi tiếp tục");
			txtUserName.requestFocus();
		}else {
			String u = txtUserName.getText();
			String p = txtPassWord.getText();
			if(nvbus.kiemTraDangNhap(u, p) != null) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
				this.setVisible(false);
				new ViewTrangChu(nvbus.kiemTraDangNhap(u, p)).setVisible(true);
			}else {
				JOptionPane.showMessageDialog(this, "Thông tin đăng nhập không chính xác. Vui lòng kiểm tra lại tên đăng nhập hoặc mật khẩu");
				txtUserName.requestFocus();
			}
		}
	}
	
	public boolean kiemTraDuLieuRong() {
		String u = txtUserName.getText().trim();
		String p = txtPassWord.getText().trim();
		if(u.equals("") || p.equals("")) {
			return false;
		}
		return true;
	}
}