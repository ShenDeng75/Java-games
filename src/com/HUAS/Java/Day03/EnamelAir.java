package com.HUAS.Java.Day03;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class EnamelAir {
	
	Random random=new Random();
	//�л�������
	int[] ex=new int [100];
	int[] ey=new int [100];
	int[] eft=new int [100];
	 int ans=0;
	//�л������ӵ��Ƿ񻭳�����
	boolean[] enamel=new boolean [100];
	boolean[] bull=new boolean [100];
	
	//���캯������ʼ���л���Ϣ��
	public EnamelAir(){
		for (int i=0;i<100;i++)
		{
			this.ex[i]=random.nextInt(340);
			this.ey[i]=-130;
			this.eft[i]=0;
			this.enamel[i]=true;
			this.bull[i]=true;
		}
	}
	//�����ײ��
	public void boom(int bx[],int by[],int f){
		for (int i=0;i<100;i++)
			for (int j=0;j<100;j++)
				if (this.enamel[j]&&this.ex[j]>=0&&this.ex[j]<=350&&this.ey[j]>=0&&this.ey[j]<=700)
				if (j<=f&&bx[i]>=this.ex[j]&&bx[i]<=this.ex[j]+49&&by[i]>=this.ey[j]&&by[i]<=this.ey[j]+36)
				{
					this.enamel[j]=false;
					this.bull[i]=false;
					this.ans++;
				}
	}
}
