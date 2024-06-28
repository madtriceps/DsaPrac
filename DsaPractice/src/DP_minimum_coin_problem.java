package DsaPrac.DsaPractice.src;

public class DP_minimum_coin_problem {
    static int[][] tab;

    public static int minCoins(int[] coins, int sum) {
        int n = coins.length;
        tab = new int[n + 1][sum + 1];

        // Initialize the table
        for (int j = 0; j <= sum; j++) {
            tab[0][j] = Integer.MAX_VALUE - 1; // Impossible to make positive sum with 0 coins
        }
        tab[0][0] = 0; // 0 coins are needed to make the sum of 0

        for (int i = 1; i <= n; i++) {
            tab[i][0] = 0; // 0 coins are needed to make the sum of 0
        }

        // Fill the table using the bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    tab[i][j] = Math.min(tab[i][j - coins[i - 1]] + 1, tab[i - 1][j]);
                } else {
                    tab[i][j] = tab[i - 1][j];
                }
            }
        }

        return tab[n][sum] == Integer.MAX_VALUE - 1 ? -1 : tab[n][sum];
    }

    public static void main(String[] args) {
        int[] coins = {2,1,3};
        int sum = 5;
        System.out.println(minCoins(coins, sum)); // Output: 2
    }
}
