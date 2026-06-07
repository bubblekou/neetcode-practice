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
        Set<ListNode> seenNodes = new HashSet<>();
        ListNode q = head;
        while (q != null && !seenNodes.contains(q)) {
            seenNodes.add(q);
            q = q.next;
        }

        return q != null;
    }
}
