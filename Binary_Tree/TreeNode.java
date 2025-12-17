import java.util.HashMap;
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public TreeNode build(int [] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> inMap)
    {                                                   
        
        if(postStart > postEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int x = inMap.get(root.val);
        int numsLeft = x - inStart;
        root.left = build(postorder,postStart,postStart+numsLeft-1,inorder,inStart,x-1,inMap);
        root.right = build(postorder,postStart+numsLeft,postEnd-1,inorder,x+1,inEnd,inMap);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inMap.put(inorder[i],i);
        }
        return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inMap);
        
    }
}
