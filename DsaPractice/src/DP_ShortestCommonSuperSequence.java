package DsaPrac.DsaPractice.src;

public class DP_ShortestCommonSuperSequence {

    /**
     * This function calculates the length of the Shortest Common Supersequence (SCS)
     * between two strings x and y. It uses the formula:
     *
     * SCS length = m + n - LCS length
     *
     * where m is the length of string x, n is the length of string y, and LCS is the
     * Longest Common Subsequence between x and y.
     */
    static int shortestCommonSuperSequence(String x, String y) {
        int lcsLength = lcs(x, y); // Calculate the LCS length
        // The length of the SCS is the total length of both strings minus the LCS length
        int shortestCommonSubsequenceLength = x.length() + y.length() - lcsLength;
        return shortestCommonSubsequenceLength;
    }

    /**
     * This function calculates the Longest Common Subsequence (LCS) between two
     * strings x and y using Dynamic Programming (DP). It fills a 2D table where
     * tab[i][j] represents the length of LCS for substrings x[0..i-1] and
     * y[0..j-1].
     */
    static int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] tab = new int[m + 1][n + 1]; // DP table to store LCS lengths

        // Fill the DP table based on LCS logic
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, take the diagonal value and add 1
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    tab[i][j] = tab[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum of top or left value
                    tab[i][j] = Math.max(tab[i - 1][j], tab[i][j - 1]);
                }
            }
        }

        // Print the DP table for LCS
        printTable(tab, m, n);

        // Print the LCS for debugging
        StringBuilder lcsBuilder = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            // If characters are equal, they are part of the LCS
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcsBuilder.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (tab[i - 1][j] > tab[i][j - 1]) {
                // Move up in the DP table
                i--;
            } else {
                // Move left in the DP table
                j--;
            }
        }
        System.out.println("String LCS: " + lcsBuilder.reverse().toString()); // Print the LCS string

        // Print the Shortest Common Supersequence (SCS)
        printSCS(x, y, tab);

        return tab[m][n]; // Return the length of LCS
    }

    /**
     * This function prints the Shortest Common Supersequence (SCS) by tracing
     * back the DP table used for LCS. It constructs the SCS by adding characters
     * from both strings while ensuring common characters are added only once.
     */
    static void printSCS(String x, String y, int[][] tab) {
        StringBuilder scsBuilder = new StringBuilder(); // To store the SCS
        int i = x.length();
        int j = y.length();

        // Trace back from bottom-right of the table to construct the SCS
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                // If characters are the same, include them only once in the SCS
                scsBuilder.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (tab[i - 1][j] > tab[i][j - 1]) {
                // If moving upwards gives a larger LCS, add character from `x`
                scsBuilder.append(x.charAt(i - 1));
                i--;
            } else {
                // Otherwise, add character from `y`
                scsBuilder.append(y.charAt(j - 1));
                j--;
            }
        }

        // Add any remaining characters from `x`
        while (i > 0) {
            scsBuilder.append(x.charAt(i - 1));
            i--;
        }

        // Add any remaining characters from `y`
        while (j > 0) {
            scsBuilder.append(y.charAt(j - 1));
            j--;
        }

        // Since we built the SCS backwards, we reverse it to get the correct order
        System.out.println("String SCS: " + scsBuilder.reverse().toString());
    }

    /**
     * Utility function to print the DP table that stores the LCS lengths.
     */
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
        // Example strings
        String x = "aggtab";
        String y = "gxtxayb";

        // Print the length of the Shortest Common Supersequence
        System.out.println("Shortest Common Supersequence Length: " + shortestCommonSuperSequence(x, y));
    }
}
