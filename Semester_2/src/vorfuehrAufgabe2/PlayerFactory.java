package vorfuehrAufgabe2;

import java.util.ArrayList;

public class PlayerFactory {
	
	private static ArrayList<Player> playerList = new ArrayList<Player>();
	
	//setter and getter
	
	public static int getPlayerCount() {
		return playerList.size();
	}
	
	public static Player getPlayer(int index) {
		return playerList.get(index);
	}
	
	//methods
	
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
			if (index > playerList.size()) {
				System.out.println("Player does not exist.");
				return null;
			} else {
				if( index + 2 > playerList.size()) {
					return PlayerFactory.getPlayer(0);
				} else {
					return PlayerFactory.getPlayer(index + 1);
				}
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
			if (index > playerList.size()) {
				System.out.println("Player does not exist.");
				return null;
			} else {
				if( index - 1 < 0) {
					return PlayerFactory.getPlayer(playerList.size() - 1);
				} else {
					return PlayerFactory.getPlayer(index - 1);
				}
			}
		} else {
			System.out.println("Player does not exist.");
			return null;
		}
	}

}
