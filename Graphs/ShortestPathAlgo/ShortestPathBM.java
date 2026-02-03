// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int N= grid.length;
        int M = grid[0].length;
        
        if(source[0]==destination[0] && source[1] == destination[1])
            return 0;
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{source[0],source[1],0});
        
        int[] x_row = {0,1,-1,0};
        int[] y_col = {-1,0,0,1};
        
        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            int d = node[2];
            
            for(int i=0;i<4;i++)
            {
                int nr = r+x_row[i];
                int nc = c+y_col[i];
                if(nr>=0 && nc>=0 && nr<N && nc<M && grid[nr][nc] == 1)
                {
                    if(nr == destination[0] && nc == destination[1])
                        return d+1;
                    grid[nr][nc]=0;
                    q.add(new int[]{nr,nc,d+1});
                }
            }
        }
        return -1;
        
        
    }
}
//problem Link 