package vorfuehrAufgabe5;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 5 - Demonstrationsbeipiel zu Turtle-Grafik (iterativ)
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-05-19
 */

import java.awt.Color;

public class SnowFlake_Skeleton {

	private static final int DEFAULT_DEPTH = 5;
	private static final int DEFAULT_SIZE = 100;
	private static final Color [] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.GREEN, Color.GRAY, Color.CYAN, Color.BLACK,Color.YELLOW};

	private int depth;
	private double size;

	SnowFlake_Skeleton(int size, int depth) {
		if (size <= 0) {
			this.size = DEFAULT_SIZE;
		} else {
			this.size = size;
		}
		if (depth <= 0) {
			this.depth = DEFAULT_DEPTH;
		} else {
			this.depth = depth;
		}
	}

	public static void main (String [] args) {

		// Initiale Ausrichtung der Turtle setzen
		Turtle.left(90);

		// 5 Schneeflocken mit unterschiedlicher Rekursionstiefe generieren/zeichnen
		SnowFlake_Skeleton snowflake0 = new SnowFlake_Skeleton(55, 1);
		
		SnowFlake_Skeleton snowflake1 = new SnowFlake_Skeleton(55, 6);
		SnowFlake_Skeleton snowflake2 = new SnowFlake_Skeleton(50, 6);
		SnowFlake_Skeleton snowflake3 = new SnowFlake_Skeleton(60, 5);
		SnowFlake_Skeleton snowflake4 = new SnowFlake_Skeleton(60, 3);
		SnowFlake_Skeleton snowflake5 = new SnowFlake_Skeleton(30, 2);

		// Schneeflocken an unterschiedlichen Positionen anzeigen
		snowflake0.drawAt(250, 250);
		
		snowflake1.drawAt(250,250);
		snowflake2.drawAt(100,150);
		snowflake3.drawAt(350,400);
		snowflake4.drawAt(50,300);
		snowflake5.drawAt(450,220);

		Turtle.showGraphics("Leise pieselt das Reh");		
	}

	public void drawAt(int x, int y) {
		Turtle.setPos(x,y);

		// Schneeflockezeichnen initialisieren (erste Rekursionsebene)
		this.draw(size, depth);   // Zeichnet je 3 Arme; hier: obere Hälfte
		Turtle.left(180);
		this.draw(size, depth);	  // Zeichnet je 3 Arme; hier: untere Hälfte
		// auf Ursprungsorientierung setzen
		Turtle.left(180);
	}

	private void draw(double length, int depth) {
		if (depth > 0) {
			// TODO: Rekursives Zeichnen von 3 Armen mit Länge 'length' im Winkel -60, 0, 60 Grad (Verwendung der Methode drawArm(...))
			//       Achtung: Für korrekte Funktion ist der Winkel vor verlassen auf den ursprünglichen Winkel zu setzen!
			Turtle.left(-60);
			drawArm(length, depth);
			Turtle.left(60); //-60 + 60 = 0
			drawArm(length, depth);
			Turtle.left(60);
			drawArm(length, depth);
			Turtle.left(-60);
		}
	}

	private void drawArm(double length, int depth) {
		setColor(depth);
		Turtle.forward(length);
		draw(length * 0.4, depth - 1);
		Turtle.left(180);
		setColor(depth);
		Turtle.forward(length);
		Turtle.left(180);
	}

	static Color getColor(int value) {
		Color c =  color[((value) % color.length)];
		return c;
	}

	private void setColor(int cc) {
		Turtle.setColor((getColor((depth-cc))));
	}
}
