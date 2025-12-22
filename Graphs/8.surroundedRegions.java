class Solution {
    int[] row = {1, -1, 0, 0};
    int[] col = {0, 0, -1, 1};

    public void dfs(int[][] grid, int r, int c, boolean[][] vis, int n, int m) {
        vis[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + row[i];
            int nc = c + col[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                !vis[nr][nc] && grid[nr][nc] == 1) {
                dfs(grid, nr, nc, vis, n, m);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        // First and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0])
                dfs(grid, i, 0, vis, n, m);

            if (grid[i][m - 1] == 1 && !vis[i][m - 1])
                dfs(grid, i, m - 1, vis, n, m);
        }

        // First and last row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j])
                dfs(grid, 0, j, vis, n, m);

            if (grid[n - 1][j] == 1 && !vis[n - 1][j])
                dfs(grid, n - 1, j, vis, n, m);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j])
                    ans++;
            }
        }
        return ans;
    }
}

//BFS Approach
/*
class Solution {
    int[] row = {1, -1, 0, 0};
    int[] col = {0, 0, -1, 1};

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // First and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                q.add(new int[]{i, 0});
                vis[i][0] = true;
            }

            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                q.add(new int[]{i, m - 1});
                vis[i][m - 1] = true;
            }
        }

        // First and last row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                q.add(new int[]{0, j});
                vis[0][j] = true;
            }

            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                q.add(new int[]{n - 1, j});
                vis[n - 1][j] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + row[i];
                int nc = c + col[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    !vis[nr][nc] && grid[nr][nc] == 1) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j])
                    ans++;

            }
        }

        return ans;
    }
}
*/