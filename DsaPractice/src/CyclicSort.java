//Cycle Sort
// This Sorting algo is used when we know something like the numbers from range 1 to N are unsorted.
/*
eg: [3 5 1 4 2] --> [1 2 3 4  5]
eg. [9 6 7 5 2 3 10 8 1] --> [1 2 3 4 5 6 7 8 9 10]

logic:
    the correct position of all elements is index+1, if the number is not at index+1 then we know its not sorted yet
    eg: in [3 5 1 4 2] --> [1 2 3 4 5]
    when sorted 1 is at 0 index, 2 is at index 1, 3 is at index 2 and so on..

So we check if number value = curr index +1 or not
            if not swap the current element to the correct index it should br at (eg: 3 is at index 0 but it should
                be at index 2 , so swap with element at index 2)
            then check again if the number at ndex 0 is expected number or not (i.e Number 1) , if not step 2 again
            continue this till the number at the index 0 is 1. Move pointer to index 1 and repeat from step 1.

So basically : 1.Check 2.Swap 3.Move pointer */

import java.util.Random;

public class CyclicSort {
    public static int[] generateUniqueRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random();

        // Fill the array with unique numbers from 1 to n
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        // Shuffle the array to randomize the order
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(n);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }

        return array;
    }
    public static int[] cyclicSort(int[] arr){
        int n = arr.length;
        int i=0;
        while(i<arr.length-1) {
            if (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
            else {
                i++;
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int n = 15;
        int[] uniqueArray = generateUniqueRandomArray(n);

        System.out.println("Jumbled Numbers upto N integers:");
        for (int number : uniqueArray) {
            System.out.print(number + " ");
        }
        System.out.println("\nSorted Numbers upto N integers:");
        int[] sortedArr = cyclicSort(uniqueArray);

        for (int number : sortedArr) {
            System.out.print(number + " ");
        }
    }
}
