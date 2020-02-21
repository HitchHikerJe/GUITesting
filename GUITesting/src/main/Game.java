package main;
import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//you can find a calculator for this online
		g2.setColor(Color.getHSBColor(.5f, .75f, .8f));
		
		g2.fillOval(0, 0, 20, 20);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Testing");
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Game game = new Game();
		game.setBackground(Color.DARK_GRAY);
		frame.add(game);
		
	}
}