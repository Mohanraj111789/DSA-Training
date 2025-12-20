class Solution {
    ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
    public void bfs(int v,ArrayList<ArrayList<Integer>> adj,boolean vis[],ArrayList<Integer>component)
    {
        Queue<Integer>q = new LinkedList<>();
        q.add(v);
        vis[v] = true;
        while(!q.isEmpty())
        {
            int x = q.poll();
            component.add(x);
            for(int ne:  adj.get(x))
            {
                if(!vis[ne])
                {
                    vis[ne] = true;
                    q.add(ne);
                }
            }
        }
        ans.add(component);
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code her
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<edges.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                ArrayList<Integer>component = new ArrayList<>();
                bfs(i,adj,vis,component);
            }
        }
        return ans;
        
    }
}