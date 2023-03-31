package ex5;



import java.util.HashMap;
import java.util.Random;

// Define the common behavior for all employees
interface Employee {
  public void assignSkill(String skill);
  public void task();
}

// Implement the Employee interface for Developers
class Developer implements Employee {

  private final String JOB; // The job of the developer
  private String skill; // The skill of the developer
  
  public Developer() {
    JOB = "Fix the issue"; // Set the job of the developer
  }
  
  @Override
  public void assignSkill(String skill) {
    this.skill = skill; // Assign the skill of the developer
  }

  @Override
  public void task() {
    // Perform the task of the developer
    System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
  }
  
}

// Implement the Employee interface for Testers
class Tester implements Employee {

  private final String JOB; // The job of the tester
  
  private String skill; // The skill of the tester
  
  public Tester() {
    JOB = "Test the issue"; // Set the job of the tester
  }
  
  @Override
  public void assignSkill(String skill) {
    this.skill = skill; // Assign the skill of the tester
  }

  @Override
  public void task() {
    // Perform the task of the tester
    System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
  }
  
}

// The EmployeeFactory class is responsible for creating and managing Employee objects
class EmployeeFactory {
  private static HashMap<String, Employee> m = new HashMap<String, Employee>(); // A map of Employee objects
  
  public static Employee getEmployee(String type) {
    Employee p = null;
    if(m.get(type) != null) {
      p = m.get(type); // If an Employee object of this type already exists, use it
    } else {
      // If an Employee object of this type doesn't exist, create one and add it to the map
      switch(type) {
      case "Developer": 
        System.out.println("Developer Created");
        p = new Developer();
        break;
      case "Tester":
        System.out.println("Tester Created");
        p = new Tester();
        break;
      default:
        System.out.println("No Such Employee");
      }
      
      m.put(type, p); // Add the Employee object to the map
    }
    return p; // Return the Employee object
  }
}

// The main class demonstrates the use of the Flyweight pattern
public class FlyWeight {

  // An array of employee types
  private static String employeeType[] = {"Developer", "Tester"};
  
  // An array of skills
  private static String skills[] = {"Java", "C++", ".Net", "Python"};
  
  public static void main(String[] args) {
    // Create multiple Employee objects
    for(int i = 0; i < 10; i++) {
      // Get a random employee type
      Employee e = EmployeeFactory.getEmployee(getRandEmployee());
      
      // Assign a random skill
      e.assignSkill(getRandSkill());
      
      // Perform a task
      e.task();
    }
  }
  
  // Get a random employee type
  public static String getRandEmployee() {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    
    return employeeType[randInt];
  }
  
  // Get a random skill
  public static String getRandSkill() {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    
    return skills[randInt];
  }

}