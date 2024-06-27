package DsaPrac.DsaPractice.src;//arr[] = {1,5,6,2,1,1}
// result = true, because yes we can split the array or partition it into two subArrays having equal sum of elements in both.
// arr1={1,5,1,1} & arr2 = {6,2} can be one such possible array as both the subArrays have sum=8
//so if we see the subset sum problem and this are linked, cuz we can pass in (sum of elements in original array)/2 as the target seum
//in that code and check whether getting this is possible or not.


public class DP_EqualSumPartition {
    public static boolean tab[][] ;

    public static boolean equalSumPartition(int[] arr){
        int sum = 0;

        for(int num: arr){
            sum += num;
        }

//      The condition is the sum of array values in original array must be even as an odd sum cannot be equally split no matter what
//        Eg: {2,3,4,5}, sum=15 --> u cannot split 15 in any way no matter how u split the elements max u can get is 7 & 8 in the new arrays.
        if(sum%2 == 0){
            int partitionSumVal = sum/2;
            return subsetSum(arr,partitionSumVal);
        }

        return false;
    }

    public static boolean subsetSum(int[] arr , int target){
        tab = new boolean[arr.length+1][target+1];
        tab[0][0]=true;
        for(int i=1 ; i<= arr.length ; i++){
            tab[i][0] = true;
        }
        for(int i=1 ; i<= arr.length ; i++){
            tab[0][i] = false;
        }

        for(int i=1; i<=arr.length ; i++){
            for(int j=1; j<=target ; j++){
                if(arr[i-1]<=j){
                    tab[i][j] = ( (tab[i-1][j-arr[i-1]] ) || (tab[i-1][j] ));
                }
                else{
                    tab[i][j] = tab[i-1][j];
                }
            }
        }
        return tab[arr.length][target];
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,2,1,1};
        System.out.println(equalSumPartition(arr));
    }
}

