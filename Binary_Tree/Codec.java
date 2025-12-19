/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(builtTreePostandinOrder root) {
        Queue<builtTreePostandinOrder>q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        if(root == null) return "";
        while(!q.isEmpty())
        {
            builtTreePostandinOrder cur = q.poll();
            if(curr == null)
            {
                ans = ans+"n ";
            }
            else
            {
                ans = ans+cur.val+" ";
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return ans.toString();
        
    }

    // Decodes your encoded data to tree.
    public builtTreePostandinOrder deserialize(String data) {
        String[] arr = data.split(" ");
        if(data.length() == 0) return null;
        Queue<builtTreePostandinOrder> q = new LinkedList<>();
        builtTreePostandinOrder root = new builtTreePostandinOrder(Integer.parseInt(arr[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty())
        {
            builtTreePostandinOrder curr = q.poll();
            if(!arr[i].equals("n"))
            {
                builtTreePostandinOrder left = new builtTreePostandinOrder(Integer.parseInt(arr[i]));
                curr.left = left;
                q.add(left);
            }
            i++;
            if(!arr[i].equals("n"))
            {
                builtTreePostandinOrder right = new builtTreePostandinOrder(Integer.parseInt(arr[i]));
                curr.right = right;
                q.add(right);
            }
            i++;
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));