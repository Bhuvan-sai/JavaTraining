package Ex7;

import java.util.Scanner;

public class noOfWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sentence:");
		String sent=sc.nextLine();
		int count=1;
		for(int i=0;i<sent.length();i++) {
			if(sent.charAt(i)==' ') {
				count++;
			}
		}
		System.out.println("No of words in the sentence: "+(count));
	}
}
