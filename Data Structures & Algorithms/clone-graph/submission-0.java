/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> old2NewMap = new HashMap<>();
        dfs(node, old2NewMap);
        return old2NewMap.get(node);
    }

    private void dfs(Node node, Map<Node, Node> old2NewMap) {
        if (old2NewMap.containsKey(node)) {
            return;
        }

        Node cloneNode = new Node(node.val);
        old2NewMap.put(node, cloneNode);

        for (Node child : node.neighbors) {
            if (!old2NewMap.containsKey(child)) {
                dfs(child, old2NewMap);
            }

            cloneNode.neighbors.add(old2NewMap.get(child));
        }
    }
}