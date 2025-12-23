class Solution
{
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{S, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            for (ArrayList<Integer> ne : adj.get(node)) {
                int nextNode = ne.get(0);
                int weight = ne.get(1);

                if (dist[nextNode] > cost + weight) {
                    dist[nextNode] = cost + weight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        return dist;

       
    }
}
