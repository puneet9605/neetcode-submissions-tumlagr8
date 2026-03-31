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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sumPaths(root);
        return maxSum;
        
    }

    int sumPaths(TreeNode root){
        if(root==null){
            return 0;
        }
        int maxLeft = sumPaths(root.left);
        int maxRight = sumPaths(root.right);
        int sumTillNow = root.val + maxLeft + maxRight;
        maxSum = Math.max(maxSum, sumTillNow);
        int maXchildSum = Math.max(maxLeft, maxRight);
        int currMax = Math.max(maXchildSum+root.val, root.val);
        maxSum = Math.max(maxSum, currMax);
        return currMax;
    }
        

}
