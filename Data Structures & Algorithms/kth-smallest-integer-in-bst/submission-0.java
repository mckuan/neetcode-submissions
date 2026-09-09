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
        int[] tmp = new int[2]; //create an array of two values
        tmp[0] = k; //first value is k
        dfs(root,tmp); //call the inorder on the root and array
        return tmp[1]; //return the the node (last node if k == num of nodes)
    }
    private void dfs(TreeNode node, int[] tmp){
        if (node == null) return; //base case 

        dfs(node.left, tmp);//inorder traversal go left
        tmp[0] -= 1; // decrement k 
        if (tmp[0] == 0) { //if we reach k first 
            tmp[1] = node.val; //return the curr node 
            return;
        }
        dfs(node.right, tmp); //inorder traversal go right
    }
}

//get this into a inorder array/list and then get the kth element
