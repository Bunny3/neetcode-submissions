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
    public ListNode mergeList(ListNode node1, ListNode node2) {
        ListNode curr1= node1;
        ListNode curr2= node2;
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while(curr1!=null || curr2!=null) {
            int v1 = curr1!=null? curr1.val:Integer.MAX_VALUE;
            int v2 = curr2!=null? curr2.val:Integer.MAX_VALUE;
            // System.out.println("Inside loop : "+ " v1 = "+v1+" v2 = "+v2);

            if(v1<v2){
                ListNode node = new ListNode(v1);
                ans.next = node;
                ans = ans.next;
                curr1=curr1.next;
            } else {
                ListNode node = new ListNode(v2);
                ans.next = node;
                ans = ans.next;
                curr2=curr2.next; 
            }
        }
        // System.out.println("Out of loop");
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
        {
            return null;
        }
        ListNode list1 = lists[0];
        for(int i=1;i<lists.length;i++) {
            ListNode list2 = lists[i];
            list1 = mergeList(list1, list2);
        }
        return list1;
    }
}
