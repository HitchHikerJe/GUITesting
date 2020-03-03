package main;
import javax.swing.*;

import sprites.*;

import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel{
	
	public Ball ball;
	public Paddle paddle;
	
	public Game() {
		setBackground(Color.DARK_GRAY);
		ball = new Ball(this);
		paddle = new Paddle(this);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				paddle.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				paddle.keyReleased(e);
			}
		});
		setFocusable(true);
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
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("Many Sprites");
		Game game = new Game();
		frame.add(game);
		
		frame.setSize(300,250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		while(true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}