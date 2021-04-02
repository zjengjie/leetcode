/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if(height.length <= 2) {
            return 0;
        }
        int[] maxIndex = new int[2];
        int max = -1;
        // 找出最高的index，可能有多个，保存两边的两个
        for(int i=0; i<height.length; i++) {
            if(height[i] > max) {
                maxIndex[0] = i;
                max = height[i];
                maxIndex[1] = i;
            } else if(height[i] == max) {
                maxIndex[1] = i;
            }
        }
        int index = 0, res = 0;
        for(int i=1; i <= maxIndex[0]; i++) {
            if (height[i] >= height[index]) {
                int j = index + 1;
                while(j < i) {
                    res = res + (height[index] - height[j]);
                    j++;
                }
                index = i;
            }
        }

        if (maxIndex[0] < maxIndex[1]-1) {
            for(int i = maxIndex[0]+1; i < maxIndex[1]; i++) {
                res = res + (height[maxIndex[0]] - height[i]);
            }
        }

        index = height.length-1;
        for(int i=height.length-2; i >= maxIndex[1]; i--) {
            if (height[i] >= height[index]) {
                int j = index - 1;
                while(j > i) {
                    res = res + (height[index] - height[j]);
                    j--;
                }
                index = i;
            }
        }
        return res;

    }
}
// @lc code=end

