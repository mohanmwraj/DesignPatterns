import java.util.ArrayList;
import java.util.List;

abstract class EmployeeComponent{
    public abstract void displayInfo();
    public abstract double calculateSalary();
}

class Employee extends EmployeeComponent{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    @Override
    public void displayInfo() {
        System.out.println("Employee: " + name + "salary: Rs. " + salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}

class Department extends EmployeeComponent{
    private String name;
    private List<EmployeeComponent> members;

    public Department(String name /*List<EmployeeComponent> members*/) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(EmployeeComponent member){
        members.add(member);
    }

    @Override
    public void displayInfo() {
        System.out.println("Department: " + name);
        for(EmployeeComponent member: members){
            member.displayInfo();
        }
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0.0;
        for(EmployeeComponent member: members){
            totalSalary += member.calculateSalary();
        }

        return totalSalary;
    }
}

class Team extends EmployeeComponent{
    private String name;
    private List<EmployeeComponent> members;

    public Team(String name/*, List<EmployeeComponent> members*/) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(EmployeeComponent member){
        members.add(member);
    }

    @Override
    public void displayInfo() {
        System.out.println("Team: "+ name);
        for(EmployeeComponent member: members){
            member.displayInfo();
        }
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0.0;
        for(EmployeeComponent member: members){
            totalSalary += member.calculateSalary();
        }

        return totalSalary;
    }
}

public class EmployeesDemo {
    public static void main(String[] args) {
        EmployeeComponent employee1 = new Employee("Employee 1", 100.0);
        EmployeeComponent employee2 = new Employee("Employee 2", 100.0);

        Team sales = new Team("Sales");
        sales.addMember(employee1);
        sales.addMember(employee2);

        EmployeeComponent bob = new Employee("Bob", 50.0);
        Team marketing = new Team("Marketing");
        marketing.addMember(bob);

        Department headoffice = new Department("Head Office");
        headoffice.addMember(sales);
        headoffice.addMember(marketing);

        headoffice.displayInfo();
        double totalSalary = headoffice.calculateSalary();
        System.out.println("Total Salary for the Organization: Rs." + totalSalary);

    }
}
