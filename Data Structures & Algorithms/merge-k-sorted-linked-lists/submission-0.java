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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        ListNode res = lists[0];

        for (int i = 1; i < lists.length; i++){
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            ListNode l1 = res;
            ListNode l2 = lists[i];
            while (l1 != null && l2 != null){
                if (l1.val > l2.val){
                    curr.next = l2;
                    curr = curr.next;
                    l2 = l2.next;
                } else {
                    curr.next = l1;
                    curr = curr.next;
                    l1 = l1.next;
                }
            }
            if (l1 != null){
                curr.next = l1;
            }
            if (l2 != null){
                curr.next = l2;
            }
            res = dummy.next;
        }
        return res;
    }
}
