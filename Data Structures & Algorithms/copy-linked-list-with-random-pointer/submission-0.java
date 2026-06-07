/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> old2NewMap = new HashMap<>();
        Node dummy = new Node(-1);
        Node q = dummy;
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            old2NewMap.put(p, newNode);
            q.next = newNode;
            q = newNode;
            p = p.next;
        }

        q = dummy.next;
        p = head;
        while (q != null) {
            Node randomNode = p.random;
            if (p != null) {
                Node newRandomNode = old2NewMap.get(randomNode);
                q.random = newRandomNode;
            }

            p = p.next;
            q = q.next;
        }

        return dummy.next;
    }
}
