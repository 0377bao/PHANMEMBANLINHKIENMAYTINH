import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class frame extends JFrame{
      private JButton btnLogIn;
	private JLabel lblImg;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPass;
	private JTextField txtPass;
	private JLabel lblTitle;



	public frame() {
  		JPanel jpTitle = new JPanel();
  		this.add(jpTitle, BorderLayout.NORTH);
  		jpTitle.add(lblTitle = new JLabel("PHẦN MỀM QUẢN LÝ HIỆU THUỐC"));
  		lblTitle.setFont(new Font("Arial", Font.PLAIN, 30));
  		lblTitle.setForeground(Color.BLUE);

  		// login
  		JPanel jpLogIn = new JPanel();
  		jpLogIn.setLayout(null);
  		jpLogIn.setBackground(Color.WHITE);
  		this.add(jpLogIn);
  		

  		lblUser = new JLabel("User: ");
  		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
  		lblUser.setBounds(410, 110, 45, 13);
  
  		txtUser = new JTextField();
  		txtUser.setBounds(515, 100, 245, 30);
  		txtUser.setColumns(10);
  
  		lblPass = new JLabel("Password:");
  		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
  		lblPass.setBounds(410, 170, 86, 13);
  
  		txtPass = new JPasswordField();
  		txtPass.setBounds(515, 160, 245, 30);
  		txtPass.setColumns(10);
  
  		btnLogIn = new JButton("Đăng nhập");
  		btnLogIn.setBounds(510, 240, 100, 30);
  
  		lblImg = new JLabel();
  		ImageIcon img = new ImageIcon("src/img/bg-img.jpg");
  		lblImg.setIcon(img);
  		lblImg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

  		jpLogIn.add(lblUser);
  		jpLogIn.add(txtUser);
  		jpLogIn.add(lblPass);
  		jpLogIn.add(txtPass);
  		jpLogIn.add(btnLogIn);
  		jpLogIn.add(lblImg);

  		add(lblUser);
  		add(txtUser);
  		add(lblPass);
  		add(txtPass);
  		add(btnLogIn);
  		add(lblImg);
  		
  		// set data
  		txtUser.setText("nhom3");
  		txtPass.setText("147852369");

  		// event
//  		btnLogIn.addActionListener(this);
  		this.getContentPane().add(lblImg);
  		
  		this.setSize(800, 450);
  		this.setLocationRelativeTo(null);
  		this.setTitle("Login");
  		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  		this.setResizable(false);
  		this.setLayout(null);
      }
      
      
      
      public static void main(String[] args) {
		new frame().setVisible(true);
	}
}
