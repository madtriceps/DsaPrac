package DsaPrac.DsaPractice.src;

import java.util.Arrays;
public class DP_Knapsack_01_memoized {

    private static int[][] tab;

    static int knapSack(int[] wt, int[] val, int cap, int n) {
        if (n == 0 || cap == 0) {
            return 0;
        }
        if (tab[n][cap] != -1) {
            return tab[n][cap];
        }
        if (wt[n - 1] <= cap) {
            return tab[n][cap] = Math.max(val[n - 1] + knapSack(wt, val, cap - wt[n - 1], n - 1), knapSack(wt, val, cap, n - 1));
        } else {
            return tab[n][cap] = knapSack(wt, val, cap, n - 1);
        }
    }

    public static void main(String[] args) {
        int[] wt = {20, 60, 20, 50, 15};
        int[] val = {90, 130, 60, 110, 42};
        int cap = 90;
        int n = 5;

        // Initialize the tab array with -1
        tab = new int[n + 1][cap + 1];
        for (int[] row : tab) {
            Arrays.fill(row, -1);
        }

        int profitmax = knapSack(wt, val, cap, n);
        System.out.print(profitmax);
    }
}
