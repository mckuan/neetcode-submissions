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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> tracker = new LinkedList();

        tracker.add(root); 
        while (!tracker.isEmpty()){
            TreeNode curr = tracker.peek();
            if (curr.val == subRoot.val){
                if (isSubtreeHelper(curr, subRoot)){
                    return true;
                }
            }
            tracker.remove();
            if (curr.left != null) tracker.add(curr.left);
            if (curr.right != null) tracker.add(curr.right);
        }
        return false;
    }

    private boolean isSubtreeHelper(TreeNode root, TreeNode subRoot){
        if (root== null && subRoot == null) {
            return root == subRoot;
        } else if (root != null && subRoot != null){
            if (root.val == subRoot.val){
                return isSubtreeHelper(root.left, subRoot.left) && isSubtreeHelper(root.right, subRoot.right);
            } else {
                return false;
            }
        } else {
                return false;
            
        }
    }
}
