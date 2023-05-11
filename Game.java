//import packages
import javax.swing.*;
import java.awt.*;
import java.util.Random;

//creates class that handles the trivia drawing and game background
public class Game extends JPanel {
	
	//initializes boolean logic
	public boolean inGame = true;
	public boolean leftAns = false;
	public boolean rightAns = false;
	public boolean start = true;
	
	//constructs some components
	private JLabel imageBack;
	public Questions quest;
	private Random random = new Random();
	
	//Initializes variable for game
	private int screen;
	private int option = 1;
	
	//sets up the games background
	public Game(int screen) {
		if (start == true) {
			setGame();
			start = false;
		}
		this.screen = screen;
	}

	//creates background image
	public void setGame() { 
		setBackground(Color.gray);
		setFocusable(true);
		quest = new Questions();
		imageBack = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource("/Background.jpg"));
		Image image = img.getImage();
		Image newImage = image.getScaledInstance(800, 800, image.SCALE_SMOOTH);
		img = new ImageIcon(newImage);
		imageBack.setIcon(img);
		imageBack.setOpaque(true);
		imageBack.setBounds(0, 0, 400, 400);	
		this.add(imageBack);
	}
	
	//changes questions using the question class
	public void changeQuestion() {
		if (Main.trivia == true) {
			quest.questionChoice = random.nextInt(4);
		}
		else {
			quest.questionChoice = random.nextInt(9);
		}
	}
	
	//changes the questions position
	public void changePosition() {
		option = random.nextInt(2);
	}
	
	//draws the questions
	public void draw(Graphics g2d) {
		
		//draws the trivia background and questions
		if (Main.trivia == true) {
			g2d.drawImage(getImage(), 0, 0, null);
			g2d.setColor(Color.red);
			g2d.setFont(new Font("Arial", Font.BOLD, 14));
			g2d.drawString( quest.question[quest.questionChoice], 180, 440);
			g2d.setFont(new Font("Arial", Font.PLAIN, 12));
			g2d.drawString("Pless LEFT for answer:", 210, 575);
			g2d.drawString("Press RIGHT for answer", 480, 575);
			//randomizes the position of the answers of the questions
			if (option == 1) {
				g2d.setColor(Color.red);
				g2d.drawString(quest.answers[0][quest.questionChoice] , 240, 590);
				g2d.drawString(quest.answers[1][quest.questionChoice] , 510, 590);
				leftAns = true;
				rightAns = false;
			}
			else {
				g2d.setColor(Color.red);
				g2d.drawString(quest.answers[0][quest.questionChoice] , 510, 590);
				g2d.drawString(quest.answers[1][quest.questionChoice] , 240, 590);
				leftAns = false;
				rightAns = true;
			}
			
		}
		//draws the questions at the bottom of the game frame as well as the score and title at the top
		else {
			g2d.setColor(Color.black);
			g2d.fillRect(0, 25, 980, 100);
			g2d.fillRect(0, 725, 980, 100);
			g2d.setColor(Color.red);
			g2d.setFont(new Font("Helvetica", Font.BOLD, 30));
			g2d.drawString(" Snake Blockade ", 300, 60);
			g2d.setFont(new Font("Helvetica", Font.BOLD, 14));
			g2d.drawString("Score: " + Main.score, 40, 60);
			g2d.setFont(new Font("Arial", Font.PLAIN, 12));
			g2d.drawString( quest.question[quest.questionChoice], 20, 740);
			
			//randomizes the position of the answers of the question
			if (option == 1) {
				g2d.setColor(Main.enemyColor);
				g2d.fillRect(100, 770, 12, 12);
				
				g2d.setColor(Main.enemy_BColor);
				g2d.fillRect(500, 770, 12, 12);
				
				g2d.setColor(Color.red);
				g2d.drawString(quest.answers[0][quest.questionChoice] , 80, 760);
				g2d.drawString(quest.answers[1][quest.questionChoice] , 480, 760);
			}
			else {
				g2d.setColor(Main.enemyColor);
				g2d.fillRect(500, 770, 12, 12);
				
				g2d.setColor(Main.enemy_BColor);
				g2d.fillRect(100, 770, 12, 12);
				
				g2d.setColor(Color.red);
				g2d.drawString(quest.answers[0][quest.questionChoice] , 480, 760);
				g2d.drawString(quest.answers[1][quest.questionChoice] ,  80, 760);
			}
			
		}
		g2d.dispose();
		
	}
	
	//gets the image for the trivia game
	public Image getImage() {
		ImageIcon i = new ImageIcon(getClass().getResource("/Question.jpg"));
		return i.getImage();
	}
	
	// method sets screen
	public void setScreen(int newScreen) {
		screen = newScreen;
	}
	
	//method gets screen
	public int getScreen() {
		return screen;
	}

}

