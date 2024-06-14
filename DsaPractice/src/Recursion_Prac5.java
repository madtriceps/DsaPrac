package DsaPrac.DsaPractice.src;

import java.util.ArrayList;
import java.util.List;

public class Recursion_Prac5 {

    static void subsequenceArr(int idx, List<Integer> ll, int[] arr, int n) {
        if (idx == n) {
            if (ll.size() == 0) {
                System.out.print("{}");
            } else {
                for (int x : ll) {
                    System.out.print(x);
                }
            }
            System.out.println();
            return;
        }

        // Include the current element
        ll.add(arr[idx]);
        subsequenceArr(idx + 1, ll, arr, n);

        // Exclude the current element
        ll.remove(ll.size() - 1);
        subsequenceArr(idx + 1, ll, arr, n);

    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2 };
        List<Integer> ll = new ArrayList<Integer>();
        int len = arr.length;
        subsequenceArr(0, ll, arr, len);
    }
}
