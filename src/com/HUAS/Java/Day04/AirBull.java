package com.HUAS.Java.Day04;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * �ӵ���
 */
public class AirBull extends AirEnemy{
	//�ӵ�����
	public int[] bullx={};   
	public int[] bully={};   
	//�ж��ӵ��Ƿ����Ŀ��
	public boolean[] bullboom={}; 
	//�÷�
	public int count=0;  
	//�ӵ��ٶ�
	public int speed=5;  
	
	//�����ӵ�
	public void fire(int x,int y){
		//�����ӵ���
		bullx=Arrays.copyOf(bullx, bullx.length+1);
		bully=Arrays.copyOf(bully, bullx.length+1);
		bullboom=Arrays.copyOf(bullboom, bullboom.length+1);
		//��ʼ���ӵ����꣬״̬
		bullx[bullx.length-1]=x+47;
		bully[bully.length-1]=y;
		bullboom[bullboom.length-1]=true;
	}
	//�ӵ�����
	public void bullfly(){
		for (int i=0;i<bully.length-1;i++)
			bully[i]-=speed;
	}
}
