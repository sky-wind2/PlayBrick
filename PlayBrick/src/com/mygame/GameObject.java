package com.mygame;


import java.awt.Rectangle;

public class GameObject {	
	 int x;
	 int y;
	 int speed;
	 int width, height;
	
	public GameObject(int x, int y, int speed, int widh, int height) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = widh;
		this.height = height;
	}
	
	public GameObject() {
	}
	

	
	/**
	 * �����������ڵľ��Ρ����ں�������ײ���
	 * @return
	 */
	public  Rectangle   getRect(){
		return  new Rectangle(x, y, width, height);
	}
	
}

