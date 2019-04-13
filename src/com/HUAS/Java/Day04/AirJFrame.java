package com.HUAS.Java.Day04;

import java.awt.Graphics;

import javax.swing.JFrame;
/** 
 * 窗体类
 * */
public class AirJFrame extends JFrame{
	public AirJFrame() {
		this.setTitle("飞机大战");
		this.setBounds((AirTool.pw-400)/2, (AirTool.ph-700)/2, 400, 700);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		AirJPanel ajp=new AirJPanel();
		this.add(ajp); 
	}
}
