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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;

import model.MauCacDongTrongBang;
import model.MyButton;
import model.MyCombobox;
import model.MyTable;

public class ViewTrangChu extends JFrame{
	//PHẦN KHAI BÁO BIẾN LOCAL
	public Color mauChuDao = new ViewDangNhap().mauChuDao;
	// COMPONENT PHẦN CONTROL
	private ImageIcon iconHinhNen;
	private JLabel lblControlTen, lblHinhNenAvt;
	private MyButton btnControlMuaHang, btnControlSanPham, btnControlHoaDon, btnControlKhuyenMai, btnControlNhanVien, btnControlKhachHang,
	btnControlThongKe, btnControlThoat;
	// COMPONENT PHẦN MUA HÀNG
	// COMPONENT PHẦN SẢN PHẨM
	// COMPONENT PHẦN HÓA ĐƠN
	// COMPONENT PHẦN KHUYẾN MÃI
	// COMPONENT PHẦN NHÂN VIÊN
	// COMPONENT PHẦN KHÁCH HÀNG
	// COMPONENT PHẦN THỐNG KÊ
	
	//CONSTRUCTER
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
		this.GUIControl();
		this.GUIMuaHang();
		this.GUISanPham();
		this.GUIHoaDon();
		this.GUIKhuyenMai();
		this.GUINhanVien();
		this.GUIKhachHang();
		this.GUIThongKe();
	}

	// PHẦN VIẾT GUI CHO CONTROL VÀ THÔNG TIN NHÂN VIÊN
	public void GUIControl() {
		JPanel pnlWest = new JPanel();
		pnlWest.setPreferredSize(new Dimension(200, 0));
		pnlWest.setBackground(mauChuDao);
		pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
		iconHinhNen = new ImageIcon("C:\\Users\\PC\\Pictures\\Hinh nen may tinh\\avt.jpg");
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
		//test
		JPanel pnlcbb = new JPanel();
		MyCombobox cbbbox = new MyCombobox();
		cbbbox.addItem("Huỳnh Quốc Bảo");
		cbbbox.addItem("Huỳnh Quốc Bảo");
		cbbbox.addItem("Huỳnh Quốc Bảo");
		cbbbox.setPreferredSize(new Dimension(150, 25));
		pnlcbb.add(cbbbox);
		this.add(pnlcbb);
	}
	//PHẦN VIẾT GUI CHO MUA HÀNG
	public void GUIMuaHang() {}
	//PHẦN VIẾT GUI CHO SẢN PHẨM
	public void GUISanPham() {}
	//PHẦN VIẾT GUI CHO HÓA ĐƠN
	public void GUIHoaDon() {}
	//PHẦN VIẾT GUI CHO KHUYẾN MÃI
	public void GUIKhuyenMai() {}
	//PHẦN VIẾT GUI CHO NHÂN VIÊN
	public void GUINhanVien() {}
	//PHẦN VIẾT GUI CHO KHÁCH HÀNG
	public void GUIKhachHang() {}
	//PHẦN VIẾT GUI CHO THỐNG KÊ
	public void GUIThongKe() {}
	
	//Hàm chuyển ảnh thành hình tròn để làm avt
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
	
	// HÀM MAIN
	public static void main(String[] args) {
		new ViewTrangChu().setVisible(true);
	}
	
}
