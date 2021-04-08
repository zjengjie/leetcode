/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int a = 0, b = nums.length -1;
        while(a < b) {
            if (nums[a] < nums[b])
                return nums[a];
            int mid = (a + b)/2;
            if (nums[mid] < nums[a]) {
                b = mid;
            } else if (nums[mid] > nums[a]) {
                a = mid + 1;
            } else {
                return nums[b];
            }
        }
        return nums[a];
    }
}
// @lc code=end

