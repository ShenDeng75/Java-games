package com.HUSA.Java.Day06;

import javax.swing.JFrame;
/**
 * 画板类
 */
public class DunJFrame extends JFrame{

	public DunJFrame() {
		setTitle("勇士出击");
		setBounds(0, 0, DunTool.pw, DunTool.ph);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DunJPanel djp=new DunJPanel();
		this.add(djp);
		this.addKeyListener(djp);
		//setVisible一定要放后面
		setVisible(true);
	}
	public static void main(String[] args) {
		new DunJFrame();
	}

}
