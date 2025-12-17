class Solution {
    public static int floor(Node root, int x) {
       int ceil = -1;
         while(root != null)
         {

             if(x<root.data)
             {
                 root = root.left;
             }
             else
             {
                 ceil = root.data;
                 root = root.right;
             }
         }
         return ceil;
    }
    
}
//for access the question use below link
//https://www.geeksforgeeks.org/find-floor-value-given-key-bst/