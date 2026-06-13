class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.offer(i * n);
                visited[i][0] = true;
            }
            if (board[i][n - 1] == 'O') {
                q.offer(i * n + n - 1);
                visited[i][n - 1] = true;
            }
        }

        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                q.offer(j);
                visited[0][j] = true;
            }
            if (board[m - 1][j] == 'O') {
                q.offer((m - 1) * n + j);
                visited[m - 1][j] = true;
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int value = q.poll();
                int row = value / n;
                int col = value % n;
                for (int[] d : dirs) {
                    int nextRow = row + d[0];
                    int nextCol = col + d[1];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || 
                        board[nextRow][nextCol] != 'O' || visited[nextRow][nextCol]) continue;
                    visited[nextRow][nextCol] = true;
                    q.offer(nextRow * n + nextCol);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }


}
