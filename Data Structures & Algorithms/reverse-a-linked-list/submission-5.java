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
        ListNode reverse = new ListNode();
        reverse.val = head.val;
        head = head.next; 
        while (head != null){
            ListNode tmp = new ListNode();
            tmp.val = head.val;
            tmp.next = reverse;
            reverse = tmp;
            head = head.next;
        }
        return reverse;

    }
}
