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
    public boolean helper(TreeNode p, TreeNode q, boolean flag) {
        if(flag == false)
            return false;
        if(p==null) {
            return (q==null);
        }
        if(q==null) {
            return (p==null);
        }
        if(p.val == q.val) {
            return flag & helper(p.left,q.left, flag) & helper(p.right, q.right, flag);
        } 
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q, true);
    }
}
