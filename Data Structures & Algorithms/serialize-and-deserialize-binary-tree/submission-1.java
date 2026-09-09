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
        if (root == null) return "N";
        
        Queue<TreeNode> tracker = new LinkedList();
        String result = "";
        tracker.add(root);

            while (!tracker.isEmpty()){
                TreeNode curr = tracker.peek();
                tracker.remove();
                if (curr == null){
                    result = result.concat("N,");
                } else {
                    result = result.concat(curr.val + ",");
                    tracker.add(curr.left);
                    tracker.add(curr.right);
                }
            }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals[0].equals("N")) return null; 
        
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> tracker = new LinkedList();
        
        tracker.add(root);
        int index = 1;

        while (!tracker.isEmpty()){
            TreeNode curr = tracker.peek();
            tracker.remove();
            if (!vals[index].equals("N")){
                curr.left = new TreeNode(Integer.parseInt(vals[index]));
                tracker.add(curr.left);
            }
            index++;
            if (!vals[index].equals("N")){
                curr.right = new TreeNode(Integer.parseInt(vals[index]));
                tracker.add(curr.right);
            }
            index++;
        }
        return root;
    }
    
}

