/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 二叉搜索树中序遍历是升序，前后相减找到最小
class Solution {
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (pre != null)
            min = Math.min(min, node.val - pre.val);
        pre = node;
        dfs(node.right);
    }
}
// @lc code=end

