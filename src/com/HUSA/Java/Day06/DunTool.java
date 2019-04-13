package com.HUSA.Java.Day06;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *工具类
 */
public class DunTool {
	//获取屏幕像素
	public static int pw=Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int ph=Toolkit.getDefaultToolkit().getScreenSize().height;
	//计时器
	public static int time=0;
	//键盘焦点
	public static boolean W,S,A,D;
	//图片
	public static BufferedImage HeroR,HeroL,bg;
	public static BufferedImage HeroMoveR[]=new BufferedImage[8];
	public static BufferedImage HeroMoveL[]=new BufferedImage[8];
	static {
		try {
			HeroR=ImageIO.read(DunTool.class.getResource("HeroR.png"));
			HeroL=ImageIO.read(DunTool.class.getResource("HeroL.png"));
			bg=ImageIO.read(DunTool.class.getResource("背景1.jpg"));
			//向右走
			HeroMoveR[0]=ImageIO.read(DunTool.class.getResource("Image 右走1.png"));
			HeroMoveR[1]=ImageIO.read(DunTool.class.getResource("Image 右走2.png"));
			HeroMoveR[2]=ImageIO.read(DunTool.class.getResource("Image 右走3.png"));
			HeroMoveR[3]=ImageIO.read(DunTool.class.getResource("Image 右走4.png"));
			HeroMoveR[4]=ImageIO.read(DunTool.class.getResource("Image 右走5.png"));
			HeroMoveR[5]=ImageIO.read(DunTool.class.getResource("Image 右走6.png"));
			HeroMoveR[6]=ImageIO.read(DunTool.class.getResource("Image 右走7.png"));
			HeroMoveR[7]=ImageIO.read(DunTool.class.getResource("Image 右走8.png"));
			//向左走
			HeroMoveL[0]=ImageIO.read(DunTool.class.getResource("Image 左走1.png"));
			HeroMoveL[1]=ImageIO.read(DunTool.class.getResource("Image 左走2.png"));
			HeroMoveL[2]=ImageIO.read(DunTool.class.getResource("Image 左走3.png"));
			HeroMoveL[3]=ImageIO.read(DunTool.class.getResource("Image 左走4.png"));
			HeroMoveL[4]=ImageIO.read(DunTool.class.getResource("Image 左走5.png"));
			HeroMoveL[5]=ImageIO.read(DunTool.class.getResource("Image 左走6.png"));
			HeroMoveL[6]=ImageIO.read(DunTool.class.getResource("Image 左走7.png"));
			HeroMoveL[7]=ImageIO.read(DunTool.class.getResource("Image 左走8.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
