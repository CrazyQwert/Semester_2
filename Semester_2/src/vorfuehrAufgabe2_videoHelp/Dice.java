package vorfuehrAufgabe2_videoHelp;

import java.util.Random;

public class Dice {

	private int value = 1; // repräsentiert die Augenzahl des Würfels (1-6)	
	private java.util.Random rand = new Random();
	private int moves = 0; // Anzahl der Spielzüge (insgesamt); Definition auch in Controller möglich

	// getter-, setter- und weitere Hilfsmethoden einfügen

	public int getValue() {
		return this.value;
	}
	
	public int getMoves() {
		return this.moves;
	}
	
	// methods
	public int tossDice(){
		value = rand.nextInt(6) + 1;
		this.moves += 1;
		
		return value;
	}
}