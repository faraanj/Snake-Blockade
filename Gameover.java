//imports java packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//creates a class that handles drawing and events for the End screen
public class Gameover extends JPanel implements ActionListener{
	
	//creates components for the class and initializes values
	private JButton restartButton, exitButton;
	private int screen;
	
	//creates and add buttons to the panel
	public Gameover(int screen){
		restartButton = new JButton("Retart");
		exitButton = new JButton("Exit");
		
		this.setLayout(null);
		
		restartButton.setBounds(18, 675, 185, 64);
		exitButton.setBounds(581, 675, 185, 64);
		
		restartButton.setOpaque(false);
		exitButton.setOpaque(false);
		
		this.add(restartButton);
		this.add(exitButton);
		
		this.screen = screen;
		
		exitButton.addActionListener(this);
		restartButton.addActionListener(this);
	}
	
	//draws the end screen background and score
	public void paint(Graphics g) {
		super.paint(g);
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(getImage(), 0, 0, null);
		g2d.setColor(Color.white);
		g2d.drawRect(18, 675, 185, 64);
		g2d.drawRect(581, 675, 185, 64);
		g2d.setColor(Color.red);
		g2d.setFont(new Font("Helvetica", Font.BOLD, 40));
		g2d.drawString("Score: " + Main.score, 300, 550);
		g2d.dispose();
	}
	
	//handles events for the buttons
	public void actionPerformed(ActionEvent evt) {
		//if exit button is clicked, close screen
		if (evt.getSource()==exitButton) {
			System.exit(0);
			
		}
		//restart button is clicked, switch to menu
		if (evt.getSource()==restartButton) {
			Main.screen = 1;
			Main.screenChange=true;
		}
	}
	
	//gets background image
		public Image getImage() {
			ImageIcon i = new ImageIcon(getClass().getResource("/over.jpg"));
			return i.getImage();
		}
		
		//method sets screen
		public void setScreen(int newScreen) {
			screen = newScreen;
		}
		
		//method gets screen
		public int getScreen() {
			return screen;
		}

}
