package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewTrangChu;

public class XuLyDieuHuongPhanMem implements ActionListener{
	private ViewTrangChu view;
	
	public XuLyDieuHuongPhanMem(ViewTrangChu view) {
		super();
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		view.xuLyDieuHuong(src);
	}
}
