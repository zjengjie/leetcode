/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int)Math.sqrt(c);
        int a2 = 0, b2 = b*b;
        while (a <= b) {
            int sum = a2 + b2;
            if (sum > c) {
                b--;
                b2 = b*b;
            } else if (sum < c) {
                a++;
                a2 = a*a;
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

