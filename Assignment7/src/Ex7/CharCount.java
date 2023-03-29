package Ex7;

import java.io.IOException;

public class CharCount {
	public static void main(String[] args) throws IOException {
		int count = 0;
		while (true) {
			int input = System.in.read();
			if (input == -1) {
				break;
			}
			count++;
		}
		System.out.println("Total characters entered: " + count);
	}
}