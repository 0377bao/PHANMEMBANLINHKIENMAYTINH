package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewTrangChu;

public class LocTheoDanhMuc implements ActionListener{
	private ViewTrangChu trangchu;
	public LocTheoDanhMuc(ViewTrangChu view) {
		trangchu = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		trangchu.xuLyDanhMuc(trangchu.cbbSPDanhMuc.getSelectedItem().toString());
	}
}
