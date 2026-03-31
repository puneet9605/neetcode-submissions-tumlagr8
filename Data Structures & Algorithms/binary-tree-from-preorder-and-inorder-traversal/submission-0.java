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
    int preOrder;
    Map<Integer, Integer> mapInOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = 0;
        mapInOrder = new HashMap<>();
        for(int i =0; i<preorder.length;i++){
            mapInOrder.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1);   
    }
    private TreeNode build(int[] preorder, int left, int right){
        if (left>right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preOrder++]);
        int mid = mapInOrder.get(root.val);
        TreeNode leftNode = build(preorder, left, mid-1);
        TreeNode rightNode = build(preorder, mid+1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
