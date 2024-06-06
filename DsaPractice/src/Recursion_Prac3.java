//Summation of Numbers till 'N' by recursion (Use Backtracking)
public class Recursion_Prac3 {

    static void sumNumbers(int n , int sum){
        if(n<1){
            System.out.println(sum);
            return;
        }
        sumNumbers(n-1 , sum+n);
    }

    public static void main(String[] args) {
        sumNumbers(3,0);
    }
}

