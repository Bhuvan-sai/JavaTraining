package Ex7;

import java.util.Scanner;

public class noOfWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sentence:");
		String sent=sc.nextLine();
		String[] words=sent.split("\\s");

		System.out.println("No of words in the sentence: "+(words.length));
	}
}
