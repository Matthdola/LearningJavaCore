import java.math.BigInteger;
import java.util.Scanner;

/**
 * This program uses bog numbers to compute the odds of winning the grand prize
 * in a lottery
 * 
 * @version 1.0 2019-12-12
 * @author Cay Horstmann
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        /**
         * Compute binomial coefficient n*(n-1)*(n-2)..(k+1)/(1*2*3...K)
         */
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= k; i++)
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));

        System.out.printf("Your odds are 1 of %,d, Good luck\n", lotteryOdds);
    }
}