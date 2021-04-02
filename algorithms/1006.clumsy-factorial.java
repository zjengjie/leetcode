/*
 * @lc app=leetcode id=1006 lang=java
 *
 * [1006] Clumsy Factorial
 */

// @lc code=start
class Solution {

    public int clumsy(int N) {
        if (N <= 2) return N;
        if (N < 4) return 6;
        int res = N * (N-1) / (N-2) + (N -3);
        N-=4;
        while (N >= 4) {
            res = res - N * (N-1) / (N-2) + (N -3);
            N-=4;
        }
        return res - clumsy(N);
    }
}
// @lc code=end
