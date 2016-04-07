package vorfuehrAufgabe2;

import java.util.Random;

public class Dice {
	
	private int sides;
	
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
	

	//methods
	
	public int generate() {
		int number;
		Random randNumber = new Random();
		
		number = randNumber.nextInt(sides) + 1; //dummy
		
		return number;
	}
	
	

}
