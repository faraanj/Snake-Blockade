/*
Written By: Faraan Javaid
Date: June 18 2021
Application: This snake game helps students review on general OOP concepts
*/

//imports Java packages
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;

//creates a class that handles the main game loop
public class Main extends JFrame implements ActionListener{
	
	//sets screen dimensions
	final static int SCREEN_HEIGHT = 800;
	final static int SCREEN_WIDTH = 800;
	
	//sets screen number to be used to switch screens
	public static int screen = 1;
	
	//used for timer
	private static final long serialVersionUID = 1L;
	
	//initializes boolean logic
	public static boolean running = false;
	public static boolean screenChange = false;
	public static boolean trivia = false;
	
	//initializes some value for the game
	public static String key = "up";
	public static int score = 0;
	public static Color enemyColor;
	public static Color enemy_BColor;
	private Random random = new Random();
	
	//creates objects
	Timer gametimer;
	MainMenu menu;
	Instructions help;
	Gameover over;
	Game game;
	Player snake;
	Enemy enemy;
	BadEnemy enemyB;
	
	//starts game timer and adds the screen
	public Main() {
		setFocusable(true);
		gametimer = new Timer(140, this);
		menu = new MainMenu(screen);
		help = new Instructions(screen);
		game = new Game(screen);
		over = new Gameover(screen);
		gametimer.start(); 
		addScreen(screen);
	}
	
	//function that switches screen
	public void addScreen(int screen) {
		
		//Menu screen
		if (screen == 1) {
			this.setContentPane(menu);
		}
		//help screen
		if (screen == 2) {
			
			this.setContentPane(help);
		} 
		//game screen, certain game values instantiated
		if (screen == 3) {
			
			this.setContentPane(game);
			snake = new Player(400,400);
			enemy = new Enemy(100,100);
			enemyB = new BadEnemy(200,200);
			snake.snakeX[0] = 400;
			snake.snakeY[0] = 400;
			snake.snakeX[1] = 400;
			snake.snakeY[1] = 375;
			snake.snakeX[2] = 400;
			snake.snakeY[2] = 350;
			enemy.score = 0;
			score = 0;
			key = "up";
		}
		//game over screen
		if (screen == 4) {
			
			this.setContentPane(over);
		} 
	}
	
	//draws graphics for the game, trivia, and gameover screen 
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//draws components for the game
		if (screen == 3 && game.inGame == true) {
			
			enemy.draw(g2d);
			enemyColor = enemy.enemyColor[enemy.color];
			enemyB.draw(g2d);
			enemy_BColor = enemyB.enemyColor_b[enemyB.color_B];
			snake.draw(g2d);
			game.draw(g2d);			
		}
		//draws components for the death quiz
		else if (trivia == true ) {
			game.draw(g2d);
			//if the user gets the question right game will continue
			if (key == "left" && game.leftAns == true || key == "right" && game.rightAns == true) {
				trivia = false;
				game.inGame = true;
				game.leftAns = false;
				game.rightAns = false;
				running = true;
				snake.snakeMove = true;
				game.changeQuestion();
				game.changePosition();

			}
			//if user gets the question wrong, game will end
			else if (key == "left" && game.leftAns == false || key == "right" && game.rightAns == false){
				screen = 4;
				running = false;
				addScreen(screen);
				screenChange = false;
				setVisible(true);
				game.inGame = false;
				game.leftAns = false;
				game.rightAns = false;
				trivia = false;
			}
		}
		g2d.dispose();
		
	}
	//when the screen change is true, a new screen is set using the add screen function
	public void actionPerformed(ActionEvent e) {
		if (screen == 1 && screenChange == true) {
			addScreen(screen);
			screenChange = false;
			setVisible(true);
		}
		if (screen == 2 && screenChange == true) {
			addScreen(screen);
			screenChange = false;
			setVisible(true);
		}
		if (screen == 3 && screenChange == true) {
			addScreen(screen);
			screenChange = false;
			setVisible(true);
		}
		if (screen == 4 && screenChange == true) {
			addScreen(screen);
			screenChange = false;
			setVisible(true);
			game.inGame = false;
			running = false;
		}
		
		//key handling while in game
		if (screen == 3 && game.inGame == true) {
			//System.out.println("in game");
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					//System.out.println(e.getKeyCode());
					if (e.getKeyCode() == KeyEvent.VK_UP && key!="down") {
						key = "up";
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN && key!="up") {
						key = "down";
					} else if (e.getKeyCode() == KeyEvent.VK_LEFT && key!="right") {
						key = "left";
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && key!="left") {
						key = "right";
					}
				}
			});
			
			//player updates position
			snake.update();
			
			//checks collision of the snake head with an obstacle containing the correct answer 
			if (enemy.enemyPos[0][enemy.xPos] == snake.snakeX[0] && enemy.enemyPos[1][enemy.yPos] == snake.snakeY[0]) {
				//snake grows, score goes up, obstacles change position, question changes
				snake.snakeSize++;
				enemy.score += 50;
				score = enemy.score;
				
				enemy.xPos = random.nextInt(15);
				enemy.yPos = random.nextInt(21);	
				enemy.color = random.nextInt(4);
				
				enemyB.xPos_B = random.nextInt(15);
				enemyB.yPos_B = random.nextInt(21);	
				enemyB.color_B = random.nextInt(3);
				
				game.changeQuestion();
				game.changePosition();
			}
			//checks collision of the snake head with an obstacle containing the correct answer 
			if (enemyB.enemyPos_B[0][enemyB.xPos_B] == snake.snakeX[0] && enemyB.enemyPos_B[1][enemyB.yPos_B] == snake.snakeY[0]) {
				//player stops moving and trivia screen opens
				snake.snakeMove = false;
				game.inGame = false;
				trivia = true;
				key = "up";
				
				enemy.xPos = random.nextInt(15);
				enemy.yPos = random.nextInt(21);	
				enemy.color = random.nextInt(6);
				enemyColor = enemy.enemyColor[enemy.color];
				
				enemyB.xPos_B = random.nextInt(15);
				enemyB.yPos_B = random.nextInt(21);	
				enemyB.color_B = random.nextInt(6);
				enemy_BColor = enemyB.enemyColor_b[enemyB.color_B];
				
				game.changeQuestion();
				game.changePosition();
				
				
			}
			//checks if the snakes head collides with rest of the body
			for(int i = 1; i<snake.snakeSize; i++) {
				if(snake.snakeX[i] == snake.snakeX[0] && snake.snakeY[i] == snake.snakeY[0] && running == true && snake.snakeMove == true) {
					//game ends
					screen = 4;
					screenChange = true;
					running = false;
				}
			}
			running = true;
		}
		//key listener for trivia question
		if (screen == 3 && trivia == true) {
			//System.out.println("in game");
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					//System.out.println(e.getKeyCode());
					if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
						key = "left";
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						key = "right";
					}
				}
			});
		}
		repaint();
	} 
	//client method that creates the frame
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				Main frm = new Main();
				frm.pack();
				frm.setResizable(false);
				frm.setLocation(400, 0);
				frm.setSize(SCREEN_HEIGHT, SCREEN_WIDTH);
				frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frm.setVisible(true);				
			}
	    });		
	}
}
