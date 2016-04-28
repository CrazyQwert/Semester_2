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
public class SeminarRoom extends Room{
	
	public SeminarRoom(int id){
		this.setId(id);
		this.setRoomType(RoomType.SEMINARRAUM);
		this.setPrice(1200.0);
		// nur die Ansprechperson wird gespeichert
		this.setGuests(new Person[1]);
	}
}