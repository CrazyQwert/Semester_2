package vorfuehrAufgabe2_videoHelp;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 2, INKLUSIVE STATISTIK
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-03-18
 */
public class Controller {

	/**
	 * Anzahl der Summe der Augenzahlen in der aktuellen Runde; 
	 * getter/setter-Methoden für den Zugriff von außen verwenden
	 */
	private static int score = 1;
	private static Player[] playerList;
	
	//setter and getter methods
	

	public static void main(String[] args) throws java.io.IOException {
		final int ROUNDS = 10;     // Anzahl der Runden, die ein Spieler für sich entscheiden muß, um das Spiel zu gewinnen
		boolean notEnoughPlayers = true;  // gibt an, ob genug Spieler definiert wurden (mindestens 2 Spieler erforderlich)
		int scoreToWinRound = 21; // kann auch global in Controller definiert werden
		int score = 1;
		boolean notYetWon = true;

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		int playerCount = 0;

		// create players and dice
		
		Dice dice = new Dice();

		while (notEnoughPlayers) {
			System.out.println("Wie viele Spieler sollen angelegt werden? (Mindestens 2)");
			playerCount = Integer.parseInt(keyboard.readLine());
			if(playerCount >= 2) {
				notEnoughPlayers = false;
			}
		}
		
		playerList = new Player[playerCount];
		
		// fetch players, assign names
		for(int i = 1; i <= playerList.length; i++){
			System.out.print("Geben Sie den Namen für Spieler " + i + " ein: ");
			playerList[i - 1] = new Player(keyboard.readLine());
		}
		
		System.out.println();
		System.out.println("Würfelspiel " + scoreToWinRound + " startet jetzt ...");
		
		Player currentP = playerList[0];
		
		while (notYetWon) {
			// start game
			while (score < 21) {
				dice.tossDice();
				currentP = nextPlayer(currentP);
				System.out.println("Spieler " + currentP.getName() 
						+ " erhält den Würfel mit Augenzahl " + dice.getValue());
				System.out.print("Aktuelle Augenzahl " 
						+ dice.getValue() + " zu bisherigem Score " + score + " addiert");
				score += dice.getValue();
				System.out.println(" -> neuer Wert " + score + " Punkte");
			}
			System.out.println();
			currentP.addPoint();
			System.out.println("Spieler " + currentP.getName() 
					+ " gewinnt diese Runde. Insgesamt gewonnene Runden: "
					+ currentP.getPoints() + "!"
					);
			System.out.println();
			score = 0;
			
			for (int i = 0; i < playerList.length; i++) {
				if (playerList[i].getPoints() >= ROUNDS) {
					notYetWon = false;
					System.out.println("Spieler " + playerList[i].getName() + " hat das Spiel gewonnen!");
				}
			}
			
		} // game has ended
		
		// sort players according to their score
		for (int i = 0; i < playerList.length; i++) {
			for (int j = 0; j < playerList.length; j++) {
				if (playerList[j].getPoints() < playerList[i].getPoints()) {
					swap(j, i);
				}
			}
		}
		
		// print statistics
		System.out.println();
		System.out.println("STATISTIK");
		System.out.println();
		System.out.println("Würfelwürfe insgesamt: " + dice.getMoves());
		
		for (int i = 0; i < playerList.length; i++) {
			System.out.print("Gewonnene Runden von " + playerList[i].getName() + ": " 
					+ playerList[i].getPoints()
					);
			if (playerList[i].getPoints() < ROUNDS) {
				System.out.println("\tDifferenz zum Sieger: " 
					+ (ROUNDS - playerList[i].getPoints()));
			} else {
				System.out.println();
			}
		}
		
	}

	
	public static Player nextPlayer(Player givenPlayer) {
		
		int index = 0;
		
		for (int i = 0; i < playerList.length; i++) {
			if(playerList[i] == givenPlayer) {
				index = i;
				break;
			}
		}
		
		if (index > playerList.length - 2) {
			index = 0;
		} else {
			index += 1;
		}
		
		return playerList[index];
	}
	
	public static void swap(int index1, int index2) {
		Player temp;
		temp = playerList[index1];
		playerList[index1] = playerList[index2];
		playerList[index2] = temp;
	}
}



