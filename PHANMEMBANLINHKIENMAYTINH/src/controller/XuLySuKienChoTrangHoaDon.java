package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.ViewTrangChu;

public class XuLySuKienChoTrangHoaDon implements ActionListener, MouseListener{
	private ViewTrangChu view = null;

	public XuLySuKienChoTrangHoaDon(ViewTrangChu view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("comboBoxChanged")) {
			this.view.locDuLieuVaoBangHoaDon();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.view.xuLySuKienKhiNhanVaoBangHoaDon();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
