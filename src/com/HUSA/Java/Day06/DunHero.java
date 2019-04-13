package com.HUSA.Java.Day06;

import java.awt.Graphics;

/**
 * Ó¢ÐÛÀà
 */
public class DunHero extends DunMove{
	//³õÊ¼»¯
	public DunHero() {
		image=DunTool.HeroR;
		MoveImage=DunTool.HeroMoveR;
		x=200;
		y=400;
		speed=3;
		F=1;
		MoveState=0;
	}
	//»­Ó¢ÐÛ
	public void paintHero(Graphics gg){
		//ÅÐ±ðÍ¼Æ¬·½Ïò
		if (DunTool.D){
			image=DunTool.HeroR;
			MoveImage=DunTool.HeroMoveR;
		}
		if (DunTool.A){
			image=DunTool.HeroL;
			MoveImage=DunTool.HeroMoveL;
		}
		if (DunTool.A&&DunTool.D&&F==1){
			image=DunTool.HeroR;
			MoveImage=DunTool.HeroMoveR;
		}
		else if (DunTool.A&&DunTool.D&&F==-1){
			image=DunTool.HeroL;
			MoveImage=DunTool.HeroMoveL;
		}
			
		//¶¯Ì¬Í¼Æ¬ÆµÂÊ
		int t;
		t=DunTool.time%48;
		//Õ¾Á¢
		if (!DunTool.W && !DunTool.S && !DunTool.A && !DunTool.D)
		gg.drawImage(image, x, y, null);
		//×ß
		else if (DunTool.A||DunTool.D||DunTool.W||DunTool.S)
			gg.drawImage(MoveImage[t/6], x, y, null);
		//ÅÜ
		
	}
	//Ó¢ÐÛÒÆ¶¯
	public void heroMove(){
		if (y>250&&y<470){
		   if (DunTool.W)y-=speed;
		   if (DunTool.S)y+=speed;
		   if (DunTool.A)x-=speed;
		   if (DunTool.D)x+=speed;
	}
   }
}
