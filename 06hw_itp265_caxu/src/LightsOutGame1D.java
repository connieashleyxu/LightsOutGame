import java.util.*;
/**
 * 1D version of lights out game
 *
 * @author Connie Xu
 * @version Mar 16, 2021
 * ITP 265, Spring 2021, Coffee Section
 * Email: caxu@usc.edu
 * Homework 06
 *
 */
public class LightsOutGame1D {
	
	//instance vars
	private Light gameLight[];
	private BFF scnr;
	private int numLights;
	
	//main func to play
	public static void main(String args[]){
		LightsOutGame1D myGame = new LightsOutGame1D();
		myGame.play();
	}
	
	//game set up
	public LightsOutGame1D() {
		scnr = new BFF();
		numLights = scnr.inputInt("How many lights would you like to have [3-15]?", 3, 15);
		gameLight = new Light[numLights];
		
		for (int i = 0; i < gameLight.length; i++) {
			gameLight[i] = new Light(getRandBoolean());
		}
		
		printLights();
	}
	
	//print lights
	public void printLights() {
		for (int i = 0; i < gameLight.length; i++) {
			System.out.print(gameLight[i].isOn());
		}
		
		System.out.println();
		
		for (int i = 0; i < gameLight.length; i++) {
			System.out.print((i + 1) + " ");
		}
	}
	
	//get random boolean
	public static boolean getRandBoolean() {
		return Math.random() < 0.5;
	}
	
	//intro game + play
	public void play() {
		System.out.println("Welcome to Lights Out!");
		System.out.println("The objective is to turn all the lights out (turn them to all spaces)");
		System.out.println(gameLight.length);
		boolean checkLightsBoolean = false;
		
		while (checkLightsBoolean == false) {
			printLights();
			System.out.println();
			
			int userInput = scnr.inputInt("Please enter the light number you want to change (or -1 to quit)", -1, gameLight.length);
			
			if (userInput == -1) {
				System.out.println("Goodbye!");
				break;
			}
			
			changeLights(userInput);
			checkLightsBoolean = checkLights();
		}
		
		System.out.println("Gameover!");
	}
	
	//change light based on user input
	private void changeLights(int userInput) {
		if (userInput == 1) {
			gameLight[userInput - 1].flip();
			gameLight[userInput].flip();
		}
		else if (userInput == gameLight.length) {
			gameLight[userInput - 1].flip();
			gameLight[userInput - 2].flip();
		}
		else {
			gameLight[userInput - 2].flip();
			gameLight[userInput - 1].flip();
			gameLight[userInput].flip();
		}
	}
	
	//check for lights
	private boolean checkLights() {
		int numberCorrect = 0;
		
		for (int i = 0; i < gameLight.length; i++) {
			if (gameLight[i].isLightOn() == false) {
				numberCorrect++;
			}
		}
		
		if (numberCorrect == gameLight.length) {
			return true;
		}
		else {
			return false;
		}
	}
}
