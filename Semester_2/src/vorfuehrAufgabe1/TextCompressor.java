package vorfuehrAufgabe1;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextCompressor {
	
	
	public static void main(String[] args) throws java.io.IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		char[] in = new char[500];
		char[] out = new char[256];
		char tempIn;
		int count = 0;
		
		
		//read procedure
		System.out.println("Please enter text which is to be \"compressed\":");
		tempIn = (char)keyboard.read();
		
		while (tempIn != '\r') {
			in[count] = tempIn;
			tempIn = (char)keyboard.read();
			count++;
		}
		
		
		//test
		System.out.println();
		System.out.print("Characters put in: ");
		System.out.println(count);
		
		
		//compression procedure
		boolean na;
		int countOut = 0;
		
		for (int i = 0; i < count; i++) {
			na = true;
			for(int j = 0; j < countOut; j++) {
				if (in[i] == out[j]) {
					na = false;
				}
			}
			if (na) {
				out[countOut] = in[i];
				countOut++;
			}
		}
		
		//calculating "compression rate"
		double rate;
		rate = 100 - (100.0 / (double)count) * (double)countOut;
		
		//test
		System.out.print("Characters put out: ");
		System.out.println(countOut);
		
		//output procedure
		System.out.println();
		System.out.println("\"Compression\" rate: ");
		System.out.println(rate + "%");
		System.out.println();
		
		System.out.print("Output: ");
		for (int i = 0; i < countOut; i++) {
			System.out.print(out[i]);
		}
		
		
	}

}