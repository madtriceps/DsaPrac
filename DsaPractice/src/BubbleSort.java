public class BubbleSort {

    public static int[] bubbleSort(int[] arr){

        for(int i=0 ; i<arr.length-1; i++){
            boolean swapped = false;
            for(int j=0 ; j<arr.length-1-i ; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]= arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
     return arr;
    }


    public static void main(String[] args) {
        int[] arr = {10,9,8,6,7,5,11,13,14,15,1};
        int[] ints = bubbleSort(arr);
        for(int x: ints){
            System.out.println(x);
        }


    }
}
