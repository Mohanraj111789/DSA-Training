/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    int min_col = 0;
    int max_col = 0;
    public void preOrder(Node root,int row,int col,HashMap<Integer,int[]>mp)
    {
        if(root == null)
            return;
        if(!mp.containsKey(col))
            mp.put(col,new int[]{root.data,row});
        else
        {
            int[]arr = mp.get(col);
            if(arr[1] <= row)
            {
                arr[0] = root.data;
                arr[1] = row;
                mp.put(col,arr);
            }
        }
        if(max_col < col)
            max_col = col;
        if(min_col > col)
            min_col = col;
        preOrder(root.left,row+1,col-1,mp);
        preOrder(root.right,row+1,col+1,mp);
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        HashMap<Integer,int[]>mp = new HashMap<>();
        preOrder(root,0,0,mp);
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=min_col;i<=max_col;i++)
        {
            ans.add(mp.get(i)[0]);
        }
        return ans;
        
    }
}