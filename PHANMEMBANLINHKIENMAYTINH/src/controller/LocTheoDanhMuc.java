package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.ViewTrangChu;

public class LocTheoDanhMuc implements ActionListener, MouseListener{
	private ViewTrangChu trangchu;
	public LocTheoDanhMuc(ViewTrangChu view) {
		trangchu = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		trangchu.xuLyDanhMuc(trangchu.cbbSPDanhMuc.getSelectedItem().toString());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		trangchu.xuLyDanhMuc(trangchu.modelSP.getValueAt(trangchu.tableSP.getSelectedRow(), 1).toString());
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
