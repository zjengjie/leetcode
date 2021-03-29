/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0)
            return 0;
        
        for(int i=0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j=1;
                for(; j< needle.length(); j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }
}
// @lc code=end

