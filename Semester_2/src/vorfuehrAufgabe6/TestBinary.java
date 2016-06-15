package vorfuehrAufgabe6;

/**
 * Einführung in die Softwareentwicklung 2 (ESE2), SS2016
 * Vorführaufgabe 6 - Arithmetische Ausdrücke
 * 
 * @author  Andreas Riener, Technische Hochschule Ingolstadt (THI)
 * @email   andreas.riener@thi.de
 * @version 2016-06-02
 */

public class TestBinary {

	public static void main (String[] args)	{
			
		// a+(b-c*d)/e
		// 2+(3-6*12)/8 -> -6
	
		IntegerNode a  = new IntegerNode(2);
		IntegerNode b  = new IntegerNode(3);
		IntegerNode c  = new IntegerNode(6);
		IntegerNode d  = new IntegerNode(12);
		IntegerNode e  = new IntegerNode(8);
		
		MultNode mult = new MultNode(c, d);
		SubNode minus = new SubNode (b, mult);
		DivNode div   = new DivNode (minus, e);
		AddNode plus  = new AddNode (a, div);
		
		plus.print();
		System.out.println(" = " +plus.compute());
		
		a  = new IntegerNode(2);
		b  = new IntegerNode(-30);
		c  = new IntegerNode(2);
		d  = new IntegerNode(12);
		e  = new IntegerNode(21);
		IntegerNode f  = new IntegerNode(7);

		// ( a - b ) * c + d * e / f
		// ( 2 - (-30) ) * 2 + 12 * 21 / 7 -> 100
		
		minus = new SubNode(a, b);
		mult = new MultNode(minus, c);
		div = new DivNode(e, f);
		MultNode mult2 = new MultNode(d, div);
		plus = new AddNode(mult, mult2);
		
		plus.print();
		System.out.println(" = " + plus.compute());
		
		
	}
}