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
    public builtTreePostandinOrder lowestCommonAncestor(builtTreePostandinOrder root, builtTreePostandinOrder p, builtTreePostandinOrder q) {
        if(root == null || root == p || root == q)
            return root;
        builtTreePostandinOrder lca1  = lowestCommonAncestor(root.left,p,q);
        builtTreePostandinOrder lca2  = lowestCommonAncestor(root.right,p,q);
        if(lca1 == null)
            return lca2;
        if(lca2 == null)
            return lca1;
        return root;

        
    }
}
//for access the question use below link
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ for accessing the question CTRL+click