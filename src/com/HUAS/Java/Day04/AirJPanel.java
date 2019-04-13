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
 * 画布类
 * */
public class AirJPanel extends JPanel implements Runnable,MouseMotionListener,MouseListener{
	Thread thread;
	AirHero hero;
	//计时
	int time=1;
	public AirJPanel() {
		
		//实例化一个英雄机
		hero=new AirHero();
		//实例化多线程对象
		thread=new Thread(this);
		//添加鼠标事件
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//画背景图
		g.drawImage(AirTool.bg, 0, 0, null);
		//画英雄机
		hero.paintHero(g);
		//画子弹
		hero.paintBull(g);
		//画敌机
		hero.paintEnemy(g);
		//画分数和生命值
		hero.show(g);
		//显示游戏状态
		hero.game(g);
		
			
	}
	@Override
	public void run() {
		while (true){
			
			//游戏结束
			if (hero.life<=0)
				hero.start=2;
			
			//记时
			time++;
			//发射子弹
			if (hero.start==1&&time%25==0)
			hero.fire(hero.x,hero.y);
			//子弹飞行
			hero.bullfly();
			//出敌机
			if (hero.start==1&&time%50==0)
				hero.enemyfire();
			//敌机飞行
			hero.enemyfly();
			//击中敌机
			hero.boom();
			//英雄机被敌机击中
			hero.heroboom();
			//重画
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//移动事件
	@Override
	public void mouseMoved(MouseEvent e) {
		if (hero.start==1&&e.getX()>0&&e.getX()<420&&e.getY()>0&&e.getY()<680){
			//使鼠标变成十字架
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			//使英雄机跟随鼠标移动
			hero.x=e.getX()-hero.w/2;
			hero.y=e.getY()-hero.h/2;
		}else{
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
	//点击事件
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
	//移进事件--继续游戏
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		thread=new Thread(this);
		thread.start();
		if (hero.start==3)
		hero.start=1;
	}
	//移出事件--暂停游戏
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
