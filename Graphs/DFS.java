class Solution {
    void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited, ArrayList<Integer> ans)
    {
        visited.add(node);
        ans.add(node);
        for(int ne: adj.get(node))
        {
            if(!visited.contains(ne))
            {
                dfsHelper(ne,adj,visited,ans);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        dfsHelper(0,adj,visited,ans);
        return ans;
        
    }
}

//problem link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1 access ctrl+click
//tc: o(V+E)    
//sc: o(V)
