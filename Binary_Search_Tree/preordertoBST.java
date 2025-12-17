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
    int idx = 0;
    public TreeNode constructBST(int[] preorder , long x,long y)
    {
        if(idx>=preorder.length || preorder[idx] <x || preorder[idx] > y)
            return null;
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = constructBST(preorder,x,root.val);
        root.right = constructBST(preorder,root.val,y);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        long x=Long.MIN_VALUE;
        long y=Long.MAX_VALUE;
        return constructBST(preorder,x,y);


        
    }
}
//time complexity: O(n)
//space complexity: O(h) h is height of tree

//problem link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//for accessing the question CTRL+click