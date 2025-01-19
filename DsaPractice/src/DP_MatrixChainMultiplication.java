package DsaPrac.DsaPractice.src;

public class DP_MatrixChainMultiplication
{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        DP_MatrixChainMultiplication obj = new DP_MatrixChainMultiplication();
        System.out.println(obj.solveMCM(arr,1,arr.length-1));
    }

    public int solveMCM(int[] arr , int i, int j ){
        int minAns = Integer.MAX_VALUE;
        if(i>=j){
            System.out.println("x1 = "+arr[i]+", x2 = "+arr[j]);
            return 0;
        }

        for(int k=i ; k<=j-1 ;k++){
            int tempAns = solveMCM(arr,i,k)+solveMCM(arr,k+1,j)+ (arr[i-1]*arr[k]*arr[j]);
            System.out.println("Current tempAns: "+tempAns+", n1 = "+arr[(i-1)]+" , n2 = "+arr[k] + ", n3 = "+arr[j]);
            if(tempAns<minAns){
                minAns = tempAns;
            }
        }
        return minAns;
    }
}
