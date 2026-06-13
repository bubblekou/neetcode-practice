class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid[i][j] == '0') continue;
                ans++;
                dfs(grid, m, n, visited, i, j);
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int m, int n, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || 
            visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;
        dfs(grid, m, n, visited, row + 1, col);    
        dfs(grid, m, n, visited, row - 1, col);    
        dfs(grid, m, n, visited, row, col + 1);    
        dfs(grid, m, n, visited, row, col - 1);
    }
}
