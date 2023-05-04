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

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
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
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableCell;

import BUS.ChiTietHoaDon_BUS;
import BUS.HoaDon_BUS;
import BUS.KhachHang_BUS;
import BUS.NhanVien_BUS;
import BUS.SanPham_BUS;
import DAO.KhachHang_DAO;
import connectDB.ConnectDB;

import controller.LoadDuLieuTheoCombobox;
//import controller.LocTheoDanhMucCuaPhanMuaHang;
import controller.LocTheoDanhMucCuaPhanSanPham;
import controller.XuLyDieuHuongPhanMem;

import controller.XuLySuKien_GUISanPham;

import controller.XuLySuKienChoTrangHoaDon;

import model.Case;
import model.Cpu;
import model.Main;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import controller.XuLySuKien_GUIKhachHang;
import controller.XuLySuKienChoTrangMuaHang;
import controller.XuLySuKienChoTrangThongKe;
import controller.XuLySuKienNhanVien;
import model.MauCacDongTrongBang;
import model.MyButton;
import model.MyCombobox;
import model.MyTable;
import model.NhanVien;
import model.Psu;
import model.Ram;
import model.SanPham;
import model.Vga;

public class ViewTrangChu extends JFrame {
	//nhân viên
	private NhanVien nhanVien = null;
	// phần khai báo bus
	private KhachHang_BUS kh_BUS = new KhachHang_BUS();
	private NhanVien_BUS nv_BUS = new NhanVien_BUS();
	private String indexFrame = "Trang Chủ";
	// PHẦN KHAI BÁO BIẾN LOCAL
	public Color mauChuDao = new ViewDangNhap().mauChuDao;
	//COMPONENT PHẦN TRANG CHỦ
	private JPanel pnlTrangChu;
	// COMPONENT PHẦN CONTROL
	private ImageIcon iconHinhNen;
	private JLabel lblControlTen, lblHinhNenAvt;
	private MyButton btnControlTrangChu,btnControlMuaHang, btnControlSanPham, btnControlHoaDon, btnControlNhanVien, btnControlKhachHang,
	btnControlThongKe, btnControlThoat;

	private JLabel lblSanPham;
	private JButton btnTat;
	private JButton btnIn;


	// COMPONENT PHẦN MUA HÀNG
	HoaDon_BUS hoadon_bus = new HoaDon_BUS();
	private HoaDon hoaDonMuaHang = new HoaDon(hoadon_bus.ranDomMaHoaDon());
	private KhachHang khachHangMH = kh_BUS.getAllKhachHang().get(0);
	private JPanel pnlMuaHang;
	private DefaultTableModel modelMHGioHang, modelMHSanPham;
	private MyTable tableMHGioHang, tableMHSanPham;
	private MyButton btnMHXoa, btnMHXoaAll, btnMHSua;
	private JLabel lblMHTimSP, lblMHDanhMuc, lblMHNhaSX;
	private JTextField txtMHTimSP;
	private MyButton btnMHThemSP;
	private MyCombobox cbbMHDanhMuc, cbbMHNhaSX;
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
	SanPham_BUS sp_BUS = new SanPham_BUS();
	private JPanel pnlSanPham, pnlSPThongTin;
	public MyCombobox cbbSPDanhMuc;
	private MyCombobox cbbSPNhaSX, cbbSPNgay, cbbSPThang, cbbSPNam;
	public MyButton btnSPThem, btnSPXoa, btnSPSua, btnSPLamMoi, btnSPPhatSinhMa;
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
	public static String name_before = ""; // biến lưu trữ tên combobox đã click trước đó
	// phần table sản phẩm
	public DefaultTableModel modelSP;
	public MyTable tableSP;
	// COMPONENT PHẦN HÓA ĐƠN
	private JPanel pnHoaDon;
	private KhachHang khachHangLocHoaDon = new KhachHang("");
	private NhanVien nhanVienLocHoaDon = new NhanVien("");
	private DefaultTableModel modelHoaDon, modelChiTietHoaDon;
	private MyTable tableHoaDon, tableChiTietHoaDon;
	private MyCombobox cbohinhThucThanhToan, cbotongTien, cbongay, cbothang, cbonam;
	private JTextField txttimKiemHoaDon;
	// COMPONENT PHẦN NHÂN VIÊN
	private DefaultTableModel model_NV;
	private MyTable table_NV;
	private Box pnlNhanVien;

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
	private JPanel pnlInfor_6;
	private JButton btnXoaNhanVien;
	private JButton btnKhoiTaoMaNhanVien;
	// COMPONENT PHẦN KHÁCH HÀNG
	private JLabel lbl_maKhach, lbl_tenKhachHang, lbl_GioiTinhKH, lbl_soDienThoaiKH, lbl_emailKH, lbl_diaChiKH, lbl_tempKH,lbl_timKiemKH;
	private JButton btn_ThemKH, btn_SuaKH, btn_LamMoiKH, btn_KhoiTaoMaKH;
	private ButtonGroup groupbtnKH;
	private JTextArea txt_AreaKH;
	private String inputTimKiemKH = "";
	private JPanel pnlCenter_KhachHang;	
	private JTextField txt_maKhachHang, txt_tenKhachHang, txt_soDienThoaiKH, txt_emailKH,txt_TimKiemTTKH = new JTextField(),txt_DiaChiTTKH = new JTextField(),txt_DiaChiLSGD = new JTextField(),txt_TimKiemLSGD = new JTextField();
	private DefaultTableModel model_KHthongTin, model_KHlichSuGD;
	private MyTable tb_LichSuGiaoDichKH, tb_thongTinCaNhanKH;
	private JRadioButton radNamKH, radNuKH;
	private MyButton btn_XoaKH;
	private JComboBox<String> combobox_TTKHGioiTinh = new JComboBox<>();
	private DefaultComboBoxModel<String>  modelcomboTTKHGioiTinh = new DefaultComboBoxModel<>();
	private JTabbedPane tabbedPane;
	private TableRowSorter<DefaultTableModel> sorter;
	// COMPONENT PHẦN THỐNG KÊ
	private JPanel pnThongKe;
	private DefaultTableModel modelThongKe;
	private MyTable tableThongKe;
	private MyCombobox cboNamThongKe, cboThangThongKe, cboDanhMucThongKe;
	private JLabel lblsoDoanhThu, lblsoTongKhachHang, lblsoSoHoaDon;
	private HoaDon_BUS hdbusThongKe = new HoaDon_BUS();
	private ChiTietHoaDon_BUS cthdbus = new ChiTietHoaDon_BUS();

	// CONSTRUCTER
	public ViewTrangChu(NhanVien nv) {
		nhanVien = nv;
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
		this.GUITrangChu();
		this.GUIControl();
		this.GUIMuaHang();
		this.GUISanPham();
		this.GUIHoaDon();
		this.GUINhanVien();
		this.GUIKhachHang();
		this.GUIThongKe();

		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// phần trang chủ
	public void GUITrangChu() {
		pnlTrangChu = new JPanel();
		JLabel lblTrangChu = new JLabel();
		lblTrangChu.setSize(new Dimension(1075, 740));
		ImageIcon icontrangchu = new ImageIcon("Image\\hinhtrangchu\\hinhtrangchu1.jpg");
		lblTrangChu.setIcon(icontrangchu);
		Image image = ((ImageIcon) icontrangchu).getImage().getScaledInstance(1070, 700, java.awt.Image.SCALE_SMOOTH);
		Icon newIcon = new ImageIcon(image);
		lblTrangChu.setIcon(newIcon);
		pnlTrangChu.add(lblTrangChu);
		this.add(pnlTrangChu);
	}

	// PHẦN VIẾT GUI CHO CONTROL VÀ THÔNG TIN NHÂN VIÊN
	public void GUIControl() {
		JPanel pnlWest = new JPanel();
		pnlWest.setPreferredSize(new Dimension(200, 0));
		pnlWest.setBackground(mauChuDao);
		pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
		iconHinhNen = new ImageIcon("Image\\logodangnhap\\logoFrame.png");

		pnlWest.add(Box.createVerticalStrut(10));
		pnlWest.add(lblHinhNenAvt = new JLabel(taoHinhTronAvt(iconHinhNen)));
		lblHinhNenAvt.setAlignmentX(Component.CENTER_ALIGNMENT);

		pnlWest.add(Box.createVerticalStrut(10));
		pnlWest.add(lblControlTen = new JLabel());
		lblControlTen.setText(nhanVien.getTen());
		lblControlTen.setFont(new Font("Arial", Font.BOLD, 20));
		lblControlTen.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlWest.add(Box.createVerticalStrut(10));

		JPanel pnlWestbtn = new JPanel();
		pnlWestbtn.setBackground(mauChuDao);
		Font fontControlBtn = new Font("Futura", Font.BOLD, 15);
		pnlWestbtn.setLayout(new GridLayout(9, 1));
		pnlWestbtn.add(btnControlTrangChu = new MyButton("Trang Chủ"));
		btnControlTrangChu.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\icontrangchu.png"));
		btnControlTrangChu.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlMuaHang = new MyButton("Mua Hàng"));
		btnControlMuaHang.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconmuahang.png"));
		btnControlMuaHang.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlSanPham = new MyButton("Sản Phẩm"));
		btnControlSanPham.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconsanpham.png"));
		btnControlSanPham.setFont(fontControlBtn);
		pnlWestbtn.add(btnControlHoaDon = new MyButton("Hóa Đơn"));
		btnControlHoaDon.setIcon(new ImageIcon("Image\\iconcontrolbtntrangchu\\iconhoadon.png"));
		btnControlHoaDon.setFont(fontControlBtn);
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
		// thêm sự kiện
		ActionListener acXuLyDieuHuong = new XuLyDieuHuongPhanMem(this);
		btnControlTrangChu.addActionListener(acXuLyDieuHuong);
		btnControlMuaHang.addActionListener(acXuLyDieuHuong);
		btnControlHoaDon.addActionListener(acXuLyDieuHuong);
		btnControlSanPham.addActionListener(acXuLyDieuHuong);
		btnControlNhanVien.addActionListener(acXuLyDieuHuong);
		btnControlKhachHang.addActionListener(acXuLyDieuHuong);
		btnControlThongKe.addActionListener(acXuLyDieuHuong);
		btnControlThoat.addActionListener(acXuLyDieuHuong);
		btnControlTrangChu.setBackground(new Color(255,165,0));
		GUIKhachHang();
	}

	// bỏ border cho thanh tiêu đề
	public void boBorderChoButtonThanhNavbar() {
		btnControlTrangChu.setBorder(null);
		btnControlMuaHang.setBorder(null);
		btnControlSanPham.setBorder(null);
		btnControlHoaDon.setBorder(null);
		btnControlThongKe.setBorder(null);
		btnControlThoat.setBorder(null);
		btnControlKhachHang.setBorder(null);
		btnControlNhanVien.setBorder(null);
	}

	// PHẦN VIẾT GUI CHO NHÂN VIÊN
	public void GUINhanVien() {
		// Box b
		pnlNhanVien = Box.createVerticalBox();

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
		Box bLayout = Box.createHorizontalBox();
		Box bInfor_1 = Box.createHorizontalBox();
		Box bInfor_2 = Box.createHorizontalBox();
		Box bInfor_3 = Box.createHorizontalBox();
		Box bInfor_4 = Box.createHorizontalBox();
		Box bInfor_5 = Box.createHorizontalBox();
		pnlInfor_6 = new JPanel();

		bInfor.add(Box.createRigidArea(new Dimension(0, 20)));

		// line layout

		bLayout.add(Box.createRigidArea(new Dimension(850, 1)));

		// line 1
		bInfor_1.add(lblMaNV = new JLabel("Mã NV"));
		lblMaNV.setPreferredSize(new Dimension(80, 20));
		bInfor_1.add(txtMaNV = new JTextField(20));
		txtMaNV.setPreferredSize(new Dimension(0, 25));
		bInfor_1.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_1.add(lblSDT = new JLabel("Điện thoại"));
		lblSDT.setPreferredSize(new Dimension(80, 20));
		bInfor_1.add(txtSDT = new JTextField(20));
		txtSDT.setPreferredSize(new Dimension(0, 25));

		// line 2
		bInfor_2.add(lblDiaChi = new JLabel("Địa Chỉ"));
		lblDiaChi.setPreferredSize(new Dimension(80, 20));
		bInfor_2.add(txtDiaChi = new JTextField(20));
		txtDiaChi.setPreferredSize(new Dimension(0, 25));
		bInfor_2.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_2.add(lblCMND = new JLabel("CNMD/CCCD"));
		lblCMND.setPreferredSize(new Dimension(80, 20));
		bInfor_2.add(txtCMND = new JTextField(20));

		// line 3
		bInfor_3.add(lblMK = new JLabel("Mật Khẩu"));
		lblMK.setPreferredSize(new Dimension(80, 20));
		bInfor_3.add(txtMK = new JTextField(20));
		txtMK.setPreferredSize(new Dimension(0, 25));
		bInfor_3.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_3.add(lblEmail = new JLabel("Email"));
		lblEmail.setPreferredSize(new Dimension(80, 20));
		bInfor_3.add(txtEmail = new JTextField(20));
		txtEmail.setPreferredSize(new Dimension(0, 25));

		// line 4
		bInfor_4.add(lblVaiTro = new JLabel("Vai Trò"));
		lblVaiTro.setPreferredSize(new Dimension(80, 20));
		comboVaiTro = new MyCombobox();
		comboVaiTro.addItem("Quản lý");
		comboVaiTro.addItem("Nhân viên");
		nv_BUS = new NhanVien_BUS();
		ArrayList<NhanVien> listNV = nv_BUS.getAllNhanVien();  
		bInfor_4.add(comboVaiTro);
		comboVaiTro.setPreferredSize(new Dimension(120, 25));
		bInfor_4.add(Box.createRigidArea(new Dimension(120, 0)));
		bInfor_4.add(lblGioiTinh = new JLabel("Giới Tính"));
		lblGioiTinh.setPreferredSize(new Dimension(80, 20));
		bInfor_4.add(Box.createRigidArea(new Dimension(30, 20)));
		bInfor_4.add(radNam_NV = new JRadioButton("Nam"));
		bInfor_4.add(Box.createRigidArea(new Dimension(30, 0)));
		bInfor_4.add(radNu_NV = new JRadioButton("Nữ"));
		bInfor_4.add(Box.createRigidArea(new Dimension(132, 0)));
		gr = new ButtonGroup();
		gr.add(radNam_NV);
		gr.add(radNu_NV);

		// line 5
		bInfor_5.add(lblTen = new JLabel("Tên NV"));
		lblTen.setPreferredSize(new Dimension(80, 20));
		bInfor_5.add(txtTen = new JTextField(20));
		txtTen.setPreferredSize(new Dimension(0, 25));
		bInfor_5.add(Box.createRigidArea(new Dimension(487, 0)));

		// line 6
		pnlInfor_6.add(btnKhoiTaoMaNhanVien = new MyButton("Khởi tạo mã"));
		btnKhoiTaoMaNhanVien.setPreferredSize(new Dimension(100, 30));
		pnlInfor_6.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlInfor_6.add(btnThemNhanVien = new MyButton("Thêm"));
		btnThemNhanVien.setPreferredSize(new Dimension(70, 30));
		pnlInfor_6.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlInfor_6.add(btnSuaNhanVien = new MyButton("Sửa"));
		btnSuaNhanVien.setPreferredSize(new Dimension(70, 30));
		pnlInfor_6.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlInfor_6.add(btnLamMoiNhanVien = new MyButton("Làm mới"));
		btnLamMoiNhanVien.setPreferredSize(new Dimension(70, 30));
		pnlInfor_6.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlInfor_6.add(btnXoaNhanVien = new MyButton("Xóa"));
		btnXoaNhanVien.setPreferredSize(new Dimension(70,30));

		// add các line vào
		bInfor.add(bLayout);
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
		bTitleSearch.add(lblTimKiem = new JLabel("Tìm kiếm theo mã hoặc theo tên:"));
		bTitleSearch.add(Box.createRigidArea(new Dimension(160, 0)));

		// Tạo phần Lọc theo giới tính và vai trò
		Box bSreachGT_VT = Box.createHorizontalBox();
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(20, 0)));
		bSreachGT_VT.add(lblLocTheoGT = new JLabel("Lọc theo giới tính"));
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(20, 0)));
		comboLocGioiTinh = new MyCombobox();
		comboLocGioiTinh.addItem("Tất cả");
		comboLocGioiTinh.addItem("Nam");
		comboLocGioiTinh.addItem("Nữ");
		comboLocGioiTinh.setActionCommand("comboBoxLocGioiTinh");
		comboLocGioiTinh.setPreferredSize(new Dimension(60, 20));
		bSreachGT_VT.add(comboLocGioiTinh);
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(170, 0)));
		bSreachGT_VT.add(lblLocTheoVT = new JLabel("Lọc theo vai trò"));
		bSreachGT_VT.add(Box.createRigidArea(new Dimension(20, 0)));
		comboLocVaiTro = new MyCombobox();
		comboLocVaiTro.addItem("Tất cả");
		comboLocVaiTro.addItem("Quản lý");
		comboLocVaiTro.addItem("Nhân viên");
		comboLocVaiTro.setActionCommand("comboBoxLocChucVu");
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
		model_NV = new DefaultTableModel();
		model_NV.addColumn("Mã NV");
		model_NV.addColumn("Tên NV");
		model_NV.addColumn("Mật khẩu");
		model_NV.addColumn("Vai Trò");
		model_NV.addColumn("Địa chỉ");
		model_NV.addColumn("Điện thoại");
		model_NV.addColumn("Giới Tính");
		model_NV.addColumn("Email");
		model_NV.addColumn("CMND/CCCD");
		table_NV = new MyTable(model_NV);
		JScrollPane croll = new JScrollPane(table_NV);
		croll.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		nv_BUS = new NhanVien_BUS();
		DocDuLieuDatabaseVaoTableNhanVien();

		// Tạo vùng chứa table
		Box bTableContainer = Box.createHorizontalBox();
		bTableContainer.add(Box.createRigidArea(new Dimension(15, 0)));
		bTableContainer.add(croll);
		bTableContainer.add(Box.createRigidArea(new Dimension(15, 0)));

		// add vào phần tổng
		pnlNhanVien.add(bTitleInfor);
		pnlNhanVien.add(bInforContainer);
		pnlNhanVien.add(Box.createRigidArea(new Dimension(0, 30)));
		pnlNhanVien.add(bTitleSearch);
		pnlNhanVien.add(pnlSreachContainer);
		pnlNhanVien.add(Box.createRigidArea(new Dimension(0, 15)));
		pnlNhanVien.add(bTableContainer);

		ActionListener ac = new XuLySuKienNhanVien(this);
		btnThemNhanVien.addActionListener(ac);
		btnLamMoiNhanVien.addActionListener(ac);
		btnSuaNhanVien.addActionListener(ac);
		btnXoaNhanVien.addActionListener(ac);
		btnKhoiTaoMaNhanVien.addActionListener(ac);
		comboLocGioiTinh.addActionListener(ac);
		comboLocVaiTro.addActionListener(ac);
		txtMaNV.setEditable(false);	
	}
	//Đọc dữ liệu vào bảng nhân viên
	public void DocDuLieuDatabaseVaoTableNhanVien() {
		model_NV.setRowCount(0);
		ArrayList<NhanVien> list = nv_BUS.getAllNhanVien();
		for (NhanVien nhanVien : list) {
			model_NV.addRow(new Object[]{nhanVien.getMa(), nhanVien.getTen(),  nhanVien.getMatkhau(),nhanVien.getChucVu(),nhanVien.getDiaChi(),nhanVien.getSDT(), nhanVien.isGioiTinh() ? "Nam" : "Nữ", 
					nhanVien.getEmail(),nhanVien.getCmnd()		});
		}

	}
	//Lọc dữ liệu Combobox giới tính và chức vụ
	ArrayList<NhanVien> filteredList1 = new ArrayList<>();
	public void LocComBoBox() {
		ArrayList<NhanVien> list = nv_BUS.getAllNhanVien();
		filteredList1.clear();
		for (NhanVien nhanVien : list) {
			if (comboLocGioiTinh.getSelectedItem().toString().equals("Tất cả")
					|| nhanVien.isGioiTinh()==(comboLocGioiTinh.getSelectedItem().toString().equals("Nữ"))) {
				// Lọc theo chức vụ
				if (comboLocVaiTro.getSelectedItem().toString().equals("Tất cả")
						|| nhanVien.getChucVu().equals(comboLocVaiTro.getSelectedItem().toString())) {
					// Thêm đối tượng Person phù hợp vào ArrayList mới
					filteredList1.add(nhanVien);
				}
			}
		}
		model_NV.setRowCount(0);
		for (NhanVien nhanVien : filteredList1) {
			model_NV.addRow(new Object[]{nhanVien.getMa(), nhanVien.getTen(), nhanVien.getMatkhau(), nhanVien.getChucVu(), nhanVien.getDiaChi(), nhanVien.getSDT(), nhanVien.isGioiTinh() ? "Nam" : "Nữ", nhanVien.getEmail(), nhanVien.getCmnd()});
		}
	}


	//Làm mới các JTextField
	public void lamMoi() {
		txtMaNV.setText("");
		txtTen.setText("");
		txtSDT.setText("");
		txtMK.setText("");
		txtDiaChi.setText("");
		txtCMND.setText("");
		txtEmail.setText("");

	}
	//thêm nhân viên 
	public void themNhanVien() {
		if(!kiemTraRong()) {
			JOptionPane.showMessageDialog(this, "Xin lỗi bạn chưa nhập đầy đủ thông tin. Vui lòng nhập đầy đủ trước khi tiếp tục");

		}
		Pattern patternten = Pattern.compile("[\\p{L}\\s]+");
		Pattern patternsdt = Pattern.compile("^0\\d{9}$");
		Pattern patterncmnd = Pattern.compile("^\\d{9}(\\d{3})?$");
		Pattern patternmk = Pattern.compile(".*");
		Pattern patternemail = Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$");
		Pattern patterndiachi = Pattern.compile("[\\p{L}\\d\\s,-.?/]+");
		Matcher matcherten = patternten.matcher(txtTen.getText());
		if (!matcherten.matches()) {
			JOptionPane.showMessageDialog(this, "Lỗi tên khách hàng phải là chữ", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtTen.requestFocus();
			return;
		}
		Matcher matchersdt = patternsdt.matcher(txtSDT.getText());
		if (!matchersdt.matches()) {
			JOptionPane.showMessageDialog(this, "Số điện thoại bắt đầu bằng 0 và có 10 số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtSDT.requestFocus();
			return;
		}
		Matcher matchercmnd = patterncmnd.matcher(txtCMND.getText());
		if (!matchercmnd.matches()) {
			JOptionPane.showMessageDialog(this, "Chứng minh nhân dân hoặc căn cước công dân có 9 hoặc 12 chữ số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtCMND.requestFocus();
			return;
		}
		Matcher matchermk = patternmk.matcher(txtMK.getText());
		if (!matchermk.matches()) {
			JOptionPane.showMessageDialog(this, "Chứng minh nhân dân hoặc căn cước công dân có 9 hoặc 12 chữ số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtMK.requestFocus();
			return;
		}
		Matcher matcheremail = patternemail.matcher(txtEmail.getText());
		if (!matcheremail.matches()) {
			JOptionPane.showMessageDialog(this, "Email có định dạng abc@xyz.com", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtEmail.requestFocus();
			return;
		}
		Matcher matcherdiachi = patterndiachi.matcher(txtDiaChi.getText());
		if (!matcherdiachi.matches()) {
			JOptionPane.showMessageDialog(this, "Lỗi địa chỉ không đúng định dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtDiaChi.requestFocus();
			return;
		}

		String ma = txtMaNV.getText(); 	  	
		String ten = txtTen.getText();
		String sdt = txtSDT.getText();
		String matKhau = txtMK.getText();
		String diaChi = txtDiaChi.getText();
		String cmnd = txtCMND.getText();
		String email = txtEmail.getText();
		String gioiTinh = radNam_NV.isSelected() ? "Nam" : "Nữ";
		Boolean phai = gioiTinh.equals("Nam");
		String chucVu = comboVaiTro.getSelectedItem().toString();

		NhanVien nv = new NhanVien(ma, ten, sdt, phai, email, diaChi, chucVu, cmnd, matKhau);
		if (nv_BUS.themNhanVien(nv)) {
			JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
			// Load lại dữ liệu trên JTable
			DocDuLieuDatabaseVaoTableNhanVien();

		} else {
			JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!");
		}
	}

	public void khoiTaoMa() {
		String ma = nv_BUS.ranDomMaKhachHang();
		txtMaNV.setText(ma);
	}
	public boolean kiemTraRong() {
		String ten = txtTen.getText().trim();
		String sdt = txtSDT.getText().trim();
		String matKhau = txtMK.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String cmnd = txtCMND.getText().trim();
		String email = txtEmail.getText().trim();
		if (  ten.isEmpty() || sdt.isEmpty() || matKhau.isEmpty()
				|| diaChi.isEmpty() || cmnd.isEmpty() || email.isEmpty()) {
			return false;
		}
		return true;
	}
	public void suaNhanVien() {
		if(!kiemTraRong()) {
			JOptionPane.showMessageDialog(this, "Xin lỗi bạn chưa nhập đầy đủ thông tin. Vui lòng nhập đầy đủ trước khi tiếp tục");

		}
		Pattern patternten = Pattern.compile("[\\p{L}\\s]+");
		Pattern patternsdt = Pattern.compile("^0\\d{9}$");
		Pattern patterncmnd = Pattern.compile("^\\d{9}(\\d{3})?$");
		Pattern patternmk = Pattern.compile(".*");
		Pattern patternemail = Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$");
		Pattern patterndiachi = Pattern.compile("[\\p{L}\\d\\s,-.?/]+");
		Matcher matcherten = patternten.matcher(txtTen.getText());
		if (!matcherten.matches()) {
			JOptionPane.showMessageDialog(this, "Lỗi tên khách hàng phải là chữ", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtTen.requestFocus();
			return;
		}
		Matcher matchersdt = patternsdt.matcher(txtSDT.getText());
		if (!matchersdt.matches()) {
			JOptionPane.showMessageDialog(this, "Số điện thoại bắt đầu bằng 0 và có 10 số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtSDT.requestFocus();
			return;
		}
		Matcher matchercmnd = patterncmnd.matcher(txtCMND.getText());
		if (!matchercmnd.matches()) {
			JOptionPane.showMessageDialog(this, "Chứng minh nhân dân hoặc căn cước công dân có 9 hoặc 12 chữ số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtCMND.requestFocus();
			return;
		}
		Matcher matchermk = patternmk.matcher(txtMK.getText());
		if (!matchermk.matches()) {
			JOptionPane.showMessageDialog(this, "Chứng minh nhân dân hoặc căn cước công dân có 9 hoặc 12 chữ số", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtMK.requestFocus();
			return;
		}
		Matcher matcheremail = patternemail.matcher(txtEmail.getText());
		if (!matcheremail.matches()) {
			JOptionPane.showMessageDialog(this, "Email có định dạng abc@xyz.com", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtEmail.requestFocus();
			return;
		}
		Matcher matcherdiachi = patterndiachi.matcher(txtDiaChi.getText());
		if (!matcherdiachi.matches()) {
			JOptionPane.showMessageDialog(this, "Lỗi địa chỉ không đúng định dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtDiaChi.requestFocus();
			return;
		}



		String ma = txtMaNV.getText();
		String ten = txtTen.getText();
		String sdt = txtSDT.getText();
		String matKhau = txtMK.getText();
		String diaChi = txtDiaChi.getText();
		String cmnd = txtCMND.getText();
		String email = txtEmail.getText();
		String gioiTinh = radNam_NV.isSelected() ? "Nam" : "Nữ";
		Boolean phai = gioiTinh.equals("Nam");
		String chucVu = comboVaiTro.getSelectedItem().toString();
		NhanVien nv = new NhanVien(ma, ten, sdt, phai, email, diaChi, chucVu, cmnd, matKhau);
		if (nv_BUS.suaNhanVien(nv)) {
			JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công!");
			DocDuLieuDatabaseVaoTableNhanVien();

		} else {
			JOptionPane.showMessageDialog(this, "Sửa nhân viên không thành công");
		}
	}
	public void xoaNhanVien() {
		int r = table_NV.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xóa!");
		} else {
			int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				String maNV = txtMaNV.getText();
				boolean result = nv_BUS.xoaNhanVien(maNV);
				if (result) {
					JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công!");
					DocDuLieuDatabaseVaoTableNhanVien();
				} else {
					JOptionPane.showMessageDialog(null, "Xóa nhân viên không thành công!");
				}
			}
		}

	}
	public void timKiem() {
	    String keyword = txtTimKiemNV.getText().toLowerCase(); 
	    model_NV.setRowCount(0);
	    ArrayList<NhanVien> searchList = (filteredList1.isEmpty()) ? nv_BUS.getAllNhanVien() : filteredList1;
	    for (NhanVien nhanVien : searchList) {
	        String ma = nhanVien.getMa().toLowerCase();
	        String ten = nhanVien.getTen().toLowerCase();
	        String matkhau = nhanVien.getMatkhau().toLowerCase();
	        String chucvu = nhanVien.getChucVu().toLowerCase();
	        String diaChi = nhanVien.getDiaChi().toLowerCase();
	        String sdt = nhanVien.getSDT().toLowerCase();
	        String gioiTinh = nhanVien.isGioiTinh() ? "Nam" : "Nữ";
	        String email = nhanVien.getEmail().toLowerCase();
	        String cmnd = nhanVien.getCmnd().toLowerCase();

	        if (ma.contains(keyword) || ten.contains(keyword) || matkhau.contains(keyword) || chucvu.contains(keyword) || diaChi.contains(keyword) || sdt.contains(keyword) || gioiTinh.equalsIgnoreCase(keyword) || email.contains(keyword) || cmnd.contains(keyword)) {
	            model_NV.addRow(new Object[]{nhanVien.getMa(), nhanVien.getTen(), nhanVien.getMatkhau(), nhanVien.getChucVu(), nhanVien.getDiaChi(), nhanVien.getSDT(), nhanVien.isGioiTinh() ? "Nam" : "Nữ", nhanVien.getEmail(), nhanVien.getCmnd()});
	        }
	    }
	}


	public void LoadDuLieuLaiCacComponent() {
		int row = table_NV.getSelectedRow();
		if (row != -1) {
			String ma = (String) table_NV.getValueAt(row,0);
			ArrayList<NhanVien> nv = nv_BUS.timTheoMaNhanVien(ma);
			for (NhanVien nhanVien : nv) {
				txtMaNV.setText(nhanVien.getMa().trim());
				txtTen.setText(nhanVien.getTen().trim());
				txtMK.setText(nhanVien.getMatkhau().trim());
				comboVaiTro.setSelectedItem(nhanVien.getChucVu().toString());
				txtDiaChi.setText(nhanVien.getDiaChi().trim());
				txtSDT.setText(nhanVien.getSDT().trim());
				txtCMND.setText(nhanVien.getCmnd().trim());
				txtEmail.setText(nhanVien.getEmail().trim());
				if(nhanVien.isGioiTinh()) {
					radNu_NV.setSelected(false);
					radNam_NV.setSelected(true);
				} else {
					radNam_NV.setSelected(false);
					radNu_NV.setSelected(true);
				}
			}
		}
	}


	public String getTimKiem() {
		return txtTimKiemNV.getText();
	}

	public void addSearchKeyListener(KeyListener listener) {
		txtTimKiemNV.addKeyListener(listener);
	}
	public void addMouse(MouseListener mouseListener) {
		table_NV.addMouseListener(mouseListener);
	}


	// PHẦN VIẾT GUI CHO MUA HÀNG
	public void GUIMuaHang() {
		pnlMuaHang = new JPanel();
		pnlMuaHang.setLayout(null);
		pnlMuaHang.setBackground(Color.white);
		JPanel pnlMuaHangSP = new JPanel();
		JPanel pnlMuaHangHD = new JPanel();
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

		lblMHTimSP = new JLabel("Tìm kiếm sản phẩm theo mã hoặc tên:");
		lblMHTimSP.setBounds(15, 30, 250, 15);

		txtMHTimSP = new JTextField();
		txtMHTimSP.setBounds(15, 50, 200, 25);

		lblMHDanhMuc = new JLabel("Danh mục:");
		lblMHDanhMuc.setBounds(250, 30, 130, 15);

		cbbMHDanhMuc = new MyCombobox();
		cbbMHDanhMuc.addItem("CASE");
		cbbMHDanhMuc.addItem("CPU");
		cbbMHDanhMuc.addItem("RAM");
		cbbMHDanhMuc.addItem("PSU");
		cbbMHDanhMuc.addItem("VGA");
		cbbMHDanhMuc.addItem("MAIN");
		cbbMHDanhMuc.setBounds(250, 50, 130, 25);

		lblMHNhaSX = new JLabel("Nhà sản xuất:");
		lblMHNhaSX.setBounds(420, 30, 130, 15);

		cbbMHNhaSX = new MyCombobox();
		cbbMHNhaSX.addItem("Tất cả");
		cbbMHNhaSX.addItem("ACER");
		cbbMHNhaSX.addItem("MSI");
		cbbMHNhaSX.addItem("DELL");
		cbbMHNhaSX.addItem("HP");
		cbbMHNhaSX.addItem("ASUS");
		cbbMHNhaSX.addItem("GIGABYTE");
		cbbMHNhaSX.setBounds(420, 50, 130, 25);

		btnMHThemSP = new MyButton("Thêm sản phẩm");
		btnMHThemSP.setBounds(590, 45, 130, 30);

		pnlMHSanPham.add(lblMHTimSP);
		pnlMHSanPham.add(txtMHTimSP);
		pnlMHSanPham.add(btnMHThemSP);
		pnlMHSanPham.add(lblMHDanhMuc);
		pnlMHSanPham.add(cbbMHDanhMuc);
		pnlMHSanPham.add(lblMHNhaSX);
		pnlMHSanPham.add(cbbMHNhaSX);

		khoiTaoBangCase();
		khoiTaoBangCpu();
		khoiTaoBangMain();
		khoiTaoBangPsu();
		khoiTaoBangRam();
		khoiTaoBangVga();
		// thêm dữ liệ vào các bảng
		capNhatDuLieuChoTatCaCacBangSanPham();


		scrMHTable = new JScrollPane(tableMHCase);
		scrMHTable.setBounds(15, 90, 710, 340);

		pnlMHSanPham.add(scrMHTable);

		pnlMuaHangSP.add(pnlMHGioHang);
		pnlMuaHangSP.add(pnlMHSanPham);

		// phần panel hóa đơn (330 x 700)
		TitledBorder titleHoaDon = BorderFactory.createTitledBorder("Hóa đơn");
		titleHoaDon.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlMuaHangHD.setBorder(titleHoaDon);
		pnlMuaHangHD.setLayout(null);
		Font fontHd = new Font("Arial", Font.PLAIN, 11);
		Font fontMoney = new Font("Arial", Font.PLAIN, 16);
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

		lblMHHDMaKH.setText(khachHangMH.getMa());
		lblMHHDTenKH.setText(khachHangMH.getTen());

		btnMHHDChon = new MyButton("Chọn");
		ViewTrangChu viewhome  = this;
		btnMHHDChon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewChonKhachHang(khachHangMH, lblMHHDMaKH, lblMHHDTenKH, lblMHHDGiams, lblMHHDThanhtoans,lblMHHDTienthuas, hoaDonMuaHang, viewhome, "Mua hàng").setVisible(true);
			}
		});
		btnMHHDThem = new MyButton("Thêm");
		btnMHHDThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewThemKhachHang(khachHangMH, lblMHHDMaKH, lblMHHDTenKH, lblMHHDGiams, lblMHHDThanhtoans, hoaDonMuaHang).setVisible(true);
			}
		});
		btnMHHDChon.setBounds(220, 10, 70, 25);
		btnMHHDThem.setBounds(220, 40, 70, 25);

		int xhd = 15, yhd = 120, width = 130;
		JLabel lblMHHDMahd = new JLabel("Mã hóa đơn: ");
		lblMHHDMahd.setBounds(xhd, yhd, width, 25);
		lblMHHDMahds = new JLabel();
		lblMHHDMahds.setText(hoaDonMuaHang.getMaHoaDon());
		lblMHHDMahds.setBounds(xhd + width, yhd, 200, 25);
		lblMHHDMahds.setFont(fontMoney);
		lblMHHDMahds.setForeground(mauChuDao);
		yhd += 45;
		JLabel lblMHHDTongtien = new JLabel("Tổng tiền: ");
		lblMHHDTongtien.setBounds(xhd, yhd, width, 25);
		lblMHHDTongtiens = new JLabel("0");
		lblMHHDTongtiens.setBounds(xhd + width, yhd, 100, 25);
		lblMHHDTongtiens.setFont(fontMoney);
		JLabel lblVnd1 = new JLabel("VND");
		lblVnd1.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDGiam = new JLabel("Voucher giảm giá: ");
		lblMHHDGiam.setBounds(xhd, yhd, width, 25);
		lblMHHDGiams = new JLabel("0");
		lblMHHDGiams.setBounds(xhd + width, yhd, 100, 25);
		lblMHHDGiams.setFont(fontMoney);
		JLabel lblVnd2 = new JLabel("VND");
		lblVnd2.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDThue = new JLabel("Thuế VAT: ");
		lblMHHDThue.setBounds(xhd, yhd, width, 25);
		lblMHHDThues = new JLabel("0");
		lblMHHDThues.setBounds(xhd + width, yhd, 100, 25);
		lblMHHDThues.setFont(fontMoney);
		JLabel lblVnd6 = new JLabel("VND");
		lblVnd6.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDThanhToan = new JLabel("Thanh toán: ");
		lblMHHDThanhToan.setBounds(xhd, yhd, width, 25);
		lblMHHDThanhtoans = new JLabel("0");
		lblMHHDThanhtoans.setBounds(xhd + width, yhd, 100, 25);
		lblMHHDThanhtoans.setFont(new Font("Arial", Font.BOLD, 16));
		lblMHHDThanhtoans.setForeground(mauChuDao);
		JLabel lblVnd3 = new JLabel("VND");
		lblVnd3.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDTienkhach = new JLabel("Tiền khách đưa: ");
		lblMHHDTienkhach.setBounds(xhd, yhd, width, 25);
		txtMHHDTienKhachDua = new JTextField();
		txtMHHDTienKhachDua.setBounds(xhd + width, yhd, 100, 25);
		txtMHHDTienKhachDua.setFont(new Font("Arial", Font.BOLD, 16));
		JLabel lblVnd4 = new JLabel("VND");
		lblVnd4.setBounds(xhd + width + 110, yhd, 30, 25);

		yhd += 45;
		JLabel lblMHHDTienthua = new JLabel("Tiền thừa trả khách: ");
		lblMHHDTienthua.setBounds(xhd, yhd, width, 25);
		lblMHHDTienthuas = new JLabel();
		lblMHHDTienthuas.setBounds(xhd + width, yhd, 100, 25);
		lblMHHDTienthuas.setFont(new Font("Arial", Font.BOLD, 17));
		lblMHHDTienthuas.setForeground(mauChuDao);
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
		//Phần thêm sự kiện
		btnMHThemSP.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		btnMHXoa.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		btnMHXoaAll.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		btnMHSua.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		cbbMHDanhMuc.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		cbbMHNhaSX.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		txtMHTimSP.addKeyListener(new XuLySuKienChoTrangMuaHang(this));
		txtMHHDTienKhachDua.addKeyListener(new XuLySuKienChoTrangMuaHang(this));
		cbbMHHDHinhthuctt.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		btnMHHDLammoi.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		btnMHHDThanhToan.addActionListener(new XuLySuKienChoTrangMuaHang(this));
		// sét tên để phân biệt
		txtMHTimSP.setName("Tìm sản phẩm");
		txtMHHDTienKhachDua.setName("Tiền khách đưa");
		cbbMHDanhMuc.setName("Danh mục");
		cbbMHNhaSX.setName("Nhà sản xuất");
		cbbMHHDHinhthuctt.setName("Hình thức thanh toán");
		// tạo hóa đơn
		khoiTaoHoaDon(hoaDonMuaHang);
	}

	public String dinhDangTien(double d) {
		return String.format("%,.0f", d);
	}

	public void khoiTaoBangCase() {
		modelMHCase = new DefaultTableModel();
		tableMHCase = new MyTable(modelMHCase);
		modelMHCase.addColumn("Mã sản phẩm");
		modelMHCase.addColumn("Tên sản phẩm");
		modelMHCase.addColumn("Đơn giá");
		modelMHCase.addColumn("Giảm giá");
		modelMHCase.addColumn("Nhà sản xuất");
		modelMHCase.addColumn("Số lượng tồn");
		modelMHCase.addColumn("Bảo hành");
		modelMHCase.addColumn("Chất liệu");
		modelMHCase.addColumn("Màu");
		modelMHCase.addColumn("Tương thích");
		tableMHCase.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setWidthChoColuomBang(tableMHCase, modelMHCase);
	}

	public void doDuLieuVaoBangCase(ArrayList<Case> ds) {
		for (Case c : ds) {
			modelMHCase.addRow(new Object[] {
					c.getMaSanPham(),
					c.getTenSanPham(),
					dinhDangTien(c.getGiaBan()),
					dinhDangTien(c.getGiamGia()),
					c.getNhaSanXuat(),
					c.getSoLuongTonKho(),
					c.getBaoHanh(),
					c.getChatLieu(),
					c.getMau(),
					c.getTuongThich()
			});
		}
	}

	public void khoiTaoBangCpu() {
		modelMHCpu = new DefaultTableModel();
		tableMHCpu = new MyTable(modelMHCpu);
		modelMHCpu.addColumn("Mã sản phẩm");
		modelMHCpu.addColumn("Tên sản phẩm");
		modelMHCpu.addColumn("Đơn giá");
		modelMHCpu.addColumn("Giảm giá");
		modelMHCpu.addColumn("Nhà sản xuất");
		modelMHCpu.addColumn("Số lượng tồn");
		modelMHCpu.addColumn("Bảo hành");
		modelMHCpu.addColumn("Sỗ lõi");
		modelMHCpu.addColumn("Sỗ luồng");
		modelMHCpu.addColumn("Tầng số cơ sỡ");
		modelMHCpu.addColumn("Tần số turbo");
		modelMHCpu.addColumn("Bộ nhớ đệm");
		modelMHCpu.addColumn("Bộ nhớ tối đa");
		tableMHCpu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setWidthChoColuomBang(tableMHCpu, modelMHCpu);
	}

	public void doDuLieuVaoBangCpu(ArrayList<Cpu> ds) {
		for (Cpu c : ds) {
			modelMHCpu.addRow(new Object[] {
					c.getMaSanPham(),
					c.getTenSanPham(),
					dinhDangTien(c.getGiaBan()),
					dinhDangTien(c.getGiamGia()),
					c.getNhaSanXuat(),
					c.getSoLuongTonKho(),
					c.getBaoHanh(),
					c.getSoLoi(),
					c.getSoLuong(),
					c.getTanSoCoSo(),
					c.getTanSoTurbo(),
					c.getBoNhoDem(),
					c.getBoNhoToiDa()
			});
		}
	}

	public void khoiTaoBangMain() {
		modelMHMain = new DefaultTableModel();
		tableMHMain = new MyTable(modelMHMain);
		modelMHMain.addColumn("Mã sản phẩm");
		modelMHMain.addColumn("Tên sản phẩm");
		modelMHMain.addColumn("Đơn giá");
		modelMHMain.addColumn("Giảm giá");
		modelMHMain.addColumn("Nhà sản xuất");
		modelMHMain.addColumn("Số lượng tồn");
		modelMHMain.addColumn("Bảo hành");
		modelMHMain.addColumn("Chip set");
		modelMHMain.addColumn("Ram hỗ trợ");
		modelMHMain.addColumn("Cpu hỗ trợ");
		modelMHMain.addColumn("Ổ cứng hỗ trợ");
		modelMHMain.addColumn("Đồ họa");
		tableMHMain.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setWidthChoColuomBang(tableMHMain, modelMHMain);
	}

	public void doDuLieuVaoBangMain(ArrayList<Main> ds) {
		for (Main c : ds) {
			modelMHMain.addRow(new Object[] {
					c.getMaSanPham(),
					c.getTenSanPham(),
					dinhDangTien(c.getGiaBan()),
					dinhDangTien(c.getGiamGia()),
					c.getNhaSanXuat(),
					c.getSoLuongTonKho(),
					c.getBaoHanh(),
					c.getChipSet(),
					c.getRamHoTro(),
					c.getCpuHoTro(),
					c.getoCungHoTro(),
					c.getDoHoa()
			});
		}
	}

	public void khoiTaoBangPsu() {
		modelMHPsu = new DefaultTableModel();
		tableMHPsu = new MyTable(modelMHPsu);
		modelMHPsu.addColumn("Mã sản phẩm");
		modelMHPsu.addColumn("Tên sản phẩm");
		modelMHPsu.addColumn("Đơn giá");
		modelMHPsu.addColumn("Giảm giá");
		modelMHPsu.addColumn("Nhà sản xuất");
		modelMHPsu.addColumn("Số lượng tồn");
		modelMHPsu.addColumn("Bảo hành");
		modelMHPsu.addColumn("Công suất");
		modelMHPsu.addColumn("Hiệu suất");
		modelMHPsu.addColumn("Tuổi thọ");
		tableMHPsu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setWidthChoColuomBang(tableMHPsu, modelMHPsu);
	}

	public void doDuLieuVaoBangPsu(ArrayList<Psu> ds) {
		for (Psu c : ds) {
			modelMHPsu.addRow(new Object[] {
					c.getMaSanPham(),
					c.getTenSanPham(),
					dinhDangTien(c.getGiaBan()),
					dinhDangTien(c.getGiamGia()),
					c.getNhaSanXuat(),
					c.getSoLuongTonKho(),
					c.getBaoHanh(),
					c.getCongSuat(),
					c.getHieuSuat(),
					c.getTuoiTho()
			});
		}
	}

	public void khoiTaoBangRam() {
		modelMHRam = new DefaultTableModel();
		tableMHRam = new MyTable(modelMHRam);
		modelMHRam.addColumn("Mã sản phẩm");
		modelMHRam.addColumn("Tên sản phẩm");
		modelMHRam.addColumn("Đơn giá");
		modelMHRam.addColumn("Giảm giá");
		modelMHRam.addColumn("Nhà sản xuất");
		modelMHRam.addColumn("Số lượng tồn");
		modelMHRam.addColumn("Bảo hành");
		modelMHRam.addColumn("Dung lượng");
		modelMHRam.addColumn("Tốc độ");
		tableMHRam.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setWidthChoColuomBang(tableMHRam, modelMHRam);
	}

	public void doDuLieuVaoBangRam(ArrayList<Ram> ds) {
		for (Ram c : ds) {
			modelMHRam.addRow(new Object[] {
					c.getMaSanPham(),
					c.getTenSanPham(),
					dinhDangTien(c.getGiaBan()),
					dinhDangTien(c.getGiamGia()),
					c.getNhaSanXuat(),
					c.getSoLuongTonKho(),
					c.getBaoHanh(),
					c.getDungLuong(),
					c.getTocDo()
			});
		}
	}

	public void khoiTaoBangVga() {
		modelMHVga = new DefaultTableModel();
		tableMHVga = new MyTable(modelMHVga);
		modelMHVga.addColumn("Mã sản phẩm");
		modelMHVga.addColumn("Tên sản phẩm");
		modelMHVga.addColumn("Đơn giá");
		modelMHVga.addColumn("Giảm giá");
		modelMHVga.addColumn("Nhà sản xuất");
		modelMHVga.addColumn("Số lượng tồn");
		modelMHVga.addColumn("Bảo hành");
		modelMHVga.addColumn("Tiến trình");
		modelMHVga.addColumn("TDP");
		modelMHVga.addColumn("Cudacores");
		tableMHVga.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setWidthChoColuomBang(tableMHVga, modelMHVga);
	}

	public void doDuLieuVaoBangVga(ArrayList<Vga> ds) {
		for (Vga c : ds) {
			modelMHVga.addRow(new Object[] {
					c.getMaSanPham(),
					c.getTenSanPham(),
					dinhDangTien(c.getGiaBan()),
					dinhDangTien(c.getGiamGia()),
					c.getNhaSanXuat(),
					c.getSoLuongTonKho(),
					c.getBaoHanh(),
					c.getTienTrinh(),
					c.getTDP(),
					c.getCudaCores()
			});
		}
	}

	public void capNhatDuLieuChoTatCaCacBangSanPham() {
		modelMHCase.setRowCount(0);
		doDuLieuVaoBangCase(new SanPham_BUS().getAllCase());
		modelMHCpu.setRowCount(0);
		doDuLieuVaoBangCpu(new SanPham_BUS().getAllCpu());
		modelMHMain.setRowCount(0);
		doDuLieuVaoBangMain(new SanPham_BUS().getAllMain());
		modelMHPsu.setRowCount(0);
		doDuLieuVaoBangPsu(new SanPham_BUS().getAllPsu());
		modelMHRam.setRowCount(0);
		doDuLieuVaoBangRam(new SanPham_BUS().getAllRam());
		modelMHVga.setRowCount(0);
		doDuLieuVaoBangVga(new SanPham_BUS().getAllVga());
	}
	// sét width coloum cho từng dòng trong table
	public void setWidthChoColuomBang(JTable table, DefaultTableModel model) {
		for(int i = 0; i < model.getColumnCount(); i++) {
			if(i == 1) {
				table.getColumnModel().getColumn(i).setPreferredWidth(200);
			}else {
				table.getColumnModel().getColumn(i).setPreferredWidth(100);
			}
		}
	}

	// PHẦN VIẾT GUI CHO SẢN PHẨM
	public void GUISanPham() {
		pnlSanPham = new JPanel();
		pnlSanPham.setLayout(null);
		// phần thông tin sản phẩm
		pnlSPThongTin = new JPanel();
		pnlSPThongTin.setLayout(null);
		TitledBorder titleSanPhamThongTin = BorderFactory.createTitledBorder("Thông tin sản phẩm");
		titleSanPhamThongTin.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		pnlSPThongTin.setBorder(titleSanPhamThongTin);
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
		cbbSPDanhMuc.addActionListener(new LocTheoDanhMucCuaPhanSanPham(this));

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
		themItemChoCbbNgayThangNam(cbbSPNgay, cbbSPThang, cbbSPNam);

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
		y =15;
		btnSPPhatSinhMa = new MyButton("Khởi tạo mã");
		btnSPPhatSinhMa.setBounds(x, y, 120, 35);
		y += 50;
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
		pnlSPThongTin.add(btnSPPhatSinhMa);
		pnlSPThongTin.add(btnSPThem);
		pnlSPThongTin.add(btnSPXoa);
		pnlSPThongTin.add(btnSPSua);
		pnlSPThongTin.add(btnSPLamMoi);

		// phần lọc sản phẩm
		pnlLocSP = new JPanel();
		pnlLocSP.setLayout(null);
		TitledBorder titleSanPhamLoc = BorderFactory.createTitledBorder("Lọc sản phẩm");
		titleSanPhamLoc.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		pnlLocSP.setBorder(titleSanPhamLoc);
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
		cbbSPLocDanhMuc.setName("cbbSPLocDanhMuc");

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
		cbbSPLocNhaSX.setName("cbbSPLocNhaSX");

		pnlLocSP3.add(new JLabel("Giá bán: "));
		pnlLocSP3.add(cbbSPLocGia = new MyCombobox());
		cbbSPLocGia.setPreferredSize(new Dimension(170, 25));
		cbbSPLocGia.setName("cbbSPLocGia");
		cbbSPLocGia.addItem("");
		cbbSPLocGia.addItem("0 - 1.000.000");
		cbbSPLocGia.addItem("1.000.000 - 2.000.000");
		cbbSPLocGia.addItem("2.000.000 - 3.000.000");
		cbbSPLocGia.addItem("3.000.000 - 4.000.000");
		cbbSPLocGia.addItem("4.000.000 - 5.000.000");
		cbbSPLocGia.addItem(" > 5.000.000");
		cbbSPLocGia.setName("cbbSPLocGia");

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
		tableSP.addMouseListener(new LocTheoDanhMucCuaPhanSanPham(this));


		// add sự kiện click cho combobox
		cbbSPLocNhaSX.addActionListener(new LoadDuLieuTheoCombobox(this));
		cbbSPLocDanhMuc.addActionListener(new LoadDuLieuTheoCombobox(this));
		cbbSPLocGia.addActionListener(new LoadDuLieuTheoCombobox(this));

		sp_BUS.DocDuLieuVaoTableSanPham(modelSP);

		// thêm sự kiện cho các btn
		ActionListener ac = new XuLySuKien_GUISanPham(this);
		btnSPThem.addActionListener(ac);
		btnSPLamMoi.addActionListener(ac);
		btnSPSua.addActionListener(ac);
		btnSPXoa.addActionListener(ac);
		btnSPPhatSinhMa.addActionListener(ac);
		txtSPLocTimKiem.addKeyListener(new XuLySuKien_GUISanPham(this));

		pnlSanPham.add(pnlSPThongTin);
		pnlSanPham.add(pnlLocSP);
		pnlSanPham.add(scroll);
		pnlSanPham.setBackground(Color.WHITE);
		pnlSPThongTin.setBackground(Color.WHITE);
		pnlLocSP.setBackground(Color.WHITE);
	}

	public void themItemChoCbbNgayThangNam(MyCombobox cbbngay, MyCombobox cbbthang, MyCombobox cbbnam) {
		for (int i = 1; i <= 31; i++) {
			cbbngay.addItem(i + "");
		}
		for (int i = 1; i <= 12; i++) {
			cbbthang.addItem(i + "");
		}
		for (int i = 2000; i <= 2023; i++) {
			cbbnam.addItem(i + "");
		}
	}

	// PHẦN VIẾT GUI CHO HÓA ĐƠN
	public void GUIHoaDon() {
		pnHoaDon = new JPanel();
		pnHoaDon.setLayout(new BorderLayout());
		JPanel pnNorthHoaDon = new JPanel();
		pnHoaDon.add(pnNorthHoaDon);
		pnNorthHoaDon.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));


		JPanel pntimKiem = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(25);
		pntimKiem.setLayout(flowLayout);
		JLabel lbltimKiemHoaDon = new JLabel("Tìm Kiếm Hóa Đơn :");
		txttimKiemHoaDon = new JTextField(70);
		txttimKiemHoaDon.setPreferredSize(new Dimension(70,25));
		pntimKiem.add(lbltimKiemHoaDon);
		pntimKiem.add(txttimKiemHoaDon);
		txttimKiemHoaDon.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		pnNorthHoaDon.add(pntimKiem, BorderLayout.NORTH);

		JPanel pnCenterHoaDon = new JPanel(new GridLayout(1, 5, 20, 0));

		JPanel pnkhachHang = new JPanel(new GridLayout(1, 1));
		MyButton btnHoaDonKhachHang = new MyButton("Khách hàng");
		pnkhachHang.add(btnHoaDonKhachHang);
		pnCenterHoaDon.add(pnkhachHang);

		JPanel pnNhanVien = new JPanel(new GridLayout(1, 1));
		MyButton btnHoaDonNhanVien = new MyButton("Nhân Viên");
		pnNhanVien.add(btnHoaDonNhanVien);
		pnCenterHoaDon.add(pnNhanVien);

		JPanel pnhinhThucThanhToan = new JPanel(new GridLayout(2, 1));
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		pnhinhThucThanhToan.setBorder(border);
		JLabel lblhinhThucThanhToan = new JLabel("Hình thức thanh toán");
		cbohinhThucThanhToan = new MyCombobox();
		cbohinhThucThanhToan.addItem("Tất cả");
		cbohinhThucThanhToan.addItem("Tiền mặt");
		cbohinhThucThanhToan.addItem("Quẹt thẻ");
		cbohinhThucThanhToan.addItem("Chuyển khoản");
		pnhinhThucThanhToan.add(lblhinhThucThanhToan);
		pnhinhThucThanhToan.add(cbohinhThucThanhToan);
		pnCenterHoaDon.add(pnhinhThucThanhToan);

		JPanel pntongTien = new JPanel(new GridLayout(2, 1));
		pntongTien.setBorder(border);
		JLabel lbltongTien = new JLabel("Tổng tiền:");
		cbotongTien = new MyCombobox();
		cbotongTien.addItem("Tất cả");
		cbotongTien.addItem("Dưới 1.000.000");
		cbotongTien.addItem("1.000.000 đến 5.000.000");
		cbotongTien.addItem("5.000.000 đến 10.000.000");
		cbotongTien.addItem("10.000.000 đến 20.000.000");
		cbotongTien.addItem("Trên 20.000.000");
		pntongTien.add(lbltongTien);
		pntongTien.add(cbotongTien);
		pnCenterHoaDon.add(pntongTien);

		JPanel ngayThangPanel = new JPanel(new GridLayout(1, 3, 10, 0));
		ngayThangPanel.setBorder(border);
		JPanel ngayPanel = new JPanel(new GridLayout(2, 1));
		JLabel ngayLabel = new JLabel("Ngày:");
		cbongay = new MyCombobox();
		ngayPanel.add(ngayLabel);
		ngayPanel.add(cbongay);
		JPanel thangPanel = new JPanel(new GridLayout(2, 1));
		JLabel thangLabel = new JLabel("Tháng:");
		cbothang = new MyCombobox();
		thangPanel.add(thangLabel);
		thangPanel.add(cbothang);
		JPanel namPanel = new JPanel(new GridLayout(2, 1));
		JLabel namLabel = new JLabel("Năm:");
		cbonam = new MyCombobox();
		themItemChoCbbNgayThangNam(cbongay, cbothang, cbonam);
		cbongay.insertItemAt("", 0);
		cbothang.insertItemAt("", 0);
		cbonam.insertItemAt("", 0);
		cbongay.setSelectedIndex(0);
		cbothang.setSelectedIndex(0);
		cbonam.setSelectedIndex(0);
		namPanel.add(namLabel);
		namPanel.add(cbonam);
		ngayThangPanel.add(ngayPanel);
		ngayThangPanel.add(thangPanel);
		ngayThangPanel.add(namPanel);
		pnCenterHoaDon.add(ngayThangPanel);

		pnNorthHoaDon.add(pnCenterHoaDon, BorderLayout.CENTER);

		String[] columnNames = { "Mã hóa đơn", "Tổng tiền", "Thanh toán", "Tiền khách trả", "Tiền thừa", "Hình thức thanh toán",
				"Ngày lập hóa đơn", "Mã NV", "Tên NV", "Mã KH", "Tên KH", "Ghi Chú" };
		modelHoaDon = new DefaultTableModel(columnNames, 0);
		tableHoaDon = new MyTable(modelHoaDon);
		tableHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i = 0; i < modelHoaDon.getColumnCount(); i++) {
			tableHoaDon.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
		JScrollPane scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setPreferredSize(new Dimension(1030,350));
		pnNorthHoaDon.add(scrollPane, BorderLayout.SOUTH);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Hóa đơn"));

		JPanel pnSouthHoaDon = new JPanel();
		pnSouthHoaDon.setPreferredSize(new Dimension(1030, 250));
		pnHoaDon.add(pnSouthHoaDon, BorderLayout.SOUTH);
		pnSouthHoaDon.setBorder(BorderFactory.createTitledBorder("Chi tiết hóa đơn"));
		String[] clos = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn Giá"};
		modelChiTietHoaDon = new DefaultTableModel(clos, 0);
		tableChiTietHoaDon = new MyTable(modelChiTietHoaDon);
		JScrollPane scrollPaneChiTietHoaDon = new JScrollPane(tableChiTietHoaDon);
		scrollPaneChiTietHoaDon.setPreferredSize(new Dimension(1030,200));
		pnSouthHoaDon.add(scrollPaneChiTietHoaDon, BorderLayout.CENTER);
		doDuLieuVaoBangHoaDon(new HoaDon_BUS().getAllHoaDon());
		//		 phần thêm sự kiện
		tableHoaDon.addMouseListener(new XuLySuKienChoTrangHoaDon(this));
		cbohinhThucThanhToan.addActionListener(new XuLySuKienChoTrangHoaDon(this));
		cbotongTien.addActionListener(new XuLySuKienChoTrangHoaDon(this));
		cbongay.addActionListener(new XuLySuKienChoTrangHoaDon(this));
		cbothang.addActionListener(new XuLySuKienChoTrangHoaDon(this));
		cbonam.addActionListener(new XuLySuKienChoTrangHoaDon(this));
		txttimKiemHoaDon.addKeyListener(new XuLySuKienChoTrangHoaDon(this));
		ViewTrangChu viewHome = this;
		btnHoaDonNhanVien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewChonNhanVien(nhanVienLocHoaDon, viewHome).setVisible(true);
			}
		});

		btnHoaDonKhachHang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewChonKhachHang(khachHangLocHoaDon, null, null, null, null, null, null, viewHome, "Hóa đơn").setVisible(true);;
			}
		});
	}
	//PHẦN VIẾT LỌC DỮ LIỆU CHO TRANG HÓA ĐƠN
	public void locDuLieuVaoBangHoaDon() {
		ArrayList<HoaDon> dsHoaDon = new HoaDon_BUS().getAllHoaDon();
		locHoaDonBangTxt(dsHoaDon);
		locHoaDonBangNhanVien(dsHoaDon);
		locHoaDonBangKhachHang(dsHoaDon);
		locHoaDonBangHinhThucThanhToan(dsHoaDon);
		locHoaDonBangTongTien(dsHoaDon);
		locHoaDonBangNgayLapHoaDon(dsHoaDon);
		locHoaDonBangThangLapHoaDon(dsHoaDon);
		locHoaDonBangNamLapHoaDon(dsHoaDon);
		modelHoaDon.setRowCount(0);
		doDuLieuVaoBangHoaDon(dsHoaDon);
	}
	
	public void locHoaDonBangTxt(ArrayList<HoaDon> ds) {
		String valuetxttext = txttimKiemHoaDon.getText().toString();
		if(!valuetxttext.equals("")) {
			ArrayList<HoaDon> dstam = new ArrayList<>();
			for (HoaDon hoaDon : ds) {
				if(hoaDon.getMaHoaDon().contains(valuetxttext)) dstam.add(hoaDon);
			}
			ds.clear();
			ds.addAll(dstam);
		}
	}

	public void locHoaDonBangNhanVien(ArrayList<HoaDon> ds) {
		ArrayList<HoaDon> dstam = new ArrayList<>();
		if(!nhanVienLocHoaDon.getMa().equals("")) {
			for (HoaDon hoaDon : ds) {
				if(hoaDon.getNhanVien().getMa().equals(nhanVienLocHoaDon.getMa())) dstam.add(hoaDon);
			}
			ds.clear();
			ds.addAll(dstam);
		}
	}

	public void locHoaDonBangKhachHang(ArrayList<HoaDon> ds) {
		ArrayList<HoaDon> dstam = new ArrayList<>();
		if(!khachHangLocHoaDon.getMa().equals("")) {
			for (HoaDon hoaDon : ds) {
				if(hoaDon.getKhachHang().getMa().equals(khachHangLocHoaDon.getMa())) dstam.add(hoaDon);
			}
			ds.clear();
			ds.addAll(dstam);
		}
	}

	public void locHoaDonBangHinhThucThanhToan(ArrayList<HoaDon> ds) {
		ArrayList<HoaDon> dstam = new ArrayList<>();
		if(cbohinhThucThanhToan.getSelectedIndex() != 0) {
			String hinhThucThanhToanLoc = cbohinhThucThanhToan.getSelectedItem()+"";
			for (HoaDon hoaDon : ds) {
				if(hoaDon.getHinhThucThanhToan().equals(hinhThucThanhToanLoc)) dstam.add(hoaDon);
			}
			ds.clear();
			ds.addAll(dstam);
		}
	}

	public void locHoaDonBangTongTien(ArrayList<HoaDon> ds) {
		ArrayList<HoaDon> dstam = new ArrayList<>();
		if(cbotongTien.getSelectedIndex() != 0) {
			int indexSelected = cbotongTien.getSelectedIndex();
			for (HoaDon hoaDon : ds) {
				double tongTienHoaDon = hoaDon.tinhTongTien();
				if(indexSelected == 1) {
					if(tongTienHoaDon < 1000000) dstam.add(hoaDon);
				}else if(indexSelected == 2) {
					if(tongTienHoaDon >= 1000000 && tongTienHoaDon < 5000000) dstam.add(hoaDon);
				}else if(indexSelected == 3) {
					if(tongTienHoaDon >= 5000000 && tongTienHoaDon < 10000000) dstam.add(hoaDon);
				}else if(indexSelected == 4) {
					if(tongTienHoaDon >= 10000000 && tongTienHoaDon < 20000000) dstam.add(hoaDon);
				}else {
					if(tongTienHoaDon >= 20000000) ds.add(hoaDon);
				}
			}
			ds.clear();
			ds.addAll(dstam);
		}
	}

	public void locHoaDonBangNgayLapHoaDon(ArrayList<HoaDon> ds) {
		ArrayList<HoaDon> dstam = new ArrayList<>();
		if(cbongay.getSelectedIndex() != 0) {
			int ngay = Integer.parseInt(cbongay.getSelectedItem()+"");
			for (HoaDon hoaDon : ds) {
				if(hoaDon.getNgayLapHoaDon().getDayOfMonth() == ngay) dstam.add(hoaDon);
			}
			ds.clear();
			ds.addAll(dstam);
		}
	}

	public void locHoaDonBangThangLapHoaDon(ArrayList<HoaDon> ds) {
		ArrayList<HoaDon> dstam = new ArrayList<>();
		if(cbothang.getSelectedIndex() != 0) {
			int thang = Integer.parseInt(cbothang.getSelectedItem()+"");
			for (HoaDon hoaDon : ds) {
				if(hoaDon.getNgayLapHoaDon().getMonthValue() == thang) dstam.add(hoaDon);
			}
			ds.clear();
			ds.addAll(dstam);
		}
	}

	public void locHoaDonBangNamLapHoaDon(ArrayList<HoaDon> ds) {
		ArrayList<HoaDon> dstam = new ArrayList<>();
		if(cbonam.getSelectedIndex() != 0) {
			int nam = Integer.parseInt(cbonam.getSelectedItem()+"");
			for (HoaDon hoaDon : ds) {
				if(hoaDon.getNgayLapHoaDon().getYear() == nam) dstam.add(hoaDon);
			}
			ds.clear();
			ds.addAll(dstam);
		}
	}


	public void doDuLieuVaoBangHoaDon(ArrayList<HoaDon> ds) {
		for (HoaDon hoaDon : ds) {
			modelHoaDon.addRow(new Object[] {
					hoaDon.getMaHoaDon(),
					dinhDangTien(hoaDon.tinhTongTien()),
					dinhDangTien(hoaDon.tinhTienCanThanhToan()),
					dinhDangTien(hoaDon.getTienKhachTra()),
					dinhDangTien(hoaDon.tinhTienThua()),
					hoaDon.getHinhThucThanhToan(),
					hoaDon.getNgayLapHoaDon(),
					hoaDon.getNhanVien().getMa(),
					hoaDon.getNhanVien().getTen(),
					hoaDon.getKhachHang().getMa(),
					hoaDon.getKhachHang().getTen(),
					hoaDon.getGhiChu()
			});
		}
	}
	//XỬ LÝ SỰ KIỆN CHO NHẤN VÀO BẢNG HÓA ĐƠN
	public void xuLySuKienKhiNhanVaoBangHoaDon() {
		int row = tableHoaDon.getSelectedRow();
		String maHoaDon = modelHoaDon.getValueAt(row, 0).toString();
		HoaDon hd = new HoaDon_BUS().getHoaDonByMaHoaDon(maHoaDon);
		doDuLieuVaoBangChiTietHoaDonTrangHoaDon(hd.getDsChiTietHoaDon());
	}

	public void doDuLieuVaoBangChiTietHoaDonTrangHoaDon(ArrayList<ChiTietHoaDon> ds) {
		modelChiTietHoaDon.setRowCount(0);
		for (ChiTietHoaDon c : ds) {
			modelChiTietHoaDon.addRow(new Object[] {
					c.getSanPham().getMaSanPham(),
					c.getSanPham().getTenSanPham(),
					c.getSoLuongMua(),
					dinhDangTien(c.tinhTongTien())
			});
		}
	}

	// PHẦN VIẾT GUI CHO KHÁCH HÀNG
	public void GUIKhachHang() {
		model_KHthongTin = new DefaultTableModel(
				new String[] { "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Số Điện Thoại", "Email", "Địa Chỉ","Điểm tích lũy" },
				0);
		tb_thongTinCaNhanKH = new MyTable(model_KHthongTin);
		tb_thongTinCaNhanKH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i =0;i<model_KHthongTin.getColumnCount();i++) {
			tb_thongTinCaNhanKH.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
		model_KHlichSuGD = new DefaultTableModel(new String[] { "Mã Giao Dịch", "Tên Khách Hàng", "Ngày giao dịch",
				"Số Điện Thoại", "Tổng tiền" }, 0);

		tb_LichSuGiaoDichKH = new MyTable(model_KHlichSuGD);

		pnlCenter_KhachHang = new JPanel();
		pnlCenter_KhachHang.setLayout(null);
		pnlCenter_KhachHang.setBackground(Color.white);

		JPanel pnlTopKH = new JPanel();
		pnlTopKH.setLayout(null);
		JLabel lbl_thietLapThongTin = new JLabel("Thiết lập thông tin khách hàng");
		pnlCenter_KhachHang.add(lbl_thietLapThongTin);
		lbl_thietLapThongTin.setBounds(40, 5, 1000, 20);
		pnlTopKH.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlCenter_KhachHang.add(pnlTopKH);
		pnlTopKH.setBounds(40, 35, 1000, 220);


		// left pnlTop thiết lập thông tin khách hàng
		Box b = new Box(BoxLayout.X_AXIS);
		b.add(lbl_maKhach = new JLabel("Mã khách hàng:"));
		b.add(txt_maKhachHang = new JTextField());
		txt_maKhachHang.setBorder(BorderFactory.createLoweredBevelBorder());
		lbl_maKhach.setPreferredSize(new Dimension(120, 30));
		txt_maKhachHang.setEditable(false);

		b.setBounds(20, 20, 350, 30);

		Box b1 = new Box(BoxLayout.X_AXIS);
		b1.add(lbl_tenKhachHang = new JLabel("Tên khách hàng: "));
		b1.add(txt_tenKhachHang = new JTextField());
		txt_tenKhachHang.setBorder(BorderFactory.createLoweredBevelBorder());
		lbl_tenKhachHang.setPreferredSize(lbl_maKhach.getPreferredSize());
		b1.setBounds(20, 70, 350, 30);

		Box b2 = new Box(BoxLayout.X_AXIS);
		b2.add(lbl_GioiTinhKH = new JLabel("Giới tính:                   "));
		lbl_GioiTinhKH.setPreferredSize(lbl_maKhach.getPreferredSize());
		b2.add(lbl_tempKH = new JLabel());
		b2.add(radNamKH = new JRadioButton("Nam"));
		b2.add(radNuKH = new JRadioButton("Nữ"));
		radNamKH.setFocusPainted(false);
		radNuKH.setFocusPainted(false);
		groupbtnKH = new ButtonGroup();
		groupbtnKH.add(radNamKH);
		groupbtnKH.add(radNuKH);
		b2.setBounds(20, 120, 350, 30);

		Box b3 = new Box(BoxLayout.X_AXIS);
		b3.add(lbl_soDienThoaiKH = new JLabel("Số điện thoại: "));
		b3.add(txt_soDienThoaiKH = new JTextField());
		txt_soDienThoaiKH.setBorder(BorderFactory.createLoweredBevelBorder());
		lbl_soDienThoaiKH.setPreferredSize(lbl_maKhach.getPreferredSize());
		b3.setBounds(20, 160, 350, 30);

		lbl_maKhach.setPreferredSize(lbl_tenKhachHang.getPreferredSize());
		lbl_soDienThoaiKH.setPreferredSize(lbl_tenKhachHang.getPreferredSize());
		lbl_GioiTinhKH.setPreferredSize(lbl_tenKhachHang.getPreferredSize());

		// center pnlTop thiết lập thông tin khách hàng
		Box b4 = new Box(BoxLayout.X_AXIS);
		b4.add(lbl_emailKH = new JLabel("Email: "));
		b4.add(txt_emailKH = new JTextField());
		txt_emailKH.setBorder(BorderFactory.createLoweredBevelBorder());
		b4.setBounds(430, 20, 300, 30);

		Box b5 = new Box(BoxLayout.X_AXIS);
		b5.add(lbl_diaChiKH = new JLabel("Địa chỉ: "));
		b5.add(txt_AreaKH = new JTextArea(8, 15));
		txt_AreaKH.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		b5.setBounds(430, 80, 300, 80);
		lbl_emailKH.setPreferredSize(lbl_diaChiKH.getPreferredSize());

		// right pnlTop thiết lập thông tin khách hàng
		JPanel pnRight = new JPanel();
		pnRight.setLayout(null);


		pnRight.add(btn_KhoiTaoMaKH = new MyButton("Khởi Tạo Mã"));
		btn_KhoiTaoMaKH.setBounds(20, 0, 120, 34);
		btn_KhoiTaoMaKH.setBorder(BorderFactory.createRaisedBevelBorder());

		pnRight.add(btn_ThemKH = new MyButton("Thêm"));
		btn_ThemKH.setBounds(20, 36, 120, 34);
		btn_ThemKH.setBorder(BorderFactory.createRaisedBevelBorder());


		pnRight.add(btn_SuaKH = new MyButton("Sửa"));
		btn_SuaKH.setBounds(20, 72, 120, 34);
		btn_SuaKH.setBorder(BorderFactory.createRaisedBevelBorder());

		pnRight.add(btn_LamMoiKH = new MyButton("Làm mới"));
		btn_LamMoiKH.setBounds(20, 108, 120, 34);
		btn_LamMoiKH.setBorder(BorderFactory.createRaisedBevelBorder());

		pnRight.add(btn_XoaKH = new MyButton("Xóa"));
		btn_XoaKH.setBounds(20, 144, 120, 34);
		btn_XoaKH.setBorder(BorderFactory.createRaisedBevelBorder());


		pnRight.setBounds(780, 20, 200, 180);

		pnlTopKH.add(b);
		pnlTopKH.add(b1);
		pnlTopKH.add(b2);
		pnlTopKH.add(b3);
		pnlTopKH.add(b4);
		pnlTopKH.add(b5);
		pnlTopKH.add(pnRight);

		// pnl bottom
		JLabel lbl_thongTinKhach = new JLabel("Thông tin khách hàng");
		lbl_thongTinKhach.setBounds(40, 270, 1000, 20);
		pnlCenter_KhachHang.add(lbl_thongTinKhach);
		JPanel pnlBottom = new JPanel();
		pnlCenter_KhachHang.add(pnlBottom);
		pnlBottom.setBounds(40, 300, 1000, 400);
		pnlBottom.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlBottom.setLayout(null);

		tabbedPane = new JTabbedPane();	
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel pn_ThongTinCaNhan = new JPanel();
		JPanel pn_LichSuGiaoDich = new JPanel();
		tabbedPane.addTab("Thông tin cá nhân", taoTabPanel(pn_ThongTinCaNhan,tb_thongTinCaNhanKH ,txt_TimKiemTTKH,txt_DiaChiTTKH,combobox_TTKHGioiTinh,modelcomboTTKHGioiTinh));
		tabbedPane.addTab("Lịch sử giao dịch", taoTabPanelLSGD(pn_LichSuGiaoDich,tb_LichSuGiaoDichKH));
		sorter = new TableRowSorter<>(model_KHthongTin);
		tb_thongTinCaNhanKH.setRowSorter(sorter);
		sorter = new TableRowSorter<>(model_KHlichSuGD);
		tb_LichSuGiaoDichKH.setRowSorter(sorter);

		pnlBottom.add(tabbedPane);
		tabbedPane.setBounds(25, 15, 950, 370);
		kh_BUS.addDaTaToTBKhachHang(model_KHthongTin);

		// Phần add sự kiện và đưa qua controller để điều hướng 
		tb_thongTinCaNhanKH.addMouseListener(new XuLySuKien_GUIKhachHang(this));
		btn_LamMoiKH.addActionListener(new XuLySuKien_GUIKhachHang(this));
		btn_KhoiTaoMaKH.addActionListener(new XuLySuKien_GUIKhachHang(this));
		btn_SuaKH.addActionListener(new XuLySuKien_GUIKhachHang(this));
		btn_ThemKH.addActionListener(new XuLySuKien_GUIKhachHang(this));
		btn_XoaKH.addActionListener(new XuLySuKien_GUIKhachHang(this));
		txt_TimKiemTTKH.addKeyListener(new XuLySuKien_GUIKhachHang(this));
		txt_DiaChiLSGD.addKeyListener(new XuLySuKien_GUIKhachHang(this));
		txt_DiaChiTTKH.addKeyListener(new XuLySuKien_GUIKhachHang(this));
		txt_TimKiemLSGD.addKeyListener(new XuLySuKien_GUIKhachHang(this));
		combobox_TTKHGioiTinh.addActionListener(new XuLySuKien_GUIKhachHang(this));
	}
	// Tạo panel cho panel thông tin khách hàng
	public JPanel taoTabPanel(JPanel temp, MyTable table, JTextField txtTimKiem, JTextField txtDiaChi, JComboBox<String> comboGioiTinh, DefaultComboBoxModel<String> modelcombo) {
		temp.setLayout(null);
		temp.setBackground(Color.white);
		temp.setBounds(25, 60, 950, 400);
		Box b8 = new Box(BoxLayout.X_AXIS);
		b8.add(lbl_timKiemKH = new JLabel("Tìm kiếm: "));
		b8.add(txtTimKiem);
		txtTimKiem.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		b8.setBounds(25, 25, 650, 30);
		temp.add(b8, BorderLayout.NORTH);


		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBounds(25, 75, 650, 250);

		JPanel pn_loc = new JPanel();
		JLabel lbl_loc = new JLabel("Lọc");
		lbl_loc.setBounds(700, 20, 100, 30);
		temp.add(lbl_loc);
		lbl_loc.setFont(new Font("Arial", Font.PLAIN, 16));
		pn_loc.setBorder(BorderFactory.createLoweredBevelBorder());
		pn_loc.setLayout(null);
		JLabel lbl_locGioiTinh = new JLabel("Giới tính: ");
		lbl_locGioiTinh.setBounds(20, 30, 100, 30);
		JLabel lbl_locDiaChi = new JLabel("Địa chỉ: ");
		lbl_locDiaChi.setBounds(20, 120, 100, 30);
		modelcombo.removeAllElements();
		modelcombo.addElement("Tất cả");
		modelcombo.addElement("Nam");
		modelcombo.addElement("Nữ");
		comboGioiTinh.setModel(modelcombo);
		comboGioiTinh.setBounds(20, 60, 180, 30);
		txtDiaChi.setBounds(20, 150, 180, 30);
		pn_loc.add(lbl_locGioiTinh);
		pn_loc.add(comboGioiTinh);
		pn_loc.add(lbl_locDiaChi);
		pn_loc.add(txtDiaChi);
		pn_loc.setBounds(700, 50, 220, 250);

		temp.add(b8);
		temp.add(sp);
		temp.add(pn_loc);
		return temp;
	}
	//Tạo panel bên tab lịch sử giao dịch
	public JPanel taoTabPanelLSGD(JPanel temp, MyTable table) {
		temp.setLayout(null);
		temp.setBackground(Color.white);
		temp.setBounds(25, 60, 950, 400);
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBounds(0, 0, 950, 400);
		temp.add(sp);
		return temp;
	}

	// PHẦN VIẾT GUI CHO THỐNG KÊ
	public void GUIThongKe() {
		pnThongKe = new JPanel();
		JPanel pnNorthThongKe = new JPanel(new GridLayout(1, 3, 20, 0));
		pnThongKe.add(pnNorthThongKe, BorderLayout.NORTH);

		JPanel pnDoanhThu = new JPanel(new GridBagLayout());
		pnDoanhThu.setPreferredSize(new Dimension(200, 100));
		pnDoanhThu.setBackground(mauChuDao);
		JLabel lbldoanhThu = new JLabel("Doanh Thu");
		lbldoanhThu.setFont(new Font("Arial", Font.BOLD, 20));
		lblsoDoanhThu = new JLabel();
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
		lblsoSoHoaDon = new JLabel("");
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
		lblsoTongKhachHang = new JLabel("");
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

		JPanel pnCenterThongKe = new JPanel(new GridLayout(1, 4, 10, 10));
		pnCenterThongKe.setPreferredSize(new Dimension(1000, 45));
		pnThongKe.add(pnCenterThongKe, BorderLayout.CENTER);

		JPanel pnNam = new JPanel(new BorderLayout());
		pnNam.setBorder(BorderFactory.createTitledBorder("Năm"));
		pnNam.setPreferredSize(new Dimension(20, 10));
		cboNamThongKe = new MyCombobox();
		cboNamThongKe.addItem("Tất cả");
		for(int i = 2000; i < 2024; i++) {
			cboNamThongKe.addItem(i);
		}
		cboNamThongKe.setPreferredSize(new Dimension(10, 5));
		pnNam.add(cboNamThongKe);
		pnCenterThongKe.add(pnNam);

		JPanel pnThang = new JPanel(new BorderLayout());
		pnThang.setBorder(BorderFactory.createTitledBorder("Tháng"));
		pnThang.setPreferredSize(new Dimension(20, 10));
		cboThangThongKe = new MyCombobox();
		cboThangThongKe.addItem("Tất cả");
		for(int i = 1; i < 13; i++) {
			cboThangThongKe.addItem(i);
		}
		pnThang.add(cboThangThongKe);
		pnCenterThongKe.add(pnThang);

		JPanel pnSouthThongKe = new JPanel(new BorderLayout());
		pnSouthThongKe.setPreferredSize(new Dimension(1000, 540));
		String[] clos = {"Mã sản phẩm","Tên sản phẩm", "Số lượng đã bán", "Doanh thu" };
		modelThongKe = new DefaultTableModel(clos, 0);
		tableThongKe = new MyTable(modelThongKe);
		JScrollPane scrollPaneChiTietHoaDon = new JScrollPane(tableThongKe);
		pnSouthThongKe.add(scrollPaneChiTietHoaDon, BorderLayout.CENTER);
		pnThongKe.add(pnSouthThongKe, BorderLayout.CENTER);
		// thêm dữ liệu 
		capNhatDuLieuPhanThongKe();
		// thêm sự kiện cho phần tử trang thống kê
		cboNamThongKe.addActionListener(new XuLySuKienChoTrangThongKe(this));
		cboThangThongKe.addActionListener(new XuLySuKienChoTrangThongKe(this));
	}
	// cập nhật dữ liệu phần thống kê
	public void capNhatDuLieuPhanThongKe() {
		lblsoDoanhThu.setText(dinhDangTien(hdbusThongKe.tinhTongDoanhThu(hdbusThongKe.getAllHoaDon())));
		lblsoSoHoaDon.setText(hdbusThongKe.soHoaDon(hdbusThongKe.getAllHoaDon())+"");
		lblsoTongKhachHang.setText(hdbusThongKe.tongSoKhachHang(hdbusThongKe.getAllHoaDon())+"");
		doDuLieuVaoBangThongKe(cthdbus.getAllChiTietHoaDonBoiDsHoaDon(hdbusThongKe.getAllHoaDon()));
	}
	// đỗ dữ liệu vào bảng thống kê
	public void doDuLieuVaoBangThongKe(ArrayList<ChiTietHoaDon> ds) {
		modelThongKe.setRowCount(0);;
		ChiTietHoaDon_BUS cthdbus = new ChiTietHoaDon_BUS();
		ArrayList<ChiTietHoaDon> dstemp = cthdbus.taoMangChiTietSanPhamKhongTrung(ds);
		for (ChiTietHoaDon ct : dstemp) {
			modelThongKe.addRow(new Object[] {
					ct.getSanPham().getMaSanPham(),
					ct.getSanPham().getTenSanPham(),
					cthdbus.tongSoLuongSanPhamDaBan(ct.getSanPham().getMaSanPham()),
					dinhDangTien(cthdbus.tongDoanhThuSanPhamDaBan(ct.getSanPham().getMaSanPham()))
			});
		}
	}

	//lọc dữ liệu trang thống kê
	public void locDuLieuThongKe() {
		ArrayList<HoaDon> dshd = new HoaDon_BUS().getAllHoaDon();
		locDuLieuThongKeBangNam(dshd);
		locDuLieuThongKeBangThang(dshd);
		lblsoDoanhThu.setText(dinhDangTien(hdbusThongKe.tinhTongDoanhThu(dshd)));
		lblsoSoHoaDon.setText(hdbusThongKe.soHoaDon(dshd)+"");
		lblsoTongKhachHang.setText(hdbusThongKe.tongSoKhachHang(dshd)+"");
		doDuLieuVaoBangThongKe(cthdbus.getAllChiTietHoaDonBoiDsHoaDon(dshd));
	}

	public void locDuLieuThongKeBangNam(ArrayList<HoaDon> dshd) {
		if(!cboNamThongKe.getSelectedItem().equals("Tất cả")) {
			int nam = Integer.parseInt(cboNamThongKe.getSelectedItem()+"");
			ArrayList<HoaDon> dstam = new ArrayList<>();
			for (HoaDon hoaDon : dshd) {
				if(hoaDon.getNgayLapHoaDon().getYear() == nam) dstam.add(hoaDon);
			}
			dshd.clear();
			dshd.addAll(dstam);
		}
	}

	public void locDuLieuThongKeBangThang(ArrayList<HoaDon> dshd) {
		if(!cboThangThongKe.getSelectedItem().equals("Tất cả")) {
			int thang = Integer.parseInt(cboThangThongKe.getSelectedItem()+"");
			ArrayList<HoaDon> dstam = new ArrayList<>();
			for (HoaDon hoaDon : dshd) {
				if(hoaDon.getNgayLapHoaDon().getMonthValue() == thang) dstam.add(hoaDon);
			}
			dshd.clear();
			dshd.addAll(dstam);
		}
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
		iconfinal.setImage(iconfinal.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
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

	// xóa giao diện hiện tại
	public void xoaGiaoDienHienTai() {
		if(indexFrame.equals("Trang Chủ")) {
			this.remove(pnlTrangChu);
			btnControlTrangChu.setBackground(mauChuDao);
		}
		if(indexFrame.equals("Mua Hàng")) {
			this.remove(pnlMuaHang);
			btnControlMuaHang.setBackground(mauChuDao);
		}
		if(indexFrame.equals("Nhân Viên")) {
			this.remove(pnlNhanVien);
			btnControlNhanVien.setBackground(mauChuDao);
		}
		if(indexFrame.equals("Sản Phẩm")) {
			this.remove(pnlSanPham);
			btnControlSanPham.setBackground(mauChuDao);
		}
		if(indexFrame.equals("Hóa Đơn")) {
			this.remove(pnHoaDon);
			btnControlHoaDon.setBackground(mauChuDao);
		}
		if(indexFrame.equals("Khách Hàng")) {
			this.remove(pnlCenter_KhachHang);
			btnControlKhachHang.setBackground(mauChuDao);
		}if(indexFrame.equals("Thống Kê")) {
			this.remove(pnThongKe);
			btnControlThongKe.setBackground(mauChuDao);
		}
	}

	// phần sử lý điều hướng ứng dụng
	public void xuLyDieuHuong(String src) {
		if(src.equals("Thoát")) {
			if(JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất hay không?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				new ViewDangNhap().setVisible(true);
				this.setVisible(false);
			}
		}else {
			if(src.equals("Trang Chủ")) {
				xoaGiaoDienHienTai();
				this.add(pnlTrangChu);
				btnControlTrangChu.setBackground(new Color(255,165,0));
				indexFrame = src;
				this.revalidate();
				this.repaint();
			}
			if(src.equals("Mua Hàng")) {
				xoaGiaoDienHienTai();
				this.add(pnlMuaHang);
				btnControlMuaHang.setBackground(new Color(255,165,0));
				indexFrame = src;
				this.revalidate();
				this.repaint();
			}
			if(src.equals("Sản Phẩm")) {
				if(kiemTraChucVu()) {
					xoaGiaoDienHienTai();
					this.add(pnlSanPham);
					btnControlSanPham.setBackground(new Color(255,165,0));
					indexFrame = src;
					this.revalidate();
					this.repaint();
				}
			}
			if(src.equals("Hóa Đơn")) {
				if(kiemTraChucVu()) {
					xoaGiaoDienHienTai();
					this.add(pnHoaDon);
					btnControlHoaDon.setBackground(new Color(255,165,0));
					indexFrame = src;
					this.revalidate();
					this.repaint();
				}
			}
			if(src.equals("Nhân Viên")) {
				if(kiemTraChucVu()) {
					xoaGiaoDienHienTai();
					this.add(pnlNhanVien);
					btnControlNhanVien.setBackground(new Color(255,165,0));
					indexFrame = src;
					this.revalidate();
					this.repaint();
				}
			}
			if(src.equals("Khách Hàng")) {
				if(kiemTraChucVu()) {
					xoaGiaoDienHienTai();
					this.add(pnlCenter_KhachHang);
					btnControlKhachHang.setBackground(new Color(255,165,0));
					indexFrame = src;
					this.revalidate();
					this.repaint();
				}
			}
			if(src.equals("Thống Kê")) {
				if(kiemTraChucVu()) {
					xoaGiaoDienHienTai();
					this.add(pnThongKe);
					btnControlThongKe.setBackground(new Color(255,165,0));
					indexFrame = src;
					this.revalidate();
					this.repaint();
				}
			}
		}
	}

	public boolean kiemTraChucVu() {
		if(!nhanVien.getChucVu().equals("Quản lý")) {
			JOptionPane.showMessageDialog(this, "Chỉ có quản lý mới có thể sử dụng tính năng này");
			return false;
		}
		return true;
	}

	// phần sử lý giao diện khi người dùng chọn một danh mục bất kỳ trong phần mua hàng
	public void xuLyDanhMucMuaHang() {
		String key = cbbMHDanhMuc.getSelectedItem().toString();
		switch (key) {
		case "CASE": {
			scrMHTable.setViewportView(tableMHCase);
			break;
		}
		case "CPU": {
			scrMHTable.setViewportView(tableMHCpu);
			break;
		}
		case "RAM": {
			scrMHTable.setViewportView(tableMHRam);
			break;
		}
		case "PSU": {
			scrMHTable.setViewportView(tableMHPsu);
			break;
		}
		case "VGA": {
			scrMHTable.setViewportView(tableMHVga);
			break;
		}
		case "MAIN": {
			scrMHTable.setViewportView(tableMHMain);
			break;
		}
		}
	}
	// Phần xử lý sự kiện ở GUI_KHACHHANG
	// Phần tạo mã khách hàng
	public String createMaKH() {
		return kh_BUS.getMaKhachHangMax();
	}
	// Phần thêm khách hàng
	public void themKhachHang() {
		String mes = "";
		if(kh_BUS.valiData(txt_tenKhachHang.getText(), txt_soDienThoaiKH.getText(), txt_emailKH.getText(), txt_AreaKH.getText(), radNamKH.isSelected(), radNuKH.isSelected())) {
			if(kh_BUS.themKhachHang(new KhachHang(txt_maKhachHang.getText(), txt_tenKhachHang.getText(), txt_soDienThoaiKH.getText(), radNamKH.isSelected(), txt_emailKH.getText(), txt_AreaKH.getText(), 0))) {
				JOptionPane.showMessageDialog(this, "Thêm thành công khách hàng");
			}else {
				JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại");
			}
		}else {
			JOptionPane.showMessageDialog(this, kh_BUS.mes);
		}
	}
	// Phần sự kiện trong bảng ở GUI_KHACHHANG
	// Phần đẩy dữ liệu các ô Text và radio bằng bảng thông tin khách hàng 
	public void upLoadTBThongTinCaNhanKHtoText() {
		int row = tb_thongTinCaNhanKH.getSelectedRow();
		txt_maKhachHang.setText(model_KHthongTin.getValueAt(row, 0).toString());
		txt_tenKhachHang.setText(model_KHthongTin.getValueAt(row, 1).toString());
		if((model_KHthongTin.getValueAt(row, 2).toString()).equalsIgnoreCase("Nam")) {
			radNamKH.setSelected(true);
		}else {
			radNuKH.setSelected(true);
		}
		txt_soDienThoaiKH.setText(model_KHthongTin.getValueAt(row, 3).toString());
		txt_emailKH.setText(model_KHthongTin.getValueAt(row, 4).toString());
		txt_AreaKH.setText(model_KHthongTin.getValueAt(row, 5).toString());
	}
	// Phần đẩy dữ liệu vào bảng lịch sử giao dịch bằng mã khách hàng được chọn
	public void doDuLieuVaoBangLSGDTheoKhachHang() {
		model_KHlichSuGD.setRowCount(0);
		int row = tb_thongTinCaNhanKH.getSelectedRow();
		kh_BUS.layDuLieuBangLSGDTheoMa(model_KHthongTin.getValueAt(row, 0).toString(), model_KHlichSuGD);
	}

	// phần sử lý sự kiện trên gui sản phẩm
	public void remove_text() {
		txtSPMa.setText("");
		txtSPTen.setText("");
		txtSPGiaBan.setText("");
		txtSPSoLuongTon.setText("");
		txtSPBaoHanh.setText("");
		txtSPGiamGia.setText("");
		txtSPGiaNhap.setText("");


		txtSPSoLoi.setText("");
		txtSPSoLuongXuLy.setText("");
		txtSPTanSoCoSo.setText("");
		txtSPTanSoTurbo.setText("");
		txtSPBoNhoDem.setText("");
		txtSPBoNhoToiDa.setText("");


		txtSPTienTrinh.setText("");
		txtSPTDP.setText("");
		txtSPCudaCores.setText("");


		txtSPMau.setText("");
		txtSPTuongThich.setText("");


		txtSPCongSuat.setText("");
		txtSPHieuSuat.setText("");
		txtSPTuoiTho.setText("");


		txtSPDungLuong.setText("");
		txtSPTocDo.setText("");


		txtSPMauChipset.setText("");
		txtSPOCungHoTro.setText("");
		txtSPCpuHoTro.setText("");
		txtSPRamHoTro.setText("");
		txtSPDoHoa.setText("");

	}

	public SanPham revert_SanPham() {
		String ma = txtSPMa.getText();
		String ten = txtSPTen.getText();
		double giaBan = Double.parseDouble(txtSPGiaBan.getText().replaceAll(",", ""));
		int slt = Integer.parseInt(txtSPSoLuongTon.getText());
		int baoHanh = Integer.parseInt(txtSPBaoHanh.getText());
		int giamGia = Integer.parseInt(txtSPGiamGia.getText().replaceAll(",", ""));
		double giaNhap = Double.parseDouble(txtSPGiaNhap.getText().replaceAll(",", ""));
		String nhasx = cbbSPNhaSX.getSelectedItem().toString();
		int ngay = Integer.parseInt(cbbSPNgay.getSelectedItem().toString());
		int thang = Integer.parseInt(cbbSPThang.getSelectedItem().toString());
		int nam = Integer.parseInt(cbbSPNam.getSelectedItem().toString());
		LocalDate d = LocalDate.of(nam, thang, ngay);
		return new SanPham(ma, ten, giaBan, slt, nhasx, d, baoHanh, giaNhap, giamGia);
	}

	public void reloadTable() {
		modelSP.setRowCount(0);
		sp_BUS.DocDuLieuVaoTableSanPham(modelSP);
	}

	public void xuLySuKienTXTtimKiem() {
		String txtTimKiem = txtSPLocTimKiem.getText().trim();
		ArrayList<SanPham> ds = sp_BUS.dsSauKhiTimKiem(txtTimKiem);
		modelSP.setRowCount(0);
		for (SanPham sp : ds) {
			modelSP.addRow(new Object[] {sp.getMaSanPham(), sp.getTenSanPham(), sp.getGiaBan(), sp.getSoLuongTonKho(), sp.getNhaSanXuat(), sp.getNgaySanXuat(), sp.getBaoHanh(), sp.getGiaNhap(), sp.getGiamGia()});
		}
	}

	public void xuLySK_GuiSanPham(Object o) {
		if(o.equals(btnSPLamMoi)) {
			remove_text();
			txtSPMa.setEditable(true);
			tableSP.clearSelection();
		}
		if(o.equals(btnSPThem)) {
			Boolean check = sp_BUS.Validate_sanpham(txtSPMa.getText(), txtSPTen.getText(), txtSPGiaBan.getText(), txtSPSoLuongTon.getText(), txtSPBaoHanh.getText(), txtSPGiaNhap.getText(), txtSPGiamGia.getText());
			SanPham temp = new SanPham();
			if(sp_BUS.checkMaTrung(txtSPMa.getText())) {
				String key = cbbSPDanhMuc.getSelectedItem().toString();
				switch(key) {
				case "CPU": {
					Boolean check_cpu = sp_BUS.validate_cpu(txtSPSoLoi.getText(), txtSPSoLuongXuLy.getText(), txtSPTanSoCoSo.getText(), txtSPTanSoTurbo.getText(), txtSPBoNhoDem.getText(), txtSPBoNhoToiDa.getText());

					if( check == false || check_cpu == false) {
						JOptionPane.showMessageDialog(this, check == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();
					}else {
						temp = revert_SanPham();
						int soLoi = Integer.parseInt(txtSPSoLoi.getText());
						int soLuongXuLy = Integer.parseInt(txtSPSoLuongXuLy.getText());
						double tanSoCoSo = Double.parseDouble(txtSPTanSoCoSo.getText());
						double tanSoTurbo = Double.parseDouble(txtSPTanSoTurbo.getText());
						int boNhoDem = Integer.parseInt(txtSPBoNhoDem.getText());
						int boNhoToiDa = Integer.parseInt(txtSPBoNhoToiDa.getText());
						Cpu p = new Cpu(temp.getMaSanPham(), temp.getTenSanPham(), temp.getGiaBan(),
								temp.getSoLuongTonKho(), temp.getNhaSanXuat(), temp.getNgaySanXuat(),
								temp.getBaoHanh(), temp.getGiaNhap(), temp.getGiamGia(),
								soLoi, soLuongXuLy, tanSoCoSo, tanSoTurbo, boNhoDem, boNhoToiDa);
						try {
							sp_BUS.themSanPham_Cpu(p);
							JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
							remove_text();
						}catch(Exception e) {
							e.printStackTrace();
						}

					}

					break;
				}
				case "VGA": {
					Boolean check_vga = sp_BUS.validate_vga(txtSPTienTrinh.getText(), txtSPTDP.getText(), txtSPCudaCores.getText());

					if( check == false || check_vga == false) {
						JOptionPane.showMessageDialog(this, check == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();
					}else {
						temp = revert_SanPham();
						int tienTrinh = Integer.parseInt(txtSPTienTrinh.getText());
						int TDP = Integer.parseInt(txtSPTDP.getText());
						int cudaCores = Integer.parseInt(txtSPCudaCores.getText());
						Vga v = new Vga(temp.getMaSanPham(), temp.getTenSanPham(), temp.getGiaBan(),
								temp.getSoLuongTonKho(), temp.getNhaSanXuat(), temp.getNgaySanXuat(),
								temp.getBaoHanh(), temp.getGiaNhap(), temp.getGiamGia(),
								tienTrinh, TDP, cudaCores);
						try {
							sp_BUS.themSanPham_Vga(v);
							JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
							remove_text();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}
				case "MAIN": {
					//				String chipSet, String ramHoTro, String cpuHoTro, String doHoa, String oCungHoTro
					Boolean check_main = sp_BUS.validate_main(txtSPMauChipset.getText(), txtSPRamHoTro.getText(), txtSPCpuHoTro.getText(), txtSPDoHoa.getText(), txtSPOCungHoTro.getText());
					if( check == false || check_main == false) {
						JOptionPane.showMessageDialog(this, check == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();					
					}else {
						temp = revert_SanPham();
						String mau = txtSPMauChipset.getText();
						String oCung = txtSPOCungHoTro.getText();
						String cpuHoTro = txtSPCpuHoTro.getText();
						String ramHoTro = txtSPRamHoTro.getText();
						String doHoa = txtSPDoHoa.getText();
						Main m = new Main(temp.getMaSanPham(), temp.getTenSanPham(), temp.getGiaBan(),
								temp.getSoLuongTonKho(), temp.getNhaSanXuat(), temp.getNgaySanXuat(),
								temp.getBaoHanh(), temp.getGiaNhap(), temp.getGiamGia(),
								mau, ramHoTro, cpuHoTro, doHoa, oCung);
						try {
							sp_BUS.themSanPham_Main(m);
							JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
							remove_text();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}
				case "PSU": {
					Boolean check_psu = sp_BUS.validate_psu(txtSPCongSuat.getText(), txtSPHieuSuat.getText(), txtSPTuoiTho.getText());
					if(check == false || check_psu == false) {
						JOptionPane.showMessageDialog(this, check == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();					
					}else {
						temp = revert_SanPham();
						int congSuat = Integer.parseInt(txtSPCongSuat.getText());
						int hieuSuat = Integer.parseInt(txtSPHieuSuat.getText());
						int tuoiTho = Integer.parseInt(txtSPTuoiTho.getText());
						Psu ps = new Psu(temp.getMaSanPham(), temp.getTenSanPham(), temp.getGiaBan(),
								temp.getSoLuongTonKho(), temp.getNhaSanXuat(), temp.getNgaySanXuat(),
								temp.getBaoHanh(), temp.getGiaNhap(), temp.getGiamGia(),
								congSuat, hieuSuat, tuoiTho);
						try {
							sp_BUS.themSanPham_Psu(ps);
							JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
							remove_text();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}
				case "RAM": {
					Boolean check_ram = sp_BUS.validate_ram(txtSPDungLuong.getText(), txtSPTocDo.getText());
					if( check == false || check_ram == false) {
						JOptionPane.showMessageDialog(this, check == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();					
					}else {
						temp = revert_SanPham();
						int dungLuong = Integer.parseInt(txtSPDungLuong.getText());
						int tocDo = Integer.parseInt(txtSPTocDo.getText());
						Ram r = new Ram(temp.getMaSanPham(), temp.getTenSanPham(), temp.getGiaBan(),
								temp.getSoLuongTonKho(), temp.getNhaSanXuat(), temp.getNgaySanXuat(),
								temp.getBaoHanh(), temp.getGiaNhap(), temp.getGiamGia(),
								dungLuong, tocDo);
						try {
							sp_BUS.themSanPham_Ram(r);
							JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
							remove_text();
						}catch(Exception e) {
							e.printStackTrace();
						}

					}
					break;
				}
				case "CASE": {
					Boolean check_case = sp_BUS.validate_case(txtSPMau.getText(), txtSPTuongThich.getText());
					if( check == false || check_case == false) {
						JOptionPane.showMessageDialog(this, check == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();					
					}else {
						temp = revert_SanPham();
						String mauSac = txtSPMau.getText();
						String tuongThich = txtSPTuongThich.getText();
						String chatLieu = cbbSPChatLieu.getSelectedItem().toString();
						Case ca = new Case( temp.getMaSanPham(), temp.getTenSanPham(), temp.getGiaBan(),
								temp.getSoLuongTonKho(), temp.getNhaSanXuat(), temp.getNgaySanXuat(),
								temp.getBaoHanh(), temp.getGiaNhap(), temp.getGiamGia(),
								chatLieu, mauSac, tuongThich);
						try {
							sp_BUS.themSanPham_Case(ca);
							JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
							remove_text();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}

				}
				reloadTable();
			}else {
				JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại");
			}
		}
		if(o.equals(btnSPXoa)) {
			int row = tableSP.getSelectedRow();
			if(row != -1 ) {
				if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này không ? ", "Cảnh báo", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
					sp_BUS.xoaSanPhamTheoMa(modelSP.getValueAt(row, 0).toString(), cbbSPDanhMuc.getSelectedItem().toString());
					modelSP.removeRow(row);
					remove_text();
					JOptionPane.showMessageDialog(this, "Xóa thành công sản phẩm");
					txtSPMa.setEditable(true);
				}
			}else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
			}
		}
		if(o.equals(btnSPSua)) {
			int rows = tableSP.getSelectedRow();

			if(rows != -1) {
				String maCanTim = modelSP.getValueAt(rows, 0).toString();
				String loai = sp_BUS.getLoaiSanPham(maCanTim);
				Boolean checks = true;
				SanPham temp = revert_SanPham();
				switch(loai) {
				case"CPU": {
					// cpu
					ArrayList<Cpu> ds_cpu = sp_BUS.getAllCpu();
					Cpu k = new Cpu();
					for (int i = 0; i < ds_cpu.size(); i++) {
						if(ds_cpu.get(i).getMaSanPham().equals(maCanTim)) {
							k = ds_cpu.get(i);
							break;
						}
					}
					checks = sp_BUS.Validate_sanpham(txtSPMa.getText(), txtSPTen.getText(), txtSPGiaBan.getText(), txtSPSoLuongTon.getText(), txtSPBaoHanh.getText(), txtSPGiaNhap.getText(), txtSPGiamGia.getText());
					boolean checks_cpu = sp_BUS.validate_cpu(txtSPSoLoi.getText(), txtSPSoLuongXuLy.getText(), txtSPTanSoCoSo.getText(), txtSPTanSoTurbo.getText(), txtSPBoNhoDem.getText(), txtSPBoNhoToiDa.getText());
					if( checks == false || checks_cpu == false) {
						JOptionPane.showMessageDialog(this, checks == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();
					}else {
						// update sản phẩm tìm được

						k.setSoLoi(Integer.parseInt(txtSPSoLoi.getText()));
						k.setSoLuong(Integer.parseInt(txtSPSoLuongXuLy.getText()));
						k.setTanSoCoSo(Double.parseDouble(txtSPTanSoCoSo.getText()));
						k.setTanSoTurbo(Double.parseDouble(txtSPTanSoTurbo.getText()));
						k.setBoNhoDem(Integer.parseInt(txtSPBoNhoDem.getText()));
						k.setBoNhoToiDa(Integer.parseInt(txtSPBoNhoToiDa.getText()));
						sp_BUS.update_cpu(temp, k);
						reloadTable();
						JOptionPane.showMessageDialog(this, "Cập nhật thành công sản phẩm");
						remove_text();				         	 

					}
					break;
				}
				case"VGA": {
					ArrayList<Vga> ds_vga = sp_BUS.getAllVga();
					Vga v = new Vga();
					for(int i = 0 ; i < ds_vga.size(); i++) {
						if(ds_vga.get(i).getMaSanPham().equals(maCanTim)) {
							v = ds_vga.get(i);
							break;
						}
					}
					checks = sp_BUS.Validate_sanpham(txtSPMa.getText(), txtSPTen.getText(), txtSPGiaBan.getText(), txtSPSoLuongTon.getText(), txtSPBaoHanh.getText(), txtSPGiaNhap.getText(), txtSPGiamGia.getText());
					boolean checks_vga = sp_BUS.validate_vga(txtSPTienTrinh.getText(), txtSPTDP.getText(), txtSPCudaCores.getText());
					if( checks == false || checks_vga == false) {
						JOptionPane.showMessageDialog(this, checks == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();
					}else {
						v.setTienTrinh(Integer.parseInt(txtSPTienTrinh.getText()));
						v.setTDP(Integer.parseInt(txtSPTDP.getText()));
						v.setCudaCores(Integer.parseInt(txtSPCudaCores.getText())); 
						sp_BUS.update_vga(temp, v);
						reloadTable();
						JOptionPane.showMessageDialog(this, "Cập nhật thành công sản phẩm");
						remove_text();	

					}
					break;
				}
				case"MAIN": {
					ArrayList<Main> ds_main = sp_BUS.getAllMain();
					Main m = new Main();
					for(int i = 0 ; i < ds_main.size(); i++) {
						if(ds_main.get(i).getMaSanPham().equals(maCanTim)) {
							m = ds_main.get(i);
							break;
						}
					}
					checks = sp_BUS.Validate_sanpham(txtSPMa.getText(), txtSPTen.getText(), txtSPGiaBan.getText(), txtSPSoLuongTon.getText(), txtSPBaoHanh.getText(), txtSPGiaNhap.getText(), txtSPGiamGia.getText());
					boolean checks_main = sp_BUS.validate_main(txtSPMauChipset.getText(), txtSPRamHoTro.getText(), txtSPCpuHoTro.getText(), txtSPDoHoa.getText(), txtSPOCungHoTro.getText());
					if( checks == false || checks_main == false) {
						JOptionPane.showMessageDialog(this, checks == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();
					}else {
						m.setChipSet(txtSPMauChipset.getText());
						m.setRamHoTro(txtSPRamHoTro.getText());
						m.setCpuHoTro(txtSPCpuHoTro.getText());
						m.setoCungHoTro(txtSPOCungHoTro.getText());
						m.setDoHoa(txtSPDoHoa.getText());
						sp_BUS.update_main(temp, m);
						reloadTable();
						JOptionPane.showMessageDialog(this, "Cập nhật thành công sản phẩm");
						remove_text();	
					}
					break;
				}
				case"PSU": {
					ArrayList<Psu> ds_psu = sp_BUS.getAllPsu();
					Psu p = new Psu();
					for(int i = 0 ; i < ds_psu.size(); i++) {
						if(ds_psu.get(i).getMaSanPham().equals(maCanTim)) {
							p = ds_psu.get(i);
							break;
						}
					}
					checks = sp_BUS.Validate_sanpham(txtSPMa.getText(), txtSPTen.getText(), txtSPGiaBan.getText(), txtSPSoLuongTon.getText(), txtSPBaoHanh.getText(), txtSPGiaNhap.getText(), txtSPGiamGia.getText());
					boolean checks_psu = sp_BUS.validate_psu(txtSPCongSuat.getText(), txtSPHieuSuat.getText(), txtSPTuoiTho.getText());
					if( checks == false || checks_psu == false) {
						JOptionPane.showMessageDialog(this, checks == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();
					}else {
						p.setCongSuat(Integer.parseInt(txtSPCongSuat.getText()));
						p.setHieuSuat(Integer.parseInt(txtSPHieuSuat.getText()));
						p.setTuoiTho(Integer.parseInt(txtSPTuoiTho.getText()));
						sp_BUS.update_psu(temp, p);
						reloadTable();
						JOptionPane.showMessageDialog(this, "Cập nhật thành công sản phẩm");
						remove_text();	
					}
					break;
				}

				case"RAM": {
					ArrayList<Ram> ds_ram = sp_BUS.getAllRam();
					Ram r = new Ram();
					for(int i = 0 ; i < ds_ram.size(); i++) {
						if(ds_ram.get(i).getMaSanPham().equals(maCanTim)) {
							r = ds_ram.get(i);
							break;
						}
					}
					checks = sp_BUS.Validate_sanpham(txtSPMa.getText(), txtSPTen.getText(), txtSPGiaBan.getText(), txtSPSoLuongTon.getText(), txtSPBaoHanh.getText(), txtSPGiaNhap.getText(), txtSPGiamGia.getText());
					boolean checks_ram = sp_BUS.validate_ram(txtSPDungLuong.getText(), txtSPTocDo.getText());
					if( checks == false || checks_ram == false) {
						JOptionPane.showMessageDialog(this, checks == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();
					}else {
						r.setDungLuong(Integer.parseInt(txtSPDungLuong.getText()));
						r.setTocDo(Integer.parseInt(txtSPTocDo.getText()));
						sp_BUS.update_ram(temp, r);
						reloadTable();
						JOptionPane.showMessageDialog(this, "Cập nhật thành công sản phẩm");
						remove_text();	
					}
					break;
				}
				case"CASE": {
					ArrayList<Case> ds_case = sp_BUS.getAllCase();
					Case ca = new Case();
					for(int i = 0 ; i < ds_case.size(); i++) {
						if(ds_case.get(i).getMaSanPham().equals(maCanTim)) {
							ca = ds_case.get(i);
							break;
						}
					}
					checks = sp_BUS.Validate_sanpham(txtSPMa.getText(), txtSPTen.getText(), txtSPGiaBan.getText(), txtSPSoLuongTon.getText(), txtSPBaoHanh.getText(), txtSPGiaNhap.getText(), txtSPGiamGia.getText());
					boolean checks_case = sp_BUS.validate_case(txtSPMau.getText(), txtSPTuongThich.getText());
					if( checks == false || checks_case == false) {
						JOptionPane.showMessageDialog(this, checks == false ? sp_BUS.message_sp + sp_BUS.message_loai : sp_BUS.message_loai);
						sp_BUS.xoaThongBaoLoi();
					}else {
						ca.setMau(txtSPMau.getText());
						ca.setTuongThich(txtSPTuongThich.getText());
						ca.setChatLieu(cbbSPChatLieu.getSelectedItem().toString());
						sp_BUS.update_case(temp, ca);
						reloadTable();
						JOptionPane.showMessageDialog(this, "Cập nhật thành công sản phẩm");
						remove_text();	
					}
					break;
				}
				}
				txtSPMa.setEditable(true);
			}else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
			}
		}
		if(o.equals(btnSPPhatSinhMa)) {
			txtSPMa.setText(sp_BUS.getMaTuDong());
		}
	}

	public void uploadTbSanPham() {
		int row = tableSP.getSelectedRow();
		double giaBan = Double.parseDouble(modelSP.getValueAt(row, 2).toString().replaceAll(",", ""));
		double giaNhap = Double.parseDouble(modelSP.getValueAt(row, 7).toString().replaceAll(",", ""));
		double giamGia = Double.parseDouble(modelSP.getValueAt(row, 8).toString().replaceAll(",", ""));
		txtSPMa.setText(modelSP.getValueAt(row, 0).toString());
		txtSPMa.setEditable(false);
		txtSPTen.setText(modelSP.getValueAt(row, 1).toString());
		txtSPGiaBan.setText(dinhDangTien(giaBan));
		txtSPSoLuongTon.setText(modelSP.getValueAt(row, 3).toString());
		txtSPBaoHanh.setText(modelSP.getValueAt(row, 6).toString());
		txtSPGiaNhap.setText(dinhDangTien(giaNhap));
		txtSPGiamGia.setText(dinhDangTien(giamGia));
		cbbSPNhaSX.setSelectedItem(modelSP.getValueAt(row, 4).toString());
		if(modelSP.getValueAt(row, 5).toString().trim().substring(8, 9).equals("0")) {
			cbbSPNgay.setSelectedItem(modelSP.getValueAt(row, 5).toString().trim().substring(9, 10));
		}else {
			cbbSPNgay.setSelectedItem(modelSP.getValueAt(row, 5).toString().trim().substring(8, 10));			
		}
		cbbSPNam.setSelectedItem(modelSP.getValueAt(row, 5).toString().trim().substring(0, 4));
		if(modelSP.getValueAt(row, 5).toString().trim().substring(6, 7).equals("1")
				|| modelSP.getValueAt(row, 5).toString().trim().substring(6, 7).equals("0")
				|| modelSP.getValueAt(row, 5).toString().trim().substring(6, 7).equals("2")) {
			cbbSPThang.setSelectedItem(modelSP.getValueAt(row, 5).toString().substring(5, 7));
		}else {
			cbbSPThang.setSelectedItem(modelSP.getValueAt(row, 5).toString().substring(6, 7));
		}

		String maCanTim = modelSP.getValueAt(row, 0).toString();
		String loai = sp_BUS.getLoaiSanPham(maCanTim).toUpperCase();
		cbbSPDanhMuc.setSelectedItem(loai);
		switch(loai) {
		case "CPU": {
			ArrayList<Cpu> ds_cpu = sp_BUS.getAllCpu();
			Cpu k = new Cpu();
			for (int i = 0; i < ds_cpu.size(); i++) {
				if(ds_cpu.get(i).getMaSanPham().equals(maCanTim)) {
					k = ds_cpu.get(i);
					break;
				}
			}
			txtSPSoLoi.setText(k.getSoLoi()+"");
			txtSPSoLuongXuLy.setText(k.getSoLuong()+"");
			txtSPTanSoCoSo.setText(k.getTanSoCoSo()+"");
			txtSPTanSoTurbo.setText(k.getTanSoTurbo()+"");
			txtSPBoNhoDem.setText(k.getBoNhoDem()+"");
			txtSPBoNhoToiDa.setText(k.getBoNhoToiDa()+"");
			break;
		}
		case "VGA": {
			ArrayList<Vga> ds_vga = sp_BUS.getAllVga();
			Vga v = new Vga();
			for (int i = 0; i < ds_vga.size(); i++) {
				if(ds_vga.get(i).getMaSanPham().equals(maCanTim)) {
					v = ds_vga.get(i);
				}
			}
			txtSPTienTrinh.setText(v.getTienTrinh()+"");
			txtSPTDP.setText(v.getTDP()+"");
			txtSPCudaCores.setText(v.getCudaCores()+"");
			break;
		}
		case "PSU": {
			ArrayList<Psu> ds_psu = sp_BUS.getAllPsu();
			Psu p = new Psu();
			for (int i = 0; i < ds_psu.size(); i++) {
				if(ds_psu.get(i).getMaSanPham().equals(maCanTim)) {
					p = ds_psu.get(i);
				}
			}
			txtSPCongSuat.setText(p.getCongSuat()+"");
			txtSPHieuSuat.setText(p.getHieuSuat()+"");
			txtSPTuoiTho.setText(p.getTuoiTho()+"");
			break;
		}
		case "RAM": {
			ArrayList<Ram> ds_ram = sp_BUS.getAllRam();
			Ram r = new Ram();
			for (int i = 0; i < ds_ram.size(); i++) {
				if(ds_ram.get(i).getMaSanPham().equals(maCanTim)) {
					r = ds_ram.get(i);
				}
			}
			txtSPDungLuong.setText(r.getDungLuong()+"");
			txtSPTocDo.setText(r.getTocDo()+"");
			break;
		}
		case "MAIN": {
			ArrayList<Main> ds_main = sp_BUS.getAllMain();
			Main m = new Main();
			for (int i = 0; i < ds_main.size(); i++) {
				if(ds_main.get(i).getMaSanPham().equals(maCanTim)) {
					m = ds_main.get(i);
				}
			}
			txtSPMauChipset.setText(m.getChipSet()+"");
			txtSPRamHoTro.setText(m.getRamHoTro()+"");
			txtSPCpuHoTro.setText(m.getCpuHoTro()+"");
			txtSPOCungHoTro.setText(m.getoCungHoTro()+"");
			txtSPDoHoa.setText(m.getDoHoa());
			break;
		}
		case "CASE": {
			ArrayList<Case> ds_case = sp_BUS.getAllCase();
			Case ca = new Case();
			for (int i = 0; i < ds_case.size(); i++) {
				if(ds_case.get(i).getMaSanPham().equals(maCanTim)) {
					ca = ds_case.get(i);
				}
			}
			txtSPMau.setText(ca.getMau()+"");
			txtSPTuongThich.setText(ca.getTuongThich()+"");
			cbbSPChatLieu.setSelectedItem(ca.getChatLieu());
			break;
		}
		}

	}


	public void xuLyDuLieuLocTrenCombobox() {
		ArrayList<SanPham> ds = sp_BUS.getDSanPhams();
		locTheoLoaiSanPham(ds);	
		locTheoNhaSanXuat(ds);
		locTheoGia(ds);
		modelSP.setRowCount(0);
		sp_BUS.DocDuLieuVaoTableSanPhams(modelSP, ds);

	}

	public void locTheoLoaiSanPham(ArrayList<SanPham> ds_temp) {
		ArrayList<SanPham> temp = new ArrayList<SanPham>();
		String loai = cbbSPLocDanhMuc.getSelectedItem().toString();
		if(loai.equals("") == false) {
			for (SanPham sp : ds_temp) {
				String t = sp_BUS.getLoaiSanPham(sp.getMaSanPham().trim());
				if(t.equals(loai)) {
					temp.add(sp);
				}
			}

		}
		if(temp.size() > 0) {
			ds_temp.clear();
			ds_temp.addAll(temp);	
		}
	}



	// lọc theo nhà sản xuất
	public void locTheoNhaSanXuat(ArrayList<SanPham> ds_temp) {
		ArrayList<SanPham> temp = new ArrayList<SanPham>();
		String key = cbbSPLocNhaSX.getSelectedItem().toString();
		for (SanPham sp : ds_temp) {
			if(sp.getNhaSanXuat().equals(key)) {
				temp.add(sp);
			}
		}
		if(temp.size() > 0) {
			ds_temp.clear();
			ds_temp.addAll(temp);    			
		}
	}



	// lọc theo giá tiền
	public void locTheoGia(ArrayList<SanPham> ds_temp) {

		ArrayList<SanPham> temp = new ArrayList<SanPham>();
		String key = cbbSPLocGia.getSelectedItem().toString();
		if(key.contains(".0")) {
			if(key.equals(" > 5.000.000")) {
				double d = 0.0;
				String[] gia = key.trim().split(">");
				for (int j = 0; j < gia.length;) {
					d = Double.parseDouble(gia[j + 1].trim().replace(".", ""));
					break;
				}

				for (SanPham sp : ds_temp) {
					double c = sp.getGiaBan();
					if(c > d) {
						temp.add(sp);
					}  		
				}
			}else {

				String[] giaTien = key.trim().split("-");
				double a = 0.0, b = 0.0;
				int i = 0;
				for (i = 0; i < giaTien.length;) {
					a = Double.parseDouble(giaTien[i].trim().replace(".", ""));
					b = Double.parseDouble(giaTien[i + 1].trim().replace(".", ""));
					break;
				}

				for (SanPham sp : ds_temp) {
					double k = sp.getGiaBan();
					if(a <= k && k <= b) {
						temp.add(sp);
					}	
				}

			}
		}

		if(temp.size() > 0) {
			ds_temp.clear();
			ds_temp.addAll(temp); 
		}
	}

	// lọc theo nhiều combobox
	public ArrayList<SanPham> getDSHienTai(String name) {
		name_before = name;
		ArrayList<SanPham> ds_hienTai = new ArrayList<SanPham>(); 
		DefaultTableModel model = (DefaultTableModel) tableSP.getModel();
		int rowCount = model.getRowCount();

		for (int i = 0; i < rowCount; i++) {
			// Lấy giá trị từng ô của hàng i
			Object value1 = model.getValueAt(i, 0);
			Object value2 = model.getValueAt(i, 1);
			Object value3 = model.getValueAt(i, 2);
			Object value4 = model.getValueAt(i, 3);
			Object value5 = model.getValueAt(i, 4);
			Object value6 = model.getValueAt(i, 5);
			Object value7 = model.getValueAt(i, 6);
			Object value8 = model.getValueAt(i, 7);
			Object value9 = model.getValueAt(i, 8);

			String ma = (String) value1.toString();
			String ten = (String) value2.toString();
			double giaBan = (double) (Double.parseDouble(value3.toString()));
			int slt = (int) (Integer.parseInt(value4.toString()));
			String nhasx = (String) value5.toString();
			LocalDate t = (LocalDate)value6;
			int baoHanh = (int) (Integer.parseInt(value7.toString()));
			double giaNhap = (double) (Double.parseDouble(value8.toString()));
			int giamGia = (int) (Integer.parseInt(value9.toString()));
			String loai = (String)(sp_BUS.getLoaiSanPham(ma));

			SanPham v = new SanPham(ma, ten, giaBan, slt, nhasx, t, baoHanh, giaNhap, giamGia);
			ds_hienTai.add(v);
			// Xử lý dữ liệu ở đây
		}
		return ds_hienTai;
	}



	// phần xử lý sự kiện các nút ở GUI_KHACHHANG

	public void xuLySuKienBtn_GUIKhachHang(Object o) {
		int selectedIndex = tabbedPane.getSelectedIndex();
		if(o.equals(btn_LamMoiKH)) {
			txt_maKhachHang.setText("");	
			txt_tenKhachHang.setText("");	
			txt_AreaKH.setText("");	
			txt_soDienThoaiKH.setText("");	
			txt_emailKH.setText("");	
			groupbtnKH.clearSelection();
			txt_maKhachHang.requestFocus();

		}
		else if(o.equals(btn_KhoiTaoMaKH)) {
			txt_maKhachHang.setText(createMaKH());
		}
		else if(o.equals(btn_ThemKH)) {
			themKhachHang();
			model_KHthongTin.setRowCount(0);
			kh_BUS.addDaTaToTBKhachHang(model_KHthongTin);
		}else if(o.equals(btn_SuaKH)) {
			if(txt_maKhachHang.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần sửa thông tin");
			}
			else if(kh_BUS.valiData(txt_tenKhachHang.getText(), txt_soDienThoaiKH.getText(), txt_emailKH.getText(), txt_AreaKH.getText(),radNamKH.isSelected(),radNuKH.isSelected())) {
				if(kh_BUS.getkhachHangTheoMa(txt_maKhachHang.getText())!=null) {
					kh_BUS.suaKhachHangTheoMa(new KhachHang(txt_maKhachHang.getText(), txt_tenKhachHang.getText(), txt_soDienThoaiKH.getText(), radNamKH.isSelected(), txt_emailKH.getText(), txt_AreaKH.getText(), 0));
					JOptionPane.showMessageDialog(this, "sửa thông tin khách hàng thành công");
					model_KHthongTin.setRowCount(0);
					kh_BUS.addDaTaToTBKhachHang(model_KHthongTin);
				}else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng cần sửa");
				}

			}else {
				JOptionPane.showMessageDialog(this, kh_BUS.mes);
			}
		}
		else if(o.equals(btn_XoaKH)) {
			if(txt_maKhachHang.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa thông tin");
			}else {
				if((JOptionPane.showConfirmDialog(this, "Xóa Khách Hàng", "Bạn có muốn xóa khách hàng này không", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)) {
					JOptionPane.showMessageDialog(this, "xóa thông tin khách hàng thành công");
					kh_BUS.xoaKhachHangTheoMa(txt_maKhachHang.getText());
					model_KHthongTin.setRowCount(0);
					kh_BUS.addDaTaToTBKhachHang(model_KHthongTin);
				}
			}
		}else if(o.equals(combobox_TTKHGioiTinh)&&selectedIndex==0) {
			xuLyTimKiemTTKH(kh_BUS.getAllKhachHang());
		}
	}

	//phần xử lý sự kiện tìm kiếm ở GUI_KHACHHANG
	public void xuLySuKienTimKiemTTKH(KeyEvent e) {
		Object o= e.getSource();
		char key = e.getKeyChar(); 
		if ((Character.isLetterOrDigit(key)||key == e.VK_BACK_SPACE)&&(tabbedPane.getSelectedIndex()==0)) {
			// Xử lý ký tự hoặc số hoặc xóa được nhập vào và sự kiện nằm ở tab thứ nhất
			xuLyTimKiemTTKH(kh_BUS.getAllKhachHang());
		}
	}
	// Phần xử lý trong sự kiện tìm kiếm của bảng thông tin khách hàng
	public void xuLyTimKiemTTKH(ArrayList ds) {
		xuLyDuLieuGioiTinh(ds);
		xuLyDuLieuKH(ds);
		xuLyDuLieuDiaChi(ds);
		model_KHthongTin.setRowCount(0);
		doDuLieuVaoBang(ds);
	}
	// Phần đưa dữ liệu từ 1 arraylist<khachhang> vào bảng thông tin khách hàng
	public void doDuLieuVaoBang(ArrayList<KhachHang> ds) {
		String phai="";
		for (KhachHang khachHang : ds) {
			if(khachHang.isGioiTinh())
				phai = "Nam";
			else
				phai = "Nữ";
			model_KHthongTin.addRow(new Object[] {
					khachHang.getMa(),
					khachHang.getTen(),
					phai,
					khachHang.getSDT(),
					khachHang.getEmail(),
					khachHang.getDiaChi(),
					khachHang.getDiemTichLuy()
					,			});;
		}
	}
	// Phần tìm kiếm theo mã, tên, số điện thoại của khách hàng
	public void xuLyDuLieuKH(ArrayList<KhachHang> ds) {
		String timkiem = txt_TimKiemTTKH.getText();
		if(!timkiem.equals("")) {
			ArrayList<KhachHang> tam = new ArrayList<>();
			Pattern p = Pattern.compile(timkiem, Pattern.CASE_INSENSITIVE);
			for (KhachHang khachHang : ds) {
				Matcher m = p.matcher(khachHang.getTen());
				Matcher m1= p.matcher(khachHang.getMa());
				Matcher m2= p.matcher(khachHang.getSDT());
				if(m.find()||m1.find()||m2.find()) {
					tam.add(khachHang);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
	// Phần tìm kiếm theo địa chỉ
	public void xuLyDuLieuDiaChi(ArrayList<KhachHang> ds) {
		String diaChi = txt_DiaChiTTKH.getText();
		if(!diaChi.equals("")) {
			ArrayList<KhachHang> tam = new ArrayList<>();
			Pattern p = Pattern.compile(diaChi);
			for (KhachHang khachHang : ds) {
				Matcher m = p.matcher(khachHang.getDiaChi());
				if(m.find()) {
					tam.add(khachHang);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
	// Phần tìm kiếm theo giới tính
	public void xuLyDuLieuGioiTinh(ArrayList<KhachHang> ds) {
		String gioiTinh = (String)combobox_TTKHGioiTinh.getSelectedItem();
		String phai;
		if(!gioiTinh.equals("Tất cả")) {
			ArrayList<KhachHang> tam = new ArrayList<>();
			Pattern p = Pattern.compile(gioiTinh);
			for (KhachHang khachHang : ds) {
				if(khachHang.isGioiTinh())
					phai = "Nam";
				else
					phai = "Nữ";
				Matcher m = p.matcher(phai);
				if(m.find()) {
					tam.add(khachHang);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}


	// phần xử lý sự kiện cho nút thêm sản phẩm trong phần mua hàng
	public void xuLySuKienChoNutThemSanPham() {
		String key = cbbMHDanhMuc.getSelectedItem().toString();
		switch (key) {
		case "CASE": {
			nhapSoSanPham(tableMHCase, modelMHCase);
			break;
		}
		case "CPU": {
			nhapSoSanPham(tableMHCpu, modelMHCpu);
			break;
		}
		case "RAM": {
			nhapSoSanPham(tableMHRam, modelMHRam);
			break;
		}
		case "PSU": {
			nhapSoSanPham(tableMHPsu, modelMHPsu);
			break;
		}
		case "VGA": {
			nhapSoSanPham(tableMHVga, modelMHVga);
			break;
		}
		case "MAIN": {
			nhapSoSanPham(tableMHMain, modelMHMain);
			break;
		}
		}
		xuLyKhiDuLieuGioHangThayDoi();
	}

	public void nhapSoSanPham(JTable table, DefaultTableModel model) {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần thêm");
		}else {
			SanPham mua = new SanPham_BUS().timSanPhamTheoMa(model.getValueAt(row, 0).toString());
			int soLuongMua = xuLySoLuongMua(mua, "Nhập vào số lượng sản phẩm cần mua: ");
			if(soLuongMua > 0) {
				if(hoaDonMuaHang.timVTChiTietHoaDon(mua) != -1) {
					ChiTietHoaDon old = hoaDonMuaHang.timChiTietHoaDon(mua.getMaSanPham());
					if(mua.getSoLuongTonKho() < soLuongMua + old.getSoLuongMua()) {
						JOptionPane.showMessageDialog(this, "Số lượng sản phẩm tồn kho không đủ");
					}else {
						hoaDonMuaHang.getDsChiTietHoaDon().get(hoaDonMuaHang.timVTChiTietHoaDon(mua)).setSoLuongMua(soLuongMua + old.getSoLuongMua());
					}
				}else {
					hoaDonMuaHang.themChiTietHoaDon(new ChiTietHoaDon(soLuongMua, mua));
				}
				doDuLieuVaoBangChiTietHoaDon(hoaDonMuaHang.getDsChiTietHoaDon());
			}
		}
	}

	public int xuLySoLuongMua(SanPham s, String mess) {
		int i = -1;
		try {
			String soluongmua = JOptionPane.showInputDialog(mess);
			if(soluongmua != null) {
				i = Integer.parseInt(soluongmua);
				if(i < 0) {
					JOptionPane.showMessageDialog(this, "Số lượng mua phải là số nguyên dương");
				}
				if(i > s.getSoLuongTonKho()) {
					JOptionPane.showMessageDialog(this, "Số lượng sản phẩm tồn kho không đủ");
					i = -1;
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Số lượng mua phải là số nguyên dương");
		}
		return i;
	}

	public void doDuLieuVaoBangChiTietHoaDon(ArrayList<ChiTietHoaDon> ds) {
		modelMHGioHang.setRowCount(0);
		for (ChiTietHoaDon chitiet : ds) {
			modelMHGioHang.addRow(new Object[] {
					chitiet.getSanPham().getMaSanPham(),
					chitiet.getSanPham().getTenSanPham(),
					chitiet.getSoLuongMua(),
					dinhDangTien(chitiet.tinhTongTien())
			});
		}
	}

	public void xuLyKhiDuLieuGioHangThayDoi() {
		lblMHHDTongtiens.setText(dinhDangTien(hoaDonMuaHang.tinhTongTien()));
		lblMHHDThues.setText(dinhDangTien(hoaDonMuaHang.tinhThue()));
		hoaDonMuaHang.giamGia();
		lblMHHDGiams.setText(dinhDangTien(hoaDonMuaHang.getGiamgia()));
		lblMHHDThanhtoans.setText(dinhDangTien(hoaDonMuaHang.tinhTienCanThanhToan()));
		lblMHHDTienthuas.setText(dinhDangTien(hoaDonMuaHang.tinhTienThua()));
	}

	public void xuLyXoaSanPhamTrongGioHang() {
		int row = tableMHGioHang.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trong giỏ hàng cần xóa");
		}else {
			if(!hoaDonMuaHang.xoaChiTietHoaDon(new SanPham(modelMHGioHang.getValueAt(row, 0) + ""))) {
				JOptionPane.showMessageDialog(this, "Xóa không thành công vì sản phẩm không tồn tại trong giỏ hàng");
			}else {
				doDuLieuVaoBangChiTietHoaDon(hoaDonMuaHang.getDsChiTietHoaDon());
				xuLyKhiDuLieuGioHangThayDoi();
			}
		}
	}

	public void xuLyXoaTatCaSanPhamTrongGioHang() {
		hoaDonMuaHang.getDsChiTietHoaDon().clear();
		doDuLieuVaoBangChiTietHoaDon(hoaDonMuaHang.getDsChiTietHoaDon());
		xuLyKhiDuLieuGioHangThayDoi();
	}

	public void xuLyCapNhatSanPhamTrongGiaHang() {
		int row = tableMHGioHang.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn chi chi tiết hóa đơn cần cập nhật");
		}else {
			SanPham mua = new SanPham_BUS().timSanPhamTheoMa(modelMHGioHang.getValueAt(row, 0).toString());
			int soLuongMua = xuLySoLuongMua(mua, "Nhập vào số lượng sản phẩm cần sửa");
			if(soLuongMua > 0) {
				if(hoaDonMuaHang.timVTChiTietHoaDon(mua) != -1) {
					if(mua.getSoLuongTonKho() < soLuongMua) {
						JOptionPane.showMessageDialog(this, "Số lượng sản phẩm tồn kho không đủ");
					}else {
						hoaDonMuaHang.getDsChiTietHoaDon().get(hoaDonMuaHang.timVTChiTietHoaDon(mua)).setSoLuongMua(soLuongMua);
					}
				}else {
					hoaDonMuaHang.themChiTietHoaDon(new ChiTietHoaDon(soLuongMua, mua));
				}
				doDuLieuVaoBangChiTietHoaDon(hoaDonMuaHang.getDsChiTietHoaDon());
				xuLyKhiDuLieuGioHangThayDoi();
			}
		}
	}

	public void khoiTaoHoaDon(HoaDon hoaDon) {
		hoaDon.setNhanVien(nhanVien);
		hoaDon.setKhachHang(khachHangMH); 
		hoaDon.setNgayLapHoaDon(LocalDate.now());
		hoaDon.setTienKhachTra(0);
		hoaDon.setHinhThucThanhToan(cbbMHHDHinhthuctt.getSelectedItem()+"");
	}

	public void xuLySuKienLocPhanMuaHang() {
		ArrayList<Case> dsCase = new SanPham_BUS().getAllCase();
		ArrayList<Cpu> dsCpu = new SanPham_BUS().getAllCpu();
		ArrayList<Psu> dsPsu = new SanPham_BUS().getAllPsu();
		ArrayList<Main> dsMain = new SanPham_BUS().getAllMain();
		ArrayList<Ram> dsRam = new SanPham_BUS().getAllRam();
		ArrayList<Vga> dsVga = new SanPham_BUS().getAllVga();

		xuLyKhiNguoiDungChonLocNhaSX(dsCase, dsCpu, dsPsu, dsMain, dsRam, dsVga);
		xuLyKhiNguoiDungNhapTrenTxtTimSP(dsCase, dsCpu, dsPsu, dsMain, dsRam, dsVga);
	}

	public void xuLyKhiNguoiDungChonLocNhaSX(ArrayList<Case> dsCase, ArrayList<Cpu> dsCpu, ArrayList<Psu> dsPsu, ArrayList<Main> dsMain, ArrayList<Ram> dsRam, ArrayList<Vga> dsVga) {
		String nhasx = cbbMHNhaSX.getSelectedItem().toString();
		if(nhasx.equals("Tất cả")) {
			dsCase = new SanPham_BUS().getAllCase();
			dsCpu = new SanPham_BUS().getAllCpu();
			dsPsu = new SanPham_BUS().getAllPsu();
			dsMain = new SanPham_BUS().getAllMain();
			dsRam = new SanPham_BUS().getAllRam();
			dsVga = new SanPham_BUS().getAllVga();
		}else {
			new SanPham_BUS().dsSanPhamCaseSauKhiLocNhaSX(dsCase, nhasx);
			new SanPham_BUS().dsSanPhamCpuSauKhiLocNhaSX(dsCpu, nhasx);
			new SanPham_BUS().dsSanPhamPsuSauKhiLocNhaSX(dsPsu, nhasx);
			new SanPham_BUS().dsSanPhamMainSauKhiLocNhaSX(dsMain, nhasx);
			new SanPham_BUS().dsSanPhamRamSauKhiLocNhaSX(dsRam, nhasx);
			new SanPham_BUS().dsSanPhamVgaSauKhiLocNhaSX(dsVga, nhasx);
		}
	}

	public void xuLyKhiNguoiDungNhapTrenTxtTimSP(ArrayList<Case> dsCase, ArrayList<Cpu> dsCpu, ArrayList<Psu> dsPsu, ArrayList<Main> dsMain, ArrayList<Ram> dsRam, ArrayList<Vga> dsVga) {
		String duLieu = txtMHTimSP.getText();
		modelMHCase.setRowCount(0);
		modelMHCpu.setRowCount(0);
		modelMHPsu.setRowCount(0);
		modelMHRam.setRowCount(0);
		modelMHMain.setRowCount(0);
		modelMHVga.setRowCount(0);
		if(duLieu.equals("")) {
			doDuLieuVaoBangCase(dsCase);
			doDuLieuVaoBangCpu(dsCpu);
			doDuLieuVaoBangPsu(dsPsu);
			doDuLieuVaoBangRam(dsRam);
			doDuLieuVaoBangMain(dsMain);
			doDuLieuVaoBangVga(dsVga);
		}else {
			doDuLieuVaoBangCase(new SanPham_BUS().dsSanPhamCaseSauKhiLoc(dsCase, duLieu));
			doDuLieuVaoBangCpu(new SanPham_BUS().dsSanPhamCpuSauKhiLoc(dsCpu, duLieu));
			doDuLieuVaoBangPsu(new SanPham_BUS().dsSanPhamPsuSauKhiLoc(dsPsu, duLieu));
			doDuLieuVaoBangRam(new SanPham_BUS().dsSanPhamRamSauKhiLoc(dsRam, duLieu));
			doDuLieuVaoBangMain(new SanPham_BUS().dsSanPhamMainSauKhiLoc(dsMain, duLieu));
			doDuLieuVaoBangVga(new SanPham_BUS().dsSanPhamVgaSauKhiLoc(dsVga, duLieu));
		}
	}

	public void xuLyKhiNhanVienNhapTienKhachTra() {
		String duLieu = txtMHHDTienKhachDua.getText();
		if(!duLieu.equals("") ) {
			try {
				double tienKhachDua = Double.parseDouble(duLieu);
				hoaDonMuaHang.setTienKhachTra(tienKhachDua);
				double tienTraKhach = hoaDonMuaHang.tinhTienThua();
				lblMHHDTienthuas.setText(dinhDangTien(tienTraKhach));
				if(tienTraKhach < 0) {
					lblMHHDTienthuas.setForeground(mauChuDao);
				}else {
					lblMHHDTienthuas.setForeground(Color.BLUE);
				}

			} catch (NumberFormatException e) {
				lblMHHDTienthuas.setText("Không hợp lệ");
			}
		}
	}

	public void xuLyKhiDoiPhuongThucThanhToan() {
		hoaDonMuaHang.setHinhThucThanhToan(cbbMHHDHinhthuctt.getSelectedItem()+"");
	}

	public void xuLyLamMoiHoaDon() {
		this.xuLyXoaTatCaSanPhamTrongGioHang();
		hoaDonMuaHang.setTienKhachTra(0);
		txtMHHDTienKhachDua.setText("");
		cbbMHHDHinhthuctt.setSelectedIndex(0);
		hoaDonMuaHang.setHinhThucThanhToan(cbbMHHDHinhthuctt.getSelectedIndex()+"");
		hoaDonMuaHang.setGhiChu("");
		txtMHHDGhichu.setText(hoaDonMuaHang.getGhiChu());
		khachHangMH = kh_BUS.getAllKhachHang().get(0);
		hoaDonMuaHang.setKhachHang(khachHangMH);
		lblMHHDTienthuas.setText("");
		lblMHHDMaKH.setText(hoaDonMuaHang.getKhachHang().getMa());
		lblMHHDTenKH.setText(hoaDonMuaHang.getKhachHang().getTen());
	}

	public void xuLyThanhToanHoaDon() {
		if(hoaDonMuaHang.getDsChiTietHoaDon().size() == 0) {
			JOptionPane.showMessageDialog(this, "Giỏ hàng đang trống");
		}else if(hoaDonMuaHang.tinhTienThua() < 0) {
			JOptionPane.showMessageDialog(this, "Số tiền khách đưa không đủ để thanh toán. Vui lòng kiểm tra lại!");
		}else {
			if(txtMHHDGhichu.getText().equals("")) {
				hoaDonMuaHang.setGhiChu("Trống");
			}else {
				hoaDonMuaHang.setGhiChu(txtMHHDGhichu.getText());
			}
			if(new HoaDon_BUS().themHoaDon(hoaDonMuaHang)) {
				new SanPham_BUS().capNhatSoLuongSanPham(hoaDonMuaHang);
				capNhatDuLieuChoTatCaCacBangSanPham();
				if(!hoaDonMuaHang.getKhachHang().getMa().equals("KH0")) {
					hoaDonMuaHang.capNhatDiemTichLuyChoKhachHang();
					new KhachHang_BUS().capNhatDiemTichLuyKhachHang(hoaDonMuaHang);
				}
				JOptionPane.showMessageDialog(this, "Thanh toán thành công và lưu hóa đơn");
				modelHoaDon.setRowCount(0);
				doDuLieuVaoBangHoaDon(new HoaDon_BUS().getAllHoaDon());
				xuLyLamMoiHoaDon();
				hoaDonMuaHang = new HoaDon(hoadon_bus.ranDomMaHoaDon());
				lblMHHDMahds.setText(hoaDonMuaHang.getMaHoaDon());
				khoiTaoHoaDon(hoaDonMuaHang);
				cbbMHNhaSX.setSelectedIndex(0);
			}
		}
	}
	}
