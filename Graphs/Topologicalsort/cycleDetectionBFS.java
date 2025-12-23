class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        int indegree[] = new int[V];
        int vis = 0;
        for(int i=0;i<V;i++)
        {
            for(int ne:adj.get(i))
            {
                indegree[ne]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int x = q.poll();
            vis++;
            for(int ne:adj.get(x))
            {
                indegree[ne]--;
                if(indegree[ne] == 0)
                    q.add(ne);
            }
        }
        return vis != V;
    }
}
//problem link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1  access ctrl+click
//tc: o(V+E)
//sc: o(V+E) + o(V) + o(V)
//o(V+E) for adjacency list
//o(V) for indegree array   o(V) for queue
