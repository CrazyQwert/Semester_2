package vorfuehrAufgabe4;

/**
 * Einf�hrung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorf�hraufgabe 3
 * DIESE KLASSE IST BEREITS FERTIG IMPLEMENTIERT!
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-04-24
 */
public class RoomNode {
	RoomNode next; // Verweis auf das n�chste Zimmer
	Room room;     // Zimmerobjekt (Typ: konkretes "Room"-Objekt (also SingleRoom, TwinRoom, etc.)
	
	public RoomNode(Room val){
		next=null;
		room=val;
	}
}