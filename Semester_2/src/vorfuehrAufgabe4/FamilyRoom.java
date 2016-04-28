package vorfuehrAufgabe4;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 3
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-04-24
 */
public class FamilyRoom extends Room {
	
	public FamilyRoom(int id){
		this.setId(id);
		this.setRoomType(RoomType.FAMILIENZIMMER);
		this.setPrice(73.99);
		this.setGuests(new Person[4]);
	}
}