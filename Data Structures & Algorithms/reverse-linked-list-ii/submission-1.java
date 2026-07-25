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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        
        ListNode p = dummy;
        int count = 0;
        while (p != null) {
            count++;
            if (count == left) {
                leftNode = p;
            } else if (count == right) {
                rightNode = p;
                break;
            }

            p = p.next;
        }

        if (leftNode == null || rightNode == null) {
            return head;
        }

        // System.out.println("leftNode = " + leftNode.val);
        // System.out.println("rightNode = " + rightNode.val);

        ListNode secondHead = rightNode.next.next;
        p = leftNode.next;
        ListNode stopNode = rightNode.next.next;
        while (p != stopNode) {
            ListNode q = p.next;
            p.next = secondHead;
            secondHead = p;
            p = q;
        }
        leftNode.next = secondHead;

        return dummy.next;
    }
}