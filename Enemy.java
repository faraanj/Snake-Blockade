//import java packages
import java.util.Random;
import java.awt.*;

//class that creates enemies holding correct answers and handles enemy dimensions
public class Enemy extends Position{
	
	//2D array containing the positions of the enemy
	public int[][] enemyPos = {{ 50,  100,  150, 200, 275, 325, 350, 400, 450, 
			 500, 550, 600, 650, 700, 750},
			{150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 
			500, 525, 550, 575, 600, 625, 650}};
	
	// array of enemy colors
	private Color oneC = new Color (255, 100, 50);
	private Color twoC = new Color (200, 10, 200);
	private Color threeC = new Color (150, 40, 250);
	public Color[] enemyColor = {Color.cyan, Color.darkGray, Color.gray, oneC, twoC, threeC};
	
	//creates random variable 
	private Random random = new Random();
	
	//initializes dimensions for enemy
	private int enemyWidth = 25;
	private int enemyHeight= 25;
	
	//Initializes score
	public int score = 0;
	
	//sets random position for enemy position and color
	public int xPos = random.nextInt(15);
	public int yPos = random.nextInt(21);
	public int color = random.nextInt(6);
	
	//takes in enemy coordinates from position class
	public Enemy(int x, int y) {
		super(x,y);
	}

	//draws the enemy
	public void draw(Graphics2D g2d) {
		g2d.setColor(enemyColor[color]);
		g2d.setStroke(new BasicStroke(3));
		g2d.fillRect(enemyPos[0][xPos], enemyPos[1][yPos], enemyWidth, enemyHeight);
		g2d.setColor(Color.black);
		g2d.drawRect(enemyPos[0][xPos], enemyPos[1][yPos], enemyWidth, enemyHeight);
		
		
	}
	
	
}
