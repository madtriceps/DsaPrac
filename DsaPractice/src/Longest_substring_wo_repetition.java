package DsaPrac.DsaPractice.src;

import java.util.*;

public class Longest_substring_wo_repetition {

    // Method 1: O(n^2) approach
    public static int lswr1(String s) {
        int[] hash = new int[256];
        StringBuffer sb = new StringBuffer();
        List<String> ss = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(hash, 0);  // Reset the hash array for each new starting point
            sb.setLength(0);
            for (int j = i; j < s.length(); j++) {
                int val = s.charAt(j);
                if (hash[val] == 1) {
                    break;
                }
                sb.append(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
                hash[val] = 1;
            }
            ss.add(sb.toString());
        }

        // Print the longest substring
        for (String sub : ss) {
            if (sub.length() == maxLength) {
                System.out.println(sub);
                break;
            }
        }

        return maxLength;
    }

    // Method 2: O(n) approach
    public static int lswr2(String s) {
        Map<Character, Integer> sett = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while (j < s.length()) {
            if (sett.containsKey(s.charAt(j))) {
                int temp = sett.get(s.charAt(j));
                if (temp >= i) {
                    i = temp + 1;
                }
            }
            sett.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "cabdzabjklobbbbbbawsdrtypoa";
        System.out.println("Length of the longest substring without repeating characters (Method 1): " + lswr1(str));
        System.out.println("Length of the longest substring without repeating characters (Method 2): " + lswr2(str));
        System.out.println("\nIn the first method we're also storing the longest subsequece for cross\n checking if correct subsequence is read or not,not asked in question");
    }
}
