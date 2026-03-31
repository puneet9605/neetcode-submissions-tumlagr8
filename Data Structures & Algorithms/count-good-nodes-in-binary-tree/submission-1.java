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
    int res = 0;
    public int goodNodes(TreeNode root) {
        checkGoodNodes(root, -1000);
        return res;

        
    }
    void checkGoodNodes(TreeNode root, int currMax){
        if (root==null){
            return;
        }
        if (root.val>=currMax){
            res++;
            currMax = root.val;
        }
        checkGoodNodes(root.left, currMax);
        checkGoodNodes(root.right, currMax);

    }
}
