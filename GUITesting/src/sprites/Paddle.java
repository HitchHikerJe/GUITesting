package sprites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import main.Constants;

public class Paddle extends JPanel{
	
	//sprite stats
	private int x, y, dx = 0;
	
	public Paddle() {
		x = 0;
		y = Constants.gameHeight - Constants.paddleHeight - 5;
	}
	
	//necessary JPanel paint method called by Game class
	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, Constants.paddleLength, Constants.paddleHeight);
	}
	
	//method that changes the paddle position on the screen called by Game class
	public void move() {
		if(x + Constants.paddleLength + dx > Constants.gameWidth || x + dx < 0) {
			dx = 0;
		}
		x += dx;
	}
	
	//method for getting where the paddle is for collision detection
	//[left, right, up, down]
	public int[] getRect() {
		int[] temp = {x, x + Constants.paddleLength, y, y + Constants.paddleHeight};
		return temp;
	}
	
//  this method existed before the constants file, if you want to use it, make the paddleLength constant not final
//	public void shrink() {
//		if(length >=15) {
//			length -= 10;
//		}
//	}
	
	//keyboard events
	public void keyPressed(KeyEvent e) {
		dx = e.getKeyCode() == KeyEvent.VK_A ? -3 : (e.getKeyCode() == KeyEvent.VK_D ? 3 : 0);
	}
	public void keyReleased(KeyEvent e) {
		dx = 0;
	}
}
