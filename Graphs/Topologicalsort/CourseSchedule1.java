//problem description:
/*
There are a total of V courses you have to take, labeled from 0 to V-1. Some courses may have prerequisites,
 for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
    example 1:
    Input: V = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0. So it is possible.


example 2:    Input: V = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take.
    To take course 1 you should have finished course 0, and to take course 0 you should
    also have finished course 1. So it is impossible.
 */


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
        return (count == V);  
    }
}
//problem link: https://leetcode.com/problems/course-schedule/  Access ctrl+click on link to open
//tc: o(V+E)
//sc: o(V+E) + o(V) + o(V)
//o(V+E) for adjacency list
//o(V) for indegree array   o(V) for queue