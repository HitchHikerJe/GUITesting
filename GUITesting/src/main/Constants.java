package main;

import java.awt.Color;

public class Constants {
	//general game constants
	public static final int gameWidth = 300;
	public static final int gameHeight = 200;
	public static final int tickTime = 10;
	
	//constants for ball sprite
	public static final int ballSize = 10;
	public static final int hitsToSpeedUp = 8;
	public static final Color ballColor = Color.getHSBColor(.5f, .75f, .8f);	//find HSB calculators online
	
	//constants for paddle sprite
	public static final int paddleLength = 100;
	public static final int paddleHeight = 5;
	public static final int paddleSpeed = 3;
}
