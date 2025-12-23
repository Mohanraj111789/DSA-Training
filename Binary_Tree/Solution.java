/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    ArrayList<Integer>result = new ArrayList<>();
    public boolean preorder(TreeNode root,int data)
    {
        if(root == null)
            return  false;
        result.add(root.val);
        if(root.val == data)
            return true;
        if(preorder(root.left,data) || preorder(root.right,data))
            return true;
        result.remove(result.size()-1);
        return false;
        
    }
    public ArrayList<Integer>solve(TreeNode A, int B) {
        preorder(A,B);
        return result;
        
    }
}
//problem link: https://www.interviewbit.com/problems/path-to-given-node/
