package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import BUS.SanPham_BUS;
import model.Cpu;
import view.ViewTrangChu;

public class XuLySuKien_GUISanPham implements ActionListener{
    private ViewTrangChu trangChu;
    public XuLySuKien_GUISanPham(ViewTrangChu trangChu) {
    	this.trangChu = trangChu;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getActionCommand();
		
	}
	
	

}
