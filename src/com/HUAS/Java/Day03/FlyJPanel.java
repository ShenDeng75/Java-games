package com.HUAS.Java.Day03;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FlyJPanel extends JPanel implements Runnable,MouseMotionListener{

	Thread thread;    //线程对象。
	EnamelAir ea;     //敌机对象。
	
	//主机的坐标。k：多个子弹移动的索引。two：子弹闪动的判断。
	int hx=130,hy=500,k=0,two=1,speedy=80,f=0,time=1,d=0;
	
    int[] bx=new int [100];  //子弹坐标。
	int[] by=new int [100];
	
	public FlyJPanel() {    //构造函数，初始化。
		
		//把该画板添加到多线程。
		thread=new Thread(this);   
		thread.start();   //开始线程运行。
		addMouseMotionListener(this);   //添加画板到鼠标事件。
		ea=new EnamelAir();
		
		//使数组不为空。
		for (int i=0;i<100;i++){   
			bx[i]=0;
			by[i]=0;
		}
	}
	public void paint(Graphics gi) {
		super.paint(gi);
		//画背景图片。
		gi.drawImage(Flyer.bg, 0, 0, null);
		//画主机图片
		gi.drawImage(Flyer.hero, hx, hy, null);
		//画子弹。
		for (int i=0;i<100;i++){
			if (bx[i]!=0&&by[i]!=0&&ea.bull[i])
		  gi.drawImage(Flyer.bull, bx[i], by[i], null);
		  
		}
		//画敌机。
		for (int i=0;i<f;i++)
			if (ea.enamel[i])
		  gi.drawImage(Flyer.air, ea.ex[i],ea.ey[i] , null);
		
		//显示得分。
		Font font=new Font("宋体", Font.BOLD, 20);
		gi.setFont(font);
		gi.drawString("得分："+ea.ans+"分", 30, 30); 
	}
	@Override
	public void run() {
		while (true){
			
			//加大难度。
			
			//进行击中判断。
			ea.boom(bx, by,f);  
			//子弹坐标变化
			bx[k]=hx+48;   
			by[k++]=hy;
			
			//使100颗子弹循环。
			if (k>=99)    
			for (int i=0;i<100;i++)
			   {
				//把循环的子弹初始化。
				  k=0;
				  ea.bull[i]=true; 
				}
			
			//控制敌机频率。
			time++;
			if (time%20==0)
			  f++;       
			//使敌机循环。
			if (f>=99)
			{
			  f=0;
			  for (int i=0;i<100;i++)
			  {
				  //把循环的敌机初始化。
				  ea.ey[i]=0;
				  ea.enamel[i]=true;
			  }
			}
			//子弹的动态效果。
			//if (two==1)   
				//speedy=50;
			//else speedy=100;
			//two=-two;
			
			for (int i=0;i<100;i++)   //每一颗子弹的移动。
				{
				if (bx[i]!=0&&by[i]!=0)
				by[i]-=speedy; 
				}
			for(int i=0;i<=f;i++)     //使敌机移动。
				ea.ey[i]+=4;
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getX()>=25&&e.getX()<370&&e.getY()>25&&e.getY()<645){
			//移动飞机。
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			hx=e.getX()-48;
			hy=e.getY()-62;
		}
		else
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
}
