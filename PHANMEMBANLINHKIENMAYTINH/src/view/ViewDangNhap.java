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

public class ViewDangNhap extends JFrame implements ActionListener{
	public Color mauNenLoGin = new Color(64,64,64);
	public Color mauChuDao = new Color(255,127,80);
	private JTextField txtUserName;
	private JPasswordField txtPassWord;
	private JButton btnDangNhap;
	public Font fontLabel = new Font("Arial", Font.BOLD, 13);
	private JButton btnExit;
	
	public ViewDangNhap() {
		
		GUI();
		btnExit.addActionListener(this);
	}
	
	public void GUI() {
		this.setSize(400, 440);
		this.setLocationRelativeTo(null);
		this.setTitle("Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setResizable(false);
		this.setLayout(null);
		this.setUndecorated(true);

		
		
		//xét hình nền cho giao diện
		ImageIcon logoFrame = new ImageIcon(new ImageIcon("Image\\logodangnhap\\logoFrame.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		this.setIconImage(logoFrame.getImage());
		JPanel jpnTitle = new JPanel();
		
		jpnTitle.setLayout(new FlowLayout());
		jpnTitle.setBounds(0, 0, 400, 40);
		jpnTitle.setBackground(mauChuDao);
		//Box b = Box.createVerticalBox();
		JLabel lblLogo = new JLabel("LOGIN");
		lblLogo.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 290));
		lblLogo.setIcon(logoFrame);
		btnExit = new JButton("X");
		btnExit.setPreferredSize(new Dimension(30,30));
		btnExit.setBorder(null);
		btnExit.setBackground(mauNenLoGin);
		btnExit.setForeground(mauChuDao);
		btnExit.setFocusPainted(false);
		//Code giao diện
		
		
		
		jpnTitle.add(lblLogo);
		jpnTitle.add(btnExit);
		this.add(jpnTitle);
		
		ImageIcon logoLogin = new ImageIcon(new ImageIcon("Image\\logodangnhap\\logoLogin.png").getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
		JLabel lblImgLogion = new JLabel();
		lblImgLogion.setBounds(130, 60, 128, 128);
		lblImgLogion.setIcon(logoLogin);
		
		int x = 30, y = 210, width = 328, height = 30;
		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setBounds(x, y, 200, height);
		lblUserName.setForeground(Color.white);
		lblUserName.setFont(fontLabel);
		txtUserName = new JTextField();
		txtUserName.setBorder(null);
		txtUserName.setFont(fontLabel);
		y += 30;
		txtUserName.setBounds(x, y, width, height);
		
		y += 40;
		JLabel lblPassWord = new JLabel("Password: ");
		lblPassWord.setFont(fontLabel);
		lblPassWord.setForeground(Color.white);
		lblPassWord.setBounds(x, y, 200, height);
		txtPassWord = new JPasswordField();
		txtPassWord.setFont(fontLabel);
		txtPassWord.setBorder(null);
		y += 30;
		txtPassWord.setBounds(x, y, width, height);
		
		y += 65;
		btnDangNhap = new JButton("LOGIN");
		btnDangNhap.setBounds(120, y, 150, 40);
		btnDangNhap.setFocusPainted(false);
		btnDangNhap.setBorder(null);
		btnDangNhap.setFont(new Font("arial", Font.BOLD, 14));
		btnDangNhap.setForeground(mauNenLoGin);
		btnDangNhap.setBackground(mauChuDao);
		
		//xét màu nền cho form login 
		this.getContentPane().setBackground(mauNenLoGin);
		
		
		
		// add các component vào frame
		this.add(lblUserName);
		this.add(txtUserName);
		this.add(lblPassWord);
		this.add(txtPassWord);
		this.add(lblImgLogion);
		this.add(btnDangNhap);
	}
	
	public static void main(String[] args) {
		new ViewDangNhap().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnExit)) {
			System.exit(0);
		}
	}
}