/*
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public void inorder(Node root,ArrayList<Integer> arr)
    {
        if(root != null)
        {
            inorder(root.left,arr);
            arr.add(root.data);
            inorder(root.right,arr);
        }
    }
    public ArrayList<Integer> mergeArrays(ArrayList<Integer> bst1,ArrayList<Integer> bst2)
    {
        ArrayList<Integer> merged = new ArrayList<>();
        int i=0,j=0;
        while(i<bst1.size() && j<bst2.size())
        {
            if(bst1.get(i) < bst2.get(j))
            {
                merged.add(bst1.get(i));
                i++;
            }
            else
            {
                merged.add(bst2.get(j));
                j++;
            }
        }
        while(i<bst1.size())
        {
            merged.add(bst1.get(i));
            i++;
        }
        while(j<bst2.size())
        {
            merged.add(bst2.get(j));
            j++;
        }
        return merged;
    }
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // code here
        ArrayList<Integer> bst1 = new ArrayList<>();
        ArrayList<Integer> bst2 = new ArrayList<>();
        inorder(root1,bst1);
        inorder(root2,bst2);
        return mergeArrays(bst1,bst2);
        
    }
}