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
    boolean found = false;
    public void inorder(TreeNode root,HashSet<Integer> set,int k)
    {
        if(root == null)
            return;
        inorder(root.left,set,k);
        if(set.contains(k - root.val))
            found = true;
        else
            set.add(root.val);
        inorder(root.right,set,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        inorder(root,set,k);
        return found;
    }
}

//problem link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
//for access link cntrl+click on problem link

//which traversal is best suited here ? Inorder traversal because it gives sorted order of elements in BST
//so we can easily check for k - current node value in the set
//inorder traversal is used to maintain the BST property while searching for the complement value..
//preorder or postorder would not maintain the sorted order and may lead to incorrect results
//thus inorder traversal is the most appropriate choice for this problem

//time complexity: O(n) where n is the number of nodes in the BST
//space complexity: O(n) for the hash set storing node values