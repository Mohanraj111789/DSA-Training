/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer>ans = new ArrayList<>();
    bool isLeaf(Node root)
    {
        return root!=null && root.left == null && root.right==null;
    }
    void leftB(Node root)
    {
        Node cur = root;
        while(cur!=null && isLeaf(cur))
        {
            result.add(cur.data);
            if(cur.left!=null)
                cur = cur.left;
            else
                cur = cur.right;
        }
    }
    void leaves(Node root)
    {
        if(root == null)
            return;
        if(isLeaf(root))
        {
            result.add(root.data);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
    void rightB(Node root)
    {
        Node cur = root;
        Stack<Integer>s = new Stack<>();
        while(cur!=null && isLeaf(cur))
        {
            s.push(cur.data);
            if(cur.right!=null)
                cur = cur.right;
            else
                cur = cur.left;
        }
        while(!s.isEmpty())
        {
            result.add(s.pop());
        }
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        if(root == null)
            return ans;
        if(!isLeaf(root))
            ans.add(root.data);
        leftB(root.left);
        leaves(root);
        rightB(root.right);
        return ans;
        
        
        
    }
}