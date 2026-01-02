class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[]flight:flights)
        {
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        PriorityQueue<int[]>pq = new PriorityQueue<>();
        pq.add(new int[]{src,0,1});
        k = k+1;
        int[]dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        while(!pq.isEmpty())
        {
            int[]cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            int stops = cur[2];

            if(stops>k)
                continue;

            for(int[]ne:adj.get(node))
            {
                int nextNode = ne[0];
                int price = ne[1];

                if(cost+price<dist[nextNode] && stops<=k)
                {
                    dist[nextNode] = cost+price;
                    pq.add(new int[]{nextNode,dist[nextNode],stops+1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        
    }
}