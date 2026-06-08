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
    private int globalSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return globalSum;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxFromHere = root.val;

        int leftMax = helper(root.left);
        int rightMax = helper(root.right);

        globalSum = Math.max(globalSum, leftMax + root.val + rightMax);
        return Math.max(root.val, root.val + Math.max(leftMax, rightMax));
     }
}
