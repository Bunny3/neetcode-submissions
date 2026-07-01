class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            int count = 0;
            ListNode curr = groupPrev.next;

            // Check if k nodes exist
            while (curr != null && count < k) {
                count++;
                curr = curr.next;
            }

            if (count < k)
                break;

            // curr now points to the next group's first node
            ListNode prev = curr;

            // Start reversing from current group's head
            curr = groupPrev.next;
            ListNode groupHead = curr;

            count = 0;

            while (count < k) {
                count++;

                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            groupPrev.next = prev;
            groupPrev = groupHead;
        }

        return dummy.next;
    }
}