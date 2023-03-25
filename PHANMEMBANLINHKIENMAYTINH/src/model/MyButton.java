package model;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import view.ViewDangNhap;

public class MyButton extends JButton implements MouseListener{
	public MyButton(String title) {
		super(title);
		this.setBackground(new ViewDangNhap().mauChuDao);
		this.setFocusPainted(false);
		this.setBorder(null);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		this.setBackground(new Color(255,165,0));
		this.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new ViewDangNhap().mauNenLoGin));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(new ViewDangNhap().mauChuDao);
		this.setBorder(null);
	}
}
