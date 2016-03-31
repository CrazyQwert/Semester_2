package vorfuehrAufgabe1;

public class Book {
	
	private String isbn;
	private String title;
	private String author;
	private int year;
	private String condition;
	private String location;
	
	//constructors
	
	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
		this.condition = "neu";
		this.location = "Buecherregal";
	}
	
	public Book(String author, String title, String isbn) {
		this(isbn, title);
		this.author = author;
	}
	
	public Book(String author, String title, String isbn, int year) {
		this(isbn, title);
		this.author = author;
		this.year = year;
	}
	
	public Book(String isbn, String title, String author, int year, String location) {
		this(author, title, isbn, year);
		this.location = location;
	}
	
	//setter and getter methods
	
	public void setIsbn(String isbn){
		this.isbn = isbn;
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
