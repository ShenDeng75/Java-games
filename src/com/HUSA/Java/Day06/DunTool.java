package com.HUSA.Java.Day06;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *������
 */
public class DunTool {
	//��ȡ��Ļ����
	public static int pw=Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int ph=Toolkit.getDefaultToolkit().getScreenSize().height;
	//��ʱ��
	public static int time=0;
	//���̽���
	public static boolean W,S,A,D;
	//ͼƬ
	public static BufferedImage HeroR,HeroL,bg;
	public static BufferedImage HeroMoveR[]=new BufferedImage[8];
	public static BufferedImage HeroMoveL[]=new BufferedImage[8];
	static {
		try {
			HeroR=ImageIO.read(DunTool.class.getResource("HeroR.png"));
			HeroL=ImageIO.read(DunTool.class.getResource("HeroL.png"));
			bg=ImageIO.read(DunTool.class.getResource("����1.jpg"));
			//������
			HeroMoveR[0]=ImageIO.read(DunTool.class.getResource("Image ����1.png"));
			HeroMoveR[1]=ImageIO.read(DunTool.class.getResource("Image ����2.png"));
			HeroMoveR[2]=ImageIO.read(DunTool.class.getResource("Image ����3.png"));
			HeroMoveR[3]=ImageIO.read(DunTool.class.getResource("Image ����4.png"));
			HeroMoveR[4]=ImageIO.read(DunTool.class.getResource("Image ����5.png"));
			HeroMoveR[5]=ImageIO.read(DunTool.class.getResource("Image ����6.png"));
			HeroMoveR[6]=ImageIO.read(DunTool.class.getResource("Image ����7.png"));
			HeroMoveR[7]=ImageIO.read(DunTool.class.getResource("Image ����8.png"));
			//������
			HeroMoveL[0]=ImageIO.read(DunTool.class.getResource("Image ����1.png"));
			HeroMoveL[1]=ImageIO.read(DunTool.class.getResource("Image ����2.png"));
			HeroMoveL[2]=ImageIO.read(DunTool.class.getResource("Image ����3.png"));
			HeroMoveL[3]=ImageIO.read(DunTool.class.getResource("Image ����4.png"));
			HeroMoveL[4]=ImageIO.read(DunTool.class.getResource("Image ����5.png"));
			HeroMoveL[5]=ImageIO.read(DunTool.class.getResource("Image ����6.png"));
			HeroMoveL[6]=ImageIO.read(DunTool.class.getResource("Image ����7.png"));
			HeroMoveL[7]=ImageIO.read(DunTool.class.getResource("Image ����8.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
