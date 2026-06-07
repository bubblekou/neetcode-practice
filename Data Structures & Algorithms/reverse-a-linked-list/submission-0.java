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
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;

        while (p != null) {
            ListNode t = p;
            p = p.next;
            t.next = newHead;
            newHead = t;
        }

        return newHead;
    }
}
