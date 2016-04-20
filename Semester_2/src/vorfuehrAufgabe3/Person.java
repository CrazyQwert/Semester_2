package vorfuehrAufgabe3;

public class Person {

	private static Person head = null;
	private boolean isHead;
	private Person next = null;
	private Person previous = null;
	private int id;
	private static int idCounter = 0;
	
	//constructor(s)
	
	Person() {
		this.id = idCounter++;
	}
	
	
	//setter and getter
	
	public static void setHead(Person newHead) {
		head = newHead;
		head.isHead = true;
	}
	
	public static Person getHead() {
		return head;
	}
	
	
	public void setNext(Person person) {
		this.next = person;
	}
	
	public Person getNext() {
		return this.next;
	}
	
	public void setPrevious(Person person) {
		this.previous = person;
	}
	
	public Person getPrevious() {
		return this.previous;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean getIsHead() {
		return this.isHead;
	}
	
	
	//methods
	
	public boolean hasNext() {
		if (this.next != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasPrevious() {
		if (this.previous != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void destroy() {
		//assign new head if this is head
		if (isHead && this.hasNext()) {
			Person.setHead(this.next);
			System.out.println("Head was eliminated.");
		}
		//set new previous for this.next and set new next for this.previous
		if (this.hasNext() && this.hasPrevious()) {
			this.getNext().setPrevious(this.previous);
			this.previous.setNext(this.next);
			System.out.println("Person " + this.id + " was eliminiated.");
		}
	}
	
	
	
}
