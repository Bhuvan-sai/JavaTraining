package patterns;

public class Strategy {
    public static void main(String[] args) {
        Employee ram = new Employee("Ram", new Consultant());
        Employee rahul = new Employee("Rahul", new SeniorConsultant());
        System.out.println("=======Before promotion=======\n");
        ram.doWork();
        rahul.doWork();
        ram.promote(new SeniorConsultant());
        rahul.promote(new LeadConsultant());
        System.out.println("\n=======After promotion=======\n");
        ram.doWork();
        rahul.doWork();
    }
}
class Employee {
    private int id;
    private String name;
    private Role role;
    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
    }
    public void promote(Role newRole) {
        role = newRole;
    }
    public String grade() {
        return this.name + " is a " + role.description();
    }
    public void doWork() {
        System.out.println(name + " Will " + role.responsibilities());
    }
}
interface Role {
    String description();
    String responsibilities();
}
class Consultant implements Role {
    @Override
    public String description() {
        return Consultant.class.getSimpleName();
    }
    @Override
    public String responsibilities() {
        return "Write Code";
    }
}
class LeadConsultant implements Role {
    @Override
    public String description() {
        return LeadConsultant.class.getSimpleName();
    }
    @Override
    public String responsibilities() {
        return "Make tech decisions";
    }
}
class PrincipalConsultant implements Role {
    @Override
    public String description() {
        return PrincipalConsultant.class.getSimpleName();
    }
    @Override
    public String responsibilities() {
        return "Talk to clients";
    }
}
class SeniorConsultant implements Role {
    @Override
    public String description() {
        return SeniorConsultant.class.getSimpleName();
    }
    @Override
    public String responsibilities() {
        return "Review Code";
    }
}