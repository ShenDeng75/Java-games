package com.HUAS.Java.Day05;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** 
 * 英雄类
 * */
public class Hero{
	public int x;
	public int y;
	public int count;
	public int life;
	public Hero() {
		this.x=650;
		this.y=600;
		this.life=100;
		this.count=0;
	}
	//子弹击中敌机
	public void boom(Bull bull,Enemy enemy){
		for (int i=0;i<bull.x.length;i++)
			for(int j=0;j<enemy.x.length;j++) {
				if (bull.fstart[i]&&enemy.fstart[j]&&bull.x[i]>enemy.x[j]-30&&bull.x[i]<enemy.x[j]+40&&bull.y[i]>enemy.y[j]-40&&bull.y[i]<enemy.y[j]+40){
					bull.fstart[i]=false;
					enemy.fstart[j]=false;
					count++;
					Runtool.boomstart=j;
				}
			}
	}
	//判断英雄机与敌机撞击
	public void boom(Enemy enemy){
		for (int i=0;i<enemy.x.length;i++){
			if(enemy.fstart[i]&&x>enemy.x[i]-100&&x<enemy.x[i]+40&&y>enemy.y[i]-100&&y<enemy.y[i]+30){
				enemy.fstart[i]=false;
				life-=15;
				Runtool.boomstart=i;
				if (life<=0)Runtool.gamestart=3;
			}
		}
	}
	//画分数和血条
	public void paintCount(Graphics gg){
		Font font=new Font("宋体", Font.ITALIC, 30);
		gg.setFont(font);
		gg.setColor(Color.blue);
		gg.drawString("得分："+count, 60, 80);
		gg.setColor(Color.white);
		gg.drawRect(140, 100, 98, 18);
		gg.setColor(Color.red);
		gg.drawString("血量", 60, 120);
		gg.fillRect(140, 100, life, 20);
	}
	//加大难度
	public void level(Bull bull,Enemy enemy){
		if (count>=10){
			enemy.image=Runtool.enemy03;
			enemy.speed=2;
		}
	}
	//画游戏状态
	public void paintStart(Graphics gg){
		switch(Runtool.gamestart){
		case 1:gg.drawImage(Runtool.run, 1200, 50,null);break;
		case 2:gg.drawImage(Runtool.stop, 550, 300,null);break;
		case 3:gg.drawImage(Runtool.gameover, 0, 0,null);break;
		}
	}
}
