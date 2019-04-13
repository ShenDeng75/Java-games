package com.HUAS.Java.Day05;

import java.awt.Graphics;
import java.util.Arrays;

import org.w3c.dom.css.ElementCSSInlineStyle;
/** 
 * 子弹类
 * */
public class Bull extends Running{
	//构造函数，初始化子弹信息
	public Bull() {
		this.speed=20;
		this.image=Runtool.fire;
	}
	//发射子弹
	public void fire(int hx,int hy,int ex,int ey){
		Runtool.bullmusic.play();
		//得到子弹个数
		int len=x.length;
		//子弹数组加一
		x=Arrays.copyOf(x, len+1);
		y=Arrays.copyOf(y, len+1);
		fx=Arrays.copyOf(fx, len+1);
		fy=Arrays.copyOf(fy, len+1);
		fstart=Arrays.copyOf(fstart, len+1);
		//初始化子弹坐标，状态
		x[len]=hx+60;
		y[len]=hy+40;
		fstart[len]=true;
		//初始化子弹飞行弹道
		double bx=Math.abs(ex-hx-80);
		double by=Math.abs(ey-hy-40);
		if (ex>hx+80)
		   fx[len]=-bx/(bx+by);
		else fx[len]=bx/(bx+by);
		if (ey>hy+50)
			fy[len]=-by/(bx+by);
		else fy[len]=by/(bx+by);
	}
	//画子弹
	public void paint(Graphics gg){
		for (int i=0;i<x.length;i++){
			if (fstart[i])
				gg.drawImage(image, x[i], y[i], null);
		}
	}
	//子弹飞行
	public void bullfly(){
		for (int i=0;i<x.length;i++){
			if (fstart[i]){
				   x[i]-=fx[i]*speed;
				   y[i]-=fy[i]*speed;
				}
		}
	}
}
