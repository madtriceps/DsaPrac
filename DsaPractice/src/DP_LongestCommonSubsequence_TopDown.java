package DsaPrac.DsaPractice.src;

public class DP_LongestCommonSubsequence_TopDown {

    static int lcs(String x , String y){
        int m= x.length();
        int n= y.length();

        int[][] tab = new int[m+1][n+1];

        //Filling the first row and first column for base case
        for(int i=0 ;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    tab[i][j]=0;
                }
                if(j==0){
                    tab[i][j]=0;
                }
            }
        }

        for(int i=1 ;i<=m;i++){
            for(int j=1;j<=n;j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    tab[i][j] = tab[i-1][j-1]+1;
                }
                else{
                    tab[i][j]=Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        //Print table
        for(int i=0 ;i<=m;i++) {
            System.out.println();
            for (int j = 0; j <= n; j++) {
                System.out.print(tab[i][j]+" ");
            }
        }

        //Print the LCS
        StringBuilder sb = new StringBuilder();
        for(int i=m ;i>=1;) {
            for (int j = n; j >=1; ) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    sb.append(x.charAt(i-1));
                    i=i-1;
                    j=j-1;
                }
                else{
                    if(tab[i-1][j]>tab[i][j-1]){
                        i=i-1;
                    }
                    else{
                        j=j-1;
                    }
                }
            }
        }
        System.out.println("\nString LCS: "+sb.reverse());

        return tab[m][n];
    }

    public static void main(String[] args) {
        System.out.println("\n"+lcs("abcbe","avbdcddb"));
    }
}
