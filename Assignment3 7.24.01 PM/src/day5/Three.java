package day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Three {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		InventorySystem inventory=new InventorySystem();
		es.execute(()->{
			for(int i=0;i<4;i++) {
				inventory.producer();
			}
		});
		es.execute(()->{
			for(int i=0;i<4;i++) {
				inventory.consumer();
			}
		});
		es.shutdown();
	}
}
class InventorySystem{
	private int totalProducts=0;
	synchronized public void producer() {
		if(totalProducts==1) {
			try {wait();}catch(Exception e) {}
		}
		totalProducts += 1;
		System.out.println("Added a product, totalProducts no of products in inventory: "+totalProducts);
		notify();
	}
	synchronized public void consumer() {
		if(totalProducts==0) {
			try {wait();}catch(Exception e) {}
		}
		totalProducts-=1;
		System.out.println("Consumed a product, totalProducts no of products in inventory: "+totalProducts);
		notify();
	}
}

