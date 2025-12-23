class Solution {
    int x;
    public void dfs(ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ans,boolean[] vis,int cur)
    {
        vis[cur] = true;
        for(int ne:adj.get(cur))
        {
            if(!vis[ne])
                dfs(adj,ans,vis,ne);
        }
        ans.add(cur);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        ArrayList<Integer>ans = new ArrayList<>(V);
        boolean[]vis = new boolean[V];
        
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int[]edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
                dfs(adj,ans,vis,i);
        }
        Collections.reverse(ans);
        return ans;
    }
}
//problem link: https://practice.geeksforgeeks.org/problems/topological-sort/1