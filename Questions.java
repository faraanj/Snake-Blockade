//import java packages
import java.awt.*;
import java.util.Random;

//class that creates questions and answers
public class Questions {
	
	//creates an array of questions
	public String[] question = 
		{"_____ variables are used to store the state of an object ",
		 "A _____ is a description of a kind of object",
		 "What is another name for creating an object?",
		 "A(n)_____ class is a class which cannot be instantiated",
		 "_______ is when a single variable is used with several different types of related objects at different places in a program",
		 "_____ is a private constant pointer that points to the current instance of a class and only can be accessed by the class itself",
		 "A(n) _____ is a single instance of a class created by invoking the constructors of the class",
		 "_______ is a mechanism to package the data and its operations inside one structure",
		 "When a member of a class is declared _____ it can be used only in methods that are members of that class"
		 };
	
	//creates a random variable and initializes a question randomizer
	private Random random = new Random();
	public int questionChoice = random.nextInt(9);
	
	//creates an array of correct and incorrect answers
	public String[][] answers = {{"Instance","class","Instantiation","abstract","Polymorphism","'this'","object","Escapulation","private"},
								 {"Integer","data type", "Constructing","closed","Overriding","'that'","method","Packaging","public"}};
	

}
