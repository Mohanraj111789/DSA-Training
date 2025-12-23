// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // FIX 1: Build adjacency list only once
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] ans = new int[V];
        Arrays.fill(ans, -1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        ans[0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int cost = cur[1];

            for (int[] ne : adj.get(node)) {
                int nextNode = ne[0];
                int weight = ne[1];
                
                if (ans[nextNode] == -1) {
                    ans[nextNode] = cost + weight;
                    q.add(new int[]{nextNode, ans[nextNode]});
                }
                else if(ans[nextNode]>cost+weight)
                {
                    ans[nextNode] = cost+weight;
                    q.add(new int[]{nextNode,ans[nextNode]});
                }
            }
        }
        return ans;
    }
}
