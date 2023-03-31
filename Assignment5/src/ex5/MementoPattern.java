package ex5;

//Main class that demonstrates the Memento pattern
public class MementoPattern {
 public static void main(String[] args) {

     // Create an Originator and a CareTaker
     Originator originator = new Originator();
     CareTaker careTaker = new CareTaker();

     // Set the state of the Originator to different values
     originator.setState("State #1");
     originator.setState("State #2");

     // Save the current state of the Originator to a Memento object
     careTaker.add(originator.saveStateToMemento());

     // Set the state of the Originator to a new value and save it again
     originator.setState("State #3");
     careTaker.add(originator.saveStateToMemento());

     // Set the state of the Originator to a new value
     originator.setState("State #4");

     // Print the current state of the Originator
     System.out.println("Current State: " + originator.getState());

     // Restore the first saved state of the Originator and print it
     originator.getStateFromMemento(careTaker.get(0));
     System.out.println("First saved State: " + originator.getState());

     // Restore the second saved state of the Originator and print it
     originator.getStateFromMemento(careTaker.get(1));
     System.out.println("Second saved State: " + originator.getState());
 }
}