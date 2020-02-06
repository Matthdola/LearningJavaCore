import java.io.Console;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ArrayTest {
    // How do you initialize an array
    // How do you copy array?
    // Allocating an array dynamically in java
    // How to change length of an array
    // Explain with example how to initialize an array
    // How to sort an array?
    // Difference between Array and ArrayList

    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        test.arraySortWithComparator();
    }

    public void arrayInitialization() {
        /*
         * int initializedArray = new int[4]; initializedArray[0] = 100;
         * initializedArray[0] = 23; initializedArray[0] = 34; initializedArray[0] = 42;
         */
        int[] initializedArray = { 100, 23, 34, 42 };
        // asserEquals(100, initializedArray[0]);
        // asserEquals(34, initializedArray[2]);
    }

    public void stringArrayDeclaration() {
        // String[] initializedArray = new String[4];
        String[] initializedArray = new String[] { "Matthias", "DOLA", "Koami", "Amivi", "Nathalie" };
    }

    public void copyArrays() {
        int[] array = new int[] { 1, 4, 5, 0, 34 };
        final int newArrayLength = array.length;

        // Copies newLength i.e. 5 values from array
        int[] copiedArray = Arrays.copyOf(array, newArrayLength);

        // Asserts on the copied array
        // assertEquals(newArrayLength, copiedArray.length);
        // assertEquals(new int[] {1, 4, 5, 0, 34}, copiedArray);
    }

    public void arraySort() {
        int[] arrayToSort = { 100, 23, 55, 34 };

        Arrays.sort(arrayToSort);
        // assertArrayEquals(new int[] {23, 34, 55, 100}, arrayToSort);
    }

    public void arraySortStrings() {
        String[] arrayToSort = { "ABC", "XYZ", "PQR" };
        Arrays.sort(arrayToSort);

        // assertArrayEquals(new String[] {"ABC", "PQR", "XYZ"}, arrayToSort);
    }

    public void arraySortWithComparator() {
        final Scanner scanner = new Scanner(System.in);

        String[] arrayToSort = { "matthiasDolaKoamiAessBreCffd", "XYZ", "PQR" };
        String s = arrayToSort[0];
        String pattern = "([A-Z])+";
        Pattern p = Pattern.compile(pattern);
        String[] items = s.split(pattern);
        // System.out.println(Arrays.toString(items));
        if (items.length <= 0) {
            System.out.println("Invalid String");
            return;
        }
        if (Character.isUpperCase(items[0].charAt(0))) {
            System.out.println("First charater is Uppercase ");
            return;
        }
        // System.out.println(String.format("You have %s word(s) in the string",
        // items.length));

        char[] values = s.toCharArray();
        if (values == null || values.length < 1 || values.length > 100_000) {
            System.out.println("Invalid string provided");
        }
        int count = 1;
        if (Character.isUpperCase(values[0])) {
            System.out.println("Invalid string provided");
            return;
        }
        for (char c : values) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        // System.out.println(String.format("You have %s word(s) in the string",
        // count));

        Arrays.sort(arrayToSort, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str2.compareTo(str1);
            }
        });

        s = "4700";
        int rest = 0;
        if (s.length() < 6) {
            rest = 6 - s.length();
        } else {
            if (!s.matches(".*[A-Z]+.*")) {
                System.out.println("No uppercase character");
                rest++;
            }
            if (!s.matches(".*[a-z]+.*")) {
                System.out.println("No lowercase character");
                rest++;
            }
            if (!s.matches(".*[0-9]+.*")) {
                System.out.println("No digit");
                rest++;
            }
            if (!s.matches(".*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+]+.*")) {
                System.out.println("No special character");
                rest++;
            }
        }
        // System.out.println(String.format("You have %s in the string", rest));

        s = "The quick brown fox jumps over the lazy dog";
        String s2 = "We promptly judged antique ivory buckles for the prize";
        pattern = "[a-zA-Z]";
        // char[] valuesItems = s.toCharArray();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        char[] alphabetChars = alphabet.toCharArray();
        boolean isPangram = true;
        for (char c : alphabetChars) {
            char lowerC = Character.toLowerCase(c);
            char upperC = Character.toUpperCase(c);
            if (s2.indexOf(lowerC) < 0 && s2.indexOf(upperC) < 0) {
                isPangram = false;
                break;
            }
        }

        if (isPangram) {
            // System.out.println("pangram");
        } else {
            // System.out.println("Not a pangram");
        }
        String sos = "SPSSSSSOQ";
        pattern = "([A-Z])+";
        if (sos.length() < 0 || sos.length() > 99 || (sos.length() % 3) != 0 || !sos.matches(pattern)) {
            // return 0;
            System.out.println("Invalid message");
            return;
        }

        int begin = 0;
        int end = 3;
        int invalidLetters = 0;
        while (begin < sos.length()) {
            String part = sos.substring(begin, end);
            if (!part.matches("SOS")) {
                char[] letters = part.toCharArray();
                if (letters[0] != 'S') {
                    invalidLetters++;
                }
                if (letters[1] != 'O') {
                    invalidLetters++;
                }
                if (letters[2] != 'S') {
                    invalidLetters++;
                }
            }

            System.out.print(part + " ");
            begin += part.length();
            end += part.length();
        }
        System.out.println();
        System.out.println(invalidLetters + " ");
        System.out.println();
        /*
         * int N = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
         * if (N >= 1 && N < 100) { if ((N % 2) != 0) { System.out.println("Weird"); }
         * else if ((N >= 2 && N <= 5) || (N > 20)) { System.out.println("Not Weird"); }
         * else if (N >= 6 && N <= 20) { System.out.println("Weird"); } }
         */
        Console cons = System.console();
        String username = cons.readLine("Your username: ");
        // System.out.println();
        char[] password = cons.readPassword("Your password: ");
        int firsttime = 1;
        String pass = new String(password);

        while (!pass.toString().equals("matthias") && firsttime < 3) {
            System.out.println("Incorrect password, retry !!!");
            password = cons.readPassword("Your password: ");
            firsttime++;
        }
        if (pass.toString().equals("matthias")) {
            System.out.println(String.format("You (%s) are connected", username));
        } else {
            System.out.println(String.format("User not connected", username));

        }
        double x = 10000.0 / 3.0;
        System.out.printf("%8.2f\n", x);
        scanner.close();
        // assertArrayEquals(new String[] {"ABC", "PQR", "XYZ"}, arrayToSort);
    }

    static int marsExploration(String s) {
        String pattern = "([A-Z])+";
        String msg = "SOS";
        char S = 'S';
        char O = 'O';
        if (s.length() < 0 || s.length() > 99 || (s.length() % 3) != 0 || !s.matches(pattern)) {
            return 0;
        }

        int begin = 0;
        int end = 3;
        int invalidLetters = 0;
        while (begin < s.length()) {
            String part = s.substring(begin, end);
            if (!part.matches(msg)) {
                char[] letters = part.toCharArray();
                if (letters[0] != S) {
                    invalidLetters++;
                }
                if (letters[1] != O) {
                    invalidLetters++;
                }
                if (letters[2] != S) {
                    invalidLetters++;
                }
            }
            begin += part.length();
            end += part.length();
        }
        return invalidLetters;
    }

    static String pangrams(String s) {
        if (s.length() < 1 || s.length() > 1000) {
            return "not pangram";
        }
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        char[] alphabetChars = alphabet.toCharArray();
        boolean isPangram = true;
        for (char c : alphabetChars) {
            char lowerC = Character.toLowerCase(c);
            char upperC = Character.toUpperCase(c);
            if (s.indexOf(lowerC) < 0 && s.indexOf(upperC) < 0) {
                isPangram = false;
                break;
            }
        }

        if (isPangram) {
            return s;
        } else {
            return "not pangram";
        }
    }

}