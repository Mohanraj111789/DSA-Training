//problem: Shortest Path in Undirected Graph

class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] ans = new int[V];
        Arrays.fill(ans,-1);
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{src,0});
        ans[src] = 0;
        while(!q.isEmpty())
        {
            int[]cur = q.poll();
            int node = cur[0];
            int cost = cur[1];
            for(int ne:adj.get(node))
            {
                if(ans[ne] == -1)
                {
                    ans[ne] = cost+1;
                    q.add(new int[]{ne,cost+1});
                }
                
            }
            
        }
        return ans;
    }
}
//problem link: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
//time complexity: O(V + E)
//space complexity: O(V)
//explanation:
//The code implements the Breadth-First Search (BFS) algorithm to find the shortest path from
//a source node to all other nodes in an undirected graph. It constructs an adjacency list
//from the given edges, initializes a distance array with -1 (indicating unvisited nodes),
//and uses a queue to explore the graph level by level, updating the shortest distance for
//each node as it is reached for the first time.
//The final distances from the source node to all other nodes are returned in the ans array.
