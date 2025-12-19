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