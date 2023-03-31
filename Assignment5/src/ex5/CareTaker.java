package ex5;

import java.util.ArrayList;
import java.util.List;

//CareTaker class that stores Memento objects
public class CareTaker {
 private List<Memento> mementoList = new ArrayList<>();

 // Add a new Memento object to the list
 public void add(Memento state) {
     mementoList.add(state);
 }

 // Get a specific Memento object from the list
 public Memento get(int index) {
     return mementoList.get(index);
 }
}