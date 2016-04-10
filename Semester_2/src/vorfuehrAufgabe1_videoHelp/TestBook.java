package vorfuehrAufgabe1_videoHelp;

public class TestBook {

	
	public static void main(String[] args) {
		// 2.a Buch anlegen und Basistests durchführen   
		Book myBook = new Book("Andreas Riener", "Sensor-Actuator Supported Implicit Interaction in Driver Assistance Systems", "978-3-8348-0963-6", 2009);
		
		System.out.println(myBook.toString());
		
		myBook.loanBook("Ingrid Stahl");
		System.out.println(myBook.toString());   
		myBook.returnBook();   
		System.out.println(myBook.toString());   
		myBook.loanBook("Andreas");   
		System.out.println(myBook.toString());   
		myBook.returnBook();   
		System.out.println(myBook.toString());
		
		// Ein ausgesondertes Buch kann nicht mehr entlehnt werden!    
		myBook.loanBook("Walter");   
		System.out.println(myBook.toString());   
		myBook.returnBook();   
		System.out.println(myBook.toString());
		
		
		
		// 2.b Prüfung der ISBN-Nummer
		
		// Angabe einer fehlerhaften ISBN-Nummer (die aktuell gespeicherte ISBN-Nummer bleibt)   
		myBook.setIsbn("1-567-67878-1");    
		System.out.println(myBook.getIsbn());   
		// Korrektes aktualisieren der ISBN-Nummer   
		myBook.setIsbn("1-567-67878-5");    
		System.out.println(myBook.getIsbn());
		
		
		// 2.c Prüfen ob 2 Bücher ident sind (Objekte vom Typ Buch; idente ISBN-Nummer)   
		// 2 verschiedene Objekte vom Typ "Book" mit gleicher ISBN: true   
		myBook = new Book("Sensor-Actuator Supported Implicit Interaction in Driver Assistance Systems", "978-3-8348-0963-6", "Andreas Riener", 2009);   
		Book myOtherBook = new Book("Sensor-Actuator Supported Implicit Interaction in Driver Assistance Systems","978-3-8348-0963-6");   
		System.out.println(myBook.equals(myOtherBook));
	}
 
}
