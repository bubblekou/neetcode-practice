class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        boolean[] rowChecks = new boolean[n];
        boolean[] colChecks = new boolean[n];
        // Check row and col
        for (int i = 0; i < 9; i++) {
            Arrays.fill(rowChecks, false);
            Arrays.fill(colChecks, false);
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                if (ch >= '0' && ch <= '9') {
                    if (rowChecks[ch - '1']) {
                        return false;
                    }

                    rowChecks[ch - '1'] = true;
                }

                char ch2 = board[j][i];
                if (ch2 >= '0' && ch2 <= '9') {
                    if (colChecks[ch2 - '1']) {
                        return false;
                    }

                    colChecks[ch2 - '1'] = true;
                }
            }
        }
    
        // Check sub-box
        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1}, { 0, 0}, { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1},
        };

        boolean[] checks = new boolean[n];
        for (int r = 1; r <= 7; r += 3) {
            for (int c = 1; c <= 7; c += 3) {
                Arrays.fill(checks, false);
                for (int[] d : dirs) {
                    int i = r + d[0];
                    int j = c + d[1];
                    char ch = board[i][j];
                    if (ch >= '1' && ch <= '9') {
                       if (checks[ch - '1']) {
                          return false;
                       }

                       checks[ch - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}
