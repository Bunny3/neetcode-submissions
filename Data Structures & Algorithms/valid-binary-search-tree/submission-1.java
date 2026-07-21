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
    public boolean isValidBSTUtil(TreeNode root, int leftBoundary, int rightBoundary) {
        if(root.val <=leftBoundary || root.val>=rightBoundary)
            return false;
        if(root == null)
            return true;
        boolean left = true, right=true;
        if(root.left !=null) {
            left = isValidBSTUtil(root.left, leftBoundary, root.val);
        }
        if(root.right != null) {
            right =  isValidBSTUtil(root.right, root.val, rightBoundary);
        }
        return left&right;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, -1001, 1001);
    }
}
