package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import view.ViewTrangChu;

public class LocTheoDanhMucCuaPhanMuaHang implements ActionListener{
	private ViewTrangChu view;
	
	public LocTheoDanhMucCuaPhanMuaHang(ViewTrangChu view) {
		super();
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		view.xuLyDanhMucMuaHang();
	}
}
