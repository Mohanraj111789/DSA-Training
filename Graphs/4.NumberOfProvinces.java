class Solution {
    int provinces = 0;
    public void bfs(int[][] isConnected,boolean vis[],int v)
    {
        Queue<Integer>q = new LinkedList<>();
        q.add(v);
        vis[v] = true;
        while(!q.isEmpty())
        {
            int x = q.poll();
            for(int i=0;i<isConnected.length;i++)
            {
                if(isConnected[x][i]==1 && !vis[i])
                {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
            if(!vis[i])
            {
                provinces++;
                bfs(isConnected,vis,i);
            }
        }
        return provinces;
        
    }
}

//problem link: https://leetcode.com/problems/number-of-provinces/ access ctrl+click

//dfs approach

/*
class Solution {
    int provinces = 0;
    public void dfs(int[][] isConnected,boolean vis[],int v)
    {
        vis[v] = true;
        for(int i=0;i<isConnected.length;i++)
        {
            if(isConnected[v][i]==1 && !vis[i])
            {
                dfs(isConnected,vis,i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
            if(!vis[i])
            {
                provinces++;
                dfs(isConnected,vis,i);
            }
        }
        return provinces;
        
    }
}
*/

//problem link: https://leetcode.com/problems/number-of-provinces/ access ctrl+click

//tc: o(V^2)
//sc: o(V)