package BUS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewKhachHang;

public class XuLySuKienGuiKhachHang implements ActionListener{
	private ViewKhachHang view;

	public XuLySuKienGuiKhachHang(ViewKhachHang view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.xuLySuKienBtnChon();
	}
	
	
}
