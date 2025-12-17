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
    int count = 0;
    public void inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            count++;
            if()
            inorder(root.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        

        
    }
}