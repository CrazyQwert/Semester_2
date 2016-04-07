package vorfuehrAufgabe1;

public class Book {
	
	private String isbn;
	private String title;
	private String author;
	private int year;
	private String condition;
	private String location;
	
	//constructors
	
	public Book(String title, String isbn) {
		this.isbn = isbn;
		this.title = title;
		this.condition = "neu";
		this.location = "Buecherregal";
	}
	
	public Book(String author, String title, String isbn) {
		this(title, isbn);
		this.author = author;
	}
	
	public Book(String author, String title, String isbn, int year) {
		this(title, isbn);
		this.author = author;
		this.year = year;
	}
	
	public Book(String isbn, String title, String author, int year, String location) {
		this(author, title, isbn, year);
		this.location = location;
	}
	
	//setter and getter methods
	
	public void setIsbn(String isbn){
		if (testIsbn(isbn)) {
			this.isbn = isbn;
		}
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setCondition(String condition){
		this.condition = condition;
	}
	
	public String getCondition(){
		return condition;
	}
	
	public void setLoctation(String location){
		this.location = location;
	}
	
	public String getLocation(){
		return location;
	}
	
	
	//methods
	
	boolean equals(Book otherBook) {
		
		boolean isEqual = false;
		
		if (otherBook instanceof Book) {
			if (otherBook.getIsbn().equals(this.getIsbn())) {
				isEqual = true;
			}
		}
		
		
		return isEqual;
	}
	
	/**
	 * blabal
	 * @param isbn
	 * @return
	 */
	boolean testIsbn(String isbn) {
		
		boolean correctIsbn;
		
		int[] isbnNum = new int[13];
		int count = 0;
		int checkDigit;
		int sum = 0;
		int mod;
		
		//read ISBN
		
		for (int i = 0; i < isbn.length(); i++) {
			if (Character.isDigit(isbn.charAt(i))) {
				isbnNum[count] = isbn.charAt(i) - '0';
				count++;
			}
		}
		
		//calculate check digit
		
		if (count == 13) {
			mod = 10;
			for (int i = 0; i < count - 1; i++) {
				if ((i & 1) != 0) {
					//is odd
					isbnNum[i] *= 3;
				}
			} 
		} else {
			mod = 11;
			for (int i = 0; i < count - 1; i++) {
					isbnNum[i] = isbnNum[i] * (i + 1);
				}
		}
		
		for (int i = 0; i < count - 1; i++) {
			sum += isbnNum[i];
		}
		
		if (count == 13) {
			checkDigit = mod - (sum % mod);
		} else {
			checkDigit = sum % mod;
		}
		
		
		//check if check digit is correct
		
		if (isbnNum[count - 1] == checkDigit ) {
			correctIsbn = true;
		} else {
			correctIsbn = false;
			System.out.println("ISBN ist falsch!");
		}
		
		return correctIsbn;
	} //end testIsbn
	
	public void loanBook(String location) {
		
		if (this.location.equalsIgnoreCase("altpapiercontainer") == false) {
			this.location = location;
		} else {
			System.out.println("Buch kann nicht mehr entliehen werden!");
		}
	}
	
	public void returnBook() {
		if (this.location.equalsIgnoreCase("altpapiercontainer") == false) {
			this.location = "Buecherregal";
			if (this.condition.equalsIgnoreCase("neu")) {
				this.condition = "gebraucht";
			} else if (this.condition.equalsIgnoreCase("gebraucht")) {
				this.condition = "ausgesondert";
				this.location = "Altpapiercontainer";
			} 
		}
	}
	
	public String toString() {
		String output = ("Titel: " + this.title + ", "  
				+ "Autor(en): " +  this.author + ", "
				+ "ISBN: " + this.isbn + ", "
				+ "Veröffentlicht: " + this.year + ", "
				+ "Zustand: " + this.condition + ", "
				+ "(Standort: " +this.location + ")"
				);
		
		return output;
	}
	

}
