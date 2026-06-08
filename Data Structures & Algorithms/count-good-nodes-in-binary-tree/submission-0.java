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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int currentMax) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        if (root.val >= currentMax) {
            ans++;
        }

        ans += dfs(root.left, Math.max(currentMax, root.val));
        ans += dfs(root.right, Math.max(currentMax, root.val));
        return ans;
    }
}
