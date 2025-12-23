class Solution {
    public boolean dfs(int[][] graph,boolean[] vis,boolean[] path,int i,List<Integer>ans)
    {
        vis[i] = true;
        path[i]= true;
        for(int ne:graph[i])
        {
            if(!vis[ne]){
                if(dfs(graph,vis,path,ne,ans))
                    return true;
            }
            else if(path[ne])
                return true;

        }
        path[i] = false;
        ans.add(i);
        return false;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer>ans = new ArrayList<>();
        int V = graph.length;
        boolean []vis = new boolean[V];
        boolean []path = new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
                dfs(graph,vis,path,i,ans);
        }
        Collections.sort(ans);
        return ans;
        
    }
}