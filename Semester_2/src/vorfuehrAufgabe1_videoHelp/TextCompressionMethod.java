package vorfuehrAufgabe1_videoHelp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextCompressionMethod {
	
	public static int inLen = 0;
	public static int outLen = 0;
	
	public static void main(String[] args) throws java.io.IOException {
		
		BufferedReader keyboard = new BufferedReader( new InputStreamReader(System.in));
		
		char ch;
		char[] in = new char[500];
		char[] outputArray3000 = new char[256];
		
		
		double rate;
		
		
		//reading procedure
		System.out.println("Enter text plox: ");
		
		ch = (char)keyboard.read();
		
		while(ch != '\r') {
			in[inLen] = ch;
			ch = (char)keyboard.read();
			inLen++;
		}
		
		
		//compression procedure
		outputArray3000 = compress(in).clone();
		
		//calculate compression rate
		rate = (double)100 - ((100.0 / (double)inLen) * (double)outLen );
		
		
		//output procedure
		System.out.println("Compressed text:");
		for (int i = 0; i < outLen; i++) {
			System.out.print(outputArray3000[i]);
		}
		System.out.println();
		System.out.print("Compression factor: ");
		System.out.println(rate + "%");
		
	}

	public static char[] compress(char[] source) {
		
		boolean notWritten;
		char[] out = new char[256];
		
		for (int i = 0; i < inLen; i++) {
			notWritten = true;
			for (int j = 0; j < outLen; j++) {
				if(out[j] == source[i]) {
					notWritten = false;
					break;
				}
			}
			
			if (notWritten) {
				out[outLen] = source[i];
				outLen++;
			}
		}
		
		return out;
	}
}
