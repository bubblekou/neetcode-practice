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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode r = dummy;
        int carryOver = 0;

        ListNode p = l1, q = l2;
        while (p != null || q != null) {
            int newVal = carryOver;
            newVal += (p != null ? p.val : 0);
            newVal += (q != null ? q.val : 0);

            carryOver = newVal / 10;
            newVal %= 10;
            r.next = new ListNode(newVal);
            r = r.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carryOver > 0) {
            r.next = new ListNode(carryOver);
        }

        return dummy.next;
    }
}
