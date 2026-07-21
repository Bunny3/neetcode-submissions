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
    public static int count;
    public void findGoodNodes(TreeNode root, int maxVal) {
        if(root.val>=maxVal) {
            maxVal = root.val;
            count++;
        }
        if(root.left!=null) {
            findGoodNodes(root.left, maxVal);
        }
        if(root.right!=null) {
            findGoodNodes(root.right, maxVal);
        }
    }
    public int goodNodes(TreeNode root) {
        count = 0;
        findGoodNodes(root, -100);
        return count;
    }
}
