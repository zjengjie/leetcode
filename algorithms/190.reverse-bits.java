/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++) {
            int last = n & 1;
            res <<= 1;
            res |= last;
            n >>>= 1;
        }
        return res;
    }
}
// @lc code=end

