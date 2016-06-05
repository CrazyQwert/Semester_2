package vorfuehrAufgabe5;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 5 - Weg durch ein Labyrinth (rekursiv)
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-05-19
 */

public class Maze_Skeleton {

	private char[][] maze;  

	private static final int ROWS = 11;
	private static final int COLS = 11;
	private static final int START_X = 1;
	private static final int START_Y = 1;
	private static final int END_X = ROWS-1;
	private static final int END_Y = COLS-1;
	private static final char START_CHAR = 'A';
	private static final char END_CHAR = 'Z';
	private static final char FREE_CHAR = ' ';
	private static final char BLOCKED_CHAR = 'X';
	private static final char WAY_CHAR = '*';
	private static final char VISITED_CHAR = '°';
	
	public Maze_Skeleton() {
		maze = new char[ROWS][COLS];
	}
	
	public Maze_Skeleton(int rows, int cols) {
		if (rows>1 && cols>1)
			maze = new char[rows][cols];
		else {
			maze = new char[ROWS][COLS];
		}
	}

	public void init() {
		for( int i = 0; i < maze.length; i++ ) {
			for( int j = 0; j < maze[i].length; j++ ) {
				// Den Rahmen um das Feld zeichnen (=als blockiert belegen)
				if( i == 0 || j == 0 || i == maze.length - 1 || j == maze[i].length - 1) {	                    
					maze[i][j] = BLOCKED_CHAR;		// blockiert
				} 
				// Innerhalb des Arrays zufällige Felder blockieren
				else if(java.lang.Math.random() > 0.7) { // 0.7 = "Dichte" der belegten Felder (je kleiner, desto voller...)	                    
					maze[i][j] = BLOCKED_CHAR;		// blockiert
				} 
				else {
					maze[i][j] = FREE_CHAR;			// frei
				}			
			} 
		} 

		// Setzen von Start und Ende
		if ((START_X >= 1) && (START_Y >= 1)) {										// Startpunkt
			maze[START_X][START_Y] = START_CHAR;					
		} else {
			maze[1][1] = START_CHAR;				
		}

		if ((END_X<maze.length-2) && (END_Y<maze[maze.length-2].length-2)) {	// Endpunkt
			maze[END_X][END_Y] = END_CHAR;
		} else {
			maze[maze.length-2][maze[maze.length-2].length-2] = END_CHAR;		
		}
	}


	public void printMaze() {
		for( int i = 0; i < maze.length; i++ ) {
			for( int j = 0; j < maze[i].length; j++ ) {
				System.out.print(maze[i][j] + " ");		//changes were made
			} 
			System.out.println();
		} 
	}

	public boolean reachable(int x, int y) {
		
		
		if (maze[x][y] == END_CHAR) {
			return true;				
		}
		
		if (maze[x][y] != BLOCKED_CHAR && maze[x][y] != VISITED_CHAR) {
			maze[x][y] = VISITED_CHAR;
			

			if (reachable(x + 1, y)) {
				
			} else if (reachable(x - 1, y)) {
				
			} else if (reachable(x, y + 1)) {
				
			} else if (reachable(x, y - 1)) {
				
			} else {
				return false;
			}
			
			return true;
			
		} else {
			return false;
		}
		
	} 

	public static void main(String[] args) {
		Maze_Skeleton m = new Maze_Skeleton();
		m.init(); // Initialisierung eines neuen "Irrgartens"
		// zum Testen auskommentieren! (Irrgarten wird überschrieben)
//		m.maze = new char[][] {{'X','X','X','X','X','X','X','X','X','X'},
//                           {'X','A','X',' ',' ','X','X',' ',' ','X'},
//                           {'X',' ',' ',' ',' ',' ','X',' ',' ','X'},
//                           {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
//                           {'X',' ','X','X','X',' ',' ',' ',' ','X'},
//                           {'X','X','X',' ',' ',' ',' ',' ',' ','X'},
//                           {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
//                           {'X',' ',' ',' ',' ',' ',' ','X',' ','X'},
//                           {'X',' ',' ',' ',' ','X','X','X','Z','X'},
//                           {'X','X','X','X','X','X','X','X','X','X'}};
		
		m.printMaze();  // Labyrinth vor dem Suchen des Wegs
		System.out.print("\nWeg von "+ START_CHAR + " nach "+ END_CHAR);
		if (m.reachable(START_X,START_Y)) {
			System.out.println(" möglich!");
		} else {
			System.out.println(" nicht möglich!");
		} 
		m.printMaze(); // Labyrinth nach dem Suchen des Wegs
	}
}
