package main;
import javax.swing.*;

import sprites.*;

import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel{
	
	//what sprites exist in this game
	public Ball ball;
	public Paddle paddle;
	public ScoreDisplay score;
	
	public Game() {
		setBackground(Color.DARK_GRAY);
		
		//sprite initialization
		ball = new Ball(this);
		paddle = new Paddle();
		score = new ScoreDisplay();
		
		//IMPORTANT:: THIS IS HOW YOU GET KEYBOARD INPUTS
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
		
		//IMPORTANT:: DONT FORGET THIS LINE IF USING KEYBOARD INPUT
		setFocusable(true);
	}
	
	//how you display things on the screen
	public void paint(Graphics g) {
		//this line clears the screen every time its called (during game loop)
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		//painting all of the sprites
		ball.paint(g2);
		paddle.paint(g2);
		score.paint(g2);
	}
	
	//getting everything to move
	public void move() {
		ball.move();
		paddle.move();
	}
	
	//what do you do when you lose
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	//IMPORTANT:: MAIN METHOD
	//yeets caring about the thread being interrupted by sleep
	public static void main(String[] args) throws InterruptedException{
		//initializing of components
		JFrame frame = new JFrame("Many Sprites");
		Game game = new Game();

		//setting the window size and combining the components
		//trust me... it may look gross, but it works rather well
		game.setPreferredSize(new Dimension(Constants.gameWidth,Constants.gameHeight));
		frame.getContentPane().add(game);
		frame.pack();
		
		frame.setVisible(true);
		//will end the program when the window is closed and the window can easily be moved
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		//game loop
		while(true) {
			game.move();
			game.repaint();
			Thread.sleep(Constants.tickTime);
		}
	}
}