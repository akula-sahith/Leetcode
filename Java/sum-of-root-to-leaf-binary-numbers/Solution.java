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
    public int sumRootToLeaf(TreeNode root) {
        List<String> set = findBinary(root,"",new ArrayList<>());
        System.out.println(set);
        int sum = 0;
        for(String s : set){
           int num = Integer.parseInt(s,2);
           sum += num;
        }
        return sum;
    }
  static List<String> findBinary(TreeNode node, String curr, List<String> bins) {
    if (node == null) {
        return bins;
    }

    curr = curr + (char)(node.val + '0');

    if (node.left == null && node.right == null) {
        bins.add(curr);
        return bins;
    }

    findBinary(node.left, curr, bins);
    
    findBinary(node.right, curr, bins);

    return bins;
}
}