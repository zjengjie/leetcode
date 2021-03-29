/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = (n << 16) | (n >>> 16);
        n = (n & 0xff00ff00) >>> 8 | (n & 0x00ff00ff) << 8;
        n = (n & 0xf0f0f0f0) >>> 4 | (n & 0x0f0f0f0f) << 4;
        n = (n & 0xcccccccc) >>> 2 | (n & 0x33333333) << 2;
        return (n & 0xaaaaaaaa) >>> 1 | (n & 0x55555555) << 1;
    }

    public int reverseBits2(int n) {
        n = (n << 16) | (n >>> 16);
        n = (n & 0b11111111000000001111111100000000) >>> 8 | (n & 0b00000000111111110000000011111111) << 8;
        n = (n & 0b11110000111100001111000011110000) >>> 4 | (n & 0b00001111000011110000111100001111) << 4;
        n = (n & 0b11001100110011001100110011001100) >>> 2 | (n & 0b00110011001100110011001100110011) << 2;
        return (n & 0b10101010101010101010101010101010) >>> 1 | (n & 0b01010101010101010101010101010101) << 1;
    }
}
// @lc code=end

