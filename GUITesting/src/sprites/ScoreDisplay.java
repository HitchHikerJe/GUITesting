package sprites;

import javax.swing.*;
import java.awt.*;

public class ScoreDisplay extends JPanel {
	
	//sprite stats
	private int score = 0;
	
	public void scoreUp() {
		score++;
	}
	
	//necessary JPanel paint method called by Game class
	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
//		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		g.drawString("Score: " + score, 2, 12);
	}
}
