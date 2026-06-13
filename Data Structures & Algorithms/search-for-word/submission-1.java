class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, m, n, used, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int m, int n, boolean[][] used, 
          int row, int col, int idx, String word) {
        if (board[row][col] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        used[row][col] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || used[nextRow][nextCol]) continue;
            if (dfs(board, m, n, used, nextRow, nextCol, idx + 1, word)) {
                return true;
            }
        }

        used[row][col] = false;

        return false;
      }
}
