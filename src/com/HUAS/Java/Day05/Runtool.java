package com.HUAS.Java.Day05;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/** 
 * π§æﬂ¿‡
 * */
public class Runtool {
	//ªÒ»°∆¡ƒªœÒÀÿ
	public static int pw=1366;
	public static int ph=768;
	//±¨’®◊¥Ã¨øÿ÷∆
	public static int boomstart=-1,t=1;
	//”Œœ∑◊¥Ã¨øÿ÷∆
	public static int gamestart=0;
	//Õº∆¨
	public static BufferedImage homebg,bg,hero,fire,enemy01,enemy02,enemy03,boom,home,run,stop,gameover;
	public static BufferedImage booms[]=new BufferedImage[7];
	//“Ù¿÷¬∑æ∂
	public static URL bgm,mbull,mboom;
	//“Ù¿÷
	public static AudioClip bgmusic,bullmusic,boommusic;
	static {
		try {
			bg=ImageIO.read(Runtool.class.getResource("homebg.png"));
			hero=ImageIO.read(Runtool.class.getResource("hero.png"));
			fire=ImageIO.read(Runtool.class.getResource("fire.png"));
			enemy01=ImageIO.read(Runtool.class.getResource("enemy01.png"));
			enemy02=ImageIO.read(Runtool.class.getResource("enemy02.png"));
			enemy03=ImageIO.read(Runtool.class.getResource("enemy03.png"));
			booms[0]=ImageIO.read(Runtool.class.getResource("boom0.png"));
			booms[1]=ImageIO.read(Runtool.class.getResource("boom1.png"));
			booms[2]=ImageIO.read(Runtool.class.getResource("boom2.png"));
			booms[3]=ImageIO.read(Runtool.class.getResource("boom3.png"));
			booms[4]=ImageIO.read(Runtool.class.getResource("boom4.png"));
			homebg=ImageIO.read(Runtool.class.getResource("homebg01.png"));
			home=ImageIO.read(Runtool.class.getResource("home.png"));
			run=ImageIO.read(Runtool.class.getResource("run.png"));
			stop=ImageIO.read(Runtool.class.getResource("stop.png"));
			gameover=ImageIO.read(Runtool.class.getResource("gameover.png"));
			bgm = Runtool.class.getResource("/bgmusic.wav");
			mbull=Runtool.class.getResource("/bulletmusic.wav");
			mboom=Runtool.class.getResource("/boommusic.wav");
			bgmusic = Applet.newAudioClip(bgm);
			bullmusic=Applet.newAudioClip(mbull);
			boommusic=Applet.newAudioClip(mboom);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
