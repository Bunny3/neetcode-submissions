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
       ListNode current1=list1,current2=list2;
       ListNode ans = new ListNode();
       ListNode head = ans;
       while(current1!=null && current2!=null) {
        if(current1.val <current2.val) {
            ans.next = current1;
            ans = ans.next;
            current1 = current1.next;
        }
        else {
            ans.next = current2;
            ans = ans.next;
            current2 = current2.next;
        }
       }
       while(current1!=null) {
        ans.next = current1;
        ans = ans.next;
        current1 = current1.next;
       }
       while(current2!=null) {
        ans.next = current2;
        ans = ans.next;
        current2 = current2.next;
       }
    //    ans.next = null;
        return head.next;
    }
}