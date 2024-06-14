package DsaPrac.DsaPractice.src;

//Fibonacci sequence by recursion
public class Recursion_multiple_1 {

    static int fibonacciSeq (int n){
        if(n<=1){
            return n;
        }
        return fibonacciSeq(n-1) + fibonacciSeq(n-2);
    }

    public static void main(String[] args) {
        System.out.print(fibonacciSeq(50));
    }
}
// 0 1 1 2 3 5 8 13 ....
//f(5) = 5
