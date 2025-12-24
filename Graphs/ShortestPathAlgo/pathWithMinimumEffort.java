class Node{
    int dis;
    int row;
    int col;
    public Node(int dis,int row,int col)
    {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n= heights.length;
        int m= heights[0].length;
        int[][] ans = new int[n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(ans[i], Integer.MAX_VALUE);

        PriorityQueue<Node>pq = new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new Node(0,0,0));
        int[]row_x = {0,0,-1,1};
        int[]col_x = {-1,1,0,0};
        while(!pq.isEmpty())
        {
            Node cur = pq.poll();
            if(cur.row == n-1 && cur.col == m-1)
                return cur.dis;
            
            for(int i=0;i<4;i++)
            {
                int nr = cur.row+row_x[i];
                int nc = cur.col+col_x[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m)
                {
                    int dif = Math.abs(heights[cur.row][cur.col] - heights[nr][nc]);
                    int maxi = Math.max(dif,cur.dis);
                    if(maxi<ans[nr][nc])
                    {
                        ans[nr][nc] = maxi;
                        pq.add(new Node(maxi,nr,nc));

                    }
                    
                }
            }
            
        }
        return 0;
        
    }
}