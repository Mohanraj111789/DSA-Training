/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else
        {
            return root;
        }
        
    }
}

//iterative approach
/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null)
        {
            if(p.val < curr.val && q.val < curr.val)
            {
                curr = curr.left;
            }
            else if(p.val > curr.val && q.val > curr.val)
            {
                curr = curr.right;
            }
            else
            {
                return curr;
            }
        }
        return null;
    }
}
*/
//for access the question use below link
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ for accessing the question CTRL+click