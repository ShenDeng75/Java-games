package com.HUAS.Java.Day05;

import java.awt.Graphics;
import java.util.Arrays;

import org.w3c.dom.css.ElementCSSInlineStyle;
/** 
 * �ӵ���
 * */
public class Bull extends Running{
	//���캯������ʼ���ӵ���Ϣ
	public Bull() {
		this.speed=20;
		this.image=Runtool.fire;
	}
	//�����ӵ�
	public void fire(int hx,int hy,int ex,int ey){
		Runtool.bullmusic.play();
		//�õ��ӵ�����
		int len=x.length;
		//�ӵ������һ
		x=Arrays.copyOf(x, len+1);
		y=Arrays.copyOf(y, len+1);
		fx=Arrays.copyOf(fx, len+1);
		fy=Arrays.copyOf(fy, len+1);
		fstart=Arrays.copyOf(fstart, len+1);
		//��ʼ���ӵ����꣬״̬
		x[len]=hx+60;
		y[len]=hy+40;
		fstart[len]=true;
		//��ʼ���ӵ����е���
		double bx=Math.abs(ex-hx-80);
		double by=Math.abs(ey-hy-40);
		if (ex>hx+80)
		   fx[len]=-bx/(bx+by);
		else fx[len]=bx/(bx+by);
		if (ey>hy+50)
			fy[len]=-by/(bx+by);
		else fy[len]=by/(bx+by);
	}
	//���ӵ�
	public void paint(Graphics gg){
		for (int i=0;i<x.length;i++){
			if (fstart[i])
				gg.drawImage(image, x[i], y[i], null);
		}
	}
	//�ӵ�����
	public void bullfly(){
		for (int i=0;i<x.length;i++){
			if (fstart[i]){
				   x[i]-=fx[i]*speed;
				   y[i]-=fy[i]*speed;
				}
		}
	}
}
