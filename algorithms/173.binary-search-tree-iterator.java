/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {

    private final TreeNode root;
    private final LinkedList<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        stack.add(root);
        TreeNode node = root;
        while(node.left != null) {
            stack.add(node.left);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pollLast();
        int res = node.val;
        if (node.right != null) {
            stack.add(node.right);
            node = node.right;
            while(node.left != null) {
                stack.add(node.left);
                node = node.left;
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        return stack.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

