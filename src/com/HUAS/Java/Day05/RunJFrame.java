package com.HUAS.Java.Day05;

import javax.swing.JFrame;
/** 
 * 窗体类
 * */
public class RunJFrame extends JFrame{
	public RunJFrame() {
		//初始化窗体信息
		this.setTitle("二维射击");
		this.setBounds(0,0,Runtool.pw,Runtool.ph);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加画布
		RunJPanel cok=new RunJPanel();
		this.add(cok);
	}
	public static void main(String[] args) {
		//实例化窗体
		new RunJFrame();
	}

}
