public class SelectionSort {
    public static int[] selectionSort(int[] arr){

        for(int i=0 ; i< arr.length-1 ; i++){
            int min = arr[i];
            int p=0; //The p variable wil keep a track of the index of the min number in the remaining unsorted array
            for(int j=i+1;j< arr.length ; j++){
                System.out.println("Comparing "+arr[j] + " and " + min);
                if(arr[j]<min){
                    min = arr[j];
                    p=j;
                }
            }
            if(arr[i] != min) {
                int temp = arr[p];
                arr[p] = arr[i];
                arr[i] = temp;
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {10,6,7,5,1,8,11,16,12};
        int [] array1 = selectionSort(arr);
        for(int x : array1){
            System.out.println(x);
        }

    }
}
