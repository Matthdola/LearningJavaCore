import java.io.Console;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * This is the first sample program in Core Java Chapter 3
 * 
 * @version 1.01 2019-12-01
 * @author Matthias DOLA
 */
public class FirstSample {
    // Class constant
    public static final double CM_PER_INCH = 2.54;

    public static void main(String[] args) {
        // int vacationDays;
        // System.out.println(vacationDays);
        System.out.println("We will not use 'Hello, World!' ");
        String[] cities = { "Lome", "Tsevie", "Notse", "Atakpame", "Blitta", "Sotouboua" };
        show(cities);

        System.out.println();
        System.out.println("Show the minimun beetween two values");
        System.out.println(String.format("Minimn of %s and %s is: %s", 23, 89, minimun(23, 89)));
        System.out.println();
        shiftEg(34);

        String greeting = "Hello";
        int n = greeting.length();
        System.out.println(n);
        n = greeting.codePointCount(0, greeting.length());
        System.out.println(n);
        int i = 3;
        int index = greeting.offsetByCodePoints(0, i);
        int cp = greeting.codePointAt(index);
        System.out.println(cp);
        /*
         * System.out.println("\n--------------GET DATA FROM INPUT----------");
         * getData();
         * System.out.println("------------END GET DATA FROM INPUT-------------");
         * 
         * System.out.
         * println("\n--------------GET CREDENTIALS (USERNAME AND PASSWORD) FROM INPUT----------"
         * ); getPassword();
         * System.out.println("------------END GET CREDENTIALS FROM INPUT-------------"
         * ); System.out.
         * println("\n--------------GET USER INFORMATION (USERNAME AND AGE) FROM INPUT----------"
         * ); inputTest(); System.out.
         * println("------------END GET USER INFORMATION FROM INPUT-------------");
         */
        System.out.printf("%, .2f \n", 10000.0 / 3.0);
        System.out.printf("%s %tB %<te, %<tY\n", "Due date", new Date());
        System.out.printf("%1$s %2$tB %2$te, %2$tY \n", "Due date", new Date());

        // Get the directory
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        System.out.println();
        balanceCheck();
        System.out.println();
        System.out.println("----------------------- Arrays -----------------------");
        testArray();
    }

    static void show(String\u005B\u005D cities) {
        for (var city : cities) {
            System.out.print(city + " ");
        }
        System.out.println();
    }

    static int minimun(int a, int b) {
        return a < b ? a : b;
    }

    static void shiftEg(int n) {
        int fourthBitFromRight = (n & (1 << 3)) >> 3;
        System.out.println(fourthBitFromRight);
    }

    static void getData() {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = in.nextLine();
        System.out.println(String.format("Your name is %s", name));

    }

    /**
     * To get password from the console, it is good to use the Console class
     */
    static void getPassword() {
        Console cons = System.console();
        String username = cons.readLine("User name: ");
        char[] passwd = cons.readPassword("Password: ");
        System.out.println(String.format("Your credentials are : username= %s, password=%s", username, passwd));
    }

    static void inputTest() {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("What us your name? ");
        String name = in.nextLine();

        // get second input
        System.out.print("How old are you? ");
        int age = in.nextInt();

        // display output on console
        System.out.println(String.format("Hello, %s, next year, you'll be %s", name, age + 1));
    }

    // File Input and Outpu
    static void readFromFile() {
        try {
            String[] args = { "test", "test2" };
            Scanner in = new Scanner(Paths.get("testfile.txt", args));

            PrintWriter out = new PrintWriter("myfile.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void balanceCheck() {
        // read inputs
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute each year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        // Update account balance while goal isn't reached
        while (balance < goal) {
            // add this years's payment and interest
            balance += payment;

            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }
        System.out.printf("You can retire in %d years.\n", years);
    }

    private void testBreakLabel() {
        System.out.printf("You can retire in %d years.\n", 33);
        int index = 33;
        label: System.out.printf("We are in break module.\n");
        // if (index == 33)
        // break label;

    }

    private static void testContinue() {
        Scanner in = new Scanner(System.in);
        int n;
        int sum = 0;
        for (int count = 1; count <= 100; count++) {
            System.out.println("Enter a number, -1 to quit: ");
            n = in.nextInt();
            if (n < 0)
                continue;
            sum += n; // not exacuted if n < 0
        }
        System.out.printf("The sum is %d\n", sum);
    }

    private static void testBigNumbers() {
        BigInteger a = BigInteger.valueOf(100);
        BigInteger b = BigInteger.valueOf(500);
        BigInteger c = a.add(b); // c = a + 500;
        BigInteger d = c.multiply(b.add(BigInteger.valueOf(2))); // d = c * (b + 2)
    }

    private static void testLotteryOdds(int n) {

    }

    private static void testArray() {
        int[] a = new int[100]; // Declaration and initialisation of integer array of size 100
        for (int i = 0; i < 100; i++) {
            a[i] = i + 1;
        }
        // Print the array values with the toString method of Arrays
        System.out.println(Arrays.toString(a));

        // Copying array elements
        int[] b = Arrays.copyOf(a, a.length);

        int[] c = new int[20];
        Arrays.fill(c, 23);
        System.out.println(Arrays.toString(c));
    }
}