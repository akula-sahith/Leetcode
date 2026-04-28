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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // List<Integer> first = inorder(p,new ArrayList<Integer>());
        // List<Integer> second = inorder(q,new ArrayList<Integer>());

        // if(first.size()!=second.size()){
        //     return false;
        // }

        // for(int i = 0 ; i < first.size() ; i++){
        //     if(first.get(i) != second.get(i)){
        //         return false;
        //     }
        // }

        // return true;

        return traverse(p,q);
    }

   
    public List<Integer> inorder(TreeNode node,List<Integer> list){
        if(node==null){
            return list;
        }
        list = inorder(node.left,list);
        list.add(node.val);
        list = inorder(node.right,list);
        return list;
    }

    public boolean traverse(TreeNode p,TreeNode q){
        if(p==null && q!=null || q==null && p!=null){
            return false;
        }


        if( p==null && q==null){
            return true;
        }

        if(p.val != q.val){
            return false;
        }

        boolean left = traverse(p.left,q.left);
        boolean right = traverse(p.right,q.right);

        return left && right;
    }
}