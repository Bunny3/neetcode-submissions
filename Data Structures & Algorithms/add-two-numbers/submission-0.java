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
        int carry = 0;
        ListNode c1 = l1, c2=l2;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(c1!=null || c2!=null || carry!=0) {
            int v1 = (c1 != null) ? c1.val : 0;
            int v2 = (c2 != null) ? c2.val : 0;

            int val = v1 + v2 + carry;
            carry = val/10;
            val = val%10;
            curr.next = new ListNode(val);
            curr = curr.next;
            c1 = (c1!=null) ? c1.next: null;
            c2 = (c2!=null) ? c2.next:null;
        }
        return dummy.next;
    }
}
