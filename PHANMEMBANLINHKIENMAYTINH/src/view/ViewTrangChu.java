package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import model.MyButton;

public class ViewTrangChu extends JFrame implements ActionListener{
	public Color mauChuDao = new ViewDangNhap().mauChuDao;
	// component phần control
	private ImageIcon iconHinhNen;
	private JLabel lblControlTen, lblHinhNenAvt;
	private MyButton btnControlMuaHang, btnControlSanPham, btnControlHoaDon, btnControlKhuyenMai, btnControlNhanVien, btnControlKhachHang,
	btnControlThongKe, btnControlThoat;
	JPanel pnlMuaHang = new JPanel();
	JPanel pnlSanPham = new JPanel();
	private JLabel lblSanPham;
	private JButton btnTat;
	private JButton btnIn;
	private JPanel pnlNhanVien;
	private JPanel pnlNhanVien_Top;
	private JLabel lblThongTinNhanVien;
	private JLabel lblMaNV;
	private JTextField txtMaNV;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private JLabel lblTen;
	private JTextField txtTen;
	private JLabel lblNS;
	private JTextField txtNS;
	private JLabel lblMK;
	private JTextField txtMK;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JComboBox<String> combo;
	private JLabel lblVaiTro;
	private JLabel lblGioiTinh;
	
	public ViewTrangChu() {
		// phần init trang chủ
		this.setTitle("PHẦN MỀM QUẢN LÝ LINH KIỆN MÁY TÍNH");
		this.setSize(1300, 750);
		this.setMinimumSize(new Dimension(1300, 750));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// xét logo
		ImageIcon logoFrame = new ImageIcon(new ImageIcon("Image\\logodangnhap\\logoFrame.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		this.setIconImage(logoFrame.getImage());
		this.GUI();
	}
	
	public void GUI() {
		// phần control
		JPanel pnlWest = new JPanel();
		pnlWest.setPreferredSize(new Dimension(200, 0));
		pnlWest.setBackground(mauChuDao);
		pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
		iconHinhNen = new ImageIcon("C:\\Users\\pc\\Downloads\\share.PNG");
		pnlWest.add(Box.createVerticalStrut(10));
		pnlWest.add(lblHinhNenAvt = new JLabel(taoHinhTronAvt(iconHinhNen)));
		lblHinhNenAvt.setAlignmentX(Component.CENTER_ALIGNMENT);

		pnlWest.add(Box.createVerticalStrut(10));
		pnlWest.add(lblControlTen = new JLabel("Huỳnh Quốc Bảo"));
		lblControlTen.setFont(new Font("Arial", Font.BOLD, 20));
		lblControlTen.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlWest.add(Box.createVerticalStrut(10));
		
		JPanel pnlWestbtn = new JPanel();
		pnlWestbtn.setBackground(mauChuDao);
		Font fontControlBtn = new Font("Futura", Font.BOLD, 15);
		pnlWestbtn.setLayout(new GridLayout(9, 1));
		pnlWestbtn.add(btnControlMuaHang = new MyButton("Mua Hàng"));
		btnControlMuaHang.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconmuahang.png"));
		btnControlMuaHang.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlSanPham = new MyButton("Sản Phẩm"));
		btnControlSanPham.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconsanpham.png"));
		btnControlSanPham.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlHoaDon = new MyButton("Hóa Đơn"));
		btnControlHoaDon.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconhoadon.png"));
		btnControlHoaDon.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlKhuyenMai = new MyButton("Khuyến Mãi"));
		btnControlKhuyenMai.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconkhuyenmai.png"));
		btnControlKhuyenMai.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlNhanVien = new MyButton("Nhân Viên"));
		btnControlNhanVien.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconnhanvien.png"));
		btnControlNhanVien.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlKhachHang = new MyButton("Khách Hàng"));
		btnControlKhachHang.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconkhachhang.png"));
		btnControlKhachHang.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlThongKe = new MyButton("Thống Kê"));
		btnControlThongKe.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconthongke.png"));
		btnControlThongKe.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlThoat = new MyButton("Thoát"));
		btnControlThoat.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconthoat.png"));
		btnControlThoat.setFont(fontControlBtn);
		
		pnlWest.add(pnlWestbtn);
		this.add(pnlWest, BorderLayout.WEST);
		taoPnlNhanVien();	
		
		
		
		btnControlSanPham.addActionListener(this);
		btnControlMuaHang.addActionListener(this);
		btnControlNhanVien.addActionListener(this);
	}
	public void taoPnlNhanVien() {
		pnlNhanVien = new JPanel();
		pnlNhanVien.setLayout(new BorderLayout());
		pnlNhanVien_Top = new JPanel();
		
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		
		b1.add(lblThongTinNhanVien = new JLabel("Thiết lập thông tin nhân viên"));
		b1.add(Box.createRigidArea(new Dimension(900, 0)));
		b.add(b1);
		
		Box b2 = Box.createHorizontalBox();
		b2.add(Box.createRigidArea(new Dimension(15, 0)));
		pnlNhanVien_Top.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		Box b2_= Box.createVerticalBox();
		Box b2_1 = Box.createHorizontalBox();
		Box b2_2 = Box.createHorizontalBox();
		Box b2_3 = Box.createHorizontalBox();
		Box b2_4 = Box.createHorizontalBox();
		Box b2_5 = Box.createHorizontalBox();
		Box b2_6 = Box.createHorizontalBox();
	
		
		b2_.add(Box.createRigidArea(new Dimension(0, 20)));
		
		
		b2_1.add(lblMaNV = new JLabel("Mã NV"));
		lblMaNV.setPreferredSize(new Dimension(80, 20));
		b2_1.add(txtMaNV = new JTextField(20));
		b2_1.add(Box.createRigidArea(new Dimension(80, 0)));
		b2_1.add(lblSDT = new JLabel("Điện thoại"));
		lblSDT.setPreferredSize(new Dimension(80, 20));
		b2_1.add(txtSDT  = new JTextField(20));
		
		
		
		b2_2.add(lblTen = new JLabel("Tên NV"));
		lblTen.setPreferredSize(new Dimension(80, 20));
		b2_2.add(txtTen = new JTextField(20));
		b2_2.add(Box.createRigidArea(new Dimension(80, 0)));
		b2_2.add(lblNS = new JLabel("Ngày Sinh"));
		lblNS.setPreferredSize(new Dimension(80, 20));
		b2_2.add(txtNS  = new JTextField(20));
		
		
		
		b2_3.add(lblMK = new JLabel("Mật Khẩu"));
		lblMK.setPreferredSize(new Dimension(80, 20));
		b2_3.add(txtMK = new JTextField(20));
		b2_3.add(Box.createRigidArea(new Dimension(80, 0)));
		b2_3.add(lblEmail = new JLabel("Ngày Sinh"));
		lblEmail.setPreferredSize(new Dimension(80, 20));
		b2_3.add(txtEmail  = new JTextField(20));
		
		
		
		b2_4.add(lblVaiTro = new JLabel("Vai Trò"));
		lblVaiTro.setPreferredSize(new Dimension(80, 20));
		combo = new JComboBox<String>();
		combo.addItem("Quản lý");
		combo.addItem("Nhân viên");
		b2_4.add(combo);
		b2_4.add(Box.createRigidArea(new Dimension(80, 0)));
		b2_4.add(lblGioiTinh = new JLabel("Giới Tính"));
		lblGioiTinh.setPreferredSize(new Dimension(80, 20));
		b2_4.add(radNam = new JRadioButton("Nam"));
		b2_4.add(radNu v  = new JRadioButton("Nam"));
		
		
		b2_.add(b2_1);
		b2_.add(Box.createRigidArea(new Dimension(0, 20)));
		b2_.add(b2_2);
		b2_.add(Box.createRigidArea(new Dimension(0, 20)));
		b2_.add(b2_3);
		
		
		
		pnlNhanVien_Top.add(b2_);
		b2.add(pnlNhanVien_Top);		
		b2.add(Box.createRigidArea(new Dimension(15, 0)));
		b.add(b2);
		
		
		pnlNhanVien.add(b,BorderLayout.NORTH);
		add(pnlNhanVien,BorderLayout.CENTER);
	}
	public static ImageIcon taoHinhTronAvt(ImageIcon icon) {
        int diameter = Math.min(icon.getIconWidth(), icon.getIconHeight());
        BufferedImage bi = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape circularShape = new Ellipse2D.Float(0, 0, diameter, diameter);
        g2d.clip(circularShape);
        g2d.drawImage(icon.getImage(), 0, 0, diameter, diameter, null);
        g2d.dispose();
        ImageIcon iconfinal = new ImageIcon(bi);
        iconfinal.setImage(iconfinal.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        return iconfinal;
    }
	
	public static void main(String[] args) {
		new ViewTrangChu().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnControlNhanVien)) {
				
			
		}
	}
	
}
