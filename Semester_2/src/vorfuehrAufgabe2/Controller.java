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
		Player activePlayer;
		int maxRounds = 3;
		int currentRounds = 0;
		int currentDice;
		Dice newDice = new Dice();
		
		//adding / removing players
		
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
		
		//playing
		
		System.out.println("Spiel wird gestartet ...");
		
		activePlayer = PlayerFactory.getPlayer(1);
		
		while (currentRounds < maxRounds) {
			score = startScore;
			do {
				currentDice = newDice.roll();
				System.out.println("Player " + activePlayer.getName() + " gets dice with "
						+ currentDice + " points.");
				activePlayer = PlayerFactory.getNext(activePlayer);	//next Player
				score += currentDice;
				System.out.println("The current score is: " + score);
			} while (score < maxScore);
			//previous player has won
			activePlayer = PlayerFactory.getPrevious(activePlayer);
			//announcing round winner
			System.out.println("Player " + activePlayer.getName() + " wins the round.");
			System.out.println();
			//adding point winner
			PlayerFactory.getPlayer(PlayerFactory.getIndex(activePlayer)).addPoints();
			currentRounds++;
			activePlayer = PlayerFactory.getNext(activePlayer);
		}
		
		//statistics
		
		for (int i = 0; i < PlayerFactory.getPlayerCount(); i++) {
			System.out.println("The Player has scored " + PlayerFactory.getPlayer(i).getPoints()
					+ "time(s)"
					);
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
			PlayerFactory.destroyPlayer(Integer.parseInt(input.substring(7)) - 1);
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
