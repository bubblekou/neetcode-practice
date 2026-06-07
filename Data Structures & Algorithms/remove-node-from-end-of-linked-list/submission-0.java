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
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p = dummy;
        for (int i = 0; i < n; i++) {
            p = p.next;
            if (p == null) {
                throw new IllegalArgumentException("Linked list is too short");
            }
        }

        ListNode tail = dummy;
        while (p.next != null) {
            p = p.next;
            tail = tail.next;
        }

        tail.next = tail.next.next;
        return dummy.next;
    }
}
