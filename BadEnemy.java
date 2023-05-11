//imports java packages
import java.util.Random;
import java.awt.*;

//class that creates enemies holding wrong answers and handles enemy dimensions
public class BadEnemy extends Position{
	
	//2D array containing the positions of the enemy
	public int[][] enemyPos_B = {{25, 75, 125, 175, 225, 250, 300, 375, 425, 
			475, 525, 575, 625, 675, 725},
			{150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 
			500, 525, 550, 575, 600, 625, 650}};
	
	// array of enemy colors
	private Color oneC = new Color (100, 120,200);
	private Color twoC = new Color (20, 10, 100);
	private Color threeC = new Color (40, 50, 250);
	public Color[] enemyColor_b = {Color.magenta, Color.orange, Color.white, oneC, twoC, threeC};
	
	//creates random variable
	private Random random = new Random();
	
	//initializes dimensions for enemy
	private int enemyWidth = 25;
	private int enemyHeight= 25;
		
	//sets random position for enemy position and color
	public int xPos_B = random.nextInt(15);
	public int yPos_B = random.nextInt(21);
	public int color_B = random.nextInt(6);
	
	//takes in enemy coordinates from position class
	public BadEnemy(int x, int y) {
		super(x,y);
	}

	//draws the enemy
	public void draw(Graphics2D g2d) {
		g2d.setColor(enemyColor_b[color_B]);
		g2d.setStroke(new BasicStroke(3));
		g2d.fillRect(enemyPos_B[0][xPos_B], enemyPos_B[1][yPos_B], enemyWidth, enemyHeight);
		g2d.setColor(Color.black);
		g2d.drawRect(enemyPos_B[0][xPos_B], enemyPos_B[1][yPos_B], enemyWidth, enemyHeight);
	}
	
	
}
