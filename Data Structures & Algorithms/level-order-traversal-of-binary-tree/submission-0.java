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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> queue =  new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int items = queue.size();
            List<Integer> currList = new ArrayList();
            while(items>0){
                TreeNode curr = queue.removeFirst();
                currList.add(curr.val);
                if (curr.left!=null) queue.addLast(curr.left);
                if (curr.right!=null) queue.addLast(curr.right);
                items--;
            }
            res.add(currList);
        }
        return res;
        
    }
}
