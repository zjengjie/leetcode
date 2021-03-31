/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while(flag) {
            if (index >= strs[0].length())
                break;
            char c = strs[0].charAt(index);
            for(int i=1; i<strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                sb.append(c);
            index++;
        }
        return sb.toString();
    }
}
// @lc code=end

