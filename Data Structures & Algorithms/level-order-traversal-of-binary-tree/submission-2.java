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
        Queue<TreeNode> tracker = new LinkedList();
        List<List<Integer>> result = new ArrayList();

        if (root != null){
            tracker.add(root);

            while (!tracker.isEmpty()){
                int length = tracker.size();
                List<Integer> level = new ArrayList();

                for (int i = 0; i <length; i++){
                    TreeNode curr = tracker.peek();
                    tracker.remove();
                    if (curr != null){
                        level.add(curr.val);
                        if (curr.left != null) tracker.add(curr.left);
                        if (curr.right != null) tracker.add(curr.right);
                    }
                }
            
                result.add(level);
            }
        }
        return result;
        
    }
}
