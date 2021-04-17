/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (21.35%)
 * Likes:    1584
 * Dislikes: 1654
 * Total Accepted:    169.5K
 * Total Submissions: 793K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * Given an integer array nums and two integers k and t, return true if there
 * are two distinct indices i and j in the array such that abs(nums[i] -
 * nums[j]) <= t and abs(i - j) <= k.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^4
 * 0 <= t <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1 || t < 0 || k <= 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        set.add((long)nums[0]);
        for(int i=1; i<nums.length; i++) {
            Long nj = set.ceiling((long)nums[i] - t);
            if (nj != null && nj <= (long)nums[i]+t)
                return true;
            if (i >= k) {
                set.remove((long)nums[i-k]);
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}
// @lc code=end

