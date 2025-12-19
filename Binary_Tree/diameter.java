class Solution {
    public int height(TreeNode root,int[] diameter)
    {
        if(root == null)
            return 0;
        
        int leftHeight = height(root.left,diameter);
        int rightHeight = height(root.right,diameter);
        
        // Update the diameter if the path through root is larger
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root,diameter);
        return diameter[0];

        
    }
}