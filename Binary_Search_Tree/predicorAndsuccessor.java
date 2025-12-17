/*
Given a Binary Search Tree and a key. Find the predecessor and successor of the given key in the BST.
* public class Node {
 *     int data;
 *    Node left;
 *    Node right;
 *    Node(int data) {
 *       this.data = data;
 *      left = null;
 *     right = null;
 *   }
 * }
 */






class Solution {
    public Node getSuccessor(Node root, int key) {
        Node succ = null;
        while(root != null)
        {
            if(key >= root.data)
            {
                root = root.right;
            }
            else
            {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
    public Node getPredecessor(Node root, int key) {
        Node pred = null;
        while(root != null)
        {
            if(key <= root.data)
            {
                root = root.left;
            }
            else
            {
                pred = root;
                root = root.right;
            }
        }
        return pred;
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> res = new ArrayList<>();
        res.add(getPredecessor(root, key));
        res.add(getSuccessor(root, key));
        return res;
    }
}

//for access the question use below link
//https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
