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
import java.awt.ScrollPane;
import java.awt.Shape;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

public class ViewTrangChu extends JFrame{
	//PHẦN KHAI BÁO BIẾN LOCAL
	public Color mauChuDao = new ViewDangNhap().mauChuDao;
	// COMPONENT PHẦN CONTROL
	private ImageIcon iconHinhNen;
	private JLabel lblControlTen, lblHinhNenAvt;
	private MyButton btnControlMuaHang, btnControlSanPham, btnControlHoaDon, btnControlKhuyenMai, btnControlNhanVien, btnControlKhachHang,
	btnControlThongKe, btnControlThoat;
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
	private JLabel lblMHHDMaKH, lblMHHDTenKH, lblMHHDMahds,lblMHHDTongtiens,lblMHHDGiams, lblMHHDThues, lblMHHDThanhtoans, lblMHHDTienthuas;
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
	//Phần component của cpu (Sản phẩm)
	private JTextField txtSPSoLoi, txtSPSoLuongXuLy, txtSPTanSoCoSo, txtSPTanSoTurbo, txtSPBoNhoDem, txtSPBoNhoToiDa;
	//Phần component của case(Sản phẩm)
	private JTextField txtSPMau, txtSPTuongThich;
	private MyCombobox cbbSPChatLieu;
	//Phần component của main(Sản phẩm)
	private JTextField txtSPMauChipset, txtSPRamHoTro, txtSPCpuHoTro, txtSPDoHoa, txtSPOCungHoTro;
	//Phần component của ram(Sản phẩm)
	private JTextField txtSPDungLuong, txtSPTocDo;
	//Phần component của psu(Sản phẩm)
	private JTextField txtSPCongSuat, txtSPHieuSuat, txtSPTuoiTho;
	//Phần component của vga(Sản phẩm)
	private JTextField txtSPTienTrinh, txtSPTDP, txtSPCudaCores;
	// phần jpanel cho từng loại sản phẩm
	private JPanel pnlSPCPU, pnlSPVGA, pnlSPMAIN, pnlSPRam, pnlSPPSU, pnlSPCase;
	// phàn lọc sản phẩm
	private JPanel pnlLocSP;
	private MyCombobox cbbSPLocDanhMuc, cbbSPLocNhaSX, cbbSPLocGia;
	private JTextField txtSPLocTimKiem;
	// phần table sản phẩm
	private DefaultTableModel modelSP;
	private MyTable tableSP;
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
		boBorderChoButtonThanhNavbar();
		pnlWest.add(pnlWestbtn);
		this.add(pnlWest, BorderLayout.WEST);
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
	//PHẦN VIẾT GUI CHO MUA HÀNG
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
		
		//phần Panel Sản Phẩm
		pnlMuaHangSP.setLayout(null);
		pnlMuaHangSP.setBackground(Color.white);
		JPanel pnlMHGioHang = new JPanel();
		JPanel pnlMHSanPham = new JPanel();
		//giỏ hàng
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
		y+= 55;
		btnMHXoaAll = new MyButton("Xóa tất cả");
		btnMHXoaAll.setBounds(580, y, 120, 35);
		y+= 55;
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
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
		modelMHCase.addRow(new Object[] {
				"123","Case","1.000.000","100.000","Acer","Nhựa","Trắng",8,9
		});
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
		txtMHHDGhichu = new JTextArea(4,20);
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
	//PHẦN VIẾT GUI CHO SẢN PHẨM
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
		// add sự kiện cho lọc danh mục sản phâm
		cbbSPDanhMuc.addActionListener(new LocTheoDanhMuc(this));
		
		y+= 40;
		JLabel lblSPMa = new JLabel("Mã sản phẩm:");
		lblSPMa.setBounds(x, y, widthlbl, height);
		txtSPMa = new JTextField();
		txtSPMa.setBounds(x + widthlbl + 10, y, widthtext, height);
		
		y+= 40;
		JLabel lblSPTen = new JLabel("Tên sản phẩm:");
		lblSPTen.setBounds(x, y, widthlbl, height);
		txtSPTen = new JTextField();
		txtSPTen.setBounds(x + widthlbl + 10, y, widthtext, height);
		
		y+= 40;
		JLabel lblSPGiaBan = new JLabel("Giá Bán:");
		lblSPGiaBan.setBounds(x, y, widthlbl, height);
		txtSPGiaBan = new JTextField();
		txtSPGiaBan.setBounds(x + widthlbl + 10, y, widthtext, height);
		
		y+= 40;
		JLabel lblSPSoLuongTon = new JLabel("Số lượng tồn:");
		lblSPSoLuongTon.setBounds(x, y, widthlbl, height);
		txtSPSoLuongTon = new JTextField();
		txtSPSoLuongTon.setBounds(x + widthlbl + 10, y, widthtext, height);
		
		y+= 40;
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
		y+= 40;
		JLabel lblSPSoGiaNhap = new JLabel("Giá nhập:");
		lblSPSoGiaNhap.setBounds(x, y, widthlbl, height);
		txtSPGiaNhap = new JTextField();
		txtSPGiaNhap.setBounds(x + widthlbl + 10, y, widthtext, height);
		y+= 40;
		JLabel lblSPSoGiamGia = new JLabel("Giảm giá:");
		lblSPSoGiamGia.setBounds(x, y, widthlbl, height);
		txtSPGiamGia = new JTextField();
		txtSPGiamGia.setBounds(x + widthlbl + 10, y, widthtext, height);
		
		y+= 40;
		JLabel lblSPNgaySx = new JLabel("Ngày sản xuất:");
		lblSPNgaySx.setBounds(x, y, widthlbl, height);
		
		cbbSPNgay = new MyCombobox();
		cbbSPNgay.setBounds(x, y + 30, 70, height);
		cbbSPThang = new MyCombobox();
		cbbSPThang.setBounds(x + 70 + 20, y + 30, 70, height);
		cbbSPNam = new MyCombobox();
		cbbSPNam.setBounds(x + 70*2 + 20*2, y + 30, 70, height);
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
		y+= 40;
		JLabel lblSPSoLuongXuLy = new JLabel("Số luồng:");
		lblSPSoLuongXuLy.setBounds(x1, y, widthlbl, height);
		txtSPSoLuongXuLy = new JTextField();
		txtSPSoLuongXuLy.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y+= 40;
		JLabel lblSPTanSoCoSo = new JLabel("Tần số cơ sở:");
		lblSPTanSoCoSo.setBounds(x1, y, widthlbl, height);
		txtSPTanSoCoSo = new JTextField();
		txtSPTanSoCoSo.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y+= 40;
		JLabel lblSPTanSoTurbo = new JLabel("Tần số turbo:");
		lblSPTanSoTurbo.setBounds(x1, y, widthlbl, height);
		txtSPTanSoTurbo = new JTextField();
		txtSPTanSoTurbo.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y+= 40;
		JLabel lblSPBoNhoDem = new JLabel("Bộ nhớ đệm:");
		lblSPBoNhoDem.setBounds(x1, y, widthlbl, height);
		txtSPBoNhoDem = new JTextField();
		txtSPBoNhoDem.setBounds(x1 + widthlbl + 10, y, widthtext, height);
		y+= 40;
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
	    
	    y+=40;
	    JLabel lblSPTDP = new JLabel("TDP: ");
	    lblSPTDP.setBounds(x1, y, widthlbl, height);
	    txtSPTDP =  new JTextField();
	    txtSPTDP.setBounds(x1 + widthlbl + 10, y, widthtext, height);
	    
	    y+=40;
	    JLabel lblSPCudaCores = new JLabel("CudaCores: ");
	    lblSPCudaCores.setBounds(x1, y, widthlbl, height);
	    txtSPCudaCores =  new JTextField();
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
	    
	    y+= 40;
	    JLabel lblSPRamHoTro = new JLabel("Ram Hỗ Trợ: ");
	    lblSPRamHoTro.setBounds(x1, y, widthlbl, height);
	    txtSPRamHoTro = new JTextField();
	    txtSPRamHoTro.setBounds(x1 + widthlbl + 10, y, widthtext, height);
	    
	    y+= 40;
	    JLabel lblSPCPUHoTro = new JLabel("Cpu Hỗ Trợ: ");
	    lblSPCPUHoTro.setBounds(x1, y, widthlbl, height);
	    txtSPCpuHoTro = new JTextField();
	    txtSPCpuHoTro.setBounds(x1 + widthlbl + 10, y, widthtext, height);
	    
	    y+= 40;
	    JLabel lblSPDoHoa = new JLabel("Card Đồ Họa: ");
	    lblSPDoHoa.setBounds(x1, y, widthlbl, height);
	    txtSPDoHoa = new JTextField();
	    txtSPDoHoa.setBounds(x1 + widthlbl + 10, y, widthtext, height);
	    
	    y+= 40;
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
        
	    y+=40;
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
	    
	    y+= 40;
	    JLabel lblSPHieuSuat = new JLabel("Hiệu Suất: ");
	    lblSPHieuSuat.setBounds(x1, y, widthlbl, height);
	    txtSPHieuSuat = new JTextField();
	    txtSPHieuSuat.setBounds(x1 + widthlbl, y, widthtext, height);
	    
	    y+= 40;
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
	    
	    y+= 40;
	    JLabel lblSPMau = new JLabel("Màu Sắc: ");
	    lblSPMau.setBounds(x1, y, widthlbl, height);
	    txtSPMau = new JTextField();
	    txtSPMau.setBounds(x1 + widthlbl, y, widthtext, height);
	    
	    y+= 40;
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

		// phần table sản phẩm
		String[] cols = {"Mã sản phẩm", "Tên Sản Phẩm", "Giá Bán", "Số Lượng Tồn", "Nhà Sản Xuất", "Ngày Sản Xuất", "Bảo Hành", "Giá Nhập", "Giảm Giá"};
		modelSP = new DefaultTableModel(cols, 0);
		tableSP = new MyTable(modelSP);
		JScrollPane scroll = new JScrollPane(tableSP);
		scroll.setBounds(10, 380, 1065, 325);

		// thêm các đối tượng để fill vào table
		modelSP.addRow(new Object[] {"N001", "CPU", 1000, 5, "Acer", "12-05-2023", 1, 800, 2});
		modelSP.addRow(new Object[] {"N002", "VGA", 2000, 6, "MSI", "12-06-2023", 1, 1800, 1});
		modelSP.addRow(new Object[] {"N003", "PSU", 3000, 7, "HP", "12-07-2023", 1, 2800, 2});
		modelSP.addRow(new Object[] {"N004", "MAIN", 4000, 8, "Dell", "12-08-2023", 1, 3800, 1});
		modelSP.addRow(new Object[] {"N005", "Ram", 5000, 9, "Acer", "12-09-2023", 1, 4800, 2});
		modelSP.addRow(new Object[] {"N006", "Case", 6000, 10, "MSI", "12-10-2023", 1, 5800, 1});
		modelSP.addRow(new Object[] {"N007", "Ram", 7000, 11, "Dell", "12-11-2023", 1, 6800, 2});
		modelSP.addRow(new Object[] {"N008", "CPU", 8000, 12, "MSI", "12-01-2023", 1, 7800, 2});
		modelSP.addRow(new Object[] {"N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1});
		modelSP.addRow(new Object[] {"N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1});
		modelSP.addRow(new Object[] {"N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1});
		modelSP.addRow(new Object[] {"N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1});
		modelSP.addRow(new Object[] {"N009", "MAIN", 9000, 13, "Acer", "12-03-2023", 1, 8800, 1});

		pnlSanPham.add(pnlSPThongTin);
		pnlSanPham.add(pnlLocSP);
		pnlSanPham.add(scroll);
		this.add(pnlSanPham);
	}
	
	public void themItemChoCbbNgayThangNam() {
		for(int i = 1; i <= 31; i++) {
			cbbSPNgay.addItem(i + "");
		}
		for(int i = 1; i <= 12; i++) {
			cbbSPThang.addItem(i + "");
		}
		for(int i = 2000; i <= 2023; i++) {
			cbbSPNam.addItem(i + "");
		}
	}
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
	
	//Hàm xử lỳ danh mục
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
