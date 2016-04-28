package vorfuehrAufgabe4;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 3
 * DIESE KLASSE IST BEREITS FERTIG IMPLEMENTIERT!
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-04-24
 */
public class Suite extends Room {
	
	public Suite(int id){
		this.setId(id);
		this.setRoomType(RoomType.SUITE);
		this.setPrice(680.0);
		this.setGuests(new Person[5]);
	}
}