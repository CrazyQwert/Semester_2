package help;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextCompression {
	
	public static void main(String[] args) throws java.io.IOException {
		
		BufferedReader keyboard = new BufferedReader( new InputStreamReader(System.in));
		
		char ch;
		char[] in = new char[500];
		char[] out = new char[256];
		int inLen = 0;
		int outLen = 0;
		boolean notWritten;
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
		for (int i = 0; i < inLen; i++) {
			notWritten = true;
			for (int j = 0; j < outLen; j++) {
				if(out[j] == in[i]) {
					notWritten = false;
					break;
				}
			}
			
			if (notWritten) {
				out[outLen] = in[i];
				outLen++;
			}
		}
		
		//calculate compression rate
		rate = (double)100 - ((100.0 / (double)inLen) * (double)outLen );
		
		
		//output procedure
		System.out.println("Compressed text:");
		for (int i = 0; i < outLen; i++) {
			System.out.print(out[i]);
		}
		System.out.println();
		System.out.print("Compression factor: ");
		System.out.println(rate + "%");
		
	}

}
