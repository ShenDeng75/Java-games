package com.HUSA.Java.Day06;

import javax.swing.JFrame;
/**
 * ������
 */
public class DunJFrame extends JFrame{

	public DunJFrame() {
		setTitle("��ʿ����");
		setBounds(0, 0, DunTool.pw, DunTool.ph);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DunJPanel djp=new DunJPanel();
		this.add(djp);
		this.addKeyListener(djp);
		//setVisibleһ��Ҫ�ź���
		setVisible(true);
	}
	public static void main(String[] args) {
		new DunJFrame();
	}

}
