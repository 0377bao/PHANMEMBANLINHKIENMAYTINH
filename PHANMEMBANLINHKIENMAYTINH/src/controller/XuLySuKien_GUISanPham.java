package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import BUS.SanPham_BUS;
import model.Cpu;
import view.ViewTrangChu;

public class XuLySuKien_GUISanPham implements ActionListener, KeyListener{
    private ViewTrangChu trangChu;
    public XuLySuKien_GUISanPham(ViewTrangChu trangChu) {
    	this.trangChu = trangChu;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		trangChu.xuLySK_GuiSanPham(o);
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
		// TODO Auto-generated method stub
		if(e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
			trangChu.xuLySuKienTXTtimKiem();
		}
	}
	
	

}
