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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the logic
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        // Traverse both lists while both have nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;   // Attach list1 node
                list1 = list1.next;  // Move list1 forward
            } else {
                curr.next = list2;   // Attach list2 node
                list2 = list2.next;  // Move list2 forward
            }
            curr = curr.next;  // Move curr forward
        }
        
        // Attach remaining nodes from either list
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        
        // Return the head (skip the dummy node)
        return dummy.next;
    }
}