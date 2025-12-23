import java.util.Deque;

import javax.swing.tree.TreeNode;

import Solution.Pair;

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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Deque<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.addLast(new Pair<>(root,0));
        int x = 1,y=0;
        while(!q.isEmpty())
        {
            while (x-- >0) {
            Pair<TreeNode,Integer> first = q.poll();
            TreeNode node = first.getKey();
            int c = first.getValue();

            if(c>0)
                c--;
            if(node.left != null)
            {
                q.add(new Pair<>(node.left,2*c+1));
                y++;
            }
            if(node.right != null)
            {
                q.add(new Pair<>(node.right,2*c+2));
                y++;
            }
        }

        x=y;
        y=0;
        }



        
    }
}
//problem link: https://leetcode.com/problems/maximum-width-of-binary-tree/