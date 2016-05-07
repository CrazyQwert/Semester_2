package vorfuehrAufgabe3_videoHelp;

import java.io.*;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 3
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-04-12
 */
public class Texteditor  {
	static ListOfLines list;

	// Einlesen der Datei
	public static boolean readFromFile(String filename) throws IOException {
		String line;
		list = new ListOfLines();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			do
			{
				line = br.readLine();
				list.append(line);
			} while (br.ready() && br != null);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Einlesen von Datei " +filename + " abgeschlossen!");
		return true;
	} // readFromFile

	// Ausgabe der linearen Liste von Zeilen (=Inhalt der Textdatei)
	public static void printDataStructure()
	{ 

		if (!list.empty()) { // Liste ist nicht leer, d.h. enthält Zeilen
			// Ausgabe der einzelnen Listenelemente (=Zeilen)
			list.setCurr(list.getHead());
			while (list.getCurr() != list.getTail()) {
				System.out.println(list.getCurr().getContent());
				list.setCurr(list.getCurr().getNext());
			}
			System.out.println(list.getTail().getContent());
			
			System.out.println("Ausgabe beendet.");
		}
	} // printDataStructure

	// Hauptprogramm
	public static void main(String[] args) throws IOException {
		if (readFromFile("c:\\test.txt"))
			printDataStructure();
	}
} 