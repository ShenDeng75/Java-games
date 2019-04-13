package com.HUAS.Java.Day04;

import java.awt.Font;
import java.awt.Graphics;

/** 
 * 英雄机类
 * */
public class AirHero extends AirBull{
	int x,y,w,h,life,start;
	public AirHero() {
		//英雄机坐标
		this.x=150;    
		this.y=500;    
		//英雄机像素
		this.w=97;     
		this.h=124; 
		//生命值
		this.life=3;   
		//游戏状态
		this.start=0;  
	}
	//画主机
	public void paintHero(Graphics g){
		g.drawImage(AirTool.hero, x, y, null);
	}
	//画子弹
	public void paintBull(Graphics g){
		for (int i=0;i<bullx.length;i++)
			if (bullboom[i])
				//火力加倍
			   if (count>=20)
					{
					  g.drawImage(AirTool.bull, bullx[i]-8, bully[i], null);
					  g.drawImage(AirTool.bull, bullx[i]+8, bully[i], null);
					}
			   else  g.drawImage(AirTool.bull, bullx[i], bully[i], null);
	}
	//子弹击中敌机
	public void boom(){
		for (int i=0;i<bullx.length;i++)
			for (int j=0;j<enemx.length;j++)
				if (bullboom[i]&&enemyboom[j]&&bullx[i]>enemx[j]&&bullx[i]<enemx[j]+49&&bully[i]>enemy[j]&&bully[i]<enemy[j]+36)
				{
					bullboom[i]=false;
					enemyboom[j]=false;
					count++;
					if (count%50==0)
						speede+=1;
				}
	}
	//英雄机被敌机击中
	public void heroboom(){
		for (int i=0;i<enemx.length;i++){
			if (enemyboom[i]&&x>enemx[i]-97&&x<enemx[i]+36&&y>enemy[i]-80&&y<enemy[i]+10){
				enemyboom[i]=false;
				life--;
				break;
			}
		}
			
	}
	//画分数和生命值
	public void show(Graphics g){
		if (start==1){
			Font font=new Font("宋体", Font.BOLD, 20);
			g.setFont(font);
			g.drawString("得分："+count, 20, 40);
			g.drawString("生命："+life, 20, 70);
			}
	}
	//显示游戏状态
	public void game(Graphics g){
		if (start==0)
			g.drawImage(AirTool.start, 0, 0, null);
		//游戏结束
		if (start==2){
			g.drawImage(AirTool.gameover, 0, 0, null);
		}
		if (start==3){
			g.drawImage(AirTool.pause, 0, 0, null);	
		}
	}
	public void showstop(Graphics g){
		g.drawImage(AirTool.pause, 0, 0, null);
	}
}
