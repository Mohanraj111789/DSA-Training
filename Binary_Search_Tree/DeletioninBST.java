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
    private TreeNode findSuccessor(TreeNode root)
    {
        TreeNode curr = root.right;
        while(curr.left != null)
        {
            curr = curr.left;
        }
        return curr;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
        {
            return null;
        }
        if(root.val < key)
        {
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key)
        {
            root.left = deleteNode(root.left,key);
        }
        else
        {
            // node found
            // case 1: no child
            if(root.left == null && root.right == null)
            {
                return null;
            }
            // case 2: one child
            else if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }
            // case 3: two children
            else
            {
                TreeNode successor = findSuccessor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right,successor.val);
            }
        }
        return root;
        
        
    }
}
//for access the question use below link
//https://leetcode.com/problems/delete-node-in-a-bst/ for accessing the question CTRL+click