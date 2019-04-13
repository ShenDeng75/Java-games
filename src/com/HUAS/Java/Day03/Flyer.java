package com.HUAS.Java.Day03;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Flyer {
	
	
	public static BufferedImage bg,air,bee,bull,hero,kt,shoot,gameover;
	static {
		//º”‘ÿÕº∆¨°£
		try {
			bg=ImageIO.read(Flyer.class.getResource("background.png"));
			air=ImageIO.read(Flyer.class.getResource("ep01.png"));
			bee=ImageIO.read(Flyer.class.getResource("bee.png"));
			bull=ImageIO.read(Flyer.class.getResource("bullet.png"));
			hero=ImageIO.read(Flyer.class.getResource("hero0.png"));
			kt=ImageIO.read(Flyer.class.getResource("hongxin.png"));
			shoot=ImageIO.read(Flyer.class.getResource("shoot.png"));
			gameover=ImageIO.read(Flyer.class.getResource("gameover.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
