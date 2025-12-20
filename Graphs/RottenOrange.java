class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean [][]vis = new boolean[n][m];
        Queue<int[]>q = new LinkedList<>();



        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            ans++;

            int []row = new int[]{0,0,1,-1};
            int []col = new int[]{1,-1,0,0};
            

            for(int i=0;i<4;i++)
            {
                int nr = r+row[i];
                int nc = c+col[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 2 && !vis[nr][nc])
                {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return ans;

        
    }
}
//problem link: https://leetcode.com/problems/rotting-oranges/  access ctrl+click
//tc: o(n*m)
//sc: o(n*m)