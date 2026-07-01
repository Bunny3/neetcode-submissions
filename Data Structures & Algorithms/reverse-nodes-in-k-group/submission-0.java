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
        int count = 0;
        ListNode curr = head;
        if(head == null)
            return null;
        while(curr!=null){
            count++;
            if(count >k) 
                break;
            curr = curr.next;
        }
        if(count < k)
            return head;
        count = 0;
        curr = head;

        ListNode prev = null;
        while(curr!=null && count<k){
            count++;
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = reverseKGroup(curr,k);
        return prev;
    }
}
