import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{
	
	public void paint(Graphics g) {
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Testing");
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Game game = new Game();
		frame.add(game);
		
	}
}
