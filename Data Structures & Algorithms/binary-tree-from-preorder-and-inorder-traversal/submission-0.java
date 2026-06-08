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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return new TreeNode(preorder[0]);
        }

        int rootVal = preorder[0];
        int i = 0;
        while (inorder[i] != rootVal) {
            i++;
        }

        TreeNode root = new TreeNode(rootVal);

        // Left sub tree
        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, i + 1), 
            Arrays.copyOfRange(inorder, 0, i));

        // Right sub tree
        root.right = buildTree(
            Arrays.copyOfRange(preorder, i + 1, len), 
            Arrays.copyOfRange(inorder, i + 1, len));
        
        return root;
    }
}
