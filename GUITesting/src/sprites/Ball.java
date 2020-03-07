package sprites;

import javax.swing.*;
import java.awt.*;

import main.Constants;
import main.Game;

public class Ball extends JPanel{
	
	//unlike other sprites, ball must have an occurrence of Game because it calls methods in other sprites which exist in Game
	public Game game;
	
	//sprite stats with default values assigned
	private int x = 0, y = 0, dy = 1, dx = 1, speed = 1, hitCount = 1;
	
	public Ball(Game g) {
		game = g;
	}
	
	//changes ball position, called by Game class
	public void move() {
		//hitting left edge
		if(x + dx < 0) {
			dx = 1;
		}
		
		//hitting right edge
		else if(x + dx + Constants.ballSize > Constants.gameWidth) {
			dx = -1;
		}
		
		//hitting top edge
		if(y + dy < 0) {
			dy = 1;
		}
		
		//hitting paddle
		else if(y + dy + Constants.ballSize > game.paddle.getRect()[2] && ((x < game.paddle.getRect()[1] && x > game.paddle.getRect()[0]) || (x + Constants.ballSize > game.paddle.getRect()[0] && x + Constants.ballSize < game.paddle.getRect()[1]))) {
			dy = -1;
			hitCount++;
			game.score.scoreUp();
			//see paddle class for discussion of this method's use
//			game.paddle.shrink();
		}
		
		//hitting bottom edge
		else if(y + dy + Constants.ballSize > Constants.gameHeight) {
			game.gameOver();
		}
		
		//checks paddle hits to see if speed increases
		if(hitCount % (Constants.hitsToSpeedUp + 1) == 0) {
			speed++;
			hitCount = 1;
		}
		
		//actually changing the position based on the excessive logic above
		x += (dx * speed);
		y += (dy * speed);
	}
	
	//necessary JPanel paint method called by Game class
	public void paint(Graphics2D g) {
		g.setColor(Constants.ballColor);
		g.fillOval(x, y, Constants.ballSize, Constants.ballSize);
	}
}
