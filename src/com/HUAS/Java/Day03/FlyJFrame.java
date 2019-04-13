package com.HUAS.Java.Day03;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class FlyJFrame extends JFrame{
	 int pw=Toolkit.getDefaultToolkit().getScreenSize().width;
	 int ph=Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public FlyJFrame() {
		this.setTitle("·É»ú´óÕ½");
		this.setBounds(pw/2-200,0,400,700);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlyJPanel coj=new FlyJPanel();
		this.add(coj);
	}
}