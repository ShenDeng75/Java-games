package com.HUAS.Java.Day04;

import java.awt.Graphics;
import java.util.Arrays;

/** 
 * 敌机类
 * */
public class AirEnemy {
    public int[] enemx={};   //敌机坐标
    public int[] enemy={};
    public boolean[] enemyboom={};  //敌机是否被击中
    int speede=3;    //敌机速度
    //画敌机
    public void paintEnemy(Graphics g){
    	for (int i=0;i<enemx.length;i++)
    		if (enemyboom[i])
    	g.drawImage(AirTool.air01, enemx[i], enemy[i], null); 
    }
    //出敌机
    public void enemyfire(){
    	enemx=Arrays.copyOf(enemx, enemx.length+1);
    	enemy=Arrays.copyOf(enemy, enemy.length+1);
    	enemyboom=Arrays.copyOf(enemyboom, enemyboom.length+1);
    	enemx[enemx.length-1]=(int)(Math.random()*((AirTool.pw-400)/2-100));
    	enemy[enemy.length-1]=0;
    	enemyboom[enemyboom.length-1]=true;
    }
    //敌机飞行
    public void enemyfly(){
    	for (int i=0;i<enemy.length;i++){
    		enemy[i]+=speede;
    	}
      }
    }
