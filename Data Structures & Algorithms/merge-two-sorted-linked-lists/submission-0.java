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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode newList = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newList.next = list1;
                list1 = list1.next;
            } else {
                newList.next = list2;
                list2 = list2.next;
            }

            newList = newList.next;
        }

        if (list1 == null) {
            newList.next = list2;
        } else if (list2 == null) {
            newList.next = list1;
        }

        return dummyNode.next;
    }
}