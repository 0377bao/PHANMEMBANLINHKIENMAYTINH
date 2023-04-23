package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.ViewKhachHang;

public class XuLySuKienChonKhachHang implements KeyListener{
	private ViewKhachHang view = null;
	
	public XuLySuKienChonKhachHang(ViewKhachHang view) {
		this.view = view;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {//xử lý khi nhập vào không phải là ký tự không định nghĩa như shilft hay alt...
		if(e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
			view.xuLySuKienNhapTXT();
		}
		
	}
	
}
