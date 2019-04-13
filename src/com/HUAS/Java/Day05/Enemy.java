package com.HUAS.Java.Day05;

import java.awt.Graphics;
import java.util.Arrays;

public class Enemy extends Running{
	public Enemy() {
		this.speed=1;
		this.image=Runtool.enemy02;
	}
	//出敌机
	public void fire(){
		//得到敌机个数
		int len=x.length;
		//敌机数组加一
		x=Arrays.copyOf(x, len+1);
		y=Arrays.copyOf(y, len+1);
		fx=Arrays.copyOf(fx, len+1);
		fy=Arrays.copyOf(fy, len+1);
		fstart=Arrays.copyOf(fstart, len+1);
		//初始化敌机坐标，状态
		x[len]=(int)(Math.random()*Runtool.pw);
		y[len]=0;
		fstart[len]=true;
		//初始化敌机轨道
		if (len%2==0)speed=-speed;
		fx[len]=(int)(Math.random()*3)*speed;
		fy[len]=(int)(Math.random()*3)+1;
	}
	//画敌机
	public void paint(Graphics gg){
		for (int i=0;i<x.length;i++){
			if (fstart[i])
				gg.drawImage(image, x[i], y[i], null);
		}
	}
	//敌机飞行
	public void enemyfly(){
		for (int i=0;i<x.length;i++){
			if (fstart[i]){
				   x[i]+=fx[i];
				   y[i]+=fy[i];
				 }
	     }
    }
	//画爆炸状态
	public void paintBoom(Graphics gg){
		int i=Runtool.boomstart;
		if (i!=-1&&Runtool.t<50){
			if (Runtool.t==2)Runtool.boommusic.play();
			gg.drawImage(Runtool.booms[Runtool.t/10], x[i], y[i], null);
			}
		else {
			Runtool.t=1;
			Runtool.boomstart=-1;
		}
		Runtool.t++;
	}
}
