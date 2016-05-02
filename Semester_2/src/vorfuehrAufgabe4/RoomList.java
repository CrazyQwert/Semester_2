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
public class RoomList { // Klasse zum Verwalten der Zimmer eines Hotels (einfach, verkettete Liste)
	RoomNode head;

	public RoomList(){
		head=null;
	}

	public void addRoom(Room room){
		RoomNode newRoomNode = new RoomNode(room);
		if (head==null) {head = newRoomNode;} 
		else {
			RoomNode temp = head;
			while (temp.next!=null){
				temp=temp.next;
			}
			temp.next=newRoomNode;
		}
	}

	// Liefert ein freies Zimmer der Kategorie 'roomType' oder 'null' falls nicht verfügbar
	// (entweder kein Zimmer der Kategorie im Hotel oder alle bereits gebucht)
	public Room getFreeRoom(RoomType roomType){
		RoomNode temp = head;

		// Erstes freies Zimmer der Kategorie 'roomType' suchen
		while (temp != null) {
			if (temp.room.getRoomType() == roomType && !temp.room.getBooked())
				break;
			else
				temp = temp.next;
		}

		if(temp == null || temp.room.getRoomType()!= roomType || temp.room.getBooked()){
			System.out.println("Kein Zimmer der Kategorie " + roomType.toString() + " verfügbar.");
			temp = null;
		}
		if (temp == null) 
			return null;

		return temp.room;
	}

	// Liefert eine eindeutige ID für das nächste anzulegende Zimmer
	public int getNewID(){
		int count = 0;
		RoomNode temp = head;
		while (temp!=null){
			temp=temp.next;
			count++;
		}
		return ++count; 
	}

	// Gibt das Zimmer mit der ID 'id' zurück (oder 'null' falls es kein Zimmer mit dieser ID gibt)
	public Room getRoom(int id){
		RoomNode temp = head;
		while (temp != null && temp.room.getId()!=id){
			temp=temp.next;
		}
		if (temp==null) 
			return null;
		return temp.room;
	}

	// Ausgabe einer Liste mit allen Zimmern des Hotels
	// Greift auf die toString()-Methode der Klasse 'Room' zurück
	public void printRooms(){
		RoomNode temp = head;

		while(temp!=null){
			System.out.println(temp.room.toString());
			temp=temp.next;
		}
	}
}	