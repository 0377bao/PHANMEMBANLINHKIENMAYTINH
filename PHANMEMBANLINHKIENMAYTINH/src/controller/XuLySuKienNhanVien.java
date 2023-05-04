package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.naming.ldap.SortResponseControl;

import view.ViewTrangChu;

public class XuLySuKienNhanVien implements ActionListener,KeyListener,MouseListener {
	private ViewTrangChu view;
	
	public XuLySuKienNhanVien(ViewTrangChu view) {
		this.view = view;
		view.addSearchKeyListener(this);
		view.addMouse(this);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
    	String src = e.getActionCommand();
    	if(src.equals("Thêm")) {
    		this.view.themNhanVien();
    	}else if (src.equals("Sửa")) {
			this.view.suaNhanVien();
		}else if (src.equals("Làm mới")) {
			this.view.lamMoi();
		}else if (src.equals("Xóa")) {
			this.view.xoaNhanVien();
		}else if (src.equals("comboBoxLocGioiTinh")) {
			this.view.LocComBoBox();
		}else if (src.equals("comboBoxLocChucVu")) {
			this.view.LocComBoBox();
		}else if (src.equals("Khởi tạo mã")) {
			this.view.khoiTaoMa();
		}
 
    }
	@Override
	public void keyTyped(KeyEvent e) {
        
	}
	@Override
	public void keyPressed(KeyEvent e) {
                		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		String tim = view.getTimKiem();  
//		if(tim.equals("")) {
//			this.view.DocDuLieuDatabaseVaoTable();
//		}else {
//			this.view.timKiem();
//		}
		this.view.timKiem();
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
           this.view.LoadDuLieuLaiCacComponent();
		
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

