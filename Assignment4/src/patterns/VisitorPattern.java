package patterns;

interface Element {
 void accept(Visitor v);
}

class C implements Element{
 public void accept(Visitor v) {
     v.visit(this);
 }
 
 public void operation() {
     System.out.println("C operation");
 }
}

interface Visitor {
 void visit(C element);
}

class ConcreteVisitor implements Visitor {
 public void visit(C element) {
     element.operation();
 }
}

public class VisitorPattern{
 public static void main(String[] args) {
     C element = new C();
     Visitor v = new ConcreteVisitor();
     element.accept(v);
 }
}
