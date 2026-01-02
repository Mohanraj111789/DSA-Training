// User function Template for Java
/*problem description:
    Given a binary matrix grid of size n x m, the task is to count the number of distinct islands.
    Two islands are considered distinct if they differ in shape or position.
    An island is a group of 1s connected 4-directionally (up, down, left, right).

    Example 1:
    Input: grid = [[1,1,0,0,0],
                   [1,0,0,0,0],
                   [0,0,0,1,1],
                   [0,0,0,1,0]]
    Output: 2
    Explanation: The grid contains two distinct islands.
    Example 2:
    Input: grid = [[1,1,0,1,1],
                   [1,0,0,0,0],
                   [0,0,0,0,1],
                   [1,1,0,1,1]]
    Output: 3
    Explanation: The grid contains three distinct islands.
    Your Task:
    You don't need to read input or print anything. Your task is to complete the function countDistinctIslands() which takes grid as input parameter and returns the count of distinct islands.
    Expected Time Complexity: O(n*m)
*/

class Solution {
    int[] x={0,0,-1,1};
    int[] y={-1,1,0,0};
    private String bfs(int[][] grid,int sr,int sc){
        StringBuilder res=new StringBuilder();
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc});
        grid[sr][sc]=0;
        res.append("0 0");
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0;i<4;i++){
                int nr=cur[0]+x[i],nc=cur[1]+y[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                    q.add(new int[]{nr,nc});
                    grid[nr][nc]=0;
                    res.append(Integer.toString(nr-sr)+" "+Integer.toString(nc-sc));
                }
            }
        }
        return res.toString();
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    set.add(bfs(grid,i,j));
                }
            }
        }
        return set.size();
    }

}
