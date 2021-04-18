/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
    private boolean[][][] dp;
    char[] a1;
    char[] a2;

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        a1 = s1.toCharArray();
        a2 = s2.toCharArray();
        int len = s1.length();
        dp = new boolean[len][len][len];
        return isScramble(0, 0, len);
    }

    private boolean isScramble(int i, int j, int length) {
        if (length == 1) {
            return a1[i] == a2[j];
        }
        if (dp[i][j][length-1]) {
            return false;
        }
        for(int index = 1; index < length; index++) {
            if (isScramble(i, j, index)
                    && isScramble(i + index, j + index, length - index))
                return true;
            if (isScramble(i, j + length - index, index)
                    && isScramble(i + index, j, length - index))
                return true;
        }
        dp[i][j][length-1] = true;
        return false;
    }
}
// @lc code=end

