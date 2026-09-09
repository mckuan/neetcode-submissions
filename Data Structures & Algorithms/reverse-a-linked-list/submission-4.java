/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> tmp = new Stack();
        ListNode curr = head;
        while (curr != null){
            tmp.push(curr);
            curr = curr.next;
        }

        ListNode reverse = tmp.pop();
        ListNode current = reverse;
        while (!tmp.isEmpty()){
            current.next = tmp.pop();
            current = current.next;
            current.next = null;
        }

        return reverse;
        
    }
}
