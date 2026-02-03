/*
Detect cycle in an undirected graph using BFS
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
    Example 1:
    Input:
    V = 5, E = 5
    edges = {{0,1},{1,2},{2,3},{3,4},{4,1}}
    Output: 1
    Explanation: The given undirected graph contains a cycle, so return true.
    Example 2:
    Input:
    V = 3, E = 2
    edges = {{0,1},{1,2}}
    Output: 0
    Explanation: The given undirected graph does not contain any cycle, so return false.
    Your Task:
    You don't need to read input or print anything. Your task is to complete the function isCycle() which takes the number of vertices V and a list of edges as input parameters and returns true if the graph contains a cycle; otherwise, it returns false.
    Expected Time Complexity: O(V + E)
    Expected Auxiliary Space: O(V)


    Approach: BFS
    Use a queue to perform BFS traversal of the graph.
    Keep track of visited nodes to avoid revisiting them.
    For each node, check its neighbors. If a neighbor has already been visited and is not the parent of the current node, a cycle is detected.

    Dry Run:
    Consider the graph with edges: {{0,1},{1,2},{2,3},{3,4},{4,1}}
    Start BFS from node 0:
    Visit node 0, mark it as visited.
    Move to node 1, mark it as visited.
    Move to node 2, mark it as visited.
    Move to node 3, mark it as visited.
    Move to node 4, mark it as visited.
    Now, check the neighbors of node 4. It has a neighbor node 1, which is already visited and is not the parent of node 4. Hence, a cycle is detected. 
    */


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