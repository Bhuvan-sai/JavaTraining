package day5;

public class Seven {

	public static void main(String[] args) {
		CountingThread countingThread = new CountingThread();
        countingThread.start();
	}

}

class CountingThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            if (i % 10 == 0) {
                System.out.println("Finished counting " + i+" numbers");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}