class Node
{
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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = n;
        int [][] ans = new int[n][m];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return -1;
        
        PriorityQueue<Node>pq = new PriorityQueue<>((a,b)->a.dis - b.dis);
        pq.add(new Node(0,0,0));
        ans[0][0] = 0;
        while(!pq.isEmpty())
        {
            Node cur = pq.poll();
            if(cur.row-1>=0 && cur.col-1 >=0 && grid[cur.row-1][cur.col-1] == 0)
            {
                if(ans[cur.row-1][cur.col-1]>cur.dis+1)
                {
                    ans[cur.row-1][cur.col-1] = cur.dis+1;
                    pq.add(new Node(cur.dis+1,cur.row-1,cur.col-1));
                }

            }
            if(cur.row-1>=0 && grid[cur.row-1][cur.col] == 0)
            {
                if(ans[cur.row-1][cur.col]>cur.dis+1)
                {
                    ans[cur.row-1][cur.col] = cur.dis+1;
                    pq.add(new Node(cur.dis+1,cur.row-1,cur.col));
                }

            }
            if(cur.row-1>=0 && cur.col+1 < m && grid[cur.row-1][cur.col+1] == 0)
            {
                if(ans[cur.row-1][cur.col+1]>cur.dis+1)
                {
                    ans[cur.row-1][cur.col+1] = cur.dis+1;
                    pq.add(new Node(cur.dis+1,cur.row-1,cur.col+1));
                }
            }
            if(cur.col-1>=0 && grid[cur.row][cur.col-1] == 0)
            {
                if(ans[cur.row][cur.col-1]>cur.dis+1)
                {
                    ans[cur.row][cur.col-1] = cur.dis+1;
                    pq.add(new Node(cur.dis+1,cur.row,cur.col-1));
                }

            }
            if(cur.col+1 < m && grid[cur.row][cur.col+1] == 0)
            {
                if(ans[cur.row][cur.col+1]>cur.dis+1)
                {
                    ans[cur.row][cur.col+1] = cur.dis+1;
                    pq.add(new Node(cur.dis+1,cur.row,cur.col+1));
                }

            }
            if(cur.row+1 < n && cur.col-1 >=0 && grid[cur.row+1][cur.col-1] == 0)
            {
                if(ans[cur.row+1][cur.col-1]>cur.dis+1)
                {
                    ans[cur.row+1][cur.col-1] = cur.dis+1;
                    pq.add(new Node(cur.dis+1,cur.row+1,cur.col-1));
                }

            }
            if(cur.row+1 < n && grid[cur.row+1][cur.col] == 0)
            {
                if(ans[cur.row+1][cur.col]>cur.dis+1)
                {
                    ans[cur.row+1][cur.col] = cur.dis+1;
                    pq.add(new Node(cur.dis+1,cur.row+1,cur.col));
                }

            }
            if(cur.row+1 < n && cur.col+1 < m && grid[cur.row+1][cur.col+1] == 0)
            {
                if(ans[cur.row+1][cur.col+1]>cur.dis+1)
                {
                    ans[cur.row+1][cur.col+1] = cur.dis+1;
                    pq.add(new Node(cur.dis+1,cur.row+1,cur.col+1));
                }
            }
        }
        if(ans[n-1][m-1] == Integer.MAX_VALUE)
            return -1;
        return ans[n-1][m-1]+1;

        
    }
}