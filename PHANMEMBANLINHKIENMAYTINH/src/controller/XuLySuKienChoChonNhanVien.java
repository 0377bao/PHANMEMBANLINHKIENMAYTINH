package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.ViewChonNhanVien;

public class XuLySuKienChoChonNhanVien implements KeyListener, ActionListener{
	private ViewChonNhanVien view = null;
	
	public XuLySuKienChoChonNhanVien(ViewChonNhanVien view) {
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
	public void keyReleased(KeyEvent e) {
		//xử lý khi nhập vào không phải là ký tự không định nghĩa như shilft hay alt...
		if(e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
			view.xuLySuKienNhapTXT();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.xuLySuKienBtnChon();
	}
}
