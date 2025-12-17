class Solution {

    public boolean isValidBSTUtil(TreeNode root, long low, long high) {
        return root == null ||
                (root.val > low && root.val < high)&&
                (isValidBSTUtil(root.left, low, root.val)) &&
               (isValidBSTUtil(root.right, root.val, high));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
