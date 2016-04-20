package vorfuehrAufgabe3;

public class Decimatio {

	static Person head;  static final int NUMPERSONS = 41; // Josephus plus 41 soldiers  
	static final int STEPWIDTH  = 10; // every 10th is to be killed 
	
	static void assembleRing(int n) {   // ...
		//replace with .add method?
		for (int i = 1; i <= n; i++) {
			System.out.println("Person Nr. " + i + " eingef�gt");   // ...
			add();
		}	
	}

	
	static void elimination(int step) {   // ...   
		Person current = Person.getHead();
		while (current.getNext().getNext() != current) {
			for (int i = 0; i < step; i++) {
				current = current.getNext();
			}
			current.destroy();
		}
		System.out.println("�berlebende Personen haben die Nummern " + Person.getHead().getId() 
			+ " und " + current.getNext().getId());
	}
	
	public static void main(String args[])  {
		System.out.println("Eliminierung jedes Zehnten (n=" + NUMPERSONS + ")");  
		System.out.println("Aufbau der Ringstruktur...");  
		assembleRing(NUMPERSONS);
		System.out.println("Aufbau fertiggestellt...\n");  
		elimination(STEPWIDTH);
		
		Person current = Person.getHead();
		
		while (current.getNext() != null) {
			System.out.println(current.getId());
			current = current.getNext();
		}
		
		System.out.println(current.getId());
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
