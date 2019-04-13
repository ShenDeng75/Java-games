package com.HUSA.Java.Day06;

import java.awt.Image;

/**
 * 移动物类
 */
public class DunMove {
	//站立图片
	Image image;
	//运动图片
	Image MoveImage[]=new Image[8];
	//坐标
	int x;
	int y;
	//速度
	int speed;
	//方向
	int F;
	//运动状态
	int MoveState;
}
