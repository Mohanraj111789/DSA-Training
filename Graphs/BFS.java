class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        Deque<Integer>q = new ArrayDeque<>();
        q.add(0);
        visited.add(0);
        while(!q.isEmpty())
        {
            int curr = q.poll();
            ans.add(curr);
            for(int ne: adj.get(curr))
            {
                if(!visited.contains(ne))
                {
                    visited.add(ne);
                    q.add(ne);
                }
            }

        }
        return ans;
        
    }
}