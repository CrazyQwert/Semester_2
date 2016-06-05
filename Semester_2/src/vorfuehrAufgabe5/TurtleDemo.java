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

public class TurtleDemo {

	public static void main(String [] args) {

		double l = 110;						// Startseitenlänge
		double a = 60;							// Startwinkel
		boolean color = false;				// wechselt zwischen ROT und BLAU


		Turtle.setPos(0,10);					// Setze Startposition der Turtle

		for (int i = 0; i < 25; i++) {
			// Setzen der Farbe abwechselnd auf ROT und BLAU
			if (color) { Turtle.setColor(Color.RED); } else { Turtle.setColor(Color.BLUE); };
			color = !color;

			Turtle.forward(l);				// Turtle fährt vorwärts die Strecke 'l'
			Turtle.left((int)a);				// Turtle dreht nach links um Winkel 'a'
			l = l * 0.85;						// Strecke wird kürzer
			a = a * 1.1;						// Winkel wird grösser
		}

		Turtle.showGraphics("Turtle-Demo");	// Anzeigen des fertigen Bilds
	}	
}