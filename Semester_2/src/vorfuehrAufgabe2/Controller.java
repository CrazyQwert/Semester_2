package vorfuehrAufgabe2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Controller {
	
	public static void main(String[] args) throws java.io.IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		int playerCount;
		String name;
		
		System.out.print("Please enter the number of Players: ");
		playerCount = Integer.parseInt(keyboard.readLine());
		
		for (int i = 0; i < playerCount; i++) {
			name = keyboard.readLine();
			new Player(name);
			
		}
		
	}

}
