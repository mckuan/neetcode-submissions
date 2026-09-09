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
        Queue<TreeNode> tracker = new LinkedList(); // create tracker queue for nodes
        List<List<Integer>> result = new ArrayList();// create your outer result arraylist

        if (root != null){ //if your root isnt null 
            tracker.add(root); //queue the root

            while (!tracker.isEmpty()){ //while your tracker isnt empty
                List<Integer> level = new ArrayList();//create a level (while loop loops after each level)
                int size = tracker.size(); // this has to be here bc the size changes everywhere else

                for (int i = 0; i < size; i++){ //while i is smaller than tracker size
                    TreeNode curr = tracker.peek(); //create a node for the first node
                    tracker.remove();//dequeue the first node
                    if (curr != null){ //if that node isnt null
                        level.add(curr.val);// add it to your level list
                        if (curr.left != null) tracker.add(curr.left);//if its children arent null add it to the tracker
                        if (curr.right != null) tracker.add(curr.right);
                    }
                }
                result.add(level); //add the level to the result
            }
        }
        return result;
        
    }
}
