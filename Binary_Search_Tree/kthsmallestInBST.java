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
    int result = -1;
    public void inorder(TreeNode root,int k)
    {
        if(root!=null)
        {
            inorder(root.left,k);
            count++;
            if(count == k)
            {
                return result = root.val;
            }
            inorder(root.right,k);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;

        

        
    }
}
//time complexity: O(H + k) where H is the height of the tree
//space complexity: O(H) for the recursion stack
//problem link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/