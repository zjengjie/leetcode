/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
// 把数组分成[0,n-1]和[1,n]两个分别计算。dp保存第i个房子之前的
// 最大值，第i个最大值为dp[i-2]+nums[i]和dp[i-1]中的最大值。
class Solution {
    public int rob(int[] nums) {
        if (nums.length < 3) {
            int max = nums[0];
            for(int i=1; i<nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i= 2; i < nums.length-1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i-1]);
        }
        int max = Math.max(dp[nums.length-2], dp[nums.length-3]);
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for(int i= 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i-1]);
        }
        return Math.max(max, Math.max(dp[nums.length-1], dp[nums.length-2]));
    }
}
// @lc code=end

