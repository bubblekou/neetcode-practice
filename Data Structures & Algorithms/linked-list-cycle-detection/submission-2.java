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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle_naive(ListNode head) {
        // Naive
        Set<ListNode> seenNodes = new HashSet<>();
        ListNode q = head;
        while (q != null && !seenNodes.contains(q)) {
            seenNodes.add(q);
            q = q.next;
        }

        return q != null;
    }
}
