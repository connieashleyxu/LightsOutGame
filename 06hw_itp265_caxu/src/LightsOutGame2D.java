import java.util.*;
/**
 * lights out game for 2d array
 *
 * @author Connie Xu
 * @version Mar 87, 2021
 * ITP 265, Spring 2021, Coffee Section
 * Email: caxu@usc.edu
 * Homework 06
 *
 */
public class LightsOutGame2D {
	//instance vars
		private Light gameLight[][];
		private BFF scnr;
		private int numLights;
		private String[] alphabet = {"A", "B", "C", "D", "E"};
		
		//main func to play
		public static void main(String args[]){
			LightsOutGame2D myGame = new LightsOutGame2D();
			myGame.play();
		}
		
		//game set up
		public LightsOutGame2D() {
			scnr = new BFF();
			numLights = scnr.inputInt("How many lights would you like to have [3-15]?", 3, 15);
			gameLight = new Light[numLights][numLights];
			
			for (int i = 0; i < numLights; i++) {
				for (int j = 0; j < numLights; j++)
				gameLight[i][j] = new Light(getRandBoolean());
			}
			
			printLights();
		}
		
		//print lights
		public void printLights() {
			for (int i = 0; i < gameLight.length; i++) {
				System.out.print(" ");
				System.out.print(alphabet[i] + "\t");
			}
			
			System.out.println();
			
			int counter = 0;
			for(Light[] x : gameLight) {
				counter++;
				System.out.print(counter);
				
				for (Light i : x) {
					System.out.print(i.isOn() + "\t");
				}
				
				System.out.println("\n");
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
				
				int rowInput = scnr.inputInt("Please enter the row number of the light (or -1 to quit)", -1, gameLight.length);
				String columnLetter = scnr.inputWord("Please enter the column letter of the light:");
				
				int columnInput = 0;
				if (columnLetter.equalsIgnoreCase("A")) {
					columnInput = 0;
				}
				else if (columnLetter.equalsIgnoreCase("B")) {
					columnInput = 1;
				}
				else if (columnLetter.equalsIgnoreCase("C")) {
					columnInput = 2;
				}
				else if (columnLetter.equalsIgnoreCase("D")) {
					columnInput = 3;
				}
				else if (columnLetter.equalsIgnoreCase("E")) {
					columnInput = 4;
				}
				
				int rowTarget;
				int columnTarget;
				
				rowTarget = rowInput;
				columnTarget =columnInput;
				if (checkPosition(rowTarget, columnTarget)) {
					changeLights(rowTarget, columnTarget);
				}
				
				rowTarget = rowInput - 1;
				columnTarget = columnInput;
				if (checkPosition(rowTarget, columnTarget)) {
					changeLights(rowTarget, columnTarget);
				}
				
				rowTarget = rowInput + 1;
				columnTarget = columnInput;
				if (checkPosition(rowTarget, columnTarget)) {
					changeLights(rowTarget, columnTarget);
				}
				
				rowTarget = rowInput;
				columnTarget = columnInput - 1;
				if (checkPosition(rowTarget, columnTarget)) {
					changeLights(rowTarget, columnTarget);
				}
				
				rowTarget = rowInput;
				columnTarget = columnInput + 1;
				if (checkPosition(rowTarget, columnTarget)) {
					changeLights(rowTarget, columnTarget);
				}
				
				if (rowInput == -1) {
					System.out.println("Goodbye!");
					break;
				}
				
				changeLights(rowInput, columnInput);
				checkLightsBoolean = checkLights();
			}
			
			System.out.println("Gameover!");
		}
		
		//check position of lights
		private boolean checkPosition (int rowTarget, int columnTarget) {
			if (rowTarget >= 0 && rowTarget <= gameLight.length && columnTarget >= 0 && columnTarget < numLights) {
				return true;
			}
			else {
				return false;
			}
		}
		
		//change light based on user input
		private void changeLights(int rowInput, int columnInput) {
			gameLight[rowInput][columnInput].flip();
		}
		
		//check for lights
		private boolean checkLights() {
			int numberCorrect = 0;
			
			for (int i = 0; i < gameLight.length; i++) {
				for (int j = 0; j < gameLight[i].length; j++) {
					if (gameLight[i][j].isLightOn() == false) {
						numberCorrect++;
					}
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
