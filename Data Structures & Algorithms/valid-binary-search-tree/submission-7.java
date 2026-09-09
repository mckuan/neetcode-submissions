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

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        
        // Check if current node's value violates BST property
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        
        // Recursively check left and right subtrees
        // Left subtree: all values must be < current value, so high = root.val
        // Right subtree: all values must be > current value, so low = root.val
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}