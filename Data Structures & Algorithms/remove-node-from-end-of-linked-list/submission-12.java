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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode curr = head;
        
        for (int i = 0; i < n ; i++){
            curr = curr.next;
        }

        if (curr == null) return head.next;

        while (curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }
        if (prev.next == curr ){
            prev.next = null;
        } else {
            ListNode tmp = prev;
            prev = prev.next.next;
            tmp.next = prev;
            prev = tmp;
        }
        return head;

    }
}
