package vorfuehrAufgabe2_videoHelp;

public class Player {

	private int points = 0; // Anzahl gewonnener Spiele (dieses Spielers!)
	private String name;
	
	//constructor(s)
	
	Player(String name) {
		this.name = name;
	}

	// setter and getter methods
	
	public void addPoint() {
		this.points += 1;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	
}