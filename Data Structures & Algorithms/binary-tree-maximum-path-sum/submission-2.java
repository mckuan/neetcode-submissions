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
    public int res = 0;
    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
        
    }
    private int dfs (TreeNode root) {
            if (root == null) return 0;

            int lMax = root.left == null ? 0 : dfs(root.left);
            int rMax = root.right == null ? 0 : dfs(root.right);
            lMax = Math.max(0, lMax);
            rMax = Math.max(0,rMax);

            res = Math.max(res , root.val + lMax + rMax);

            return root.val + Math.max(lMax, rMax);
        }
}
