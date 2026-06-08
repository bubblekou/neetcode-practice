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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode p = head;
        ListNode q = head;

        while (q != null) {
            // Advance q by K nodes
            boolean done = false;
            for (int i = 0; i < k; i++) {
                if (q == null) {        
                    // Less than k left
                    tail.next = p;
                    // System.out.println("short of k, tail =  " + tail.val + ", p = " + p.val);
                    done = true;
                    break;
                }
                q = q.next;

                // System.out.println("q = " + q.val);
            }

            if (done) {
                break;
            }

            // Reverse K nodes from p to q
            ListNode savedP = p;
            ListNode prev = null;
            while (p != q) {
                ListNode t = p;
                p = p.next;
                t.next = prev;
                prev = t;
            }

            tail.next = prev;
            tail = savedP;
            p = q;
        }

        return dummy.next;
    }
}
