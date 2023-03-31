package ex5;

//Memento class that holds the saved state of Originator
public class Memento {
 private String state;

 public Memento(String state) {
     this.state = state;
 }

 public String getState() {
     return state;
 }
}