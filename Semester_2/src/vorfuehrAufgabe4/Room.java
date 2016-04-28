package vorfuehrAufgabe4;

public abstract class Room {

	private RoomType roomtype;
	private double price;
	private int id;
	private Person[] guests;
	
	//getter and setter
	public RoomType getRoomType() {
		return this.roomtype;
	}
	
	public void setRoomType(RoomType roomtype) {
		this.roomtype = roomtype;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Person[] getGuests() {
		return this.guests;
	}
	
	public void setGuests(Person[] guests) {
		this.guests = guests.clone();
	}
	
	
}
