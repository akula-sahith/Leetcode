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

 //Solution explanation 
 /* In order to build BST from a sorted array we need to find out the middle element which acts as the root of the tree */
class Solution {
     public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // Recursive helper
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, start, mid - 1);
        root.right = build(nums, mid + 1, end);

        return root;
    }
}