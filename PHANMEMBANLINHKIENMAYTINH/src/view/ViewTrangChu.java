package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.ScrollPane;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;

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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableCell;

import controller.LocTheoDanhMuc;

import model.MauCacDongTrongBang;
import model.MyButton;
import model.MyCombobox;
import model.MyTable;
import model.Vga;

public class ViewTrangChu extends JFrame {
	// PHẦN KHAI BÁO BIẾN LOCAL
	public Color mauChuDao = new ViewDangNhap().mauChuDao;
	// COMPONENT PHẦN CONTROL
	private ImageIcon iconHinhNen;
	private JLabel lblControlTen, lblHinhNenAvt;
	private MyButton btnControlMuaHang, btnControlSanPham, btnControlHoaDon, btnControlKhuyenMai, btnControlNhanVien,
			btnControlKhachHang, btnControlThongKe, btnControlThoat;

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
	private JRadioButton radNam_NV;
	private JRadioButton radNu_NV;
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

	private JPanel pnlCenter_KhachHang;
	private MyTable tb_thongTinCaNhan;
	private JTextField txt_maKhachHang, txt_tenKhachHang, txt_soDienThoai, txt_email;
	private DefaultTableModel model_KHthongTin, model_KHlichSuGD;
	private JRadioButton radNam, radNu;
	// COMPONENT PHẦN MUA HÀNG
	private JPanel pnlMuaHang;
	private DefaultTableModel modelMHGioHang, modelMHSanPham;
	private MyTable tableMHGioHang, tableMHSanPham;
	private MyButton btnMHXoa, btnMHXoaAll, btnMHSua;
	private JLabel lblMHTimSP, lblMHDanhMuc;
	private JTextField txtMHTimSP;
	private MyButton btnMHThemSP;
	private MyCombobox cbbMHDanhMuc;
	private DefaultTableModel modelMHCase, modelMHCpu, modelMHRam, modelMHPsu, modelMHVga, modelMHMain;
	private MyTable tableMHCase, tableMHCpu, tableMHRam, tableMHPsu, tableMHVga, tableMHMain;
	private JScrollPane scrMHTable;
	private JLabel lblMHHDMaKH, lblMHHDTenKH, lblMHHDMahds, lblMHHDTongtiens, lblMHHDGiams, lblMHHDThues,
			lblMHHDThanhtoans, lblMHHDTienthuas;
	private JTextField txtMHHDTienKhachDua;
	private JTextArea txtMHHDGhichu;
	private MyCombobox cbbMHHDHinhthuctt;
	private MyButton btnMHHDChon, btnMHHDThem, btnMHHDLammoi, btnMHHDThanhToan;

	// COMPONENT PHẦN SẢN PHẨM
	private JPanel pnlSanPham, pnlSPThongTin;
	public MyCombobox cbbSPDanhMuc;
	private MyCombobox cbbSPNhaSX, cbbSPNgay, cbbSPThang, cbbSPNam;
	private MyButton btnSPThem, btnSPXoa, btnSPSua, btnSPLamMoi;
	private JTextField txtSPMa, txtSPTen, txtSPGiaBan, txtSPSoLuongTon, txtSPBaoHanh, txtSPGiaNhap, txtSPGiamGia;
	// Phần component của cpu (Sản phẩm)
	private JTextField txtSPSoLoi, txtSPSoLuongXuLy, txtSPTanSoCoSo, txtSPTanSoTurbo, txtSPBoNhoDem, txtSPBoNhoToiDa;
	// Phần component của case(Sản phẩm)
	private JTextField txtSPMau, txtSPTuongThich;
	private MyCombobox cbbSPChatLieu;
	// Phần component của main(Sản phẩm)
	private JTextField txtSPMauChipset, txtSPRamHoTro, txtSPCpuHoTro, txtSPDoHoa, txtSPOCungHoTro;
	// Phần component của ram(Sản phẩm)
	private JTextField txtSPDungLuong, txtSPTocDo;
	// Phần component của psu(Sản phẩm)
	private JTextField txtSPCongSuat, txtSPHieuSuat, txtSPTuoiTho;
	// Phần component của vga(Sản phẩm)
	private JTextField txtSPTienTrinh, txtSPTDP, txtSPCudaCores;
	// phần jpanel cho từng loại sản phẩm
	private JPanel pnlSPCPU, pnlSPVGA, pnlSPMAIN, pnlSPRam, pnlSPPSU, pnlSPCase;
	// phàn lọc sản phẩm
	private JPanel pnlLocSP;
	private MyCombobox cbbSPLocDanhMuc, cbbSPLocNhaSX, cbbSPLocGia;
	private JTextField txtSPLocTimKiem;
	// phần table sản phẩm
	public DefaultTableModel modelSP;
	public MyTable tableSP;
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
		boBorderChoButtonThanhNavbar();
		pnlWest.add(pnlWestbtn);
		this.add(pnlWest, BorderLayout.WEST);
		GUIKhachHang();

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

	// PHẦN VIẾT GUI CHO NHÂN VIÊN
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

		Box bInfor = Box.createVerticalBox();
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
		bInfor_1.add(txtSDT = new JTextField(20));

		// line 2
		bInfor_2.add(lblTen = new JLabel("Tên NV"));
		lblTen.setPreferredSize(new Dimension(80, 20));
		bInfor_2.add(txtTen = new JTextField(20));
		bInfor_2.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_2.add(lblNS = new JLabel("Ngày Sinh"));
		lblNS.setPreferredSize(new Dimension(80, 20));
		bInfor_2.add(txtNS = new JTextField(20));

		// line 3
		bInfor_3.add(lblMK = new JLabel("Mật Khẩu"));
		lblMK.setPreferredSize(new Dimension(80, 20));
		bInfor_3.add(txtMK = new JTextField(20));
		bInfor_3.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_3.add(lblEmail = new JLabel("Email"));
		lblEmail.setPreferredSize(new Dimension(80, 20));
		bInfor_3.add(txtEmail = new JTextField(20));

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
		bInfor_4.add(radNam_NV = new JRadioButton("Nam"));
		bInfor_4.add(Box.createRigidArea(new Dimension(30, 0)));
		bInfor_4.add(radNu_NV = new JRadioButton("Nữ"));
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
		pnlSreachContainerNV.setBounds(856, 0, 214, 45);
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
		model.addRow(new Object[] { "NV1", "Đạt", "123", "Nhân Viên", "778 Thống Nhất", "091123", "12/12/2003", "Nữ",
				"111@gmail.com", "111231" });
		croll.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		// Tạo vùng chứa table
		Box bTableContainer = Box.createHorizontalBox();
		bTableContainer.add(Box.createRigidArea(new Dimension(15, 0)));
		bTableContainer.add(croll);
		bTableContainer.add(Box.createRigidArea(new Dimension(15, 0)));

		// add vào phần tổng
		b.add(bTitleInfor);
		b.add(bInforContainer);
		b.add(Box.createRigidArea(new Dimension(0, 30)));
		b.add(bTitleSearch);
		b.add(pnlSreachContainer);
		b.add(Box.createRigidArea(new Dimension(0, 15)));
		b.add(bTableContainer);

		add(b, BorderLayout.CENTER);
	}

	// PHẦN VIẾT GUI CHO MUA HÀNG
	public void GUIMuaHang() {
		pnlMuaHang = new JPanel();
		pnlMuaHang.setLayout(null);
		pnlMuaHang.setBackground(Color.white);
		// x = 1300, y = 750;
		// 1300 - 200 = 1100
		JPanel pnlMuaHangSP = new JPanel();
		JPanel pnlMuaHangHD = new JPanel();

//		pnlMuaHangSP.setPreferredSize(new Dimension(750, 750));
//		pnlMuaHangHD.setPreferredSize(new Dimension(320, 750));
		pnlMuaHangSP.setBounds(0, 0, 750, 750);
		pnlMuaHangHD.setBounds(750, 5, 330, 700);
		pnlMuaHang.add(pnlMuaHangSP);
		pnlMuaHang.add(pnlMuaHangHD);

		// phần Panel Sản Phẩm
		pnlMuaHangSP.setLayout(null);
		pnlMuaHangSP.setBackground(Color.white);
		JPanel pnlMHGioHang = new JPanel();
		JPanel pnlMHSanPham = new JPanel();
		// giỏ hàng
		pnlMHGioHang.setBounds(5, 5, 740, 250);
		pnlMHGioHang.setBackground(Color.white);
		pnlMHGioHang.setBorder(BorderFactory.createTitledBorder("Giỏ hàng"));
		pnlMHGioHang.setLayout(null);
		modelMHGioHang = new DefaultTableModel();
		tableMHGioHang = new MyTable(modelMHGioHang);
		JScrollPane scrTableMHGioHang = new JScrollPane(tableMHGioHang);
		modelMHGioHang.addColumn("Mã sản phẩm");
		modelMHGioHang.addColumn("Tên sản phẩm");
		modelMHGioHang.addColumn("Số lượng");
		modelMHGioHang.addColumn("Đơn giá");
		scrTableMHGioHang.setBounds(15, 25, 550, 210);
		pnlMHGioHang.add(scrTableMHGioHang);

		int y = 50;
		btnMHXoa = new MyButton("Xóa sản phẩm");
		btnMHXoa.setBounds(580, y, 120, 35);
		y += 55;
		btnMHXoaAll = new MyButton("Xóa tất cả");
		btnMHXoaAll.setBounds(580, y, 120, 35);
		y += 55;
		btnMHSua = new MyButton("Cập nhật");
		btnMHSua.setBounds(580, y, 120, 35);
		pnlMHGioHang.add(btnMHXoa);
		pnlMHGioHang.add(btnMHXoaAll);
		pnlMHGioHang.add(btnMHSua);
		// danh sách sản phẩm
		pnlMHSanPham.setBounds(5, 260, 740, 445);
		pnlMHSanPham.setBackground(Color.white);
		pnlMHSanPham.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm"));
		pnlMHSanPham.setLayout(null);

		lblMHTimSP = new JLabel("Tìm kiếm sản phẩm:");
		lblMHTimSP.setBounds(15, 30, 150, 15);

		txtMHTimSP = new JTextField();
		txtMHTimSP.setBounds(15, 50, 200, 25);

		btnMHThemSP = new MyButton("Thêm sản phẩm");
		btnMHThemSP.setBounds(305, 45, 150, 30);

		lblMHDanhMuc = new JLabel("Danh mục:");
		lblMHDanhMuc.setBounds(545, 30, 150, 15);

		cbbMHDanhMuc = new MyCombobox();
		cbbMHDanhMuc.addItem("CASE");
		cbbMHDanhMuc.addItem("CPU");
		cbbMHDanhMuc.addItem("RAM");
		cbbMHDanhMuc.addItem("PSU");
		cbbMHDanhMuc.addItem("VGA");
		cbbMHDanhMuc.addItem("MAIN");
		cbbMHDanhMuc.setBounds(545, 50, 150, 25);

		pnlMHSanPham.add(lblMHTimSP);
		pnlMHSanPham.add(txtMHTimSP);
		pnlMHSanPham.add(btnMHThemSP);
		pnlMHSanPham.add(lblMHDanhMuc);
		pnlMHSanPham.add(cbbMHDanhMuc);

		khoiTaoBangCase();
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		modelMHCase.addRow(new Object[] { "123", "Case", "1.000.000", "100.000", "Acer", "Nhựa", "Trắng", 8, 9 });
		scrMHTable = new JScrollPane(tableMHCase);
		scrMHTable.setBounds(15, 90, 710, 325);

		pnlMHSanPham.add(scrMHTable);

		pnlMuaHangSP.add(pnlMHGioHang);
		pnlMuaHangSP.add(pnlMHSanPham);

		// phần panel hóa đơn (330 x 700)
		pnlMuaHangHD.setBackground(Color.white);
		pnlMuaHangHD.setBorder(BorderFactory.createTitledBorder("Hóa đơn"));
		pnlMuaHangHD.setLayout(null);
		Font fontHd = new Font("Arial", Font.PLAIN, 11);

		JPanel pnlMHKhachHang = new JPanel();
		pnlMHKhachHang.setBounds(15, 25, 300, 80);
		pnlMHKhachHang.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlMHKhachHang.setLayout(null);
		JLabel lblMHMaKH = new JLabel("Mã khách hàng: ");
		JLabel lblMHTenKH = new JLabel("Tên khách hàng: ");
		lblMHMaKH.setBounds(10, 10, 100, 25);
		lblMHMaKH.setFont(fontHd);
		lblMHTenKH.setBounds(10, 40, 100, 25);
		lblMHTenKH.setFont(fontHd);

		lblMHHDMaKH = new JLabel();
		lblMHHDTenKH = new JLabel();
		lblMHHDMaKH.setBounds(110, 10, 100, 25);
		lblMHHDTenKH.setBounds(110, 40, 100, 25);

		lblMHHDMaKH.setText("KH00");
		lblMHHDTenKH.setText("Khách hàng lẻ");

		btnMHHDChon = new MyButton("Chọn");
		btnMHHDThem = new MyButton("Thêm");
		btnMHHDChon.setBounds(220, 10, 70, 25);
		btnMHHDThem.setBounds(220, 40, 70, 25);

		int xhd = 15, yhd = 120, width = 130;
		JLabel lblMHHDMahd = new JLabel("Mã hóa đơn: ");
		lblMHHDMahd.setBounds(xhd, yhd, width, 25);
		lblMHHDMahds = new JLabel("0");
		lblMHHDMahds.setBounds(xhd + width, yhd, 200, 25);

		yhd += 45;
		JLabel lblMHHDTongtien = new JLabel("Tổng tiền: ");
		lblMHHDTongtien.setBounds(xhd, yhd, width, 25);
		lblMHHDTongtiens = new JLabel("0");
		lblMHHDTongtiens.setBounds(xhd + width, yhd, 100, 25);
		JLabel lblVnd1 = new JLabel("VND");
		lblVnd1.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDGiam = new JLabel("Giảm giá: ");
		lblMHHDGiam.setBounds(xhd, yhd, width, 25);
		lblMHHDGiams = new JLabel("0");
		lblMHHDGiams.setBounds(xhd + width, yhd, 100, 25);
		JLabel lblVnd2 = new JLabel("VND");
		lblVnd2.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDThue = new JLabel("Thuế VAT: ");
		lblMHHDThue.setBounds(xhd, yhd, width, 25);
		lblMHHDThues = new JLabel("0");
		lblMHHDThues.setBounds(xhd + width, yhd, 100, 25);
		JLabel lblVnd6 = new JLabel("VND");
		lblVnd6.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDThanhToan = new JLabel("Thanh toán: ");
		lblMHHDThanhToan.setBounds(xhd, yhd, width, 25);
		lblMHHDThanhtoans = new JLabel("0");
		lblMHHDThanhtoans.setBounds(xhd + width, yhd, 100, 25);
		JLabel lblVnd3 = new JLabel("VND");
		lblVnd3.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDTienkhach = new JLabel("Tiền khách đưa: ");
		lblMHHDTienkhach.setBounds(xhd, yhd, width, 25);
		txtMHHDTienKhachDua = new JTextField("0");
		txtMHHDTienKhachDua.setBounds(xhd + width, yhd, 100, 25);
		JLabel lblVnd4 = new JLabel("VND");
		lblVnd4.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDTienthua = new JLabel("Tiền thừa trả khách: ");
		lblMHHDTienthua.setBounds(xhd, yhd, width, 25);
		lblMHHDTienthuas = new JLabel("0");
		lblMHHDTienthuas.setBounds(xhd + width, yhd, 100, 25);
		JLabel lblVnd5 = new JLabel("VND");
		lblVnd5.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDTHinhthuctt = new JLabel("Hình thức thanh toán: ");
		lblMHHDTHinhthuctt.setBounds(xhd, yhd, width, 25);
		cbbMHHDHinhthuctt = new MyCombobox();
		cbbMHHDHinhthuctt.setBounds(xhd + width, yhd, 150, 25);
		cbbMHHDHinhthuctt.addItem("Tiền mặt");
		cbbMHHDHinhthuctt.addItem("Quẹt thẻ");
		cbbMHHDHinhthuctt.addItem("Chuyển khoản");

		yhd += 45;
		JLabel lblMHHDGhichu = new JLabel("Ghi chú: ");
		lblMHHDGhichu.setBounds(xhd, yhd, width, 25);
		txtMHHDGhichu = new JTextArea(4, 20);
		JScrollPane srcMHHDGhichu = new JScrollPane(txtMHHDGhichu);
		srcMHHDGhichu.setBounds(xhd, yhd + 30, 300, 80);

		yhd += 120;
		btnMHHDLammoi = new MyButton("Làm mới");
		btnMHHDLammoi.setBounds(xhd + 100, yhd, 100, 30);

		yhd += 40;
		btnMHHDThanhToan = new MyButton("Thanh toán");
		btnMHHDThanhToan.setBounds(xhd, yhd, 300, 50);
		btnMHHDThanhToan.setFont(new Font("Arial", Font.BOLD, 18));
		btnMHHDThanhToan.setIcon(new ImageIcon("Image\\Muahang\\pay.png"));

		pnlMHKhachHang.add(lblMHMaKH);
		pnlMHKhachHang.add(lblMHTenKH);
		pnlMHKhachHang.add(lblMHHDMaKH);
		pnlMHKhachHang.add(lblMHHDTenKH);
		pnlMHKhachHang.add(btnMHHDChon);
		pnlMHKhachHang.add(btnMHHDThem);

		pnlMuaHangHD.add(pnlMHKhachHang);
		pnlMuaHangHD.add(lblMHHDMahd);
		pnlMuaHangHD.add(lblMHHDMahds);
		pnlMuaHangHD.add(lblMHHDTongtien);
		pnlMuaHangHD.add(lblMHHDTongtiens);
		pnlMuaHangHD.add(lblVnd1);
		pnlMuaHangHD.add(lblMHHDGiam);
		pnlMuaHangHD.add(lblMHHDGiams);
		pnlMuaHangHD.add(lblVnd2);
		pnlMuaHangHD.add(lblMHHDThue);
		pnlMuaHangHD.add(lblMHHDThues);
		pnlMuaHangHD.add(lblVnd6);
		pnlMuaHangHD.add(lblMHHDThanhToan);
		pnlMuaHangHD.add(lblMHHDThanhtoans);
		pnlMuaHangHD.add(lblVnd3);
		pnlMuaHangHD.add(lblMHHDTienkhach);
		pnlMuaHangHD.add(txtMHHDTienKhachDua);
		pnlMuaHangHD.add(lblVnd4);
		pnlMuaHangHD.add(lblMHHDTienthua);
		pnlMuaHangHD.add(lblMHHDTienthuas);
		pnlMuaHangHD.add(lblVnd5);
		pnlMuaHangHD.add(lblMHHDTHinhthuctt);
		pnlMuaHangHD.add(cbbMHHDHinhthuctt);
		pnlMuaHangHD.add(lblMHHDGhichu);
		pnlMuaHangHD.add(srcMHHDGhichu);
		pnlMuaHangHD.add(btnMHHDLammoi);
		pnlMuaHangHD.add(btnMHHDThanhToan);
//		this.add(pnlMuaHang);
	}

	public void khoiTaoBangCase() {
		modelMHCase = new DefaultTableModel();
		tableMHCase = new MyTable(modelMHCase);
		modelMHCase.addColumn("Mã sản phẩm");
		modelMHCase.addColumn("Tên sản phẩm");
		modelMHCase.addColumn("Đơn giá");
		modelMHCase.addColumn("Giảm giá");
		modelMHCase.addColumn("Nhà sản xuất");
		modelMHCase.addColumn("Chất liệu");
		modelMHCase.addColumn("Màu");
		modelMHCase.addColumn("Tương thích");
		modelMHCase.addColumn("Số lượng tồn");
//		tableMHCase.getColumnModel().getColumn(1).setPreferredWidth(120);

	}

	// PHẦN VIẾT GUI CHO SẢN PHẨM
	public void GUISanPham() {
		pnlSanPham = new JPanel();
		pnlSanPham.setLayout(null);
		// phần thông tin sản phẩm
		pnlSPThongTin = new JPanel();
		pnlSPThongTin.setLayout(null);
		pnlSPThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));
		pnlSPThongTin.setBounds(10, 5, 1065, 260);

		int x = 25, y = 20, widthlbl = 90, widthtext = 150, height = 25;

		JLabel lblSPDanhMuc = new JLabel("Danh Mục:");
		lblSPDanhMuc.setBounds(x, y, widthlbl, height);
		cbbSPDanhMuc = new MyCombobox();
		cbbSPDanhMuc.addItem("CPU");
		cbbSPDanhMuc.addItem("CASE");
		cbbSPDanhMuc.addItem("MAIN");
		cbbSPDanhMuc.addItem("PSU");
		cbbSPDanhMuc.addItem("RAM");
		cbbSPDanhMuc.addItem("VGA");
		cbbSPDanhMuc.setBounds(x + widthlbl + 10, y, widthtext, height);
		// add sự kiện cho lọc danh mục sản phẩm
		cbbSPDanhMuc.addActionListener(new LocTheoDanhMuc(this));

		y += 40;
		JLabel lblSPMa = new JLabel("Mã sản phẩm:");
		lblSPMa.setBounds(x, y, widthlbl, height);
		txtSPMa = new JTextField();
		txtSPMa.setBounds(x + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPTen = new JLabel("Tên sản phẩm:");
		lblSPTen.setBounds(x, y, widthlbl, height);
		txtSPTen = new JTextField();
		txtSPTen.setBounds(x + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPGiaBan = new JLabel("Giá Bán:");
		lblSPGiaBan.setBounds(x, y, widthlbl, height);
		txtSPGiaBan = new JTextField();
		txtSPGiaBan.setBounds(x + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPSoLuongTon = new JLabel("Số lượng tồn:");
		lblSPSoLuongTon.setBounds(x, y, widthlbl, height);
		txtSPSoLuongTon = new JTextField();
		txtSPSoLuongTon.setBounds(x + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPNhaSX = new JLabel("Nhà sản xuất:");
		lblSPNhaSX.setBounds(x, y, widthlbl, height);
		cbbSPNhaSX = new MyCombobox();
		cbbSPNhaSX.addItem("ACER");
		cbbSPNhaSX.addItem("MSI");
		cbbSPNhaSX.addItem("DELL");
		cbbSPNhaSX.addItem("HP");
		cbbSPNhaSX.addItem("ASUS");
		cbbSPNhaSX.addItem("GIGABYTE");
		cbbSPNhaSX.setBounds(x + widthlbl + 10, y, widthtext, height);

		// hàng thứ 2
		y = 20;
		x = widthlbl + widthtext + 90;
		JLabel lblSPSoBaoHanh = new JLabel("Bản hành:");
		lblSPSoBaoHanh.setBounds(x, y, widthlbl, height);
		txtSPBaoHanh = new JTextField();
		txtSPBaoHanh.setBounds(x + widthlbl + 10, y, widthtext, height);
		y += 40;
		JLabel lblSPSoGiaNhap = new JLabel("Giá nhập:");
		lblSPSoGiaNhap.setBounds(x, y, widthlbl, height);
		txtSPGiaNhap = new JTextField();
		txtSPGiaNhap.setBounds(x + widthlbl + 10, y, widthtext, height);
		y += 40;
		JLabel lblSPSoGiamGia = new JLabel("Giảm giá:");
		lblSPSoGiamGia.setBounds(x, y, widthlbl, height);
		txtSPGiamGia = new JTextField();
		txtSPGiamGia.setBounds(x + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPNgaySx = new JLabel("Ngày sản xuất:");
		lblSPNgaySx.setBounds(x, y, widthlbl, height);

		cbbSPNgay = new MyCombobox();
		cbbSPNgay.setBounds(x, y + 30, 70, height);
		cbbSPThang = new MyCombobox();
		cbbSPThang.setBounds(x + 70 + 20, y + 30, 70, height);
		cbbSPNam = new MyCombobox();
		cbbSPNam.setBounds(x + 70 * 2 + 20 * 2, y + 30, 70, height);
		themItemChoCbbNgayThangNam();

		// phần sản phẩm cpu;
		x += widthlbl + widthtext + 70;
		pnlSPCPU = new JPanel();
		pnlSPCPU.setLayout(null);
		pnlSPCPU.setBounds(x, 9, 250, 248);
		int x1 = 0;
		y = 11;
		JLabel lblSPSoLoi = new JLabel("Số lõi:");
		lblSPSoLoi.setBounds(x1, y, widthlbl, height);
		txtSPSoLoi = new JTextField();
		txtSPSoLoi.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y += 40;
		JLabel lblSPSoLuongXuLy = new JLabel("Số luồng:");
		lblSPSoLuongXuLy.setBounds(x1, y, widthlbl, height);
		txtSPSoLuongXuLy = new JTextField();
		txtSPSoLuongXuLy.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y += 40;
		JLabel lblSPTanSoCoSo = new JLabel("Tần số cơ sở:");
		lblSPTanSoCoSo.setBounds(x1, y, widthlbl, height);
		txtSPTanSoCoSo = new JTextField();
		txtSPTanSoCoSo.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y += 40;
		JLabel lblSPTanSoTurbo = new JLabel("Tần số turbo:");
		lblSPTanSoTurbo.setBounds(x1, y, widthlbl, height);
		txtSPTanSoTurbo = new JTextField();
		txtSPTanSoTurbo.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y += 40;
		JLabel lblSPBoNhoDem = new JLabel("Bộ nhớ đệm:");
		lblSPBoNhoDem.setBounds(x1, y, widthlbl, height);
		txtSPBoNhoDem = new JTextField();
		txtSPBoNhoDem.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y += 40;
		JLabel lblSPBoNhoToiDa = new JLabel("Bộ nhớ tối đa:");
		lblSPBoNhoToiDa.setBounds(x1, y, widthlbl, height);
		txtSPBoNhoToiDa = new JTextField();
		txtSPBoNhoToiDa.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		pnlSPCPU.add(lblSPSoLoi);
		pnlSPCPU.add(txtSPSoLoi);
		pnlSPCPU.add(lblSPSoLuongXuLy);
		pnlSPCPU.add(txtSPSoLuongXuLy);
		pnlSPCPU.add(lblSPTanSoCoSo);
		pnlSPCPU.add(txtSPTanSoCoSo);
		pnlSPCPU.add(lblSPTanSoTurbo);
		pnlSPCPU.add(txtSPTanSoTurbo);
		pnlSPCPU.add(lblSPBoNhoDem);
		pnlSPCPU.add(txtSPBoNhoDem);
		pnlSPCPU.add(lblSPBoNhoToiDa);
		pnlSPCPU.add(txtSPBoNhoToiDa);

		// phần sản phẩm Vga
		pnlSPVGA = new JPanel();
		pnlSPVGA.setLayout(null);
		pnlSPVGA.setBounds(x, 9, 250, 248);
		x1 = 0;
		y = 11;
		JLabel lblSPTienTrinh = new JLabel("Tiến trình: ");
		lblSPTienTrinh.setBounds(x1, y, widthlbl, height);
		txtSPTienTrinh = new JTextField();
		txtSPTienTrinh.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPTDP = new JLabel("TDP: ");
		lblSPTDP.setBounds(x1, y, widthlbl, height);
		txtSPTDP = new JTextField();
		txtSPTDP.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPCudaCores = new JLabel("CudaCores: ");
		lblSPCudaCores.setBounds(x1, y, widthlbl, height);
		txtSPCudaCores = new JTextField();
		txtSPCudaCores.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		pnlSPVGA.add(lblSPTienTrinh);
		pnlSPVGA.add(txtSPTienTrinh);
		pnlSPVGA.add(lblSPTDP);
		pnlSPVGA.add(txtSPTDP);
		pnlSPVGA.add(lblSPCudaCores);
		pnlSPVGA.add(txtSPCudaCores);

		// phần sản phầm main
		pnlSPMAIN = new JPanel();
		pnlSPMAIN.setLayout(null);
		pnlSPMAIN.setBounds(x, 9, 250, 248);
		x1 = 0;
		y = 11;

		JLabel lblSPChipSet = new JLabel("Chíp Sét: ");
		lblSPChipSet.setBounds(x1, y, widthlbl, height);
		txtSPMauChipset = new JTextField();
		txtSPMauChipset.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPRamHoTro = new JLabel("Ram Hỗ Trợ: ");
		lblSPRamHoTro.setBounds(x1, y, widthlbl, height);
		txtSPRamHoTro = new JTextField();
		txtSPRamHoTro.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPCPUHoTro = new JLabel("Cpu Hỗ Trợ: ");
		lblSPCPUHoTro.setBounds(x1, y, widthlbl, height);
		txtSPCpuHoTro = new JTextField();
		txtSPCpuHoTro.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPDoHoa = new JLabel("Card Đồ Họa: ");
		lblSPDoHoa.setBounds(x1, y, widthlbl, height);
		txtSPDoHoa = new JTextField();
		txtSPDoHoa.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		y += 40;
		JLabel lblSPOCungHoTro = new JLabel("Ổ Cứng Hỗ Trợ: ");
		lblSPOCungHoTro.setBounds(x1, y, widthlbl + 10, height);
		txtSPOCungHoTro = new JTextField();
		txtSPOCungHoTro.setBounds(x1 + widthlbl + 10, y, widthtext, height);

		pnlSPMAIN.add(lblSPChipSet);
		pnlSPMAIN.add(txtSPMauChipset);
		pnlSPMAIN.add(lblSPRamHoTro);
		pnlSPMAIN.add(txtSPRamHoTro);
		pnlSPMAIN.add(lblSPCPUHoTro);
		pnlSPMAIN.add(txtSPCpuHoTro);
		pnlSPMAIN.add(lblSPDoHoa);
		pnlSPMAIN.add(txtSPDoHoa);
		pnlSPMAIN.add(lblSPOCungHoTro);
		pnlSPMAIN.add(txtSPOCungHoTro);

		// phần sản phẩm Ram
		pnlSPRam = new JPanel();
		pnlSPRam.setLayout(null);
		pnlSPRam.setBounds(x, 9, 250, 248);

		x1 = 0;
		y = 11;
		JLabel lblSPDungLuong = new JLabel("Dung Lượng: ");
		lblSPDungLuong.setBounds(x1, y, widthlbl, height);
		txtSPDungLuong = new JTextField();
		txtSPDungLuong.setBounds(x1 + widthlbl, y, widthtext, height);

		y += 40;
		JLabel lblSPTocDo = new JLabel("Tốc Độ: ");
		lblSPTocDo.setBounds(x1, y, widthlbl, height);
		txtSPTocDo = new JTextField();
		txtSPTocDo.setBounds(x1 + widthlbl, y, widthtext, height);
		pnlSPRam.add(lblSPDungLuong);
		pnlSPRam.add(txtSPDungLuong);
		pnlSPRam.add(lblSPTocDo);
		pnlSPRam.add(txtSPTocDo);

		// phần sản phẩm psu
		pnlSPPSU = new JPanel();
		pnlSPPSU.setLayout(null);
		pnlSPPSU.setBounds(x, 9, 250, 248);

		x1 = 0;
		y = 11;
		JLabel lblSPCongSuat = new JLabel("Công Suất: ");
		lblSPCongSuat.setBounds(x1, y, widthlbl, height);
		txtSPCongSuat = new JTextField();
		txtSPCongSuat.setBounds(x1 + widthlbl, y, widthtext, height);

		y += 40;
		JLabel lblSPHieuSuat = new JLabel("Hiệu Suất: ");
		lblSPHieuSuat.setBounds(x1, y, widthlbl, height);
		txtSPHieuSuat = new JTextField();
		txtSPHieuSuat.setBounds(x1 + widthlbl, y, widthtext, height);

		y += 40;
		JLabel lblSPTuoiTho = new JLabel("Tuổi Thọ: ");
		lblSPTuoiTho.setBounds(x1, y, widthlbl, height);
		txtSPTuoiTho = new JTextField();
		txtSPTuoiTho.setBounds(x1 + widthlbl, y, widthtext, height);

		pnlSPPSU.add(lblSPCongSuat);
		pnlSPPSU.add(txtSPCongSuat);
		pnlSPPSU.add(lblSPHieuSuat);
		pnlSPPSU.add(txtSPHieuSuat);
		pnlSPPSU.add(lblSPTuoiTho);
		pnlSPPSU.add(txtSPTuoiTho);

		// phần sản phẩm case
		pnlSPCase = new JPanel();
		pnlSPCase.setLayout(null);
		pnlSPCase.setBounds(x, 9, 250, 248);

		x1 = 0;
		y = 11;
		JLabel lblSPChatLieu = new JLabel("Chất Liệu: ");
		lblSPChatLieu.setBounds(x1, y, widthlbl, height);
		cbbSPChatLieu = new MyCombobox();
		cbbSPChatLieu.setBounds(x1 + widthlbl, y, widthtext, height);
		cbbSPChatLieu.addItem("Nhựa");
		cbbSPChatLieu.addItem("Kim Loại");

		y += 40;
		JLabel lblSPMau = new JLabel("Màu Sắc: ");
		lblSPMau.setBounds(x1, y, widthlbl, height);
		txtSPMau = new JTextField();
		txtSPMau.setBounds(x1 + widthlbl, y, widthtext, height);

		y += 40;
		JLabel lblSPTuongThich = new JLabel("Tương Thích: ");
		lblSPTuongThich.setBounds(x1, y, widthlbl, height);
		txtSPTuongThich = new JTextField();
		txtSPTuongThich.setBounds(x1 + widthlbl, y, widthtext, height);

		pnlSPCase.add(lblSPChatLieu);
		pnlSPCase.add(cbbSPChatLieu);
		pnlSPCase.add(lblSPMau);
		pnlSPCase.add(txtSPMau);
		pnlSPCase.add(lblSPTuongThich);
		pnlSPCase.add(txtSPTuongThich);
		// phần btn sản phẩm
		x += widthlbl + widthtext + 50;
		y = 40;
		btnSPThem = new MyButton("Thêm");
		btnSPThem.setBounds(x, y, 120, 35);
		y += 50;
		btnSPXoa = new MyButton("Xóa");
		btnSPXoa.setBounds(x, y, 120, 35);
		y += 50;
		btnSPSua = new MyButton("Sửa");
		btnSPSua.setBounds(x, y, 120, 35);
		y += 50;
		btnSPLamMoi = new MyButton("Làm mới");
		btnSPLamMoi.setBounds(x, y, 120, 35);

		pnlSPThongTin.add(lblSPDanhMuc);
		pnlSPThongTin.add(cbbSPDanhMuc);
		pnlSPThongTin.add(lblSPMa);
		pnlSPThongTin.add(txtSPMa);
		pnlSPThongTin.add(lblSPTen);
		pnlSPThongTin.add(txtSPTen);
		pnlSPThongTin.add(lblSPGiaBan);
		pnlSPThongTin.add(txtSPGiaBan);
		pnlSPThongTin.add(lblSPSoLuongTon);
		pnlSPThongTin.add(txtSPSoLuongTon);
		pnlSPThongTin.add(lblSPNhaSX);
		pnlSPThongTin.add(cbbSPNhaSX);
		pnlSPThongTin.add(lblSPSoBaoHanh);
		pnlSPThongTin.add(txtSPBaoHanh);
		pnlSPThongTin.add(lblSPSoGiaNhap);
		pnlSPThongTin.add(txtSPGiaNhap);
		pnlSPThongTin.add(lblSPSoGiamGia);
		pnlSPThongTin.add(txtSPGiamGia);
		pnlSPThongTin.add(lblSPNgaySx);
		pnlSPThongTin.add(cbbSPNgay);
		pnlSPThongTin.add(cbbSPThang);
		pnlSPThongTin.add(cbbSPNam);
		pnlSPThongTin.add(pnlSPCPU);
		pnlSPThongTin.add(btnSPThem);
		pnlSPThongTin.add(btnSPXoa);
		pnlSPThongTin.add(btnSPSua);
		pnlSPThongTin.add(btnSPLamMoi);

		// phần lọc sản phẩm
		pnlLocSP = new JPanel();
		pnlLocSP.setLayout(null);
		pnlLocSP.setBorder(BorderFactory.createTitledBorder("Lọc sản phẩm"));
		pnlLocSP.setBounds(10, 270, 1065, 100);

		JPanel pnlLocSP1 = new JPanel();
		JPanel pnlLocSP2 = new JPanel();
		JPanel pnlLocSP3 = new JPanel();
		JPanel pnlLocSP4 = new JPanel();

		pnlLocSP1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 50)));
		pnlLocSP2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 50)));
		pnlLocSP3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 50)));
		pnlLocSP4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 50)));

		pnlLocSP1.setBounds(30, 20, 200, 65);
		pnlLocSP2.setBounds(260, 20, 200, 65);
		pnlLocSP3.setBounds(490, 20, 200, 65);
		pnlLocSP4.setBounds(725, 20, 310, 65);

		pnlLocSP1.add(new JLabel("Danh mục: "));
		pnlLocSP1.add(cbbSPLocDanhMuc = new MyCombobox());
		cbbSPLocDanhMuc.setPreferredSize(new Dimension(170, 25));
		cbbSPLocDanhMuc.addItem("CPU");
		cbbSPLocDanhMuc.addItem("CASE");
		cbbSPLocDanhMuc.addItem("MAIN");
		cbbSPLocDanhMuc.addItem("PSU");
		cbbSPLocDanhMuc.addItem("RAM");
		cbbSPLocDanhMuc.addItem("VGA");
		cbbSPLocDanhMuc.addItem("Tất cả");
		cbbSPLocDanhMuc.setSelectedIndex(6);

		pnlLocSP2.add(new JLabel("Nhà sản xuất: "));
		pnlLocSP2.add(cbbSPLocNhaSX = new MyCombobox());
		cbbSPLocNhaSX.setPreferredSize(new Dimension(170, 25));
		cbbSPLocNhaSX.addItem("ACER");
		cbbSPLocNhaSX.addItem("MSI");
		cbbSPLocNhaSX.addItem("DELL");
		cbbSPLocNhaSX.addItem("HP");
		cbbSPLocNhaSX.addItem("ASUS");
		cbbSPLocNhaSX.addItem("GIGABYTE");
		cbbSPLocNhaSX.addItem("Tất cả");
		cbbSPLocNhaSX.setSelectedIndex(6);

		pnlLocSP3.add(new JLabel("Giá bán: "));
		pnlLocSP3.add(cbbSPLocGia = new MyCombobox());
		cbbSPLocGia.setPreferredSize(new Dimension(170, 25));
		cbbSPLocGia.addItem("");
		cbbSPLocGia.addItem("0 - 1.000.000");
		cbbSPLocGia.addItem("1.000.000 - 2.000.000");
		cbbSPLocGia.addItem("2.000.000 - 3.000.000");
		cbbSPLocGia.addItem("3.000.000 - 4.000.000");
		cbbSPLocGia.addItem("4.000.000 - 5.000.000");
		cbbSPLocGia.addItem(" > 5.000.000");

		pnlLocSP4.add(new JLabel("Tìm kiếm sản phẩm: "));
		pnlLocSP4.add(txtSPLocTimKiem = new JTextField());
		txtSPLocTimKiem.setPreferredSize(new Dimension(280, 25));

		pnlLocSP.add(pnlLocSP1);
		pnlLocSP.add(pnlLocSP2);
		pnlLocSP.add(pnlLocSP3);
		pnlLocSP.add(pnlLocSP4);

		// đổi màu panel
		pnlSPCPU.setBackground(Color.white);
		pnlSPMAIN.setBackground(Color.WHITE);
		pnlSPVGA.setBackground(Color.WHITE);
		pnlSPPSU.setBackground(Color.WHITE);
		pnlSPRam.setBackground(Color.WHITE);
		pnlSPCase.setBackground(Color.WHITE);

		// phần table sản phẩm
		String[] cols = { "Mã sản phẩm", "Tên Sản Phẩm", "Giá Bán", "Số Lượng Tồn", "Nhà Sản Xuất", "Ngày Sản Xuất",
				"Bảo Hành", "Giá Nhập", "Giảm Giá" };
		modelSP = new DefaultTableModel(cols, 0);
		tableSP = new MyTable(modelSP);
		JScrollPane scroll = new JScrollPane(tableSP);
		scroll.setBounds(10, 380, 1065, 325);

		// add sự kiện click cho table
		tableSP.addMouseListener(new LocTheoDanhMuc(this));

		// thêm các đối tượng để fill vào table
		modelSP.addRow(new Object[] { "N001", "CPU", 1000, 5, "Acer", "12-05-2023", 1, 800, 2 });
		modelSP.addRow(new Object[] { "N002", "VGA", 2000, 6, "MSI", "12-06-2023", 1, 1800, 1 });
		modelSP.addRow(new Object[] { "N003", "PSU", 3000, 7, "HP", "12-07-2023", 1, 2800, 2 });
		modelSP.addRow(new Object[] { "N004", "MAIN", 4000, 8, "Dell", "12-08-2023", 1, 3800, 1 });
		modelSP.addRow(new Object[] { "N005", "RAM", 5000, 9, "Acer", "12-09-2023", 1, 4800, 2 });
		modelSP.addRow(new Object[] { "N006", "Case", 6000, 10, "MSI", "12-10-2023", 1, 5800, 1 });
		modelSP.addRow(new Object[] { "N007", "RAM", 7000, 11, "Dell", "12-11-2023", 1, 6800, 2 });
		modelSP.addRow(new Object[] { "N008", "CPU", 8000, 12, "MSI", "12-01-2023", 1, 7800, 2 });
		modelSP.addRow(new Object[] { "N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1 });
		modelSP.addRow(new Object[] { "N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1 });
		modelSP.addRow(new Object[] { "N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1 });
		modelSP.addRow(new Object[] { "N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1 });
		modelSP.addRow(new Object[] { "N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1 });

		pnlSanPham.add(pnlSPThongTin);
		pnlSanPham.add(pnlLocSP);
		pnlSanPham.add(scroll);
		pnlSanPham.setBackground(Color.WHITE);
		pnlSPThongTin.setBackground(Color.WHITE);
		pnlLocSP.setBackground(Color.WHITE);
		this.add(pnlSanPham);
	}

	public void themItemChoCbbNgayThangNam() {
		for (int i = 1; i <= 31; i++) {
			cbbSPNgay.addItem(i + "");
		}
		for (int i = 1; i <= 12; i++) {
			cbbSPThang.addItem(i + "");
		}
		for (int i = 2000; i <= 2023; i++) {
			cbbSPNam.addItem(i + "");
		}
	}

	// PHẦN VIẾT GUI CHO HÓA ĐƠN
	public void GUIHoaDon() {
		JPanel pnHoaDon = new JPanel(new GridLayout(2, 1));
		add(pnHoaDon, BorderLayout.CENTER);
		JPanel pnNorthHoaDon = new JPanel();
		pnHoaDon.add(pnNorthHoaDon, BorderLayout.SOUTH);
		pnNorthHoaDon.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		JPanel pntimKiem = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(10);
		pntimKiem.setLayout(flowLayout);
		JLabel lbltimKiemHoaDon = new JLabel("Tìm Kiếm Hóa Đơn :");
		JTextField txttimKiemHoaDon = new JTextField(70);
		pntimKiem.add(lbltimKiemHoaDon);
		pntimKiem.add(txttimKiemHoaDon);
		txttimKiemHoaDon.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		pnNorthHoaDon.add(pntimKiem, BorderLayout.NORTH);

		JPanel pnCenterHoaDon = new JPanel(new GridLayout(1, 5, 20, 0));

		JPanel pnkhachHang = new JPanel(new GridLayout(1, 1));
		MyButton khachHangButton = new MyButton("Khách hàng");
		pnkhachHang.add(khachHangButton);
		pnCenterHoaDon.add(pnkhachHang);

		JPanel pnNhanVien = new JPanel(new GridLayout(1, 1));
		MyButton btnNhanVien = new MyButton("Nhân Viên");
		pnNhanVien.add(btnNhanVien);
		pnCenterHoaDon.add(pnNhanVien);

		JPanel pnhinhThucThanhToan = new JPanel(new GridLayout(2, 1));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		pnhinhThucThanhToan.setBorder(border);
		JLabel lblhinhThucThanhToan = new JLabel("Hình thức thanh toán");
		MyCombobox cbohinhThucThanhToan = new MyCombobox();
		cbohinhThucThanhToan.addItem("Trực tiếp");
		cbohinhThucThanhToan.addItem("Ngân hàng");
		cbohinhThucThanhToan.addItem("");
		cbohinhThucThanhToan.setEnabled(false);
		pnhinhThucThanhToan.add(lblhinhThucThanhToan);
		pnhinhThucThanhToan.add(cbohinhThucThanhToan);
		pnCenterHoaDon.add(pnhinhThucThanhToan);

		JPanel pntongTien = new JPanel(new GridLayout(2, 1));
		pntongTien.setBorder(border);
		JLabel lbltongTien = new JLabel("Tổng tiền:");
		MyCombobox cbotongTien = new MyCombobox();
		cbotongTien.addItem("1000000");
		cbotongTien.addItem("2000000");
		pntongTien.add(lbltongTien);
		pntongTien.add(cbotongTien);
		pnCenterHoaDon.add(pntongTien);

		JPanel ngayThangPanel = new JPanel(new GridLayout(1, 3, 10, 0));
		ngayThangPanel.setBorder(border);
		JPanel ngayPanel = new JPanel(new GridLayout(2, 1));
		JLabel ngayLabel = new JLabel("Ngày:");
		MyCombobox cbongay = new MyCombobox();
		cbongay.addItem("1");
		cbongay.addItem("2");
		cbongay.addItem("3");
		ngayPanel.add(ngayLabel);
		ngayPanel.add(cbongay);
		JPanel thangPanel = new JPanel(new GridLayout(2, 1));
		JLabel thangLabel = new JLabel("Tháng:");
		MyCombobox cbothang = new MyCombobox();
		cbothang.addItem("1");
		cbothang.addItem("2");
		cbothang.addItem("3");
		cbothang.addItem("4");
		cbothang.addItem("5");
		thangPanel.add(thangLabel);
		thangPanel.add(cbothang);
		JPanel namPanel = new JPanel(new GridLayout(2, 1));
		JLabel namLabel = new JLabel("Năm:");
		MyCombobox cboNam = new MyCombobox();
		cboNam.addItem("2021");
		cboNam.addItem("2022");
		cboNam.addItem("2023");
		namPanel.add(namLabel);
		namPanel.add(cboNam);
		ngayThangPanel.add(ngayPanel);
		ngayThangPanel.add(thangPanel);
		ngayThangPanel.add(namPanel);
		pnCenterHoaDon.add(ngayThangPanel);

		pnNorthHoaDon.add(pnCenterHoaDon, BorderLayout.CENTER);

		String[] columnNames = { "Mã hóa đơn", "Tổng tiền", "Thanh toán", "Tiền thừa", "Hình thức thanh toán",
				"Ngày lập hóa đơn", "Trạng thái thanh toán", "Mã NV", "Tên NV", "Mã KH", "Tên KH", "Ghi Chú" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		MyTable table = new MyTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(getWidth(), getHeight() - 300));
		pnNorthHoaDon.add(scrollPane, BorderLayout.SOUTH);

		JPanel pnSouthHoaDon = new JPanel(new BorderLayout());
		pnHoaDon.add(pnSouthHoaDon, BorderLayout.SOUTH);
		pnSouthHoaDon.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
		String[] clos = { "Mã hóa đơn chi tiết", "Mã sản phẩm", "Tên sản phẩm chi tiết", "Số lượng", "Đơn Giá",
				"Thành Tiền" };
		DefaultTableModel tableModelChiTietHoaDon = new DefaultTableModel(clos, 0);
		MyTable tabelChiTietHoaDon = new MyTable(tableModelChiTietHoaDon);
		JScrollPane scrollPaneChiTietHoaDon = new JScrollPane(tabelChiTietHoaDon);

		pnSouthHoaDon.add(scrollPaneChiTietHoaDon, BorderLayout.CENTER);
	}

	// PHẦN VIẾT GUI CHO KHUYẾN MÃI
	public void GUIKhuyenMai() {
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
		model_KHlichSuGD = new DefaultTableModel(new String[] { "Mã Giao Dịch", "Tên Khách Hàng", "Tên Nhân Viên",
				"Giới Tính", "Số Điện Thoại", "Địa Chỉ", "Ngày Giao Dịch" }, 0);

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
//        this.add(pnlCenter_KhachHang);
	}

	// PHẦN VIẾT GUI CHO THỐNG KÊ
	public void GUIThongKe() {
		JPanel pnThongKe = new JPanel();

		add(pnThongKe, BorderLayout.CENTER);
		JPanel pnNorthThongKe = new JPanel(new GridLayout(1, 3, 20, 0));
		pnThongKe.add(pnNorthThongKe, BorderLayout.NORTH);

		JPanel pnDoanhThu = new JPanel(new GridBagLayout());
		pnDoanhThu.setPreferredSize(new Dimension(200, 100));
		pnDoanhThu.setBackground(mauChuDao);
		JLabel lbldoanhThu = new JLabel("Doanh Thu");
		lbldoanhThu.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel lblsoDoanhThu = new JLabel("7200000");
		lblsoDoanhThu.setFont(new Font("Arial", Font.BOLD, 20));
		GridBagConstraints gbcdoanhThu = new GridBagConstraints();
		gbcdoanhThu.gridx = 0;
		gbcdoanhThu.gridy = 0;
		gbcdoanhThu.anchor = GridBagConstraints.CENTER;
		gbcdoanhThu.insets.bottom = 10;
		pnDoanhThu.add(lbldoanhThu, gbcdoanhThu);
		gbcdoanhThu.gridx = 0;
		gbcdoanhThu.gridy = 1;
		pnDoanhThu.add(lblsoDoanhThu, gbcdoanhThu);
		pnNorthThongKe.add(pnDoanhThu);

		JPanel pnSoHoaDon = new JPanel(new GridBagLayout());
		pnSoHoaDon.setPreferredSize(new Dimension(100, 50));
		pnSoHoaDon.setBackground(mauChuDao);
		JLabel lblsoHoaDon = new JLabel("Số Hóa Đơn");
		lblsoHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel lblsoSoHoaDon = new JLabel("2");
		lblsoSoHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		GridBagConstraints gbcsoHoaDon = new GridBagConstraints();
		gbcsoHoaDon.gridx = 0;
		gbcsoHoaDon.gridy = 0;
		gbcsoHoaDon.anchor = GridBagConstraints.CENTER;
		gbcsoHoaDon.insets.bottom = 10;
		pnSoHoaDon.add(lblsoHoaDon, gbcsoHoaDon);
		gbcsoHoaDon.gridx = 0;
		gbcsoHoaDon.gridy = 1;
		pnSoHoaDon.add(lblsoSoHoaDon, gbcsoHoaDon);
		pnNorthThongKe.add(pnSoHoaDon);

		JPanel pntongKhachHang = new JPanel(new GridBagLayout());
		pntongKhachHang.setPreferredSize(new Dimension(200, 100));
		pntongKhachHang.setBackground(mauChuDao);
		JLabel lbltongKhachHang = new JLabel("Tổng Khách Hàng");
		lbltongKhachHang.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel lblsoTongKhachHang = new JLabel("2");
		lblsoTongKhachHang.setFont(new Font("Arial", Font.BOLD, 20));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets.bottom = 10;
		pntongKhachHang.add(lbltongKhachHang, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pntongKhachHang.add(lblsoTongKhachHang, gbc);
		pnNorthThongKe.add(pntongKhachHang);

		JPanel pnCenterThongKe = new JPanel(new GridLayout(2, 3, 10, 10));
		pnCenterThongKe.setPreferredSize(new Dimension(900, 100));
		pnThongKe.add(pnCenterThongKe, BorderLayout.CENTER);

		JPanel pnNam = new JPanel(new BorderLayout());
		pnNam.setBorder(BorderFactory.createTitledBorder("Năm"));
		pnNam.setPreferredSize(new Dimension(20, 10));
		MyCombobox cbonam = new MyCombobox();
		cbonam.addItem("2021");
		cbonam.setPreferredSize(new Dimension(10, 5));
		pnNam.add(cbonam);
		pnCenterThongKe.add(pnNam, BorderLayout.CENTER);

		JPanel pnQuy = new JPanel(new BorderLayout());
		pnQuy.setBorder(BorderFactory.createTitledBorder("Quý"));
		pnQuy.setPreferredSize(new Dimension(20, 10));
		MyCombobox cboQuy = new MyCombobox();
		cboQuy.addItem("1");
		pnQuy.add(cboQuy);
		pnCenterThongKe.add(pnQuy, BorderLayout.CENTER);

		JPanel pnThang = new JPanel(new BorderLayout());
		pnThang.setBorder(BorderFactory.createTitledBorder("Tháng"));
		pnThang.setPreferredSize(new Dimension(20, 10));
		MyCombobox cboThang = new MyCombobox();
		cboThang.addItem("1");
		pnThang.add(cboThang);
		pnCenterThongKe.add(pnThang, BorderLayout.CENTER);

		MyButton btnTatCa = new MyButton("Tất Cả");
		pnCenterThongKe.add(btnTatCa);

		JPanel pnDanhMuc = new JPanel(new BorderLayout());
		pnDanhMuc.setBorder(BorderFactory.createTitledBorder("Danh Mục"));
		pnDanhMuc.setPreferredSize(new Dimension(20, 10));
		MyCombobox cboDanhMuc = new MyCombobox();
		cboDanhMuc.addItem("1");
		pnDanhMuc.add(cboDanhMuc);
		pnCenterThongKe.add(pnDanhMuc, BorderLayout.CENTER);

		JPanel pnTimKiem = new JPanel(new BorderLayout());
		pnTimKiem.setBorder(BorderFactory.createTitledBorder("Tìm Kiếm"));
		pnTimKiem.setPreferredSize(new Dimension(20, 10));
		JTextField txtTimKiem = new JTextField();
		pnTimKiem.add(txtTimKiem);
		txtTimKiem.setPreferredSize(new Dimension(80, 50));
		pnCenterThongKe.add(pnTimKiem, BorderLayout.CENTER);

		JPanel pnSouthThongKe = new JPanel(new BorderLayout());
		pnSouthThongKe.setPreferredSize(new Dimension(1000, 900));
		String[] clos = { "Sản Phẩm", "Số Lượng", "Doanh Thu" };
		DefaultTableModel tableModelChiTietHoaDon = new DefaultTableModel(clos, 0);
		MyTable tabelChiTietHoaDon = new MyTable(tableModelChiTietHoaDon);
		JScrollPane scrollPaneChiTietHoaDon = new JScrollPane(tabelChiTietHoaDon);
		pnSouthThongKe.add(scrollPaneChiTietHoaDon, BorderLayout.CENTER);
		pnThongKe.add(pnSouthThongKe, BorderLayout.CENTER);
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

	// Hàm xử lỳ danh mục
	public void xuLyDanhMuc(String key) {
		switch (key) {
		case "CPU": {
			xoaHetDanhMuc();
			pnlSPThongTin.add(pnlSPCPU);
			pnlSPThongTin.repaint();
			break;
		}
		case "CASE": {
			xoaHetDanhMuc();
			pnlSPThongTin.add(pnlSPCase);
			pnlSPThongTin.repaint();
			break;
		}
		case "MAIN": {
			xoaHetDanhMuc();
			pnlSPThongTin.add(pnlSPMAIN);
			pnlSPThongTin.repaint();
			break;
		}
		case "PSU": {
			xoaHetDanhMuc();
			pnlSPThongTin.add(pnlSPPSU);
			pnlSPThongTin.repaint();
			break;
		}
		case "RAM": {
			xoaHetDanhMuc();
			pnlSPThongTin.add(pnlSPRam);
			pnlSPThongTin.repaint();
			break;
		}
		case "VGA": {
			xoaHetDanhMuc();
			pnlSPThongTin.add(pnlSPVGA);
			pnlSPThongTin.repaint();
			break;
		}
		}
	}

	public void xoaHetDanhMuc() {
		pnlSPThongTin.remove(pnlSPCPU);
		pnlSPThongTin.remove(pnlSPCase);
		pnlSPThongTin.remove(pnlSPMAIN);
		pnlSPThongTin.remove(pnlSPPSU);
		pnlSPThongTin.remove(pnlSPVGA);
		pnlSPThongTin.remove(pnlSPRam);
	}

	// HÀM MAIN
	public static void main(String[] args) {
		new ViewTrangChu().setVisible(true);
	}

}
