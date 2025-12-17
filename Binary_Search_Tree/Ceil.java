
class Solution {
    int findCeil(Node root, int x) {
        int ceil = -1;
        while(root != null)
        {
            if(root.data == x)
            {
                ceil = root.data;
                return ceil;
            }
            else if(root.data < x)
            {
                root = root.right;
            }
            else
            {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
//for access the question use below link
//https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1