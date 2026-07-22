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
    public static int maxSum;
    public int maxPathSumUtil(TreeNode root) {
        if(root == null) {
            return -1002;
        }
        int left = Math.max(0,maxPathSumUtil(root.left));
        int right = Math.max(0,maxPathSumUtil(root.right));
        int v1 = left + right + root.val;
        maxSum = Math.max(maxSum, v1);
        // maxSum = Math.max(maxSum, left);
        // maxSum = Math.max(maxSum, right);
        // return Math.max(left,right)+root.val;
        return root.val + Math.max(0, Math.max(left, right));
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = -1001;
        maxPathSumUtil(root);
        // dfs(root);
        return maxSum;
    }
}
