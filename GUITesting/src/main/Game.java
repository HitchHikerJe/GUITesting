package main;
import javax.swing.*;

import sprites.Ball;

import java.awt.*;

public class Game extends JPanel{
	
	private Ball ball = new Ball(this);
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		ball.paint(g2);
	}
	
	public void move() {
		ball.move();
	}
	
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("Testing");
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