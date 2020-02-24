package sprites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import main.Game;

public class Paddle extends JPanel{
	private Game game;
	
	private int x, y, dx = 0, length = 100, height = 10;
	
	public Paddle(Game g) {
		game = g;
//		x = (game.getWidth() - length)/2;
//		y = (game.getHeight() - (height + 10));
		x = 0;
		y = 130;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, length, height);
	}
	
	public void move() {
		x += dx;
	}
	
	
	public void keyPressed(KeyEvent e) {
		dx = e.getKeyCode() == KeyEvent.VK_A ? -2 : (e.getKeyCode() == KeyEvent.VK_D ? 2 : 0);
	}
	public void keyReleased(KeyEvent e) {
		dx = 0;
	}
}
