import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//problem description:
/*
Given the root of a binary tree, the value of a target node target, and an integer k,
return an array of the values of all nodes that have a distance k from the target node.
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Example 2:
Input: root = [1], target = 1, k = 3
Output: []

explanation:
            The problem involves finding all nodes at a specific distance k from a given target node in a binary tree.
            3
        /   \
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Hash<TreeNode,TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parentMap.put(root,null);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr.left != null)
            {
                parentMap.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right != null)
            {
                parentMap.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        int dist=0,x=1,y=0;
        Queue<TreeNode>q = new LinkedList<>();
        while (!q.isEmpty()) {
            while (x-->0) {
                TreeNode n = q.poll();
                if (dist == k) {
                    res.add(n.val);
                }
                if (n.left != null && !vis.contains(n.left)) {
                    q.add(n.left);
                    vis.add(n.left);
                    y++;
                }
                if (n.right != null && !vis.contains(n.right)) {
                    q.add(n.right);
                    vis.add(n.right);
                    y++;
                }
                if(parentMap.get(n)!=null && !mp.containsKey(parentMap.get(n)))
                {
                    q.add(parentMap.get(n));
                    y++;
                }
                
                
            }
            dist++;
            x=y;
            y=0;
            
        }
        List<Integer>ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            ans.add(q.poll().val);
        }
        return ans;
        

    }
}