
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Random;

/**
 * This program create an employee class
 * 
 * @version 1.0 2019-12-28
 * @author Matthias DOLA,
 * @book:From Core Java Volume 1 of Horstmann, Cay S & Cornell, Gary
 */
public class Employee extends Person implements Cloneable, Comparable<Employee> {
    // static variable
    private static int nextId = 1;
    // instance fields
    // private String name = ""; 
    private double salary;
    private Date hireDay;
    private int id; // = assignId();

    // static initialization block
    static {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee(String aName, double aSalary) {
        // this.name = aName;
        super(aName);
        this.salary = aSalary;
        this.hireDay = new GregorianCalendar().getTime();
    }

    public Employee(double aSalary) {
        // calls the Employee(String, double) constructor    
        this("Employee #" + nextId, aSalary);
    }
    
    /**
     * The default constructor
    */
    public Employee() {
        // name initialisation to "" -- below
        // salary no explicitly set--initialized to 0
        // id initialized in initialization block
        super("");
    }

    // constructor
    public Employee(String n, double s, int year, int month, int day) {
        // this.name = n;
        super(n);
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
        // this.id = 0;
    }

    /**
     * This class return the employee'name
     * We make it final to prevent subclasses to override it
     * @return a string representing the name of the employee
     */
    /*
    final public String getName() {
        return this.name;
    }
    */

    public void setName(String n) {
        // this.name = n;
    }

    /**
     * Compares employees by salary
     * @param other another Employee object
     * @return a negative value if this employee has a lower salary than
     * other, 0 if the salaries are the same, a positive value otherwise
     */
    @Override
    public int compareTo(Employee other){
        return Double.compare(salary, other.salary);
    }

    public Employee clone() throws CloneNotSupportedException {
        // call Object.clone()
        Employee cloned = (Employee) super.clone();
        // clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }
    
    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double s) {
        this.salary = s;
    }

    /**
     * @param id the id to set
     */
    public void setId() {
        this.id = nextId; // set id to next available id
        nextId++;
    }

    public static int assignId() {
        int r = nextId;
        nextId++;
        return r;
    }

    public static int getNextId() {
        return nextId; // returns static field
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * This method return the hire date of the employee We return the cloned hireDay
     * to avoid breaking Encapsulation rule, Returning simple object will applied
     * changes on it to the internal private object
     * 
     * @return
     */
    public Object getHireDay() {
        return this.hireDay.clone();
    }

    public void setHireDay(Date d) {
        this.hireDay = d;
    }

    /**
     * Raises the salary of an employee.
     * @param byPercent the percentage by which to raise the salary (e.g. 10 means 10%)
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salaray of $%.2f", this.salary);
        
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }

    @Override
    public boolean equals(Object otherObject) {
        // a quick test to see of the objects are identical
        if (this == otherObject) 
            return true;
        
        // must return false if the explicit parameter is null
        if (otherObject == null)
            return false;

        if (getClass() != otherObject.getClass())
            return false;
            
        // now we know otherObject is a non-null Employee
        Employee other = (Employee) otherObject;

        // test whether the fields have identical values
        return getName().equals(other.getName())
            && salary == other.salary
            && Objects.equals(hireDay, other.hireDay);
            // && hireDay.equals(other.getHireDay());
    }

    public int hashCode() {
        return Objects.hash(getName(), salary, hireDay);
        /*
        return 7 * Objects.hashCode(getName()) 
            + 11 * (new Double(salary)).hashCode()
            + 13 * Objects.hashCode(hireDay);
            */
    }

    @Override
    public String toString() {
        return String.format("%s[Id = %s, name = %s, salary = %s, hireDay = %s]", getClass().getName(), this.id, super.getName(), this.salary,
                this.hireDay);
    }

    public static void main(String[] args) {
        Employee e = new Employee("Harry", 50000, 1989, 4, 23);
        System.out.println(e);
    }

}

class Manager extends Employee {
    private double bonus;

    public Manager() {
        
    }

    public Manager(String aName, double aSalary, int year, int month, int day) {
        super(aName, aSalary, year, month, day);
        this.bonus = 0;
    }

    public void setBonus(double b) {
        this.bonus = b;
    }

    public double getBonus() {
        return this.bonus;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + this.bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject))
            return false;
        // super.equals check that this and otherObject belong to the same class

        Manager other = (Manager) otherObject;
        return bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [bonus = %s]", this.bonus);
    }
}

/**
 * This class is a final, which prevent others to 
 * subclass it.
 */
final class Executive extends Manager {
}

class Secretary extends Employee {
}

class Programmer extends Employee {
}