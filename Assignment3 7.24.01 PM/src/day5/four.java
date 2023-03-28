package day5;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class four {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);

		LocalTime time = LocalTime.now();
		int seconds, minutes, hours;

		seconds = time.getSecond();
		minutes = time.getMinute();
		hours = time.getHour();
		DigitalClock dc = new DigitalClock(seconds, minutes, hours);

		es.execute(() -> {
			while (true) {
				dc.getSeconds();
			}
		});
		es.execute(() -> {
			while (true) {
				dc.getMinutes();
			}
		});
		es.execute(() -> {
			while (true) {
				dc.getHours();
			}
		});
		es.shutdown();
	}
}

class DigitalClock {
	int seconds;
	int minutes;
	int hours;

	DigitalClock(int seconds, int minutes, int hours) {
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
	}

	synchronized public void getSeconds() {
		if (seconds < 59) {
			for (int i = seconds; i < 59; i++) {
				seconds++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println(hours + ":" + minutes + ":" + seconds);
			}

		}
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("The thread is interrupted...");
		}
	}

	synchronized public void getMinutes() {

		if (seconds == 59) {
			seconds = 0;
			minutes++;
			notifyAll();
		}
		if (seconds < 59) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("the thread is interrupted...");
			}
		}
	}

	synchronized public void getHours() {
		if (minutes == 59) {
			hours++;
			if (hours > 23)
				hours = 0;
			minutes = 0;
			seconds = 0;
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("the thread is interrupted...");
			}
		}
	}
}