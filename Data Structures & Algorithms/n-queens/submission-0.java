class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(n, 0, board, ans);
        return ans;
    }

    private void backtrack(int n, int idx, char[][] board, List<List<String>> ans) {
        if (idx == n) {
            List<String> config = new ArrayList<> ();
            for (int i = 0; i < n; i++) {
                config.add(new String(board[i]));
            }
            ans.add(config);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (safe(board, n, idx, j)) {
                board[idx][j] = 'Q';
                backtrack(n, idx + 1, board, ans);
                board[idx][j] = '.';
            }
        }
    }

    private boolean safe(char[][] board, int n, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;

                if (col == j) return false;
                if (i - row == col - j || i - row == j - col) return false;
            }
        }

        return true;
    }
}
