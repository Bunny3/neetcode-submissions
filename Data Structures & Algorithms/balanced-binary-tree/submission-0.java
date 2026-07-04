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

    public int height(TreeNode root) {
        if(root == null)
            return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }

    public int[] dfs(TreeNode root) {
        if(root == null)
            return new int[]{1,0};
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);

        boolean balanced = (left[0]==1 && right[0]==1) && (Math.abs(left[1]-right[1])<=1);
        int height = 1 + Math.max(left[1],right[1]);
        return new int[]{balanced ? 1 : 0, height};
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0]==1;
    }
}
