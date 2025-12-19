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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode mid = null;
    TreeNode last = null;
    public void swap(TreeNode a,TreeNode b)
    {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    
    public void inorder(TreeNode root)
    {
        if(root != null)
        {
            inorder(root.left);
            if(prev != null && (root.val<prev.val))
            {
                if(first == null)
                {
                    first = prev;
                    mid = root;
                }
                else
                {
                    last = root;
                }
            }
            prev = root;
            inorder(root.right);
        }
        if(first != null && last != null)
        {
            swap(first,last);
        }
        else
        {
            swap(first,mid);
        }
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        
    }
}