class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int[] pre:prerequisites)
        {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
        int count =0;
        int[] ans = new int[numCourses];
        while(!q.isEmpty())
        {
            int cur = q.poll();
            ans[count++] = cur;
            for(int ne:adj.get(cur))
            {
                indegree[ne]--;
                if(indegree[ne] == 0)
                    q.add(ne);
            }
        }
        return ans.length == numCourses ? ans : new int[0];
    }
}
//problem link: https://leetcode.com/problems/course-schedule-ii/ access ctrl+click
//tc: o(V+E)
//sc: o(V+E) + o(V) + o(V)
//o(V+E) for adjacency list
//o(V) for indegree array   o(V) for queue
