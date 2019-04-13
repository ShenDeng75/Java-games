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
 * �����ࣨ���̿��ƣ�
 * */
public class RunJPanel extends JPanel implements Runnable,MouseListener,MouseMotionListener{
    //�����̶߳���
	Thread thread;
	//����Ӣ�ۻ�����
    Hero hero;
    //�����ӵ�����
    Bull bull;
    //����л�����
    Enemy enemy;
    //��ʱ
    int time=0;
	public RunJPanel() {
		//ʵ����Ӣ�۶������߳�֮ǰ
		hero=new Hero();
		//ʵ�����ӵ�����
		bull=new Bull();
		enemy=new Enemy();
		//ʵ�����̶߳��󣬲���ʼ����
    	thread=new Thread(this);
    	//thread.start();
    	//��ӵ�������¼�
    	addMouseListener(this);
    	//��ӵ�����ƶ��¼�
    	addMouseMotionListener(this);
    }
	@Override
    public void paint(Graphics gg){
    	super.paint(gg);
    	//������
    	gg.drawImage(Runtool.bg, 0, 0, null);
    	//������
    	gg.drawImage(Runtool.hero, hero.x, hero.y, null);
    	//����������Ѫ��
    	hero.paintCount(gg);
    	//���ӵ�
    	bull.paint(gg);
    	//���л�
    	enemy.paint(gg);
    	//����ը״̬
    	enemy.paintBoom(gg);
    	//����ҳ
    	if (Runtool.gamestart==0)
    	gg.drawImage(Runtool.homebg, 0, 0, null);
    	//����Ϸ״̬
    	hero.paintStart(gg);
    }
	@Override
	public void run() {
		//��������
		Runtool.bgmusic.play();
		while (true){
			time++;
			//�ӵ�����
			bull.bullfly();
			//���л�
			if (time%60==0&&Runtool.gamestart==1)
			enemy.fire();
			//�л�����
			enemy.enemyfly();
			//�ж��ӵ���л�ײ��
			hero.boom(bull, enemy);
			//�ж�Ӣ�ۻ���л�ײ��
			hero.boom(enemy);
			//�Ӵ��Ѷ�
			hero.level(bull,enemy);
			//�жϽ�����Ϸ
			if (Runtool.gamestart==3){
				  repaint();
				  thread.stop();
				}
			//�ػ�
			repaint();
			//����
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//��갴���¼�
	@Override
	public void mousePressed(MouseEvent e) {
		//�����ӵ�
		if (Runtool.gamestart==1)
		bull.fire(hero.x,hero.y,e.getX(),e.getY());
	}
	//����ƶ��¼�
    @Override
	public void mouseMoved(MouseEvent e) {
    	//����ڵ�¼������λ��ʱ���С��
    	if (Runtool.gamestart==0||Runtool.gamestart==2&&(e.getX()>550&&e.getX()<845&&e.getY()>300&&e.getY()<360)){
			setCursor(new Cursor(Cursor.HAND_CURSOR));
    	}
    	//����ʱ��������ͣλ��
    	else if (Runtool.gamestart==1&&e.getX()>1200&&e.getX()<1250&&e.getY()>50&&e.getY()<100){
    		setCursor(new Cursor(Cursor.HAND_CURSOR));
    	}
		//�ƶ�Ӣ�ۻ�
    	else setCursor(new Cursor(Cursor.MOVE_CURSOR));
    	if (Runtool.gamestart==1){
    	hero.x=(e.getX()+650)/2;
		hero.y=(e.getY()+600)/2;
    	}
	}
    //������¼�
	@Override
	public void mouseClicked(MouseEvent e) {
		//��Ϸ״̬����
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
