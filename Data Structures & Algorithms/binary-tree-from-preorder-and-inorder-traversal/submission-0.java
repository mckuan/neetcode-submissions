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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int split = -1;
        for (int i = 0; i < inorder.length ; i++){
            if (root.val == inorder[i]){
                split = i;
                break;
            }
        }

        int[] leftRootPreorder = Arrays.copyOfRange(preorder,1,split+1);
        int[] leftRootInorder = Arrays.copyOfRange(inorder,0,split);

        int[] rightRootPreorder = Arrays.copyOfRange(preorder,split+1,preorder.length);
        int[] rightRootInorder = Arrays.copyOfRange(inorder, split+1, inorder.length);

        root.left = buildTree(leftRootPreorder,leftRootInorder);
        root.right = buildTree(rightRootPreorder,rightRootInorder);

        return root;
        
    }   
}
