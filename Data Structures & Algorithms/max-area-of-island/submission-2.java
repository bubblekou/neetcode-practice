class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;

                int area = dfs(grid, m, n, visited, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int m, int n, boolean[][] visited, int row, int col) {
        if (row < 0 | row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int area = 1;
        area += dfs(grid, m, n, visited, row + 1, col);
        area += dfs(grid, m, n, visited, row - 1, col);
        area += dfs(grid, m, n, visited, row, col + 1);
        area += dfs(grid, m, n, visited, row, col - 1);

        return area;
    }
}
