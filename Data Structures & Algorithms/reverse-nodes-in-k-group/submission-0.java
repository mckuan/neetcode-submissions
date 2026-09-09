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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevTail = null;
        boolean isFirstGroup = true;
        
        int i = 0;

        while (fast != null){
            fast = fast.next;
            i++;
            if (i == k){
                // Store the next group start BEFORE reversal
                ListNode nextGroupStart = fast;
                
                // Save the original start (will become tail after reversal)
                ListNode originalStart = slow;
                
                // Reverse the current group
                ListNode rev = slow;
                ListNode curr = slow.next;
                while (curr != nextGroupStart){
                    ListNode nextTemp = curr.next;
                    curr.next = rev;
                    rev = curr;
                    curr = nextTemp;
                }
                
                // Connect previous group's tail to this group's new head
                if (prevTail != null) {
                    prevTail.next = rev;
                }
                
                // Update head if this is the first group
                if (isFirstGroup) {
                    head = rev;
                    isFirstGroup = false;
                }
                
                // Connect this group's tail to next group
                originalStart.next = nextGroupStart;
                
                // Update prevTail for next iteration
                prevTail = originalStart;
                
                // Move slow to the next group
                slow = nextGroupStart;
                
                i = 0;
            }
        }
        return head;
    }
}