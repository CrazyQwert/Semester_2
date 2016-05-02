package vorfuehrAufgabe4;

public abstract class Room {

	private RoomType roomtype;
	private double price;
	private int id;
	private Person[] guests;
	boolean booked = false;
	int daysBooked;
	
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
		this.guests = guests;
	}
	
	public boolean getBooked() {
		return booked;
	}
	
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	//methods
	
	public boolean book(Person[] guests, int days) {
		if (booked) {
			return false;
		} else {
			this.guests = guests;
			this.daysBooked = days;
			this.booked = true;
			return true;
		}
	}
	
	public double calcPrice() {
		double multi = 0;
		for (int i = 0; i < guests.length; i++) {
			if (guests[i] != null) {
				if (guests[i].isKid()) {
					multi += 0.5;
				} else {
					multi += 1;
				}
			}
		}
		return price * multi * daysBooked;
	}
	
	public String receiptClearRoom() {
		String receipt = "Rechnung für Gast " + guests[0].getName() + ": " + calcPrice()
			+ " für " + roomtype;
		this.booked = false;
		this.guests = null;
		this.daysBooked = 0;
		return receipt;
	}
	
	public String toString() {
		String output = "Zimmernummer " + id + " (Kategorie: " + roomtype + ")";
		
		if (booked && guests.length > 1) {
			output += " belegt von Gästen ";
			for (int i = 1; i < guests.length; i++) {
				output += guests[i].getName() + " ";
			}
			output += "und " + guests[guests.length - 1] + ".";
		} else if (booked) {
			output += "belegt von Gast " + guests[0].getName();
		} else {
			output += " nicht belegt.";
		}
		
		return output;
	}
}
