//imports java packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//creates a class that handles drawing and events for the Main Menu
public class MainMenu extends JPanel implements ActionListener{

	//creates components for the class and initializes values
	private JButton startButton, helpButton;
	private int screen;
	
	//creates and add buttons to the panel
	public MainMenu(int screen){

		startButton = new JButton("Start");
		helpButton = new JButton("How To Play");
		
		this.setLayout(null);
		
		startButton.setBounds(322, 360, 200, 85);
		helpButton.setBounds(322, 460, 200, 85);
		
		startButton.setOpaque(false);
		helpButton.setOpaque(false);
		
		this.add(startButton);
		this.add(helpButton);
		
		this.screen = screen;
		
		helpButton.addActionListener(this);
		startButton.addActionListener(this);
			
	}
	
	//handles events for the buttons
	public void actionPerformed(ActionEvent evt) {
		//if help button is clicked, switch to instructions
		if (evt.getSource()==helpButton) {
			Main.screen = 2;
			Main.screenChange=true;
		}
		//play button is clicked, switch to game
		if (evt.getSource()==startButton) {
			Main.screen = 3;
			Main.screenChange=true;
		}
	}
	
	//draws the menu background
	public void paint(Graphics g) {
		super.paint(g);
		Graphics g2d = (Graphics2D) g;
		g2d.drawImage(getImage(), 0, 0, null);
		g2d.drawRect(322, 360, 200, 85);
		g2d.drawRect(322, 460, 200, 85);
		g2d.dispose();
	}
	
	//gets background image
	public Image getImage() {
		ImageIcon i = new ImageIcon(getClass().getResource("/Main.jpg"));
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
