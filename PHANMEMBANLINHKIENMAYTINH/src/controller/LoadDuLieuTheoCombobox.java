package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import view.ViewTrangChu;

public class LoadDuLieuTheoCombobox implements ActionListener{
    private ViewTrangChu trangchu;
    public LoadDuLieuTheoCombobox(ViewTrangChu trangchu) {
    	this.trangchu = trangchu;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		trangchu.xuLyDuLieuLocTrenCombobox();
	}
}
