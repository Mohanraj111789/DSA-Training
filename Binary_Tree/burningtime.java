/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {

        // code here
        if(root == null) return 0;
        Map<Node,Node> parentMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        parentMap.put(root,null);
        Node targetNode = null;
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            if(curr.data == target)
                targetNode = curr;
            if(curr.left != null)
            {
                parentMap.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right != null)
            {
                parentMap.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        Set<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);
        int time = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean flag = false;
            for(int i=0;i<size;i++)
            {
                Node curr = q.poll();
                if(curr.left != null && !visited.contains(curr.left))
                {
                    flag = true;
                    visited.add(curr.left);
                    q.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right))
                {
                    flag = true;
                    visited.add(curr.right);
                    q.add(curr.right);
                }
                if(parentMap.get(curr) != null && !visited.contains(parentMap.get(curr)))
                {
                    flag = true;
                    visited.add(parentMap.get(curr));
                    q.add(parentMap.get(curr));
                }
            }
            if(flag) time++;
        }
        return time;
        
    }
}

/* 
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parentMap.put(root,null);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr.left != null)
            {
                parentMap.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right != null)
            {
                parentMap.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> vis = new HashSet<>();
        int dist=0,x=1,y=0;
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(target);
        vis.add(target);
        while (!q2.isEmpty()) {
            while (x-->0) {
                TreeNode n = q2.poll();
                if (dist == k) {
                    res.add(n.val);
                }
                if (n.left != null && !vis.contains(n.left)) {
                    q2.add(n.left);
                    vis.add(n.left);
                    y++;
                }
                if (n.right != null && !vis.contains(n.right)) {
                    q2.add(n.right);
                    vis.add(n.right);
                    y++;
                }
                if(parentMap.get(n)!=null && !vis.contains(parentMap.get(n)))
                {
                    q2.add(parentMap.get(n));
                    vis.add(parentMap.get(n));
                    y++;
                }
                
                
            }
            dist++;
            x=y;
            y=0;
            
        }
        return res;
        

    }
}


*/