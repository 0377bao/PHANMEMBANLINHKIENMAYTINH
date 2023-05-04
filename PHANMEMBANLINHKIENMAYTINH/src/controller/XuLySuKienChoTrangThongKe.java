package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewTrangChu;

public class XuLySuKienChoTrangThongKe implements ActionListener{
	private ViewTrangChu view;

	public XuLySuKienChoTrangThongKe(ViewTrangChu view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.locDuLieuThongKe();
	}
	
}
