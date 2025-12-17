class Solution {
    public void flatten(TreeNode root) {
        //using morris traversal
        TreeNode curr = root;
        while(curr != null)
        {
            if(curr.left != null)
            {
                TreeNode prev = curr.left;
                while(prev.right != null)
                {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        //Dfs approach
        /*if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode prev = null;
        while(!st.isEmpty())
        {
            TreeNode node = st.pop();
            if(prev != null)
            {
                prev.right = node;
                prev.left = null;
            }
            if(node.right != null)
                st.push(node.right);
            if(node.left != null)
                st.push(node.left);
            prev = node;
        }*/
    }
}