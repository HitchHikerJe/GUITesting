package sprites;

import javax.swing.*;
import java.awt.*;

import main.Game;

public class ScoreDisplay extends JPanel {
	
	public Game game;
	
	private int score = -1;
	
	public ScoreDisplay(Game g) {
		game = g;
	}
	
	public void scoreUp() {
		score++;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, 0, 10);
	}
}
