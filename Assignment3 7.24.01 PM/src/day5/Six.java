package day5;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Six {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Scanner sc = new Scanner(System.in);
		String s = "";
		while (true) {
			System.out.println("Enter only one character... ");
			char c = sc.next().charAt(0);
			try {
				if (!Character.isAlphabetic(c))
					throw new CharacterException("Invalid Input");
				else
					s += c;
			} catch (CharacterException e) {
				System.out.println(e);
				System.out.println("The String after the exception is : ");
				System.out.println(s);
				break;
			}
		}
	}
}
class CharacterException extends Exception {
	String msg;
	public CharacterException(String msg) {
		super(msg);
		this.msg = msg;
	}
}
