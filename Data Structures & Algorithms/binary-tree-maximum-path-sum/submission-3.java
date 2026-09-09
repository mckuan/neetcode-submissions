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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root){
        if (root == null) return 0;

        int leftmax = Math.max(dfs(root.left), 0);
        int rightmax = Math.max(dfs(root.right), 0);

        int totalPath = root.val + leftmax + rightmax;
        max = Math.max(max, totalPath);

        return root.val + Math.max(leftmax, rightmax);   
    }
}
