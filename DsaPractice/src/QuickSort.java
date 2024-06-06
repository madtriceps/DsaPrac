import java.util.Random;

public class QuickSort {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low, j = high - 1;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int idx = partition(arr, low, high);
            quickSort(arr, low, idx - 1);
            quickSort(arr, idx + 1, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("Array before sorting:");
        for (int x : arr) {
            System.out.print(" " + x);
        }

        int low = 0;
        int high = arr.length - 1;
        int[] newArr = quickSort(arr, low, high);

        System.out.println("\nArray after sorting:");
        for (int x : newArr) {
            System.out.print(" " + x);
        }
    }
}
