class Solution {
    int[] row = {0, 0, -1, 1};
    int[] col = {-1, 1, 0, 0};

    public void dfs(char[][] board, boolean[][] vis, int i, int j) {
        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nr = i + row[k];
            int nc = j + col[k];

            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {
                if (board[nr][nc] == 'O' && !vis[nr][nc]) {
                    dfs(board, vis, nr, nc);
                }
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        // First and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0])
                dfs(board, vis, i, 0);
            if (board[i][m - 1] == 'O' && !vis[i][m - 1])
                dfs(board, vis, i, m - 1);
        }

        // First and last row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j])
                dfs(board, vis, 0, j);
            if (board[n - 1][j] == 'O' && !vis[n - 1][j])
                dfs(board, vis, n - 1, j);
        }

        // Flip surrounded regions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
