package vorfuehrAufgabe3_videoHelp;

public class Person {
	
	static int idCounter = 1;
	
	private Person next;
	private int id;
	
	//constructor(s)
	
	public Person() {
		this.id = idCounter;
		idCounter++;
	}
	
	//setter and getter
	
	public Person getNext() {
		return this.next;
	}
	
	public void setNext(Person next) {
		this.next = next;
	}
	
	public int getId() {
		return this.id;
	}
	
	//methods
	
	public Person destroy() {
		Person curr = Decimatio.head;
		while(curr.getNext() != this) {
			curr = curr.getNext();
		}
		if (this == Decimatio.head) {
			Decimatio.head = this.next;
		}
		curr.setNext(this.getNext());
		
		System.out.println(this.id + " wurde gelöscht.");
		
		return this.next;
	}

}
