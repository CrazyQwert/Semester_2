package vorfuehrAufgabe3_uebung;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 3
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-04-12
 */
public class Eliminate_Tenth {

	static Person head;
	static final int NUMPERSONS = 42; // Josephus plus 41 Soldaten
	static final int STEPWIDTH  = 10; // Jeder 10. soll eleminiert werden

	static void assembleRing(int n) {
		
		Person current = new Person();
		System.out.println("Person Nr. 1 eingefügt");
		if (head == null) {
			head = current;				
		}
		current.setNext(head);
		
		Person previous;
		
		for (int i = 1; i < n; i++) {
			previous = current;

			current = new Person();
			System.out.println("Person Nr. " + (i + 1) + " eingefügt");
			
			previous.setNext(current);
			current.setNext(head);
		}
		
	}

	static void elimination(int step) {
		Person current = head;
		while (current.getNext().getNext() != current) {
			for (int i = 2; i < step; i++) {
				current = current.getNext();
			}
			System.out.println("Person Nr. " + current.getNext().getId() + " wurde eliminiert.");
			if (current.getNext() == head) {
				head = current.getNext().getNext();
			}
			current.setNext(current.getNext().getNext());
			current = current.getNext();
			
		}
		
		System.out.println("Überlebende Personen haben die Nummern " + head.getId() + " und " + head.getNext().getId());
	}

	public static void main(String args[]){
		System.out.println("Eliminierung jedes Zehnten (n=41)");

		System.out.println("Aufbau der Ringstruktur...");
		assembleRing(NUMPERSONS);
		
	
		System.out.println("Aufbau fertiggestellt...\n");
		elimination(STEPWIDTH);
	} 
} // End of class EliminateTenth
