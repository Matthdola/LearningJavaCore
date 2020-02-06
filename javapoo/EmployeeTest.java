import java.util.ArrayList;
import java.util.Arrays;




/**
 * This program create an EmployeeTest class that test the Employee class we
 * created
 * 
 * @version 1.0 2019-12-28
 * @author Matthias DOLA,
 * @book:From Core Java Volume 1 of Horstmann, Cay S & Cornell, Gary
 */

public class EmployeeTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        // Employee[] staff = new Employee[3];
        // Manager[] admins = new Manager[3];
        ArrayList<Employee> staff = new ArrayList<Employee>();
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        Employee b = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        // admins[0] = b;
        staff.add(boss);
        staff.add(b);
        staff.add(new Employee("Tony Tester", 40000, 1990, 2, 15));
        System.out.println();
        Employee[] staffArrays = new Employee[3];
        staffArrays[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staffArrays[1] = new Employee("Matthias DOLA", 70000, 2020, 10, 1);
        staffArrays[2] = new Employee("Nathalie DOLA", 50000, 2020, 10, 1);
        Arrays.sort(staffArrays);
        // Raise everyone's salary by 5%
        for (Employee e : staff) {
            // e.setId();
            e.raiseSalary(5);
        }

        // print out information about all Empoyee objects
        for (Employee e : staff)
            System.out.println(e.toString());

        int n = Employee.getNextId();
        System.out.println(String.format("Next available id = %s", n));
        // System.out.println(String.format("x puissance a: %s", calculatePow(3, 3)));
        System.out.println("--------------------------Check ENUM-------------------");
        // Date d = new Date();
        // System.out.println(d.toLocaleString());
        // Date d2 = new GregorianCalendar().getTime();
        System.out.println(Arrays.toString(Size.values()));

        // ActionListener listener = new TimePrinter();

        // // construct a timer that calls the listener
        // // once every 5 seconds
        // Timer t = new Timer(5000, listener);
        // t.start();

        // JOptionPane.showMessageDialog(null, "Quit program ?");
        // System.exit(0);
    }

    public static double max(double... values) {
        double largest = Double.MIN_VALUE;
        for (double v: values)
            if (v > largest) 
                largest = v;

        return largest;
    }

    static int calculatePow(int x, int a) {
        if (x == 0)
            return 0;
        if (a == 0)
            return 1;
        int pow = 1;
        for (int i = 0; i < a; i++)
            pow *= x;

        return pow;
    }
}

class CardDeck {
    private Card[] cards;

    public CardDeck() {

    }

    public void shuffle() {}

    public Card getTop() { return null;}

    public void draw() {}
}

class Card {
    private int value;
    private int suit;

    public Card() {

    }

    public Card(int aValue, int aSuit){ this.value = aValue; this.suit = aSuit;}
    public int getValue() { return this.value; }
    public int getSuit() { return this.suit; }
}

class BaseCard extends Card {
    
    Size size = Size.EXTRA_LARGE;
    @Override
    public int getValue() {
        return  2;
    }
}

enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL"),
    EXTRA_EXTRA_LARGE("XXL");

    private String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
};

// class TimerPrinter implements ActionListener {
//     public void actionPerformed(ActionEvent event) {
//         Date now = new Date();
//         System.out.println("At the tone, the time is " + now);
//         Toolkit.getDefaultToolkit().beep();
//     }
// }