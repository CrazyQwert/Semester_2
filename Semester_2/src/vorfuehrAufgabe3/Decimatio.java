package vorfuehrAufgabe3;

public class Decimatio {

	static Person head;  static final int NUMPERSONS = 42; // Josephus plus 41 soldiers  
	static final int STEPWIDTH  = 10; // every 10th is to be killed 
	
	static void assembleRing(int n) {   // ...
		//replace with .add method?
		for (int i = 1; i <= n; i++) {
			System.out.println("Person Nr. " + i + " eingefügt");   // ...
			add();
		}	
	}

	
	static void elimination(int step) {   // ...   
		Person current = Person.getHead();
		Person next = current;
		while (next.getNext().getNext() != next) {
			for (int i = 0; i < step; i++) {
				current = current.getNext();
			}
			current.destroy();
			next = current.getNext();
		}
		System.out.println("Überlebende Personen haben die Nummern " + Person.getHead().getId() 
			+ " und " + Person.getHead().getNext().getId());
	}
	
	public static void main(String args[])  {
		System.out.println("Eliminierung jedes Zehnten (n=" + NUMPERSONS + ")");  
		System.out.println("Aufbau der Ringstruktur...");  
		assembleRing(NUMPERSONS);
		System.out.println("Aufbau fertiggestellt...\n");  
		elimination(STEPWIDTH);
		
	}
	
	public static Person add() {
		
		Person newPerson = new Person();
		
		if (Person.getHead() == null) {
			Person.setHead(newPerson);
		} else if (Person.getHead().hasNext()){
			Person.getHead().getPrevious().setNext(newPerson);
			newPerson.setPrevious(Person.getHead().getPrevious());
			Person.getHead().setPrevious(newPerson);
			newPerson.setNext(Person.getHead());
		} else {
			Person.getHead().setNext(newPerson);
			newPerson.setNext(Person.getHead());
			Person.getHead().setPrevious(newPerson);
			newPerson.setPrevious(Person.getHead());
		}
		return newPerson;
	}
	
}
