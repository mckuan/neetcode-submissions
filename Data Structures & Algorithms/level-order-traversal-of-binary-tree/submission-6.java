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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> track = new LinkedList<>();
        track.add(root);

        while (!track.isEmpty()){
            int levelsize = track.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < levelsize ; i++){
                TreeNode curr = track.remove();

                if (curr != null) {
                    level.add(curr.val);
                    if (curr.left != null) track.add(curr.left);
                    if (curr.right != null) track.add(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
















