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

	Thread thread;    //�̶߳���
	EnamelAir ea;     //�л�����
	
	//���������ꡣk������ӵ��ƶ���������two���ӵ��������жϡ�
	int hx=130,hy=500,k=0,two=1,speedy=80,f=0,time=1,d=0;
	
    int[] bx=new int [100];  //�ӵ����ꡣ
	int[] by=new int [100];
	
	public FlyJPanel() {    //���캯������ʼ����
		
		//�Ѹû�����ӵ����̡߳�
		thread=new Thread(this);   
		thread.start();   //��ʼ�߳����С�
		addMouseMotionListener(this);   //��ӻ��嵽����¼���
		ea=new EnamelAir();
		
		//ʹ���鲻Ϊ�ա�
		for (int i=0;i<100;i++){   
			bx[i]=0;
			by[i]=0;
		}
	}
	public void paint(Graphics gi) {
		super.paint(gi);
		//������ͼƬ��
		gi.drawImage(Flyer.bg, 0, 0, null);
		//������ͼƬ
		gi.drawImage(Flyer.hero, hx, hy, null);
		//���ӵ���
		for (int i=0;i<100;i++){
			if (bx[i]!=0&&by[i]!=0&&ea.bull[i])
		  gi.drawImage(Flyer.bull, bx[i], by[i], null);
		  
		}
		//���л���
		for (int i=0;i<f;i++)
			if (ea.enamel[i])
		  gi.drawImage(Flyer.air, ea.ex[i],ea.ey[i] , null);
		
		//��ʾ�÷֡�
		Font font=new Font("����", Font.BOLD, 20);
		gi.setFont(font);
		gi.drawString("�÷֣�"+ea.ans+"��", 30, 30); 
	}
	@Override
	public void run() {
		while (true){
			
			//�Ӵ��Ѷȡ�
			
			//���л����жϡ�
			ea.boom(bx, by,f);  
			//�ӵ�����仯
			bx[k]=hx+48;   
			by[k++]=hy;
			
			//ʹ100���ӵ�ѭ����
			if (k>=99)    
			for (int i=0;i<100;i++)
			   {
				//��ѭ�����ӵ���ʼ����
				  k=0;
				  ea.bull[i]=true; 
				}
			
			//���Ƶл�Ƶ�ʡ�
			time++;
			if (time%20==0)
			  f++;       
			//ʹ�л�ѭ����
			if (f>=99)
			{
			  f=0;
			  for (int i=0;i<100;i++)
			  {
				  //��ѭ���ĵл���ʼ����
				  ea.ey[i]=0;
				  ea.enamel[i]=true;
			  }
			}
			//�ӵ��Ķ�̬Ч����
			//if (two==1)   
				//speedy=50;
			//else speedy=100;
			//two=-two;
			
			for (int i=0;i<100;i++)   //ÿһ���ӵ����ƶ���
				{
				if (bx[i]!=0&&by[i]!=0)
				by[i]-=speedy; 
				}
			for(int i=0;i<=f;i++)     //ʹ�л��ƶ���
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
			//�ƶ��ɻ���
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			hx=e.getX()-48;
			hy=e.getY()-62;
		}
		else
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
}
