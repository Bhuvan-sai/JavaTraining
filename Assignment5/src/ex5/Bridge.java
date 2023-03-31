package ex5;

// Define an interface for the implementation of drawing a circle
interface DrawAPI {
   public void drawCircle(int radius, int x, int y);
}

// Implement the DrawAPI interface to draw a circle in red color
class RedCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
   }
}

// Implement the DrawAPI interface to draw a circle in green color
class GreenCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
   }
}

// Define an abstract class for a shape that uses a DrawAPI implementation to draw
abstract class Shape {
   protected DrawAPI drawAPI;
   
   protected Shape(DrawAPI drawAPI){
      this.drawAPI = drawAPI;
   }
   
   // Declare an abstract method for drawing a shape
   public abstract void draw();  
}

// Define a concrete shape class for drawing circles
class Circle extends Shape {
   private int x, y, radius;

   // Constructor to create a circle with a specific position, size, and DrawAPI implementation
   public Circle(int x, int y, int radius, DrawAPI drawAPI) {
      super(drawAPI);
      this.x = x;  
      this.y = y;  
      this.radius = radius;
   }

   // Implement the draw method to draw the circle using the DrawAPI implementation
   public void draw() {
      drawAPI.drawCircle(radius,x,y);
   }
}

// Demonstrate the use of the Bridge pattern to draw circles with different colors
public class Bridge {
   public static void main(String[] args) {
      // Create a red circle using the RedCircle DrawAPI implementation
      Shape redCircle = new Circle(100,100, 10, new RedCircle());
      
      // Create a green circle using the GreenCircle DrawAPI implementation
      Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

      // Draw the red circle
      redCircle.draw();
      
      // Draw the green circle
      greenCircle.draw();
   }
}
