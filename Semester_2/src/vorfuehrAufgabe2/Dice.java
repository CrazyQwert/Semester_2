package vorfuehrAufgabe2;

import java.util.Random;

public class Dice {
	
	private int sides;
	private int diceTosses = 0;
	
	//Constructors
	
	public Dice() {
		this.sides = 6;
	}
	
	public Dice(int sides) {
		this.sides = sides;
	}
	
	//setter and getter methods
	
	public void setSides(int sides) {
		this.sides = sides;
	}
	
	public int getSides(){
		return sides;
	}
	
	public void setDiceTosses(int tosses) {
		this.diceTosses = tosses;
	}
	
	public int getDiceTosses() {
		return this.diceTosses;
	}
	

	//methods
	
	public int roll() {
		int number;
		Random randNumber = new Random();
		
		number = randNumber.nextInt(sides) + 1;
		this.diceTosses++;
		
		return number;
	}
	
	

}
