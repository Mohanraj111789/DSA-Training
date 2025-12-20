class Solution {
    public boolean bfs(int s,boolean vis[],List<List<Integer>> adj)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s,-1});
        vis[s] = true;
        while(!q.isEmpty())
        {
            int node[] = q.poll();
            int curr = node[0];
            int parent = node[1];
            for(Integer it : adj.get(curr))
            {
                if(!vis[it])
                {
                    vis[it] = true;
                    q.add(new int[]{it,curr});
                }
                else if(parent != it)
                    return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        //BFS approach
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
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
                if(bfs(i,vis,adj))
                    return true;
            }
        }
        return false;
        
    }
}

//problem link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1 access ctrl+click

//DFS approach
// class Solution {
//     public boolean dfs(ArrayList<ArrayList<Integer>>adj,boolean vis[],int curr,int parent)
//     {
//         vis[curr] = true;
//         for(Integer it : adj.get(curr))
//         {
//             if(!vis[it])
//             {
//                 if(dfs(adj,vis,it,curr))
//                     return true;
//             }
//             else if(it != parent)
//                 return true;
//         }
//         return false;
        
//     }
//     public boolean isCycle(int V, int[][] edges) {
//         // Code here
//         ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
//         for(int i=0;i<V;i++)
//         {
//             adj.add(new ArrayList<>());
//         }
        
//         for(int[]edge:edges)
//         {
//             adj.get(edge[0]).add(edge[1]);
//             adj.get(edge[1]).add(edge[0]);
//         }
        
//         boolean []vis = new boolean[V];
        
//         for(int i=0;i<V;i++)
//         {
//             if(!vis[i])
//             {
//                 if(dfs(adj,vis,i,-1))
//                     return true;
//             }
//         }
//         return false;
        
//     }
// }