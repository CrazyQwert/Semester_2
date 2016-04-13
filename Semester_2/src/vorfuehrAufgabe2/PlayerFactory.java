package vorfuehrAufgabe2;

import java.util.ArrayList;

public class PlayerFactory {
	
	private static ArrayList<Player> playerList = new ArrayList<Player>();
	
	//setter and getter
	
	public static int getPlayerCount() {
		return playerList.size();
	}
	
	public static Player getPlayer(int index) {
		return (Player) playerList.get(index);
	}
	
	//methods
	
	public static void createPlayer(String name) {
		playerList.add(new Player(name));
	}
	
	public static void destroyPlayer(int index) {
		index -= 1;
		if (index >= 0 && index <= playerList.size()) {
			System.out.println((playerList.get(index)).getName()
					+ " was removed.");
			playerList.remove(index);
		} else {
			System.out.println("No player has the specified index.");
		}
	}

}
