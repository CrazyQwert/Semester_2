package vorfuehrAufgabe1_videoHelp;

public class Book {
	
	private String isbn;
	private String title;
	private String authors;
	private int year;
	private String condition;
	private String location;
	
	//constructors
	
	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
		this.condition = "neu";
		this.location = "Buecherregal";
	}
	
	public Book(String title, String isbn, String authors) {
		this(title, isbn);
		this.authors = authors;
	}
	
	public Book(String title, String isbn, String authors, int year) {
		this(title, isbn, authors);
		this.year = year;
	}
	
	public Book(String title, String isbn, String authors, int year, String location) {
		this(title, isbn, authors, year);
		this.location = location;
	}
	
	//setter and getter methods
	
	public void setIsbn(String isbn) {
		
		boolean condition = false;
		int count = 0;
		int[] in = new int[13];
		int sum = 0;
		
		//reading isbn
		for (int i = 0; i < isbn.length(); i++) {
			if (Character.isDigit(isbn.charAt(i))) {
				in[count] = isbn.charAt(i) - '0';
				count++;
			}
		}
		
		//weighting procedure
		if (count == 10) {
			//weighting for isbn-10
			for (int i = 0; i < 9; i++) {
				in[i] *= (i + 1);
			}
		} else {
			//weighting for isbn-13
			for (int i = 1; i <= 12; i++) {
				if ((i % 2) == 0) {
					in[i] *= 3;
				}
			}
		}
		
		
		//building sum of weighted isbn
		for (int i = 0; i < count - 1; i++) {
			sum += in[i];
		}
		
		
		//checking check digit ... I guess ...
		if (count == 10) {
			//checking check digit for isbn-10
			if (in[count - 1] == sum % 11) {
				condition = true;
			} 
		} else {
			//checking check digit for isbn-13
			if (in[count - 1] == 10 - (sum % 10)) {
				condition = true;
			}
		}
		
		
		//setting isbn if check digit is correct
		if (condition) {
			this.isbn = isbn;
		} else {
			System.out.println("Errrp! Fehler! ISBN ist falsch!");
		}
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public String getAuthors() {
		return this.authors;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getCondition() {
		return this.condition;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	//methods
	
	/**
	 * Sets location of Book to defined loaction.
	 * @param location
	 */
	public void loanBook(String location) {
		if (this.condition.equalsIgnoreCase("ausgesondert") == false) {
			this.location = location;
		} else {
			System.out.println("Errrp! Fehler! Ein ausgesondertes Buch" 
					+ "kann nicht ausgeliehen werden!");
		}
	}
	
	public void returnBook() {
		if (this.condition.equalsIgnoreCase("neu")) {
			this.condition = "gebraucht";
		} else if (this.condition.equalsIgnoreCase("gebraucht")) {
			this.condition = "ausgesondert";
			this.location = "Altpapiercontainer";
		}
	}
	
	public String toString() {
		String output;
		output = "Titel: " + title + ", Autor(en): " + authors 
				+ ", ISBN: " + isbn + ", Veröffentlicht: " + year 
				+ ", Zustand: " + condition + ", (Standort: " + location + ")";
		return output;
	}
	
	
	public boolean equals(Object book) {
		
		if (book instanceof Book) {
			if (((Book) book).getIsbn().equals(this.isbn)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
		
	}
}
