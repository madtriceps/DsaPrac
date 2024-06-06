import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] randomArr = new int[10];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = r.nextInt(10000);
        }
        System.out.println("Unsorted Array is:\n");
        for (int x : randomArr) {
            System.out.print(x + " ");
        }
        mergeSort(randomArr, 0, randomArr.length - 1);

        System.out.println("\nSorted Array is:\n");
        for (int x : randomArr) {
            System.out.print(x + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
