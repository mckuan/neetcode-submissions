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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> track = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        track.add(root);

        while (!track.isEmpty()){
            TreeNode curr = track.remove();
            if (curr == null) res.append("null,");
            else {
                res.append(curr.val + ",");

                if (curr.left == null) track.add(null);
                else track.add(curr.left);
                if (curr.right == null) track.add(null);
                else track.add(curr.right);
            }
        }    
        
        return res.toString();  
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) return null;
    String[] nodes = data.split(",");
    if (nodes.length == 0 || nodes[0].equals("null")) return null;

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    queue.add(root);

    int i = 1;
    while (!queue.isEmpty() && i < nodes.length) {
        TreeNode curr = queue.poll();

        // left child
        if (!nodes[i].equals("null")) {
            curr.left = new TreeNode(Integer.parseInt(nodes[i]));
            queue.add(curr.left);
        }
        i++;

        // right child
        if (i < nodes.length && !nodes[i].equals("null")) {
            curr.right = new TreeNode(Integer.parseInt(nodes[i]));
            queue.add(curr.right);
        }
        i++;
    }
    return root;
}
}
