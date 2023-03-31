package ex5;

//Originator class whose state needs to be saved and restored
public class Originator {
 private String state;

 // Set the state of the Originator
 public void setState(String state) {
     this.state = state;
 }

 // Get the current state of the Originator
 public String getState() {
     return state;
 }

 // Create a new Memento object with the current state of the Originator
 public Memento saveStateToMemento() {
     return new Memento(state);
 }

 // Restore the state of the Originator from a Memento object
 public void getStateFromMemento(Memento memento) {
     state = memento.getState();
 }
}