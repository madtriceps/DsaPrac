//Print from N to 1 using recursion with backtarcking
//so you're not allowed to write function (i-1 , N) as a recursive call
public class Recursion_Prac2 {
    static void printNumFromNto1(int i, int n){
        if(i>n){
            return;
        }
        printNumFromNto1(i+1 , n);
        System.out.println(i);
    }


    public static void main(String[] args) {
        printNumFromNto1(1 , 3);
    }
}
