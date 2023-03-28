package day5;


public class Eight {
	public static void main(String[] args) {

		StringBuffer stringbfr = new StringBuffer("A");

		ThreadClass1 obj1 = new ThreadClass1(stringbfr);
		ThreadClass1 obj2 = new ThreadClass1(stringbfr);
		ThreadClass1 obj3 = new ThreadClass1(stringbfr);

		obj1.start();
		obj2.start();
		obj3.start();
	}
}
class ThreadClass1 extends Thread {
	StringBuffer strbfr;
	ThreadClass1(StringBuffer stringbfr) {
		strbfr = stringbfr;
	}
	@Override
	public void run() {
		synchronized (strbfr) {
			for (int i = 1; i <=100; i++) {
				System.out.print(strbfr);
			}
			System.out.println();
			char c=strbfr.charAt(0);
			c++;
			String local=Character.toString(c);
			strbfr.replace(0, 1, local);
		}
	}
}