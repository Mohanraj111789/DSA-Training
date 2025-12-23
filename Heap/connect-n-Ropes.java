//problem statement
/*
we have n ropes our task is to merge the ropes And get minimum cost
 */
//give the testcase

class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i:arr)
            pq.add(i);
        int c =0;
        while(pq.size()>1)
        {
            int t1 = pq.poll();
            int t2 = pq.poll();
            c+=t1+t2;
            pq.add(t1+t2);
        }
        return c;
    }
}
//problem link 