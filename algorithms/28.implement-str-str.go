/*
 * @lc app=leetcode id=28 lang=golang
 *
 * [28] Implement strStr()
 */

// @lc code=start
func strStr(haystack string, needle string) int {
	m := len(haystack)
	n := len(needle)
	if m < n {
		return -1
	}
	if n == 0 {
		return 0
	}
	match := true
	for i, _ := range haystack[:m-n+1] {
		match = true
		for j, nc := range needle {
			if haystack[i+j] != byte(nc) {
				match = false
				break
			}
		}
		if match {
			return i
		}
	}
	return -1
}

// @lc code=end
