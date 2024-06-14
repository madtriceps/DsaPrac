package DsaPrac.DsaPractice.src;//Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
//You may return the answer in any order.
//Example 1:
//        Input: n = 4, k = 2
//        Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//        Explanation: There are 4 choose 2 = 6 total combinations.
//        Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
//Example 2:
//        Input: n = 1, k = 1
//        Output: [[1]]
//        Explanation: There is 1 choose 1 = 1 total combination.

import java.util.ArrayList;
import java.util.List;

public class Backtracking_combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finans = new ArrayList<>();
        backtrack(finans, new ArrayList<>(), 1, n, k);
        return finans;
    }

    private void backtrack(List<List<Integer>> finans, List<Integer> tempList, int start, int n, int k) {
        if (tempList.size() == k) {
            finans.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(finans, tempList, i + 1, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Backtracking_combinations bc = new Backtracking_combinations();
        List<List<Integer>> ll = bc.combine(5,3);
        System.out.print(ll);

    }

}
