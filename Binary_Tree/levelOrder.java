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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode>q = new ArrayDeque<>();
        List<List<Integer>>ans = new ArrayList<>();
        if(root == null)
            return ans;

        q.addLast(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            List<Integer>temp = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                TreeNode node = q.removeFirst();
                temp.add(node.val);
                if(node.left != null)
                    q.addLast(node.left);
                if(node.right != null)
                    q.addLast(node.right);
            }
            ans.add(temp);
        }
        return ans;
        
    }
}