package vorfuehrAufgabe6;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 6 - Arithmetische Ausdrücke
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-06-02
 */

abstract class ExpressionNode {	

	int value;	//value held by node
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public abstract int compute();
	public abstract void print();

}