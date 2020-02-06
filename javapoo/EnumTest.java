import java.util.Scanner;

/**
 * This program demonstrates enum types.
 * 
 * @version 1.0 2019-12-28
 * @author Matthias DOLA,
 * @book:From Core Java Volume 1 of Horstmann, Cay S & Cornell, Gary
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE, EXTRA_EXTRA_LARGE: ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("Size = " + size);
        System.out.println("Abbreviation = " + size.getAbbreviation());
        
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job-- you paid attention the _.");
        }
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