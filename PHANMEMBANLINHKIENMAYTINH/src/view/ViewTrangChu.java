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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;

import model.MauCacDongTrongBang;
import model.MyButton;
import model.MyCombobox;
import model.MyTable;

public class ViewTrangChu extends JFrame {
	// PHẦN KHAI BÁO BIẾN LOCAL
	public Color mauChuDao = new ViewDangNhap().mauChuDao;
	// COMPONENT PHẦN CONTROL
	private ImageIcon iconHinhNen;
	private JLabel lblControlTen, lblHinhNenAvt;
	private MyButton btnControlMuaHang, btnControlSanPham, btnControlHoaDon, btnControlKhuyenMai, btnControlNhanVien,
			btnControlKhachHang, btnControlThongKe, btnControlThoat;
	private JPanel pnlCenter_KhachHang;
	private MyTable tb_thongTinCaNhan;
	private JTextField txt_maKhachHang, txt_tenKhachHang, txt_soDienThoai, txt_email;
	private DefaultTableModel  model_KHthongTin, model_KHlichSuGD;
	private JRadioButton radNam, radNu;
	// COMPONENT PHẦN MUA HÀNG
	// COMPONENT PHẦN SẢN PHẨM
	// COMPONENT PHẦN HÓA ĐƠN
	// COMPONENT PHẦN KHUYẾN MÃI
	// COMPONENT PHẦN NHÂN VIÊN
	// COMPONENT PHẦN KHÁCH HÀNG
	// COMPONENT PHẦN THỐNG KÊ

	// CONSTRUCTER
	public ViewTrangChu() {
		// phần init trang chủ
		this.setTitle("PHẦN MỀM QUẢN LÝ LINH KIỆN MÁY TÍNH");
		this.setSize(1300, 750);
		this.setMinimumSize(new Dimension(1300, 750));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// xét logo
		ImageIcon logoFrame = new ImageIcon(new ImageIcon("Image\\logodangnhap\\logoFrame.png").getImage()
				.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
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
		iconHinhNen = new ImageIcon("E:\\hinhnen\\1.jpg");
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
		
	}

	// PHẦN VIẾT GUI CHO MUA HÀNG
	public void GUIMuaHang() {
	}

	// PHẦN VIẾT GUI CHO SẢN PHẨM
	public void GUISanPham() {	
	}
	

	// PHẦN VIẾT GUI CHO HÓA ĐƠN
	public void GUIHoaDon() {
	}

	// PHẦN VIẾT GUI CHO KHUYẾN MÃI
	public void GUIKhuyenMai() {
	}

	// PHẦN VIẾT GUI CHO NHÂN VIÊN
	public void GUINhanVien() {
	}

	// PHẦN VIẾT GUI CHO KHÁCH HÀNG
	public void GUIKhachHang() {
		// test panel khách hàng
		// Khai báo các component cần sử dụng
		JLabel lbl_maKhach, lbl_tenKhachHang, lbl_GioiTinh, lbl_soDienThoai, lbl_email, lbl_diaChi, lbl_temp;
		JButton btn_Them, btn_Sua, btn_LamMoi;
		ButtonGroup groupbtn;
		JTextArea txt_Area;
		model_KHthongTin = new DefaultTableModel(
				new String[] { "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Số Điện Thoại", "Email", "Địa Chỉ" },
				0);
		model_KHlichSuGD = new DefaultTableModel(new String[] { "Mã Giao Dịch", "Tên Khách Hàng",
				"Tên Nhân Viên", "Giới Tính", "Số Điện Thoại", "Địa Chỉ", "Ngày Giao Dịch" }, 0);

		pnlCenter_KhachHang = new JPanel();
		pnlCenter_KhachHang.setLayout(null);

		JPanel pnlTop = new JPanel();
		pnlTop.setLayout(null);
		JLabel lbl_thietLapThongTin = new JLabel("Thiết lập thông tin khách hàng");
		pnlCenter_KhachHang.add(lbl_thietLapThongTin);
		lbl_thietLapThongTin.setBounds(40, 5, 1000, 20);
		pnlTop.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlCenter_KhachHang.add(pnlTop);
		pnlTop.setBounds(40, 35, 1000, 220);

		// left pnlTop thiết lập thông tin khách hàng
		Box b = new Box(BoxLayout.X_AXIS);
		b.add(lbl_maKhach = new JLabel("Mã khách hàng: "));
		b.add(txt_maKhachHang = new JTextField());
		txt_maKhachHang.setBorder(BorderFactory.createLoweredBevelBorder());
		b.setBounds(20, 20, 350, 30);

		Box b1 = new Box(BoxLayout.X_AXIS);
		b1.add(lbl_tenKhachHang = new JLabel("Tên khách hàng: "));
		b1.add(txt_tenKhachHang = new JTextField());
		txt_tenKhachHang.setBorder(BorderFactory.createLoweredBevelBorder());
		b1.setBounds(20, 70, 350, 30);

		Box b2 = new Box(BoxLayout.X_AXIS);
		b2.add(lbl_GioiTinh = new JLabel("Giới tính:             "));
		b2.add(lbl_temp = new JLabel());
		b2.add(radNam = new JRadioButton("Nam"));
		b2.add(radNu = new JRadioButton("Nữ"));
		radNam.setFocusPainted(false);
		radNu.setFocusPainted(false);
		groupbtn = new ButtonGroup();
		groupbtn.add(radNam);
		groupbtn.add(radNu);
		b2.setBounds(20, 120, 350, 30);

		Box b3 = new Box(BoxLayout.X_AXIS);
		b3.add(lbl_soDienThoai = new JLabel("Số điện thoại: "));
		b3.add(txt_soDienThoai = new JTextField());
		txt_soDienThoai.setBorder(BorderFactory.createLoweredBevelBorder());
		b3.setBounds(20, 160, 350, 30);

		lbl_maKhach.setPreferredSize(lbl_tenKhachHang.getPreferredSize());
		lbl_soDienThoai.setPreferredSize(lbl_tenKhachHang.getPreferredSize());
		lbl_GioiTinh.setPreferredSize(lbl_tenKhachHang.getPreferredSize());

		// center pnlTop thiết lập thông tin khách hàng
		Box b4 = new Box(BoxLayout.X_AXIS);
		b4.add(lbl_email = new JLabel("Email: "));
		b4.add(txt_email = new JTextField());
		txt_email.setBorder(BorderFactory.createLoweredBevelBorder());
		b4.setBounds(430, 20, 300, 30);

		Box b5 = new Box(BoxLayout.X_AXIS);
		b5.add(lbl_diaChi = new JLabel("Địa chỉ: "));
		b5.add(txt_Area = new JTextArea(8, 15));
		b5.setBounds(430, 80, 300, 80);
		lbl_email.setPreferredSize(lbl_diaChi.getPreferredSize());

		// right pnlTop thiết lập thông tin khách hàng
		JPanel pnRight = new JPanel();
		pnRight.setLayout(null);

		pnRight.add(btn_Them = new MyButton("Thêm"));
		btn_Them.setBounds(20, 0, 150, 40);
		btn_Them.setBorder(BorderFactory.createRaisedBevelBorder());

		pnRight.add(btn_Sua = new MyButton("Sửa"));
		btn_Sua.setBounds(20, 65, 150, 40);
		btn_Sua.setBorder(BorderFactory.createRaisedBevelBorder());

		pnRight.add(btn_LamMoi = new MyButton("Làm mới"));
		btn_LamMoi.setBounds(20, 130, 150, 40);
		btn_LamMoi.setBorder(BorderFactory.createRaisedBevelBorder());
		pnRight.setBounds(780, 20, 200, 180);

		pnlTop.add(b);
		pnlTop.add(b1);
		pnlTop.add(b2);
		pnlTop.add(b3);
		pnlTop.add(b4);
		pnlTop.add(b5);
		pnlTop.add(pnRight);

		// pnl bottom
		JLabel lbl_thongTinKhach = new JLabel("Thông tin khách hàng");
		lbl_thongTinKhach.setBounds(40, 270, 1000, 20);
		pnlCenter_KhachHang.add(lbl_thongTinKhach);
		JPanel pnlBottom = new JPanel();
		pnlCenter_KhachHang.add(pnlBottom);
		pnlBottom.setBounds(40, 300, 1000, 400);
		pnlBottom.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlBottom.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel pn_ThongTinCaNhan = new JPanel();
		JPanel pn_LichSuGiaoDich = new JPanel();
		tabbedPane.addTab("Thông tin cá nhân", taoTabPanel(pn_ThongTinCaNhan, model_KHthongTin));
		tabbedPane.addTab("Lịch sử giao dịch", taoTabPanel(pn_LichSuGiaoDich, model_KHlichSuGD));
		pnlBottom.add(tabbedPane);
		tabbedPane.setBounds(25, 15, 950, 370);
		model_KHthongTin
				.addRow(new Object[] { "123", "Sang", "Nam", "0397866052", "sang@gmail.com", "124/9 Nơ Trang Long" });
        this.add(pnlCenter_KhachHang);
	}

	// PHẦN VIẾT GUI CHO THỐNG KÊ
	public void GUIThongKe() {
	}

	// Hàm tạo panel cho JTabbedPane
	public JPanel taoTabPanel(JPanel temp, DefaultTableModel model) {
		JLabel lbl_timKiem;
		JTextField txt_timKiem;
		temp.setLayout(null);
		temp.setBounds(25, 60, 950, 400);
		Box b8 = new Box(BoxLayout.X_AXIS);
		b8.add(lbl_timKiem = new JLabel("Tìm kiếm: "));
		b8.add(txt_timKiem = new JTextField());
		txt_timKiem.setBorder(BorderFactory.createLoweredBevelBorder());
		b8.setBounds(25, 25, 650, 30);
		temp.add(b8, BorderLayout.NORTH);

		tb_thongTinCaNhan = new MyTable(model);
		JScrollPane sp = new JScrollPane(tb_thongTinCaNhan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBounds(25, 75, 650, 250);

		JPanel pn_loc = new JPanel();
		JLabel lbl_loc = new JLabel("Loc");
		lbl_loc.setBounds(700, 20, 100, 30);
		temp.add(lbl_loc);
		lbl_loc.setFont(new Font("Arial", Font.PLAIN, 16));
		pn_loc.setBorder(BorderFactory.createLoweredBevelBorder());
		pn_loc.setLayout(null);
		JLabel lbl_locGioiTinh = new JLabel("Giới tính: ");
		lbl_locGioiTinh.setBounds(20, 30, 100, 30);
		JLabel lbl_locDiaChi = new JLabel("Địa chỉ: ");
		lbl_locDiaChi.setBounds(20, 120, 100, 30);
		MyCombobox cb_gioiTinh = new MyCombobox();
		cb_gioiTinh.addItem(" Nam");
		cb_gioiTinh.addItem(" Nữ");
		cb_gioiTinh.setBounds(20, 60, 180, 30);

		MyCombobox cb_diaChi = new MyCombobox();
		cb_diaChi.addItem(" Khánh hòa");
		cb_diaChi.addItem(" Kiên giang");
		cb_diaChi.addItem(" Vĩnh long");
		cb_diaChi.setBounds(20, 150, 180, 30);
		pn_loc.add(lbl_locGioiTinh);
		pn_loc.add(cb_gioiTinh);
		pn_loc.add(lbl_locDiaChi);
		pn_loc.add(cb_diaChi);
		pn_loc.setBounds(700, 50, 220, 250);

		temp.add(b8);
		temp.add(sp);
		temp.add(pn_loc);
		return temp;
	}

	// Hàm chuyển ảnh thành hình tròn để làm avt
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
