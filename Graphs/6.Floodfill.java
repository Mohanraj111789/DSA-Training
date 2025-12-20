class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc])
            return image;
        
        int n = image.length;
        int m = image[0].length;

        int old = image[sr][sc];
        int []row={0,0,-1,1};
        int []col = {-1,1,0,0};


        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!q.isEmpty())
        {
            int []node = q.poll();
            int r=node[0];
            int c = node[1];
            for(int i=0;i<4;i++)
            {
                int nr = r+row[i];
                int nc = c+col[i];
                if(nr>=0 && nr<n && nc >=0 && nc<m && image[nr][nc] == old)
                {
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }
            }


        }
        return image;
        
    }
}

//problem link: https://leetcode.com/problems/flood-fill/ access ctrl+click

//dfs approach
/*
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc])
            return image;
        
        int n = image.length;
        int m = image[0].length;

        int old = image[sr][sc];
        int []row={0,0,-1,1};
        int []col = {-1,1,0,0};

        dfs(image,sr,sc,old,color,n,m,row,col);
        return image;
        
    }
    public void dfs(int [][]image,int sr,int sc,int old,int color,int n,int m,int []row,int []col)
    {
        image[sr][sc] = color;
        for(int i=0;i<4;i++)
        {
            int nr = sr+row[i];
            int nc = sc+col[i];
            if(nr>=0 && nr<n && nc >=0 && nc<m && image[nr][nc] == old)
            {
                dfs(image,nr,nc,old,color,n,m,row,col);
            }
        }
    }
}
*/