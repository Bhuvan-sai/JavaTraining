package patterns;

public class singleton {
	public static void main(String[] args) {
		Singletonn instance = Singletonn.getInstance();
		System.out.println(instance);
		Singletonn instance1 = Singletonn.getInstance();
		System.out.println(instance1);
	}
}
class Singletonn {
	private static Singletonn instance; 
	private Singletonn(){}
	public static synchronized Singletonn getInstance() {
		if(instance == null) {
			instance = new Singletonn();
		}
		return instance;
	}
}