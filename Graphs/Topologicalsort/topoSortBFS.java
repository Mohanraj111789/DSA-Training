class Solution {
    int x;
    public void bfs(ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ans,int[] indegree)
    {
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int x = q.poll();
            ans.add(x);
            for(int ne:adj.get(x))
            {
                indegree[ne]--;
                if(indegree[ne] == 0)
                    q.add(ne);
            }
        }
        
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        ArrayList<Integer>ans = new ArrayList<>(V);
        boolean[]vis = new boolean[V];
        int[] indegree = new int[V];
        
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int[]edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        bfs(adj,ans,indegree);
        return ans;
    }
}
//problem link: https://practice.geeksforgeeks.org/problems/topological-sort/1