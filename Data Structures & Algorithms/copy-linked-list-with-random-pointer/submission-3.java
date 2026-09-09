/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> otoc = new HashMap<>();
        otoc.put(null,null);

        Node curr = head;
        while (curr != null){
            if (!otoc.containsKey(curr)){
                otoc.put(curr, new Node(0));
            }
            otoc.get(curr).val = curr.val;

            if (!otoc.containsKey(curr.next)){
                otoc.put(curr.next, new Node(0));
            }
            otoc.get(curr).next = otoc.get(curr.next);

            if (!otoc.containsKey(curr.random)){
                otoc.put(curr.random, new Node(0));
            }
            otoc.get(curr).random = otoc.get(curr.random);
            curr = curr.next;
        }
        return otoc.get(head);
    }
}
