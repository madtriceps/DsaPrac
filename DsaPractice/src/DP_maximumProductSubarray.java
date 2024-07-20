package DsaPrac.DsaPractice.src;

//When we say subArray it must be consecutive
public class DP_maximumProductSubarray {

    // Method 1: Recursive approach. Not feasible for large inputs. TC: 2^n (It forms a binary tree)
    static int maxProductSubarrayRecursive(int[] input, int currentIndex, int currentProduct, int maxProduct) {
        if (currentIndex == input.length) {
            return maxProduct;
        }

        // Calculate product including the current element
        int includeCurrent = maxProductSubarrayRecursive(input, currentIndex + 1, currentProduct * input[currentIndex],
                Math.max(maxProduct, currentProduct * input[currentIndex]));

        // Calculate product excluding the current element (reset currentProduct to 1)
        int excludeCurrent = maxProductSubarrayRecursive(input, currentIndex + 1, 1, maxProduct);

        // Return the maximum product found
        return Math.max(includeCurrent, excludeCurrent);
    }

    // Method 2: DP approach by tabulation (bottom-up approach). TC: O(n), SC: O(1)
    static int maxProductSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] maxProduct = new int[n];
        int[] minProduct = new int[n];

        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                maxProduct[i] = Math.max(nums[i], maxProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(nums[i], minProduct[i - 1] * nums[i]);
            } else {
                maxProduct[i] = Math.max(nums[i], minProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(nums[i], maxProduct[i - 1] * nums[i]);
            }

            result = Math.max(result, maxProduct[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, -1, -2, -6};
        int maxProductRecursive = maxProductSubarrayRecursive(input, 0, 1, Integer.MIN_VALUE);
        System.out.println("Maximum Product SubArray, By Recursion Method: " + maxProductRecursive);
        System.out.println("Maximum Product SubArray, By DP approach Method: " + maxProductSubarray(input));
    }
}
