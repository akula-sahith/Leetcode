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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = inordertraversal(new ArrayList<>(), root);
        // inorder of BST is already sorted, so no need to sort
        return insertNodes(list, 0, list.size() - 1);
    }

    // Build balanced BST using recursion (NOT insertion)
    public TreeNode insertNodes(List<Integer> nodes, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode newRoot = new TreeNode(nodes.get(mid));

        newRoot.left = insertNodes(nodes, start, mid - 1);
        newRoot.right = insertNodes(nodes, mid + 1, end);

        return newRoot;
    }

    // Inorder traversal
    public List<Integer> inordertraversal(List<Integer> nodes, TreeNode root) {
        if (root == null) return nodes;

        inordertraversal(nodes, root.left);
        nodes.add(root.val);
        inordertraversal(nodes, root.right);
        return nodes;
    }
}