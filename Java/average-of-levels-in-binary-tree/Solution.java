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
    public List<Double> averageOfLevels(TreeNode root) {
         List<Double> ans = new ArrayList<>();
         if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            for(int i = 0;i<size;i++){
               TreeNode polled = queue.poll();
               sum = sum + (double)polled.val;
               if(polled.left!=null){
                queue.add(polled.left);
               }
               if(polled.right!=null){
                queue.add(polled.right);
               }
            }
            double avg = (sum)/(size);
            ans.add(avg);
        }
        return ans;
    }
}