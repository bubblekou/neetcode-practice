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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        boolean result = check(root, subRoot);
        if (result) {
            return true;
        }

        if (isSubtree(root.left, subRoot)) {
            return true;
        }

        return isSubtree(root.right, subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root != null && subRoot != null) {
            return root.val == subRoot.val && check(root.left, subRoot.left) && check(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
