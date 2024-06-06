public class RotateArray {
    //The idea is we will be given an array and an input k, we have to rotate the array(shift it) by k

    public static int[] rotateArray(int[] arr , int k) {
        int[] rarr = new int[arr.length];

        //[1 2 3 4 5 6 7] --> [5 6 7 1 2 3 4]
        if (k <= arr.length) {

            int i = arr.length - k;
            int j = 0;
            while (i < arr.length) {
                rarr[j] = arr[i];
                i++;
                j++;
            }
            i = 0;
            while (j < rarr.length) {
                rarr[j] = arr[i];
                j++;
                i++;
            }

        }
        else{
            //If the rotation is more than the length of the array , then effectively it is only k-arr.length
            //This is because after arr.length rotations, the array becomes same as original.
            k=k%arr.length;
            rarr = rotateArray(arr,k);
        }
        return rarr;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k=3;
        arr = rotateArray(arr,k);
        for(int x: arr){
            System.out.println(x);
        }

    }
}

