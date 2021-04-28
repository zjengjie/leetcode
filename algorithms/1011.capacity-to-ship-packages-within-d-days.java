/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for(int i=0; i < weights.length; i++) {
            right += weights[i];
            left = Math.max(left, weights[i]);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (shipWithCap(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean shipWithCap(int[] weights, int cap, int D) {
        int sum = 0;
        int i=0;
        while (i < weights.length) {
            int nSum = sum + weights[i];
            if (nSum < cap) {
                sum = nSum;
            } else {
                D--;
                if (D == 0 && (nSum > cap || i < weights.length -1))
                    return false;
                sum = nSum == cap ? 0 : weights[i];
            }
            i++;
        }
        return i == weights.length;
    }
}
// @lc code=end

