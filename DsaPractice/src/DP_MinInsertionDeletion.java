package DsaPrac.DsaPractice.src;//Minimum number of insertions and deletions required to change String a to String B
//eg: heap -- > pea
//to convert the "heap" string to "pea" string we must remove 2 charcaters ('h' & 'p') from heap and add a single character 'p' at start
// heap--> ea  --> pea     [First delete 2 chars and then insert 1 at the start]

/*
Again the question implements to find how many characters of the existing and required string are same so that we remove other characters,
other than the common ones.
Observe carefully 'ea' is the largest common subsequence b/w both the Strings.

The reason we are takign subsequence and not substring is
while choosing the common charcters we wanna save , continuous or non-continuous doesn't matter.

Approach:
use lcs to find out common characters we have in existing and required string and then we can delete the non-common charcaters and then add
the extra characters in the required string.

deletions needed = currString length - common character length
additions needed = required string length - common character length
 */

public class DP_MinInsertionDeletion {

    static int[] minInsertionDeletionRequired(String currString , String desiredString){
        int commonCharacters = lcs(currString, desiredString);
        int deletionsNeeded = currString.length() - commonCharacters;
        int insertionsNeeded = desiredString.length()-commonCharacters;

        return new int[]{deletionsNeeded,insertionsNeeded};

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
        int[] ans = minInsertionDeletionRequired("heap","pea");
        System.out.println("Deletions required: "+ans[0]);
        System.out.println("Insertions required: "+ans[1]);
    }
}
