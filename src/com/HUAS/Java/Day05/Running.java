package com.HUAS.Java.Day05;

import java.awt.image.BufferedImage;
/** 
 * 飞行物类
 * */
public class Running {
	//飞行物坐标
	public int[] x={};
	public int[] y={};
	//飞行物弹道
	public double[] fx={};
	public double[] fy={};
	//飞行物状态
	public boolean[] fstart={};
	//飞行物图片
	public BufferedImage image;
	//飞行物速度
	public int speed;
}
