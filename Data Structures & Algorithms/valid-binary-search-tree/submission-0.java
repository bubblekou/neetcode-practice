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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, Integer.MIN_VALUE, root.val) &&
        helper(root.right, root.val, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int lower, int upper) {
        if (root == null) {
            return true;
        } else if (root.val < lower || root.val > upper) {
            return false;
        } else {
            return helper(root.left, root.val, lower) && helper(root.right, upper, root.val);
        }
    }
}
