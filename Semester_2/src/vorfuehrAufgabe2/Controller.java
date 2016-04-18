package vorfuehrAufgabe2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Controller {
	
	public static void main(String[] args) throws java.io.IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		int minimumPlayers = 2;
		int maxScore = 21;
		String yn = "y";	//String for yes/no answers
		int startScore = 1;
		int score;
		Player activePlayer;
		int maxRounds = 3;
		boolean notYetWon = true;
		int currentDice;
		Dice newDice = new Dice();
		
		
		//change game settings
		System.out.println("Do you want to change the default game settings? (y/n)");
		
		if (keyboard.readLine().equalsIgnoreCase("y")) {
			//setting score needed to win
			System.out.println("Do you want to change the score needed to win? (y/n)");
			if (keyboard.readLine().equalsIgnoreCase("y")) {
				System.out.print("Enter new score: ");
				maxScore = Integer.parseInt(keyboard.readLine());
			}
			//setting rounds to win
			System.out.println("Do you want to change the rounds needed to win? (y/n)");
			if (keyboard.readLine().equalsIgnoreCase("y")) {
				System.out.print("Enter new round limit: ");
				maxRounds = Integer.parseInt(keyboard.readLine());
			} 
		}
		
		
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
		
		while (notYetWon) {
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
			System.out.println();
			System.out.println("Player " + activePlayer.getName() + " wins the round.");
			System.out.println();
			//adding point winner
			PlayerFactory.getPlayer(PlayerFactory.getIndex(activePlayer)).addPoints();
			for (int i = 0; i < PlayerFactory.getPlayerCount(); i++) {
				if (PlayerFactory.getPlayer(i).getPoints() >= maxRounds) {
					notYetWon = false;
					activePlayer.setWinner(true);
					System.out.println(activePlayer.getName() + " has won the game!!!");
				}
			}
			activePlayer = PlayerFactory.getNext(activePlayer);
		}
		
		//statistics
		System.out.println();
		System.out.println("The dice was tossed " + newDice.getDiceTosses() + " times.");
		System.out.println();
		
		PlayerFactory.sort();
		
		for (int i = 0; i < PlayerFactory.getPlayerCount(); i++) {
			int currentMaxScore = 0;
			for (int j = 0; j < PlayerFactory.getPlayerCount(); j++) {
				if(PlayerFactory.getPlayer(j).getPoints() > currentMaxScore) {
					
				}
			}
		}
		
		for (int i = 0; i < PlayerFactory.getPlayerCount(); i++) {
			System.out.println(PlayerFactory.getPlayer(i).getName()
					+ " has scored " + PlayerFactory.getPlayer(i).getPoints()
					+ " time(s)."
					);
			if (PlayerFactory.getPlayer(i).isWinner() == false) {
				System.out.println("The Player would have had to score another "
						+ (maxRounds - PlayerFactory.getPlayer(i).getPoints())
						+ " point(s) to win the game."
						);
			}
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
