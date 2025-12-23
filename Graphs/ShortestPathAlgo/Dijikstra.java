class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int[] ans = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0});
        ans[src] = 0;
        while(!pq.isEmpty())
        {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            for(int[] ne:adj.get(node))
            {
                int nextNode = ne[0];
                int weight = ne[1];
                if(ans[nextNode]>cost+weight)
                {
                    ans[nextNode] = cost+weight;
                    pq.add(new int[]{nextNode,ans[nextNode]});
                }
            }
        }
        
        return ans;
    }
}

//problem link: https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
//time complexity: O(E log V)
//space complexity: O(V + E)
//explanation:
//The code implements Dijkstra's algorithm to find the shortest path from a source node to all other nodes in a weighted graph.
//It constructs an adjacency list from the given edges, initializes a distance array with maximum values,
//and uses a priority queue to explore the graph based on the minimum cost path found so far.
//As it explores each node, it updates the shortest distance for each neighboring node if a shorter path is found.

