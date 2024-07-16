package DsaPrac.DsaPractice.src;

public class DP_ShortestCommonSuperSequence {

    static int shortestCommonSuperSequence(String x, String y) {
        int lcsLength = lcs(x, y);
        int shortestCommonSubsequenceLength = x.length() + y.length() - lcsLength;
        return shortestCommonSubsequenceLength;
    }

    static int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] tab = new int[m + 1][n + 1];

        // Fill the table according to LCS logic
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    tab[i][j] = tab[i - 1][j - 1] + 1;
                } else {
                    tab[i][j] = Math.max(tab[i - 1][j], tab[i][j - 1]);
                }
            }
        }

        // Print the LCS table
        printTable(tab, m, n);

        // Print the LCS (for debugging purposes)
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sb.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (tab[i - 1][j] > tab[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("String LCS: " + sb.reverse().toString());

        return tab[m][n];
    }

    static void printTable(int[][] table, int m, int n) {
        System.out.println("LCS Table:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String x = "aggtab";
        String y = "gxtxayb";
        System.out.println("Shortest Common Supersequence Length: " + shortestCommonSuperSequence(x, y));
    }
}
