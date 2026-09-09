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
        if (root == null) return true;
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean helper(TreeNode root, int max, int min){
        if (root == null) return true;

        if (root.val < max && root.val > min) {
            return helper(root.left, root.val, min) && helper(root.right, max, root.val);
        } return false;
    }
}
