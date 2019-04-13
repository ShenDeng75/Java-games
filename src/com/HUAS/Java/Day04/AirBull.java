package com.HUAS.Java.Day04;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * 子弹类
 */
public class AirBull extends AirEnemy{
	//子弹坐标
	public int[] bullx={};   
	public int[] bully={};   
	//判断子弹是否击中目标
	public boolean[] bullboom={}; 
	//得分
	public int count=0;  
	//子弹速度
	public int speed=5;  
	
	//发射子弹
	public void fire(int x,int y){
		//增加子弹数
		bullx=Arrays.copyOf(bullx, bullx.length+1);
		bully=Arrays.copyOf(bully, bullx.length+1);
		bullboom=Arrays.copyOf(bullboom, bullboom.length+1);
		//初始化子弹坐标，状态
		bullx[bullx.length-1]=x+47;
		bully[bully.length-1]=y;
		bullboom[bullboom.length-1]=true;
	}
	//子弹飞行
	public void bullfly(){
		for (int i=0;i<bully.length-1;i++)
			bully[i]-=speed;
	}
}
