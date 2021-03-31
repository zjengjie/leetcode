/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = findRow(matrix, target);
        return binarySearch(matrix[index], target);
    }

    public int findRow(int[][] arr, int target) {
        int less = 0, greater = arr.length - 1;
        while(less < greater) {
            int mid = (less + greater) / 2;
            if (target == arr[mid][0])
                return mid;

            if (target < arr[mid][0]) {
                greater = mid;
            } else {
                if (mid == greater - 1) {
                    return arr[greater][0] > target ? mid : greater; 
                }
                less = mid;
            }
        }
        return less;
    }

    public boolean binarySearch(int[] arr, int target) {
        int less = 0, greater = arr.length - 1;
        while(less < greater) {
            int mid = (less + greater) / 2;
            if (target == arr[mid])
                return true;

            if (target < arr[mid]) {
                greater = mid - 1;
            } else {
                less = mid + 1;
            }
        }
        return arr[less] == target;
    }
}
// @lc code=end

