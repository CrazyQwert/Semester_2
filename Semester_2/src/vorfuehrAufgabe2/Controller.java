package vorfuehrAufgabe2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.text.html.MinimalHTMLWriter;

public class Controller {
	
	public static void main(String[] args) throws java.io.IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		int minimumPlayers = 2;
		int maxScore = 21;
		String yn = "y";
		int startScore = 1;
		int score;
		int activePlayer = 0;
		int rounds = 3;
		int currentDice;
		Dice newDice = new Dice();
		boolean notYetWon = true;
		
		
		while (yn.equalsIgnoreCase("y") || PlayerFactory.getPlayerCount() < minimumPlayers) {
			System.out.println("There are currently " + PlayerFactory.getPlayerCount() + " player(s).");
			System.out.println("You need at least " + minimumPlayers + " players to play.");
			System.out.println();
			System.out.println("Do you want to add or remove Players? y/n");
			yn = keyboard.readLine();
			if (yn.equalsIgnoreCase("y")) {
				editPlayers();
			}
		}
		
		System.out.println("Spiel wird gestartet ...");
		
		score = startScore;
		
		while (notYetWon) {
			do {
				currentDice = newDice.roll();
				System.out.println("Player " + PlayerFactory.getPlayer(activePlayer).getName() + " gets dice with "
						+ currentDice + " points.");
				activePlayer++;
				if (activePlayer >= PlayerFactory.getPlayerCount()) {
					activePlayer = 0;
				}
				score += currentDice;
				System.out.println("The current score is: " + score);
			} while (score < maxScore);
			System.out.println("Player " + PlayerFactory.getPlayer(activePlayer).getName() + " wins the round.");
			PlayerFactory.getPlayer(activePlayer).addPoints(1);
			notYetWon = false;
		}
		
	} //end main
	
	private static void editPlayers() throws IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		System.out.println("Current Players:");
		for (int i = 1; i <= PlayerFactory.getPlayerCount(); i++) {
			System.out.print("Player [" + i + "]: ");
			System.out.println(PlayerFactory.getPlayer(i - 1).getName());
		}
		
		System.out.println();
		System.out.println("To remove a player type: \"remove <index>\".");
		System.out.println("To add a single player type \"add\"");
		System.out.println("To add mulitple players type \"add <number of Players>\".");
		
		input = keyboard.readLine();
		
		if (input.toLowerCase().lastIndexOf(("add")) > -1) {
			if (input.length() == 3) {
				System.out.print("Player " + (PlayerFactory.getPlayerCount() + 1) + ": ");
				PlayerFactory.createPlayer(keyboard.readLine());
			} else {
				addPlayers(Integer.parseInt(input.substring(4)));
			}
		} else if (input.toLowerCase().lastIndexOf("remove") > -1) {
			PlayerFactory.destroyPlayer(Integer.parseInt(input.substring(7)));
		}
		
		
		
	} //end editPlayers
	
	private static void addPlayers(int quantity) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		int number = PlayerFactory.getPlayerCount() + 1;
		for (int i = 1; i <= quantity; i++) {
			System.out.print("Player " + number + ": ");
			String name = keyboard.readLine();
			PlayerFactory.createPlayer(name);
			number++;
		}
	}

}
