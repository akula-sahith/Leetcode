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
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorder(root,new ArrayList<Integer>());
    }

    public List<Integer> preorder(TreeNode node,List<Integer> list){
        if(node == null){
            return list;
        }

        list.add(node.val);
        list = preorder(node.left,list);
        list = preorder(node.right,list);
        return list;
    }
}