import java.util.Scanner;

//Printing the name n number of times by recursion
public class Recursion_Prac1 {
    static void printName(int i ,int n){
        if(i>n) {return;}
        System.out.println("Madhav Jha" + " Current i = "+i);
        printName(++i, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of times to print the name: ");
        int n = sc.nextInt();
        printName(0,n);

    }
}
