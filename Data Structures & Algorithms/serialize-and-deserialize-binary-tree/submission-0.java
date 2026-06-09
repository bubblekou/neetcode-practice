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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                sb.append(',');
                if (node.left != null) {
                    sb.append(node.left.val);
                    q.offer(node.left);
                }

                sb.append(',');
                if (node.right != null) {
                    sb.append(node.right.val);
                    q.offer(node.right);
                }
            }
        }

        int len = sb.length();
        while (len > 0 && sb.charAt(len - 1) == ',') {
            len--;
        } 
        sb.setLength(len);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] parts = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        q.offer(root);

        for (int i = 1; i < parts.length; i += 2) {
            if (q.isEmpty()) {
                throw new IllegalStateException("Expect parent but queue is empty");
            }

            TreeNode parent = q.poll();

            if (parts[i].length() > 0) {
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                parent.left = left;
                q.offer(left);
            }

            if (parts[i + 1].length() > 0) {
                TreeNode right = new TreeNode(Integer.parseInt(parts[i + 1]));
                parent.right = right;
                q.offer(right);
            }
        }

        return root;        
    }
}
