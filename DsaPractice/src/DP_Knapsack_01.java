package DsaPrac.DsaPractice.src;

public class DP_Knapsack_01 {
    static int knapSack(int[] wt , int[] val ,int cap , int n){
        if(n==0 || cap==0){
            return 0;
        }
        return Math.max(val[n-1] + knapSack(wt , val, cap-wt[n-1] ,n-1) , knapSack(wt , val, cap ,n-1));
    }

    public static void main(String[] args) {
        int[] wt = {20,60,20,50,15};
        int[] val = {90,130,60,110,42};
        int cap=90;
        int n=5;
        int profitmax = knapSack(wt,val,cap,n);
        System.out.print(profitmax);
    }
}
