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

public class Codec {

    // Encodes a tree to a single string.
    // 1 # 2 # 3 . # . # 4 # 5
    // (size 1)
    //  (size 2)
    /*      1
        2       3
    .       . 4     5
    */
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        String ans = "";
        while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node == null){
                   ans = ans + ".#"; 
                   continue;
                }
                ans = ans + node.val + "#";
                queue.add(node.left);
                queue.add(node.right);
        }
        System.out.println(ans);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue=new LinkedList<>();
        String nodes[] = data.split("#");
        if(nodes[0].indexOf('.')>-1)
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty()) {
            // size = queue.size();
            // while(size--  >0) {
                TreeNode node = queue.poll();
                if(node == null)
                {
                    continue;
                }
                node.left = nodes[i].indexOf(".")>-1 ? null :new TreeNode(Integer.parseInt(nodes[i]));
                i++;
                node.right = nodes[i].indexOf(".")>-1 ? null :new TreeNode(Integer.parseInt(nodes[i]));
                i++;
                queue.offer(node.left);
                queue.offer(node.right);
            // } 
        }
        return root;
    }
}
