/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }

    public int kthSmallest_recursive(TreeNode root, int k) {
        List<TreeNode> visited = new ArrayList<>();
        dfs(root, visited);

        if (visited.size() >= k) {
            return visited.get(k - 1).val;
        } else {
            return -1;
        }
    }

    private void dfs(TreeNode root, List<TreeNode> visited) {
        if (root == null) {
            return;
        }

        if (root.left != null) dfs(root.left, visited);
        visited.add(root);
        if (root.right != null) dfs(root.right, visited);
    }
}
