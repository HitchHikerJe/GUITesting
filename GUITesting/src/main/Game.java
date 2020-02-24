package main;
import javax.swing.*;

import sprites.*;

import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel{
	
	private static Ball ball;
	private static Paddle paddle;
	
	public Game() {
		ball = new Ball(this);
		paddle = new Paddle(this);
//		addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyTyped(KeyEvent e) {}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				paddle.keyPressed(e);
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				paddle.keyReleased(e);
//			}
//		});
//		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		ball.paint(g2);
		paddle.paint(g2);
	}
	
	public void move() {
		ball.move();
		paddle.move();
	}
	
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("Many Sprites");
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Game game = new Game();
		game.setBackground(Color.DARK_GRAY);
		frame.add(game);
		
		while(true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}