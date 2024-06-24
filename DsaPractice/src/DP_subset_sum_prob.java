package DsaPrac.DsaPractice.src;//subset set problem asks you to find out whether there exists a subset from the array which the sum can result into the target/sum asked.
//eg: [2 3 5 7 8 10], sum=11

/*
our job is to return true in the above eg as [3,8] --> 3+8 = 11 . sum achievable
 */
//reference: Aditya verma dynamic programming lec subset sum prob
public class DP_subset_sum_prob {

    private static boolean[][] tab ;

    public static boolean subsetProb(int[] arr, int sum) {
        tab = new boolean[arr.length+1][sum+1];
        tab[0][0] = true; // If we have 0 sum to be made from 0 items from the array then the answer is true , [] null set is the answer.

        for (int i = 1; i <= arr.length; i++) {
            tab[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            tab[0][i] = false;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    tab[i][j] = (tab[i - 1][j - arr[i-1]]) || (tab[i - 1][j]);
                } else {
                    tab[i][j] = tab[i - 1][j];
                }
            }
        }
        return tab[arr.length][sum];
    }

    public static void printArr(){
        for(int i=0 ; i<=6 ; i++){
            for(int j=0 ; j<=11 ;j++){
                System.out.print(tab[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,8,7,10};
        int sum = 11;
        boolean nooo  = subsetProb(arr,sum);
        System.out.println(nooo);
        printArr();

    }
}
