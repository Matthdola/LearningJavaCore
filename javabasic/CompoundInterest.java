/**
 * This program shows how to store tabular data in a 2D array.
 * 
 * @version 1.0 2019-12-12
 * @author Matthias K. DOLA
 */
public class CompoundInterest {
    public static void main(String[] args) {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        // set interest tates to 10 ... 15%
        double[] interestRate = new double[NRATES];
        for (int i = 0; i < interestRate.length; i++) {
            interestRate[i] = (STARTRATE + i) / 100.0;
        }
        double[][] balances = new double[NYEARS][NRATES];

        // set initial balances to 10000
        System.out.printf("The index is %d\n", balances.length);
        for (int i = 0; i < balances[0].length; i++) {
            balances[0][i] = 10000.0;
        }

        // Compute interest for future years
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                // get last years's balances from previous row
                double oldBalance = balances[i - 1][j];

                // compute interest
                double interest = oldBalance * interestRate[j];

                // compute this year's balances
                balances[i][j] = oldBalance + interest;
            }
        }

        // print one row of interest rates
        for (int k = 0; k < interestRate.length; k++)
            System.out.printf("%9.0f%%", 100 * interestRate[k]);

        System.out.println();

        // print balance table
        for (double[] row : balances) {
            // print table row
            for (double b : row)
                System.out.printf("%10.2f", b);
            System.out.println();
        }
    }
}