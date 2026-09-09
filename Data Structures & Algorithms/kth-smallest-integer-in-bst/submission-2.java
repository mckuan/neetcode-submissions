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
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> track = new LinkedList<>();
        inOrder(root, track);
        for (int i = 1; i < k; i++){
            track.remove();
        }
        int ans = track.peek();
        return ans;    
    }
    private void inOrder(TreeNode curr, Queue<Integer> queue) {
        if (curr == null) return;

        inOrder(curr.left, queue);
        queue.add(curr.val);
        inOrder(curr.right, queue);
    }
}
