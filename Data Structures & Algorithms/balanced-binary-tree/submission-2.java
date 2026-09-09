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
    public boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1) return false;
        return true;
    }

    private int getHeight(TreeNode root){
        if (root == null) return 0;

        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        if (lHeight == -1) return -1;
        if (rHeight == -1) return -1;

        if (Math.abs(lHeight - rHeight) > 1) return -1;
        return Math.max(lHeight, rHeight) + 1;

    }
}
