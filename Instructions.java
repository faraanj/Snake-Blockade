//imports java packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//creates a class that handles drawing and events for the Instructions
public class Instructions extends JPanel implements ActionListener{
	
	//creates components for the class and initializes values
	private JButton startButton, backButton;
	private int screen;
	
	//creates and add buttons to the panel
	public Instructions(int screen) {
		startButton = new JButton("Retart");
		backButton = new JButton("back");
		
		this.setLayout(null);
		
		startButton.setBounds(592, 30, 150, 75);
		backButton.setBounds(40, 30, 150, 75);
		
		startButton.setOpaque(false);
		backButton.setOpaque(false);
		
		this.add(startButton);
		this.add(backButton);
		
		this.screen = screen;
		
		backButton.addActionListener(this);
		startButton.addActionListener(this);
		
	}
	//draws the instructions background
	public void paint(Graphics g) {
		super.paint(g);
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(getImage(), 0, 0, null);
		g2d.drawRect(40, 30, 150, 75);
		g2d.drawRect(592, 30, 150, 75);
		g2d.dispose();
	}
	
	//handles events for the buttons
	public void actionPerformed(ActionEvent evt) {
		//if back button is clicked, switch to menu
		if (evt.getSource()==backButton) {
			Main.screen = 1;
			Main.screenChange=true;	
		}
		//play button is clicked, switch to game
		if (evt.getSource()==startButton) {
			Main.screen = 3;
			Main.screenChange=true;
		}
	}
	
	//gets background image
	public Image getImage() {
		ImageIcon i = new ImageIcon(getClass().getResource("/Help.jpg"));
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
