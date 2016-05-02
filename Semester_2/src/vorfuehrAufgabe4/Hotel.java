package vorfuehrAufgabe4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 3
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-04-24
 */
public class Hotel {
	static RoomList roomlist;
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

	public Hotel() {
	}

	public static void main(String[] args) throws IOException {
		roomlist = new RoomList();

		char c = '0';
		System.out.println("*** Hotel-Management System V1.0 ***");
		while (c != 'x') { // 'x' für Exit
			System.out.print("Option wählen (n...neues Zimmer anlegen, b...Zimmer buchen, a...Auschecken/Zimmer freigeben, l...Zimmer auflisten, x...Exit): ");
			c = keyboard.readLine().toCharArray()[0];
			switch (c) {
			case 'n':
				createRoom();
				break;
			case 'b':
				bookRoom();
				break;
			case 'a':
				checkOut();
				break;
			case 'l':
				roomlist.printRooms();
				break;
			default:
			}
		}
	}

	private static void createRoom() throws IOException {
		System.out.println("Neues Zimmer anlegen");
		System.out.print("Bitte Zimmerkategorie angeben (1...Einzelzimmer, 2...Doppelzimmer, 3...Familienzimmer, 4...Suite, S...Seminarraum): ");
		char c = keyboard.readLine().toCharArray()[0];
		Room room = null;
		int roomID=0;
		
		switch (c) {
		case '1':
			room = new SingleRoom(roomID=roomlist.getNewID());
			break;
		case '2':
			room = new TwinRoom(roomID=roomlist.getNewID());
			break;
		case '3':
			room = new FamilyRoom(roomID=roomlist.getNewID());
			break;
		case '4':
			room = new Suite(roomID=roomlist.getNewID());
			break;
		case 'S':
			room = new SeminarRoom(roomID=roomlist.getNewID());
			break;
		
		default:
			System.out.println("Ungültige Eingabe (Zimmerkategorie): " + c);
		}
		if (room != null) {
			roomlist.addRoom(room);
			System.out.println("Zimmer mit Nummer "+roomID+" angelegt.");
		}
	}
	
	private static void bookRoom() throws IOException {
		System.out.println("Zimmer buchen und einchecken");
		System.out.print("Bitte Zimmerkategorie auswählen (1...Einzelzimmer, 2...Doppelzimmer," 
				+ " 3...Familienzimmer, 4...Suite, S...Seminarraum): ");
		char c = keyboard.readLine().toCharArray()[0];
		
		Room room = null;
		switch (c) {
		case '1':
			room = roomlist.getFreeRoom(RoomType.EINZELZIMMER);
			break;
		case '2':
			room = roomlist.getFreeRoom(RoomType.DOPPELZIMMER);
			break;
		case '3':
			room = roomlist.getFreeRoom(RoomType.FAMILIENZIMMER);
			break;
		case '4':
			room = roomlist.getFreeRoom(RoomType.SUITE);
			break;
		case 'S':
			room = roomlist.getFreeRoom(RoomType.SEMINARRAUM);
			break;
		default:
			System.out.println("Ungültige Eingabe (Zimmerkategorie): " + c);
		}
		if (room == null)
			return;
		bookPersons(room);

	}
	
	// Auschecken: Rechnung ausgeben und Zimmer freigeben
	private static void checkOut() throws IOException {
		System.out.print("Bitte Zimmernummer eingeben: ");
		int id = Integer.parseInt(keyboard.readLine());
		Room room = roomlist.getRoom(id);
		if (room == null) {
			System.out.println("Ungültige Zimmernummer eingegeben!");
			return;
		}
		System.out.println(room.receiptClearRoom());
	}

	private static void bookPersons(Room room) throws IOException {
		String userinput;
		String name;
		int age;
		Person[] guests = room.getGuests();
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < guests.length; i++) {
			System.out.println("Name des Gastes " + (i + 1) + " (ENTER für Abbruch): ");
			userinput = keyboard.readLine();
			if (userinput.equals("")) {
				break;
			} else {
				name = userinput;
			}
			
			System.out.print("Alter (Drücken Sie ENTER zum überspringen): ");
			if (userinput.equals("")) {
				break;
			} else {
				age = Integer.parseInt(userinput);
			}
		}
	}
}