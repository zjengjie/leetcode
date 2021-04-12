/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            str[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(str, (s1, s2) -> (s1+s2).compareTo(s2+s1));
        StringBuilder sb = new StringBuilder();
        for(int i=nums.length-1; i>=0; i--) {
            sb.append(str[i]);
        }
        String result = sb.toString();
        if (result.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}
// @lc code=end

