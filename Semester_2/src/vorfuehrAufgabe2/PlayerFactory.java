package vorfuehrAufgabe2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PlayerFactory {
	
	private static List<Player> playerList = new ArrayList<Player>();
	
	//setter and getter
	
	public static int getPlayerCount() {
		return playerList.size();
	}
	
	public static Player getPlayer(int index) {
		return playerList.get(index);
	}
	
	//methods
	
	/**
	 * Creates a new player instance and adds it to the list of players
	 * @param name	name of new player
	 */
	public static void createPlayer(String name) {
		playerList.add(new Player(name));
	}
	
	public static void destroyPlayer(int index) {
		if (index >= 0 && index <= playerList.size()) {
			System.out.println((playerList.get(index)).getName()
					+ " was removed.");
			playerList.remove(index);
		} else {
			System.out.println("No player has the specified index.");
		}
	}
	
	/**
	 * Returns the index of a chosen player-object within the player array.
	 * If there is no such object -1 will be returned.
	 * @param 	player
	 * @return 	index of given player object within the player list as int.
	 * 			If there is no such player -1 gets returned.
	 */
	public static int getIndex(Player player) {
		return playerList.indexOf(player);
	}
	
	
	/**
	 * Returns next object in the list relative to specified object {@link Player} .
	 * @param player	an object of class Player
	 * @return			the next object in the list relative to specified Object
	 */
	public static Player getNext(Player player) {
		int index;
		index = PlayerFactory.getIndex(player);
		if (index > -1) {
			if( index + 2 > playerList.size()) {
				return PlayerFactory.getPlayer(0);
			} else {
				return PlayerFactory.getPlayer(index + 1);
			}
		} else {
			System.out.println("Player does not exist.");
			return null;
		}
	}
	
	/**
	 * Returns previous object in the list relative to specified object {@link Player} .
	 * @param player	an object of class Player.
	 * @return			the previous object in the list relative to specified Object.
	 */
	public static Player getPrevious(Player player) {
		int index;
		index = PlayerFactory.getIndex(player);
		if (index > -1) {
			if( index - 1 < 0) {
				return PlayerFactory.getPlayer(playerList.size() - 1);
			} else {
				return PlayerFactory.getPlayer(index - 1);
			}
		} else {
			System.out.println("Player does not exist.");
			return null;
		}
	}
	
	
	/**
	 * Sorts the list which contains all players by the score of each player.
	 */
	public static void sort() {
		for (int i = 0; i < playerList.size(); i++) {
			for (int j = 0; j < playerList.size(); j++) {
				int p1 = playerList.get(i).getPoints();
				int p2 = playerList.get(j).getPoints();
				if (p1 > p2) {
					Collections.swap(playerList, i, j);
				} else if (p1 == p2) {
					int comp = playerList.get(i).getName()
							.compareToIgnoreCase(playerList.get(j).getName());
					if (comp < 0) {
						Collections.swap(playerList, i, j);
					}
				}
			}
		}
	}
}
