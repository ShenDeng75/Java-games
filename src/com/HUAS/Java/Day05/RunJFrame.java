package com.HUAS.Java.Day05;

import javax.swing.JFrame;
/** 
 * ������
 * */
public class RunJFrame extends JFrame{
	public RunJFrame() {
		//��ʼ��������Ϣ
		this.setTitle("��ά���");
		this.setBounds(0,0,Runtool.pw,Runtool.ph);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ӻ���
		RunJPanel cok=new RunJPanel();
		this.add(cok);
	}
	public static void main(String[] args) {
		//ʵ��������
		new RunJFrame();
	}

}
