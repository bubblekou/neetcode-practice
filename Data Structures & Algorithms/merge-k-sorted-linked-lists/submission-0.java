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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int n = lists.length;
        if (n == 1) {
            return lists[0];
        }

        int half = n / 2;
        ListNode firstHalf = mergeKLists(Arrays.copyOfRange(lists, 0, half));
        ListNode secondHalf = mergeKLists(Arrays.copyOfRange(lists, half, n));

        ListNode dummy = new ListNode();
        ListNode r = dummy;
        ListNode p = firstHalf;
        ListNode q = secondHalf;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return dummy.next;
    }
}
