package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class two {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		String msg = "[ ------Message------ ]";

		es.execute(() -> {
			getMessage(msg.substring(0, 8));
		});
		es.execute(() -> {
			getMessage(msg.substring(8, 15));
		});
		es.execute(() -> {
			getMessage(msg.substring(15, 23));
		});
		es.shutdown();
	}
	synchronized static void getMessage(String message) {
		for (int i = 0; i < message.length(); i++) {
			System.out.print(message.charAt(i));
		}
	}
}