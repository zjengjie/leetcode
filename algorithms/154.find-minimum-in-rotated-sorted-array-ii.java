/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int a=0, b=nums.length-1;
        while(a < b) {
            int mid = (a+b)/2;
            if (nums[mid] < nums[b]) {
                b = mid;
            } else if (nums[mid] > nums[b]) {
                a = mid + 1;
            } else {
                b--;
            }
        }
        return nums[a];
    }
}
// @lc code=end

