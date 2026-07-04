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
    public boolean helper(TreeNode p, TreeNode q) {
        // if(flag == false)
        //     return false;
        if(p == null && q==null)
            return true;
        // if(p==null) {
        //     return (q==null);
        // }
        // if(q==null) {
        //     return (p==null);
        // }
        if(p!=null && q!=null && p.val == q.val) {
            return helper(p.left,q.left) && helper(p.right, q.right);
        } 
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
}
