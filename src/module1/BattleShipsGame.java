/* Microsoft: DEV277x Object Oriented Programming in Java
 * 
 * Module 1 Project - Battle Ships
 * 
 * STEP 1 – CREATE THE OCEAN MAP
 * STEP 2 – DEPLOY PLAYER’S SHIPS
 * Step 3 – Deploy computer’s ships
 * STEP 4 – BATTLE
 * STEP 5 - GAME OVER
 * 
 */
package module1;

import java.util.Scanner;

public class BattleShipsGame {

	public static String[][] oceanMap = new String[12][16];
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		intro();
		printOceanMap();
		deployPlayerShips();

	}

	public static void intro() {
		System.out.println("**** Welcome to Battle Ships game ****");
		System.out.println();
		System.out.println("Right now, the sea is empty.");
		System.out.println();
		oceanMap();
	}

	public static void oceanMap() {
		// set all grid's value from null to 0.
		for (int i = 0; i < oceanMap.length; i++) {
			for (int j = 0; j < oceanMap[i].length; j++) {
				oceanMap[i][j] = " ";
			}
		}
		// set upper and bottom "0123456789".
		for (int i = 0; i < 10; i++) {
			oceanMap[0][i + 3] = Integer.toString(i); // convert Integer i to String i by using "Integer.toString(i)".
			oceanMap[11][i + 3] = Integer.toString(i);
		}
		// set left and right side.
		for (int i = 1; i < (oceanMap.length - 1); i++) {
			for (int j = 0; j < oceanMap[i].length; j++) {
				oceanMap[i][0] = Integer.toString(i - 1);
				oceanMap[i][13] = oceanMap[i][2];
				oceanMap[i][2] = "|";
				oceanMap[i][15] = oceanMap[i][0];
			}
		}
	}

	public static void printOceanMap() {
		for (int i = 0; i < oceanMap.length; i++) {
			for (int j = 0; j < oceanMap[i].length; j++) {
				System.out.print(oceanMap[i][j]);
			}
			System.out.println();
		}

	}

	public static void deployPlayerShips() {
		// DEPLOY PLAYER’S SHIPS
		System.out.println();
		System.out.println("Deploy your ships: ");

		for (int i = 0; i <= 5; i++) {
			System.out.print("Enter X coordinate for your ship: ");
			int x = input.nextInt();
			System.out.print("Enter Y coordinate for your ship: ");
			int y = input.nextInt();
			oceanMap[x][y] = "@";
		}
		printOceanMap();

	}

	public static void deployComputerShips() {
		// DEPLOY COMPUTER’S SHIPS

	}

	public static void battle() {

	}

}
