/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length <=2) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int leftMax = height[0];
        int rightMax = height[right];
        int res = 0;
        while(left<right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

