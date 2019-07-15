package com.mygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;




public class Brick extends GameObject {
	boolean left, right, up, down;
	
	public Brick() {
		super();
		x = 220;
		y = 80;
		speed = 5;
		width = 20;
		height = 10;
	}
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		
		if (left) {
			x -= speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
		
		g.setColor(c);
		
	}
	//按下按键，朝着相应方向移动
	public void addDirection(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
	//取消按键，停止移动
	public void minusDirection(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}
}
