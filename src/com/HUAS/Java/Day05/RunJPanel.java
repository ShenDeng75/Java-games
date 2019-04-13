package com.HUAS.Java.Day05;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.time.Year;
import java.net.URL;
import javax.swing.JPanel;
import javax.xml.stream.events.StartDocument;
/** 
 * 画布类（流程控制）
 * */
public class RunJPanel extends JPanel implements Runnable,MouseListener,MouseMotionListener{
    //定义线程对象
	Thread thread;
	//定义英雄机对象
    Hero hero;
    //定义子弹对象
    Bull bull;
    //定义敌机对象
    Enemy enemy;
    //记时
    int time=0;
	public RunJPanel() {
		//实例化英雄对象，在线程之前
		hero=new Hero();
		//实例化子弹对象
		bull=new Bull();
		enemy=new Enemy();
		//实例化线程对象，并开始运行
    	thread=new Thread(this);
    	//thread.start();
    	//添加到鼠标点击事件
    	addMouseListener(this);
    	//添加到鼠标移动事件
    	addMouseMotionListener(this);
    }
	@Override
    public void paint(Graphics gg){
    	super.paint(gg);
    	//画背景
    	gg.drawImage(Runtool.bg, 0, 0, null);
    	//画主机
    	gg.drawImage(Runtool.hero, hero.x, hero.y, null);
    	//画分数，和血条
    	hero.paintCount(gg);
    	//画子弹
    	bull.paint(gg);
    	//画敌机
    	enemy.paint(gg);
    	//画爆炸状态
    	enemy.paintBoom(gg);
    	//画首页
    	if (Runtool.gamestart==0)
    	gg.drawImage(Runtool.homebg, 0, 0, null);
    	//画游戏状态
    	hero.paintStart(gg);
    }
	@Override
	public void run() {
		//背景音乐
		Runtool.bgmusic.play();
		while (true){
			time++;
			//子弹飞行
			bull.bullfly();
			//出敌机
			if (time%60==0&&Runtool.gamestart==1)
			enemy.fire();
			//敌机飞行
			enemy.enemyfly();
			//判断子弹与敌机撞击
			hero.boom(bull, enemy);
			//判断英雄机与敌机撞击
			hero.boom(enemy);
			//加大难度
			hero.level(bull,enemy);
			//判断结束游戏
			if (Runtool.gamestart==3){
				  repaint();
				  thread.stop();
				}
			//重画
			repaint();
			//休眠
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//鼠标按下事件
	@Override
	public void mousePressed(MouseEvent e) {
		//发射子弹
		if (Runtool.gamestart==1)
		bull.fire(hero.x,hero.y,e.getX(),e.getY());
	}
	//鼠标移动事件
    @Override
	public void mouseMoved(MouseEvent e) {
    	//鼠标在登录，继续位置时变成小手
    	if (Runtool.gamestart==0||Runtool.gamestart==2&&(e.getX()>550&&e.getX()<845&&e.getY()>300&&e.getY()<360)){
			setCursor(new Cursor(Cursor.HAND_CURSOR));
    	}
    	//运行时鼠标放在暂停位置
    	else if (Runtool.gamestart==1&&e.getX()>1200&&e.getX()<1250&&e.getY()>50&&e.getY()<100){
    		setCursor(new Cursor(Cursor.HAND_CURSOR));
    	}
		//移动英雄机
    	else setCursor(new Cursor(Cursor.MOVE_CURSOR));
    	if (Runtool.gamestart==1){
    	hero.x=(e.getX()+650)/2;
		hero.y=(e.getY()+600)/2;
    	}
	}
    //鼠标点击事件
	@Override
	public void mouseClicked(MouseEvent e) {
		//游戏状态控制
		switch(Runtool.gamestart){
		  case 0:if (e.getX()>550&&e.getX()<845&&e.getY()>420&&e.getY()<560){
			  Runtool.gamestart=1;thread.start();
			  }break;
		  case 1:if (e.getX()>1200&&e.getX()<1250&&e.getY()>50&&e.getY()<100){
			  Runtool.gamestart=2; repaint();thread.stop();
		      }break;
		 case 2:if (e.getX()>550&&e.getX()<845&&e.getY()>300&&e.getY()<360){
			 Runtool.gamestart=1; 
			 thread=new Thread(this);
			  thread.start();
		      }break;
		 case 3:
			 Runtool.gamestart=0;
			 hero=new Hero();
			 thread=new Thread(this);
			 thread.start();
			 break;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
}
