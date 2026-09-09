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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode prev = null; 

        int carry = 0;
        while(curr1 != null && curr2 != null){
            curr1.val = curr1.val + curr2.val + carry;
            carry = 0;
            while (curr1.val > 9){
                curr1.val -= 10;
                carry++; 
            }
            prev = curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if (curr2 != null) {
            prev.next = curr2;  
            curr1 = prev.next;
        }

         while (carry > 0 && curr1 != null) {
            curr1.val = curr1.val + carry;
            carry = curr1.val / 10;
            curr1.val = curr1.val % 10;
            prev = curr1;
            curr1 = curr1.next;
        }
        
        // If carry still exists, create a new node
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        
        
        return l1;
    }
}
