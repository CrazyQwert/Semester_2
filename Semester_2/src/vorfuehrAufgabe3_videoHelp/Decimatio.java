package vorfuehrAufgabe3_videoHelp;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 3
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-04-12
 */
public class Decimatio {

	static Person head;
	static final int NUMPERSONS = 42; // Josephus plus 41 Soldaten
	static final int STEPWIDTH  = 10; // Jeder 10. soll eleminiert werden

	static void assembleRing(int n) {
		Person curr;
		Person prev = null;
		for (int i = 0; i < n; i++) {
			curr = new Person();
			if (prev != null) {
				prev.setNext(curr);
			}
			if (head == null) {
				head = curr;
			}
			curr.setNext(head);
			System.out.println("Person Nr. " + curr.getId() + " eingefügt");
			
			prev = curr;
			
		}
		
	}

	static void elimination(int step) {
		
		Person curr = head;
		while (curr.getNext().getNext() != curr) {
			for (int i = 1; i < step; i++) {
				curr = curr.getNext();
			}
			curr = curr.destory();
		}
		System.out.println("Überlebende Personen haben die Nummern " 
				+ head.getId() + " und " + head.getNext().getId());
	} 

	public static void main(String args[]) {
		System.out.println("Eliminierung jedes Zehnten (n=41)");

		System.out.println("Aufbau der Ringstruktur...");
		assembleRing(NUMPERSONS);
		
		System.out.println("Aufbau fertiggestellt...\n");
		elimination(STEPWIDTH);
	} 
} // End of class EliminateTenth
