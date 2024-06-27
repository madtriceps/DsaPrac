package DsaPrac.DsaPractice.src;

public class DP_minimumSubsetSumDifference {
    static boolean[][] tab;

    public static int minSumDiff(int[] arr){
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }
        boolean[] s1 = subsetSumDiff(arr, totalSum);
        int mn = Integer.MAX_VALUE;
        for(int i = 0; i <= totalSum / 2 ; i++){
            if(s1[i]){
                mn = Math.min(mn, totalSum - 2 * i);
            }
        }

        return mn;
    }

    public static boolean[] subsetSumDiff(int[] arr , int totalSum){
        tab = new boolean[arr.length + 1][totalSum + 1];
        tab[0][0] = true;

        for(int k = 1; k <= totalSum; k++){
            tab[0][k] = false;
        }
        for(int k = 1; k <= arr.length; k++){
            tab[k][0] = true;
        }

        for(int i = 1; i <= arr.length ; i++){
            for(int j = 1 ; j <= totalSum; j++){
                if(arr[i - 1] <= j){
                    tab[i][j] = tab[i - 1][j - arr[i - 1]] || tab[i - 1][j];
                } else {
                    tab[i][j] = tab[i - 1][j];
                }
            }
        }

        boolean[] s1 = new boolean[totalSum / 2 + 1];

        for(int i = 0; i <= totalSum / 2; i++){
            if(tab[arr.length][i]) {
                s1[i] = true;
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        System.out.println("For Array 1 {2, 5, 3, 4, 6} , min diff :"+minSumDiff(new int[] {2, 5, 3, 4, 6})); // Output: 0
        System.out.println("For Array 1 {1, 9, 11} , min diff :"+minSumDiff(new int[] {1, 9, 11})); // Output: 1
    }
}
