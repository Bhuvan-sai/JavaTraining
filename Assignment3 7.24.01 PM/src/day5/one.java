package day5;

public class one {
	public static void main(String[] args) {
		myThread1 t1=new myThread1();
		t1.start();
		myThread2 t2=new myThread2();
		t2.start();
	}
}
class myThread1 extends Thread{
	synchronized public void run() {
		for(int i=1;i<100;i+=2) {
			System.out.println("odd-"+i);
		}
	}
}
class myThread2 extends Thread{
	synchronized public void run() {
		for(int i=2;i<100;i+=2) {
			System.out.println("even-"+i);
		}
	}
}