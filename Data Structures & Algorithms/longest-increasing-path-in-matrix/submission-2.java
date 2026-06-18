class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dp = new int[m][n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, m, n, visited, i, j, dp));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int m, int n, boolean[][] visited, int row, int col, int[][] dp) {
        if (row >= n || col >= n) {
            return 0;
        }

        if (dp[row][col] > 0) {
            return dp[row][col];
        }

        visited[row][col] = true;

        int ans = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n
              || visited[nextRow][nextCol] || matrix[row][col] >= matrix[nextRow][nextCol]) continue;

            ans = Math.max(ans, dfs(matrix, m, n, visited, nextRow, nextCol, dp) + 1);  
        }

        visited[row][col] = false;

        dp[row][col] = ans;
        return ans;
    }
}
