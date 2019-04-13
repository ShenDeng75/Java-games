package com.HUAS.Java.Day04;

import java.awt.Font;
import java.awt.Graphics;

/** 
 * Ӣ�ۻ���
 * */
public class AirHero extends AirBull{
	int x,y,w,h,life,start;
	public AirHero() {
		//Ӣ�ۻ�����
		this.x=150;    
		this.y=500;    
		//Ӣ�ۻ�����
		this.w=97;     
		this.h=124; 
		//����ֵ
		this.life=3;   
		//��Ϸ״̬
		this.start=0;  
	}
	//������
	public void paintHero(Graphics g){
		g.drawImage(AirTool.hero, x, y, null);
	}
	//���ӵ�
	public void paintBull(Graphics g){
		for (int i=0;i<bullx.length;i++)
			if (bullboom[i])
				//�����ӱ�
			   if (count>=20)
					{
					  g.drawImage(AirTool.bull, bullx[i]-8, bully[i], null);
					  g.drawImage(AirTool.bull, bullx[i]+8, bully[i], null);
					}
			   else  g.drawImage(AirTool.bull, bullx[i], bully[i], null);
	}
	//�ӵ����ел�
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
	//Ӣ�ۻ����л�����
	public void heroboom(){
		for (int i=0;i<enemx.length;i++){
			if (enemyboom[i]&&x>enemx[i]-97&&x<enemx[i]+36&&y>enemy[i]-80&&y<enemy[i]+10){
				enemyboom[i]=false;
				life--;
				break;
			}
		}
			
	}
	//������������ֵ
	public void show(Graphics g){
		if (start==1){
			Font font=new Font("����", Font.BOLD, 20);
			g.setFont(font);
			g.drawString("�÷֣�"+count, 20, 40);
			g.drawString("������"+life, 20, 70);
			}
	}
	//��ʾ��Ϸ״̬
	public void game(Graphics g){
		if (start==0)
			g.drawImage(AirTool.start, 0, 0, null);
		//��Ϸ����
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
