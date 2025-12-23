class Solution {
    public boolean canFinish(int V, int[][] edges) {
        // code here
        int [] indegree = new int[V];
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        
        for(int[]edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        int count =0;
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty())
        {
            count++;
            int cur = q.poll();
            for(int ne:adj.get(cur))
            {
                indegree[ne]--;
                if(indegree[ne] == 0)
                    q.add(ne);
            }
        }
        return !(count != V);  
    }
}
//problem link: https://practice.geeksforgeeks.org/problems/course-schedule/1
//tc: o(V+E)
//sc: o(V+E) + o(V) + o(V)
//o(V+E) for adjacency list
//o(V) for indegree array   o(V) for queue
//access ctrl+click 