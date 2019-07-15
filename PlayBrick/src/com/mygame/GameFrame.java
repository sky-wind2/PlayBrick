package com.mygame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {
	Image bg = GameUtil.getImage("images/bg.jpg");
	Brick brick = new Brick();
	Ball ball = new Ball();	
	private Image offScreenImage = null;	//图像缓存
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		brick.draw(g);
		ball.draw(g);
		boolean crash = ball.getRect().intersects(brick.getRect());
		
		if(crash) {
			ball.change = -ball.change;
			}
		System.out.println(ball.change);
	}
	
	//帮助我们反复的重画窗口！
	class  PaintThread  extends  Thread  {
		@Override
		public void run() {
			while(true) {
				repaint();		//重画				
				try {
					Thread.sleep(40);   	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
	}
	
	//定义键盘监听的内部类
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent event) {
			brick.addDirection(event);
		}

		@Override
		public void keyReleased(KeyEvent event) {
			brick.minusDirection(event);
		}			
	}
	//初始化窗口
	public  void  launchFrame() {		
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		new PaintThread().start();//启动重画窗口的线程
		addKeyListener(new KeyMonitor()); 
	}
	
	public static void main(String[] args) {
		GameFrame  gameframe = new GameFrame();
		gameframe.launchFrame();
	}
			
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(500, 500);//这是游戏窗口的宽度和高度	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}
}