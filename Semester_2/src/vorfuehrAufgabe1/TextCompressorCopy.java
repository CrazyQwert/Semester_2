package vorfuehrAufgabe1;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextCompressorCopy {
	
	public static int count = 0;
	public static int countOut = 0;
	
	
	public static void main(String[] args) throws java.io.IOException {
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		int inLen;
		char[] in = new char[500];
		char[] out = new char[256];
		char tempIn;
		
		
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
		out = compress(in);
		
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
	
	/**
	 * removes duplicate letters from a char array.
	 * @param source char array duplicates are to be removed from
	 * @return compressed char array
	 */
	public static char[] compress (char[] source) {
		boolean na;
		char out[] = new char[source.length];
		
		for (int i = 0; i < count; i++) {
			na = true;
			for(int j = 0; j < countOut; j++) {
				if (source[i] == out[j]) {
					na = false;
				}
			}
			if (na) {
				out[countOut] = source[i];
				countOut++;
			}
		}
		return out;
	}

}