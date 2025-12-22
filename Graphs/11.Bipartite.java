class Solution {
    public boolean dfs(int[][] graph,int []colors,int v,int c) {
        colors[v] = c;
        for(int ne: graph[v]) {
            if(colors[ne] == -1) {
                if(dfs(graph,colors,ne,1-c) == false)
                    return false;
            } 
            else if(colors[ne] == c) 
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        //DFS

        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color,-1);
        for(int i=0;i<v;i++) {
            if(color[i] == -1) {
                if(dfs(graph,color,i,0) == false)
                    return false;
            }
        }
        return true; 
    }
}

// BFS Approach
/*
class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        Arrays.fill(colors,-1);
        for(int i=0;i<v;i++) {
            if(colors[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 0;
                while(!q.isEmpty()) {
                    int node = q.poll();
                    for(int ne: graph[node]) {
                        if(colors[ne] == -1) {
                            colors[ne] = 1 - colors[node];
                            q.add(ne);
                        } else if(colors[ne] == colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
*/

//problem link: https://leetcode.com/problems/is-graph-bipartite/description/
//tc: O(V + E)
//sc: O(V)