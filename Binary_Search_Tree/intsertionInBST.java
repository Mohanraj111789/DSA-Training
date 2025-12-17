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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null)
        {
            return new TreeNode(val);
        }
        if(val < root.val)
        {
            root.left = insertIntoBST(root.left,val);
        }
        else
        {
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
    //iterative approach
    /*public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root == null)
        {
            return newNode;
        }
        TreeNode curr = root;
        TreeNode parent = null;
        while(curr != null)
        {
            parent = curr;
            if(val < curr.val)
            {
                curr = curr.left;
            }
            else
            {
                curr = curr.right;
            }
        }
        if(val < parent.val)
        {
            parent.left = newNode;
        }
        else
        {
            parent.right = newNode;
        }
        return root;
    }*/
}
//for access the question use below link
//https://leetcode.com/problems/insert-into-a-binary-search-tree/