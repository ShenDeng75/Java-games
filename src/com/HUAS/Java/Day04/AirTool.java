package com.HUAS.Java.Day04;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.HUAS.Java.Day04.AirTool;

/** 
 * 素材类
 * */
public class AirTool {
	//获取屏幕宽，高
	public static int pw=Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int ph=Toolkit.getDefaultToolkit().getScreenSize().height;
	public static BufferedImage ep01,bg,air01,bee,bull,hero,kt,air02,gameover,start,pause;
	static {
		//加载图片。
		try { 
			bg=ImageIO.read(AirTool.class.getResource("background.png"));
			air01=ImageIO.read(AirTool.class.getResource("ep01.png"));
			bee=ImageIO.read(AirTool.class.getResource("bee.png"));
			bull=ImageIO.read(AirTool.class.getResource("bullet.png"));
			hero=ImageIO.read(AirTool.class.getResource("hero0.png"));
			air02=ImageIO.read(AirTool.class.getResource("shoot.png"));
			gameover=ImageIO.read(AirTool.class.getResource("gameover.png"));
			start=ImageIO.read(AirTool.class.getResource("start.png"));
			pause=ImageIO.read(AirTool.class.getResource("pause.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
