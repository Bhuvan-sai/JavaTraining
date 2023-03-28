package patterns;
class Light {
	public void turnOn( ) {
		System.out.println("Light is on ");
	}
	public void turnOff( ) {
		System.out.println("Light is off");
	}
}
class Switch {
	private Command UpCommand, DownCommand;
	public Switch( Command Up, Command Down){
		UpCommand=Up; 
		DownCommand=Down;
	}
	void flipUp( ) { 
		UpCommand.execute() ;                         
	}
	void flipDown( ) {
		DownCommand.execute();
	}
}
class LightOnCommand implements Command{
	private Light myLight;
	public LightOnCommand(Light L){
		myLight = L;
	}
	public void execute(){
		myLight.turnOn();
	}
}
class LightOffCommand implements Command{
	private Light myLight;
	public LightOffCommand(Light L){
		myLight = L;
	}
	public void execute(){
		myLight.turnOff();
	}
}
public class CommandPattern{
	public static void main(String[] args){
		Light  testLight = new Light( );
		LightOnCommand testLOC = new LightOnCommand(testLight);
		LightOffCommand testLFC = new LightOffCommand(testLight);
		Switch testSwitch = new Switch( testLOC,testLFC);       
		testSwitch.flipUp( );
		testSwitch.flipDown( );
	}
}
interface Command{
	public abstract void execute();
}