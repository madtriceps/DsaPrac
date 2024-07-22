package DsaPrac.DsaPractice.src;

public class DP_rodCuttingProblem {

    static int maxProfits(int[] prices, int n) {
        int[] dp = new int[n + 1];

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, prices[j] + dp[i - j - 1]);
            }
            dp[i] = maxVal;
        }

        return dp[n];
    }
    static int maxProfits_Tabulation(int[] prices, int n, int[] sizes) {
        int[][] tab = new int[n + 1][prices.length + 1];

        //Initializing the matrix
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < prices.length + 1; j++) {
                if (i == 0 || j == 0) {
                    tab[i][j] = 0;
                }
            }
        }
        //Logic for filling the subsequent cells of the matrix
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= sizes.length; j++) {
                if (sizes[j - 1] <= i) {
                    tab[i][j] = Math.max(prices[j - 1] + tab[i - sizes[j - 1]][j], tab[i][j - 1]);
                } else {
                    tab[i][j] = tab[i][j - 1];
                }
            }
        }

        // Printing the matrix
        for (int i = 0; i < n + 1; i++) {
            System.out.println();
            for (int j = 0; j < prices.length + 1; j++) {
                System.out.print(tab[i][j] + " ");
            }
        }

        return tab[n][sizes.length];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 3, 6, 7, 8};
        int[] sizes = {1, 2, 3, 4, 5, 6};
        int n = sizes.length;
        System.out.println("Max profits: " + maxProfits(prices, n)); // Expected output: 10
        System.out.println("\nMax profits by tabulation: " + maxProfits_Tabulation(prices, n, sizes));
    }
}
