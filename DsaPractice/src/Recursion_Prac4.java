//Recursion to reverse an array of Integers
public class Recursion_Prac4 {
    static int[] reverseArr(int i , int[] arr){
        if(i>=arr.length/2){
            return null;
        }
        //Swapping Logic
        int temp = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = arr[i];
        arr[i] = temp;
        //Recursive Calling the Function
        reverseArr(i+1 , arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,9,3,5,7};
        arr =reverseArr(0,arr);
        for(int i : arr){
            System.out.print(i);
        }
    }
}
