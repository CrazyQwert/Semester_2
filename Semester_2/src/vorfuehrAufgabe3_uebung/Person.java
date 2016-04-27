package vorfuehrAufgabe3_uebung;

public class Person {
	
	private static int idCounter = 1;
	
	private Person next = null;
	private int id;
	
	//constructor
	public Person() {
		this.id = idCounter++;
	}
	
	//getter and setter
	public Person getNext() {
		return this.next;
	}
	
	public void setNext(Person next) {
		this.next = next;
	}
	
	public int getId() {
		return this.id;
	}

}
