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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> queue =  new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int items = queue.size();
            int rightMost = 0;
            while(items>0){
                TreeNode curr = queue.removeFirst();
                if (curr.left!=null) queue.addLast(curr.left);
                if (curr.right!=null) queue.addLast(curr.right);
                rightMost = curr.val;
                items--;
            }
            res.add(rightMost);
        }
        return res;
        
    }
}
