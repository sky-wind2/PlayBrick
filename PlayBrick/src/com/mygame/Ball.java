package com.mygame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{
	double degree;
	int change = 1;
	public Ball() {
		super();
		x = 250;
		y = 250;
		speed = 5;
		width = 10;
		height = 10;
		degree = Math.random() * Math.PI * 2;	
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
		if (change == 1) {
			move();
		}
		if (change == -1) {
			degree = -degree;
			move();	
		}
		
		g.setColor(c);		
	}
	public void move() {
		x += (int) (speed * Math.cos(degree));
		y += (int) (speed * Math.sin(degree));
		if(x<0||x>Constant.GAME_WIDTH-width){
			degree  = Math.PI - degree;
		}	
		if(y<30||y>Constant.GAME_HEIGHT-height){
			degree  =- degree;
		}
		
	}
}
