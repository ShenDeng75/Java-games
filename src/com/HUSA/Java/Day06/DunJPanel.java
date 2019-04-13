package com.HUSA.Java.Day06;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit;

import com.HUAS.Java.Day05.Hero;

/**
 * ������
 */
public class DunJPanel extends JPanel implements Runnable,KeyListener{
	
	DunHero hero;
	Dunbg dunbg;
	Thread thread;
	public DunJPanel() {
		hero=new DunHero();
		dunbg=new Dunbg();
		thread=new Thread(this);
		thread.start();
		
	}
	@Override
	public void paint(Graphics gg){
		super.paint(gg);
		//������
		gg.drawImage(DunTool.bg, dunbg.x, dunbg.y, null);
		//��Ӣ��
		hero.paintHero(gg);
		
	}
	@Override
	public void run() {
		while(true){
			DunTool.time++;
			if (DunTool.time>1000000)DunTool.time=0;
			hero.heroMove();
		repaint();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}
	//�����¼�
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_W:DunTool.W=true;break;
		case KeyEvent.VK_S:DunTool.S=true;break;
		case KeyEvent.VK_A:DunTool.A=true;hero.F=-1;break;
		case KeyEvent.VK_D:DunTool.D=true;hero.F=1;break;
		
		}
		
	}
	//�ɿ��¼�
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:DunTool.W=false;break;
		case KeyEvent.VK_S:DunTool.S=false;break;
		case KeyEvent.VK_A:DunTool.A=false;break;
		case KeyEvent.VK_D:DunTool.D=false;break;
		
		}
		
	}
	//�����¼�
	@Override
	public void keyTyped(KeyEvent e) {}
}
