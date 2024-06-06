public class InsertionSort {
    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i]; // Store the current element

            // Move elements of arr[0..i-1] that are greater than temp to one position ahead of their current position
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp; // Place temp in its correct position
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 6, 7, 5, 1, 8, 11, 16, 12};
        arr = insertionSort(arr);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
