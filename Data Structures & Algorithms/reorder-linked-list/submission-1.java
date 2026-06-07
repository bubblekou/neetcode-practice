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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half
        ListNode list2 = null;
        ListNode q = slow.next;
        slow.next = null;
        while (q != null) {
            ListNode t = q;
            q = q.next;
            t.next = list2;
            list2 = t;
        }

        // Merge two lists
        ListNode p = head;
        q = list2;
        while (q != null) {
            ListNode t = p;
            p = p.next;
            t.next = q;

            t = q;
            q = q.next;
            t.next = p;
        }
    }
}
