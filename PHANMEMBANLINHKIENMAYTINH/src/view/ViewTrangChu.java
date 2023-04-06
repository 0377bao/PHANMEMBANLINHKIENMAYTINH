package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicBorders.ButtonBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;


import model.MauCacDongTrongBang;
import model.MyButton;
import model.MyCombobox;
import model.MyTable;


public class ViewTrangChu extends JFrame implements ActionListener{

	//PHẦN KHAI BÁO BIẾN LOCAL

	public Color mauChuDao = new ViewDangNhap().mauChuDao;
	// COMPONENT PHẦN CONTROL
	private ImageIcon iconHinhNen;
	private JLabel lblControlTen, lblHinhNenAvt;
	private MyButton btnControlMuaHang, btnControlSanPham, btnControlHoaDon, btnControlKhuyenMai, btnControlNhanVien, btnControlKhachHang,
	btnControlThongKe, btnControlThoat;

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
	private JLabel lblVaiTro;
	private JLabel lblGioiTinh;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private ButtonGroup gr;
	private JLabel lblDiaChi;
	private JTextField txtDiaChi;
	private JLabel lblCMND;
	private JTextField txtCMND;
	private MyButton btnThemNhanVien;
	private MyButton btnSuaNhanVien;
	private MyButton btnLamMoiNhanVien;
	private JPanel pnlNhanVien_Center;
	private JComponent pnlNhanVien_Info;
	private JLabel lblLoc;
	private JLabel lblTimKiem;
	private JLabel lblLocTheoGT;
	private JLabel lblLocTheoVT;
	private JComboBox comboVaiTro;
	private JComboBox comboLocVaiTro;
	private JComboBox comboLocGioiTinh;
	private JTextField txtTimKiemNV;
	private JPanel pnlSreach;
	private JPanel pnlSreachContainer;
	private JPanel pnlSreachContainerNV;
	private DefaultTableModel model;
	private JTable table;
	private JPanel pnlInfor_6;
	
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
		
		 boBorderChoButtonThanhNavbar();
		
		pnlWest.add(pnlWestbtn);
		this.add(pnlWest, BorderLayout.WEST);
		GUINhanVien();
		
		
		
		btnControlSanPham.addActionListener(this);
		btnControlMuaHang.addActionListener(this);
		btnControlNhanVien.addActionListener(this);
	}
	// bỏ border cho thanh tiêu đề
		public void boBorderChoButtonThanhNavbar() {
			btnControlMuaHang.setBorder(null);
			btnControlSanPham.setBorder(null);
			btnControlHoaDon.setBorder(null);
			btnControlKhuyenMai.setBorder(null);
			btnControlThongKe.setBorder(null);
			btnControlThoat.setBorder(null);
			btnControlKhachHang.setBorder(null);
			btnControlNhanVien.setBorder(null);
		}
	public void GUINhanVien() {
		
		
		// Box b 
		Box b = Box.createVerticalBox();
		
		// Tạo title cho phần thông tin nhân viên
		Box bTitleInfor = Box.createHorizontalBox();
		
		bTitleInfor.add(lblThongTinNhanVien = new JLabel("Thiết lập thông tin nhân viên"));
		bTitleInfor.add(Box.createRigidArea(new Dimension(900, 0)));
		
		// Tạo phần chứa thông tin nhân viên
		Box bInforContainer = Box.createHorizontalBox();
		bInforContainer.add(Box.createRigidArea(new Dimension(15, 0)));
		pnlNhanVien_Info = new JPanel();
		pnlNhanVien_Info.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		// Tạo thông tin nhân viên
		
		Box bInfor= Box.createVerticalBox();
		Box bInfor_1 = Box.createHorizontalBox();
		Box bInfor_2 = Box.createHorizontalBox();
		Box bInfor_3 = Box.createHorizontalBox();
		Box bInfor_4 = Box.createHorizontalBox();
		Box bInfor_5 = Box.createHorizontalBox();
		pnlInfor_6 = new JPanel();
	
		
		bInfor.add(Box.createRigidArea(new Dimension(0, 20)));
		
		// line 1
		bInfor_1.add(lblMaNV = new JLabel("Mã NV"));
		lblMaNV.setPreferredSize(new Dimension(80, 20));
		bInfor_1.add(txtMaNV = new JTextField(20));
		bInfor_1.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_1.add(lblSDT = new JLabel("Điện thoại"));
		lblSDT.setPreferredSize(new Dimension(80, 20));
		bInfor_1.add(txtSDT  = new JTextField(20));
		
		// line 2
		bInfor_2.add(lblTen = new JLabel("Tên NV"));
		lblTen.setPreferredSize(new Dimension(80, 20));
		bInfor_2.add(txtTen = new JTextField(20));
		bInfor_2.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_2.add(lblNS = new JLabel("Ngày Sinh"));
		lblNS.setPreferredSize(new Dimension(80, 20));
		bInfor_2.add(txtNS  = new JTextField(20));
		
		// line 3
		bInfor_3.add(lblMK = new JLabel("Mật Khẩu"));
		lblMK.setPreferredSize(new Dimension(80, 20));
		bInfor_3.add(txtMK = new JTextField(20));
		bInfor_3.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_3.add(lblEmail = new JLabel("Email"));
		lblEmail.setPreferredSize(new Dimension(80, 20));
		bInfor_3.add(txtEmail  = new JTextField(20));
		
		// line 4
		bInfor_4.add(lblVaiTro = new JLabel("Vai Trò"));
		lblVaiTro.setPreferredSize(new Dimension(80, 20));
		comboVaiTro = new MyCombobox();
		comboVaiTro.addItem("Quản lý");
		comboVaiTro.addItem("Nhân viên");
		comboVaiTro.setPreferredSize(new Dimension(20, 20));
		bInfor_4.add(comboVaiTro);
		bInfor_4.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_4.add(lblGioiTinh = new JLabel("Giới Tính"));
		lblGioiTinh.setPreferredSize(new Dimension(180, 20));
		bInfor_4.add(radNam = new JRadioButton("Nam"));
		bInfor_4.add(Box.createRigidArea(new Dimension(30, 0)));
		bInfor_4.add(radNu= new JRadioButton("Nữ"));
		gr = new ButtonGroup();
		gr.add(radNam);
		gr.add(radNu);
		
		// line 5
		bInfor_5.add(lblDiaChi = new JLabel("Địa Chỉ"));
		lblDiaChi.setPreferredSize(new Dimension(80, 20));
		bInfor_5.add(txtDiaChi = new JTextField(20));
		bInfor_5.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_5.add(lblCMND = new JLabel("CNMD/CCCD"));
		lblCMND.setPreferredSize(new Dimension(80, 20));
		bInfor_5.add(txtCMND = new JTextField(20));
		
		// line 6
		pnlInfor_6.add(btnThemNhanVien = new MyButton("Thêm"));
		
		btnThemNhanVien.setPreferredSize(new Dimension(70, 30));
		pnlInfor_6.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlInfor_6.add(btnSuaNhanVien = new MyButton("Sửa"));
		btnSuaNhanVien.setPreferredSize(new Dimension(70, 30));
		pnlInfor_6.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlInfor_6.add(btnLamMoiNhanVien = new MyButton("Làm mới"));
		btnLamMoiNhanVien.setPreferredSize(new Dimension(70, 30));
		
		// add các line vào 
		bInfor.add(bInfor_1);
		bInfor.add(Box.createRigidArea(new Dimension(0, 20)));
		bInfor.add(bInfor_2);
		bInfor.add(Box.createRigidArea(new Dimension(0, 20)));
		bInfor.add(bInfor_3);
		bInfor.add(Box.createRigidArea(new Dimension(0, 20)));
		bInfor.add(bInfor_4);
		bInfor.add(Box.createRigidArea(new Dimension(0, 20)));
		bInfor.add(bInfor_5);
		bInfor.add(Box.createRigidArea(new Dimension(0, 20)));	
		bInfor.add(pnlInfor_6);
		
		// add thông tin nhân viên vào phần chứa
		pnlNhanVien_Info.add(bInfor);
		bInforContainer.add(pnlNhanVien_Info);		
		bInforContainer.add(Box.createRigidArea(new Dimension(15, 0)));
		
		// Tạo title phần tìm kiếm 
		Box bTitleSearch = Box.createHorizontalBox();
		
		bTitleSearch.add(lblLoc = new JLabel("Lọc"));
		bTitleSearch.add(Box.createRigidArea(new Dimension(820, 0)));
		bTitleSearch.add(lblTimKiem = new JLabel("Tìm kiếm"));
		bTitleSearch.add(Box.createRigidArea(new Dimension(160, 0)));
		
		
		// Tạo phần Lọc theo giới tính và vai trò
		Box bSreachGT_VT = Box.createHorizontalBox();
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(20, 0)));
		bSreachGT_VT.add(lblLocTheoGT = new JLabel("Lọc theo giới tính"));
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(20, 0)));
		comboLocGioiTinh = new MyCombobox();
		comboLocGioiTinh.addItem("");
		comboLocGioiTinh.addItem("Nam");
		comboLocGioiTinh.addItem("Nữ");
		comboLocGioiTinh.setPreferredSize(new Dimension(60, 20));
		bSreachGT_VT.add(comboLocGioiTinh);
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(170, 0)));
		bSreachGT_VT.add(lblLocTheoVT = new JLabel("Lọc theo vai trò"));
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(20, 0)));
		comboLocVaiTro = new MyCombobox();
		comboLocVaiTro.addItem("");
		comboLocVaiTro.addItem("Quản lý");
		comboLocVaiTro.addItem("Nhân Viên");
		comboLocVaiTro.setPreferredSize(new Dimension(60, 20));
		bSreachGT_VT.add(comboLocVaiTro);
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(20, 0)));
		
		Box bSreachContainerGT_VT = Box.createVerticalBox();
		bSreachContainerGT_VT.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		bSreachContainerGT_VT.add(Box.createRigidArea(new Dimension(0, 10)));
		bSreachContainerGT_VT.add(bSreachGT_VT);
		bSreachContainerGT_VT.add(Box.createRigidArea(new Dimension(0, 10)));
		
		// Tạo phần lọc theo mã nhân viên
		pnlSreachContainerNV = new JPanel();
		pnlSreachContainerNV.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		pnlSreachContainerNV.setLayout(null);
		txtTimKiemNV = new JTextField();
		txtTimKiemNV.setBounds(20, 12, 174, 21);
		pnlSreachContainerNV.add(txtTimKiemNV);
		
		
		// Tạo vùng chứa phần tìm kiếm 	
		pnlSreachContainer = new JPanel();
		pnlSreachContainer.setLayout(null);
		pnlSreachContainer.setPreferredSize(new Dimension(1300, 50));
		bSreachContainerGT_VT.setBounds(15, 0, 740, 45);
		pnlSreachContainer.add(bSreachContainerGT_VT);
		pnlSreachContainerNV.setBounds(856,0 ,214 , 45);
		pnlSreachContainer.add(pnlSreachContainerNV);
		
		
		
		
		
		// Tạo table
		model = new DefaultTableModel();
		model.addColumn("Mã NV");
		model.addColumn("Tên NV");
		model.addColumn("Mật khẩu");
		model.addColumn("Vai Trò");
		model.addColumn("Địa chỉ");
		model.addColumn("Điện thoại");
		model.addColumn("Ngày sinh");
		model.addColumn("Giới Tính");
		model.addColumn("Email");
		model.addColumn("CMND/CCCD");
		table = new MyTable(model);
		JScrollPane croll = new JScrollPane(table); 
		model.addRow(new Object []  {"NV1","Đạt","123","Nhân Viên","778 Thống Nhất","091123","12/12/2003","Nữ","111@gmail.com","111231"});
		croll.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		// Tạo vùng chứa table
		Box bTableContainer = Box.createHorizontalBox();
		bTableContainer.add(Box.createRigidArea(new Dimension(15, 0)));
		bTableContainer.add(croll);
		bTableContainer.add(Box.createRigidArea(new Dimension(15, 0)));
		
		
		
				
		//add vào phần tổng
		b.add(bTitleInfor);
		b.add(bInforContainer);
		b.add(Box.createRigidArea(new Dimension(0, 30)));
		b.add(bTitleSearch);
		b.add(pnlSreachContainer);
		b.add(Box.createRigidArea(new Dimension(0, 15)));
		b.add(bTableContainer);
		
		
		
		add(b,BorderLayout.CENTER);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnControlNhanVien)) {
				
			
		}
	}
	
}
