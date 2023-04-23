package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;

import view.ViewTrangChu;

public class XuLySuKienChoTrangMuaHang implements ActionListener, KeyListener{
	private ViewTrangChu view;
	
	public XuLySuKienChoTrangMuaHang(ViewTrangChu view) {
		super();
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("comboBoxChanged")) {
			String loaiCbb = ((JComboBox)e.getSource()).getName();
			if(loaiCbb.equals("Danh mục")) {
				view.xuLyDanhMucMuaHang();
			}else {
				view.xuLyKhiDoiPhuongThucThanhToan();
			}
		}else if(src.equals("Thêm sản phẩm")) {
			view.xuLySuKienChoNutThemSanPham();
		}else if(src.equals("Xóa sản phẩm")) {
			view.xuLyXoaSanPhamTrongGioHang();
		}else if(src.equals("Xóa tất cả")) {
			view.xuLyXoaTatCaSanPhamTrongGioHang();
		}else if(src.equals("Cập nhật")) {
			view.xuLyCapNhatSanPhamTrongGiaHang();
		}else if(src.equals("Làm mới")) {
			view.xuLyLamMoiHoaDon();
		}else if(src.equals("Thanh toán")) {
			view.xuLyThanhToanHoaDon();
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// nếu không phải là số hoặc phím xóa thì không nhận cho txt nhập tiền khách đưa
		String thaoTacTrenTextField = e.getComponent().getName();
		if(thaoTacTrenTextField.equals("Tiền khách đưa")) {
			char c = e.getKeyChar();
	        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
	            e.consume();
	        }
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
	}


	@Override
	public void keyReleased(KeyEvent e) {
		//xử lý khi nhập vào không phải là ký tự không định nghĩa như shilft hay alt...
		if(e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
			// phân biệt nhập trên txt nào
			String thaoTacTrenTextField = e.getComponent().getName();
			if(thaoTacTrenTextField.equals("Tìm sản phẩm")) {
				view.xuLyKhiNguoiDungNhapTrenTxtTimSP();
			}else {
				view.xuLyKhiNhanVienNhapTienKhachTra();
			}
		}
	}
}
