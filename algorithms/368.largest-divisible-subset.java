import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {

    // 考虑到整除具有传递性，a%b=0, b%c=0，则 a%c=0。
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int index = 0;
        int[] dp = new int[nums.length];
        int begin = 0;
        while (nums[begin] == 0) {
            begin++;
        }
        for (int i = begin+1; i < nums.length; i++) {
            for (int j = i-1; j >= begin; j--) {
                if (dp[i] <= dp[j] && nums[i] % nums[j] == 0) {
                    dp[i] = dp[j]+1;
                    if (dp[i] > dp[index]) {
                        index = i;
                    }
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>(dp[index] + 1);
        res.add(nums[index]);
        int pre = index;
        index--;
        while (index >= begin) {
            if (dp[index] == dp[pre] -1 && nums[pre] % nums[index] ==0) {
                res.add(nums[index]);
                pre = index;
            }
            index--;
        }
        return res;
    }
}
// @lc code=end

