/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());
        int index = 0;
        for(int i=0; i< nums.length; i++) {
            int oldSize = res.size();
            if (i == 0 || nums[i] != nums[i-1])
                index = 0;
            for (int j = index; j < oldSize; j++) {
                List<Integer> list = res.get(j);
                ArrayList<Integer> newList = new ArrayList<>(list.size()+1);
                newList.addAll(list);
                newList.add(nums[i]);
                res.add(newList);
            }
            index = oldSize;
        }
        return res;
    }
}
// @lc code=end

