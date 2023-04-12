package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import model.MyButton;

public class ViewDangNhap extends JFrame{
	public Color mauNenLoGin = new Color(64,64,64);
	public Color mauChuDao = new Color(255,127,80);
	private JTextField txtUserName;
	private JPasswordField txtPassWord;
	private JButton btnDangNhap;
	public Font fontLabel = new Font("Arial", Font.BOLD, 12);
	
	public ViewDangNhap() {
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
		txtUserName = new JTextField();
		txtUserName.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		txtUserName.setFont(fontLabel);
		y += 25;
		txtUserName.setBounds(x, y, width, height);
		
		y += 35;
		JLabel lblPassWord = new JLabel("Password: ");
		lblPassWord.setFont(fontLabel);
		lblPassWord.setForeground(Color.black);
		lblPassWord.setBounds(x, y, 200, height);
		txtPassWord = new JPasswordField();
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
}