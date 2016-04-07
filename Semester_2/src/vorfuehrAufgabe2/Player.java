package vorfuehrAufgabe2;

public class Player {
	
	private String name;
	private int points;
	private int playerNumber;
	private boolean hasWon = false;
	
	//constructor
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, int playerNumer) {
		this(name);
		this.playerNumber = playerNumber;
	}
	
	//setter and getter methods
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	public int getPlayerNumber() {
		return this.playerNumber;
	}

}
