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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> track = new LinkedList<>();

        track.add(root);

        while (!track.isEmpty()){
            int levelsize = track.size();
            int lastright = -1;

            for (int i = 0; i < levelsize; i++){
                TreeNode curr = track.remove();

                if (curr != null) lastright = curr.val;

                if(curr != null){
                    if (curr.left != null) track.add(curr.left);
                    else track.add(null);
                    if (curr.right != null) track.add(curr.right);
                    else track.add(null);
                }
            }
            if (lastright != -1) res.add(lastright);
        }
        return res;
        
    }
}
