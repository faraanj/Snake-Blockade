//imports packages
import java.awt.*;

//creates a class that handles player movements and events
public class Player extends Position{
	
	//initializes speed and player dimensions
	public int playerWidth = 25;
	public int playerHeight = 25;
	public int speedX = 0;
	public int speedY = 0;
	
	//initializes snake size and array for points 
	public int snakeSize = 3;
	public int snakeX[] = new int[1024];
	public int snakeY[] = new int[1024];
	
	//Initializes boolean logic
	public boolean snakeMove = true;
	
	//takes in the x and y points from the position class
	public Player(int x, int y) {
		super(x, y);
	}
	
	//updates player movements
	public void update() {
		//moves up
		if (Main.key.equals("up")) {
			speedY = -1;
			speedX = 0;
		}
		//moves down
		else if (Main.key.equals("down")) {
			speedY = 1;
			speedX = 0;
		}
		//moves left
		else if (Main.key.equals("left")) {
			speedX = -1;
			speedY = 0;
		}
		//moves right
		else if (Main.key.equals("right")) {
			speedX = 1;
			speedY = 0;
		}
		//adds distance 
		if (snakeMove == true) {
			x += 25*speedX;
			y += 25*speedY;
			
			snakeX[0] = x;
			snakeY[0] = y;
		}else {
			x += 0;
			y += 0;
		}
		
		//ends game if player hits the border
		if (x<0 || y<105 || x>775 || y>720) {
			Main.screen = 4; 
			Main.screenChange=true;	
		}

	}
	
	//draws player
	public void draw(Graphics2D g2d) {
		for (int i = 0; i<snakeSize; i++) {
			//draws head
			if (i == 0) {
				g2d.setColor(Color.red);
				g2d.fillRect(snakeX[i], snakeY[i], playerWidth, playerHeight);
				g2d.setColor(Color.black);
				g2d.drawRect(snakeX[i], snakeY[i], playerWidth, playerHeight);

			}
			//draws body
			else {
				g2d.setColor(Color.pink);
				g2d.fillRect(snakeX[i], snakeY[i], playerWidth, playerHeight);
				g2d.setColor(Color.black);
				g2d.drawRect(snakeX[i], snakeY[i], playerWidth, playerHeight);
				//System.out.println("snake:"+ i + " " + snakeX[i] + " " + snakeY[i]);
			}
			
		}
		//sets position of the body to the previous value of the array
		if (snakeMove == true && Main.running == true) {
			for(int i = snakeSize-1;i>0;i--) {
				snakeX[i] = snakeX[i-1];
				snakeY[i] = snakeY[i-1];
			}
		}
	}

}
