/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int[] sum = new int[matrix[0].length];
                for (int l = 0; l < matrix[0].length; l++) {
                    sum[l] = sum[l] + matrix[i][l];
                }
                ans = Math.max(ans,maxSumSubarray(sum, k));
            }
        }
        return ans;
    }

    public int maxSumSubarray(int[] arr, int k) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null) {
                ans = Math.max(ans, sum - ceiling);
            }
            set.add(sum);
        }
        return ans;
    }
}
// @lc code=end

