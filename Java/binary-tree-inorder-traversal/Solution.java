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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorder(root,new ArrayList<Integer>());
    }

    //Helper function for Inorder Traversal
    public List<Integer> inorder(TreeNode node,List<Integer> list){
        if(node==null){
            return list;
        }
        list = inorder(node.left,list);
        list.add(node.val);
        list = inorder(node.right,list);
        return list;
    }
}