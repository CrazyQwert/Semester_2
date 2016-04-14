package vorfuehrAufgabe2;

import java.util.Comparator;


public class Player {
	
	private String name;
	private int points = 0;
	private boolean winner = false;
	
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
	
	public void addPoints() {
		this.points += 1;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	public boolean isWinner() {
		return this.winner;
	}


	public void sort() {
		for (int i = 0; i < PlayerFactory.getPlayerCount(); i++) {
			for (int j = 0; j < PlayerFactory.getPlayerCount(); j++) {
				if(PlayerFactory.getPlayer(i).points < PlayerFactory.getPlayer(j).points) {
					
				}
			}
		}
	}
}
