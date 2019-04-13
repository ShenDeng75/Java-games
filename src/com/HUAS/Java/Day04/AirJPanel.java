package com.HUAS.Java.Day04;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/** 
 * ������
 * */
public class AirJPanel extends JPanel implements Runnable,MouseMotionListener,MouseListener{
	Thread thread;
	AirHero hero;
	//��ʱ
	int time=1;
	public AirJPanel() {
		
		//ʵ����һ��Ӣ�ۻ�
		hero=new AirHero();
		//ʵ�������̶߳���
		thread=new Thread(this);
		//�������¼�
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//������ͼ
		g.drawImage(AirTool.bg, 0, 0, null);
		//��Ӣ�ۻ�
		hero.paintHero(g);
		//���ӵ�
		hero.paintBull(g);
		//���л�
		hero.paintEnemy(g);
		//������������ֵ
		hero.show(g);
		//��ʾ��Ϸ״̬
		hero.game(g);
		
			
	}
	@Override
	public void run() {
		while (true){
			
			//��Ϸ����
			if (hero.life<=0)
				hero.start=2;
			
			//��ʱ
			time++;
			//�����ӵ�
			if (hero.start==1&&time%25==0)
			hero.fire(hero.x,hero.y);
			//�ӵ�����
			hero.bullfly();
			//���л�
			if (hero.start==1&&time%50==0)
				hero.enemyfire();
			//�л�����
			hero.enemyfly();
			//���ел�
			hero.boom();
			//Ӣ�ۻ����л�����
			hero.heroboom();
			//�ػ�
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//�ƶ��¼�
	@Override
	public void mouseMoved(MouseEvent e) {
		if (hero.start==1&&e.getX()>0&&e.getX()<420&&e.getY()>0&&e.getY()<680){
			//ʹ�����ʮ�ּ�
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			//ʹӢ�ۻ���������ƶ�
			hero.x=e.getX()-hero.w/2;
			hero.y=e.getY()-hero.h/2;
		}else{
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
	//����¼�
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(hero.start){
		  case 0:hero.start=1;
			    thread.start();
			    break;
		  case 2:hero.start=1;
			   hero=new AirHero();
			   break;
		}
	}
	//�ƽ��¼�--������Ϸ
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		thread=new Thread(this);
		thread.start();
		if (hero.start==3)
		hero.start=1;
	}
	//�Ƴ��¼�--��ͣ��Ϸ
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		hero.start=3;
		repaint();
		thread.stop();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
