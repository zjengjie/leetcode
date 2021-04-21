/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int preLast = 1;
        int last = 1;
        int cur = last;
        for(int i= 1; i< s.length(); i++) {
            char curChar = s.charAt(i);
            char preChar = s.charAt(i-1);
            if (curChar == '0') {
                if (preChar == '0' || preChar > '2') {
                    return 0;
                }
                cur = preLast;
            } else {
                if (preChar == '0' || preChar > '2') {
                    cur = last;
                } else if (preChar == '2' && curChar > '6') {
                    cur = last;
                } else {
                    cur = last + preLast;
                }
            }
            preLast = last;
            last = cur;
        }
        return cur;
    }
}
// @lc code=end

