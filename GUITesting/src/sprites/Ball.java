package sprites;

import javax.swing.*;
import java.awt.*;

import main.Game;

public class Ball extends JPanel{
	
	public Game game;
	
	private int x = 0, y = 0, dx = 1, dy = 1, size = 20;
	
	public Ball(Game g) {
		game = g;
	}
	
	public void move() {
		if(x + dx < 0) {
			dx = 1;
		}
		else if(x + dx + size > game.getWidth()) {
			dx = -1;
		}
		if(y + dy < 0) {
			dy = 1;
		}
		else if(y + dy + size > game.paddle.getRect()[2] && (x < game.paddle.getRect()[1] || x + size > game.paddle.getRect()[0])) {
			dy = -1;
		}
		else if(y + dy + size > game.getHeight()) {
			game.gameOver();
		}
		
		x += dx;
		y += dy;
	}
	
	public void paint(Graphics2D g) {
		//you can find calculators for this online
		g.setColor(Color.getHSBColor(.5f, .75f, .8f));
		g.fillOval(x, y, size, size);
	}
}
