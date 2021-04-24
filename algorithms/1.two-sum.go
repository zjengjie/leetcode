package algorithms

/*
 * @lc app=leetcode id=1 lang=golang
 *
 * [1] Two Sum
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		if j, found := m[target-v]; found {
			return []int{i, j}
		}
		m[v] = i
	}
	return []int{-1, -1}
}

// @lc code=end
