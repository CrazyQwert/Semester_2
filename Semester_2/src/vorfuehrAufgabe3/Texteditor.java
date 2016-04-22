package vorfuehrAufgabe3;

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

	//reading the file
	public static boolean readFromFile(String filename) throws IOException {
		String line;
		list = new ListOfLines();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			do {
				line = br.readLine();
				list.append(line);
			} while (br.ready() && br != null);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Einlesen von Datei " + filename + " abgeschlossen!");
		return true;
	} //end of readFromFile

	//printing linear list of lines
	public static void printDataStructure()
	{ 
		if (!list.empty()) { //check whether list is empty
			while (list.getNext() != list.getTail()) {
				System.out.println(list.getCurrent().getContent());
			}
			System.out.println("Ausgabe beendet.");
		}
	} //end of printDataStructure

	//main program
	public static void main(String[] args) throws IOException {
		if (readFromFile("c:\\test.txt"))
			printDataStructure();
	}
} 