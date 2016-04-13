package vorfuehrAufgabe2;

public class Player {
	
	private String name;
	private int points = 0;
	private boolean hasWon = false;
	
	//constructor
	
	public Player(String name) {
		this.name = name;
	}
	
	
	//setter and getter methods
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
	
	public int getPoints() {
		return this.points;
	}

}
