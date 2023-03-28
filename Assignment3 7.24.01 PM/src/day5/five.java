package day5;

public class five {
	public static void main(String[] args) {
		mt t1= new mt();
		t1.start();
		try{
			t1.start();
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("Finished");
	}
}
class mt extends Thread{
	public void run() {
		System.out.println("Started..");
	}
}