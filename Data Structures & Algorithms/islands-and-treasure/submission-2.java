class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(i * n + j);
                }
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
                        grid[nextRow][nextCol] != Integer.MAX_VALUE) continue;

                    grid[nextRow][nextCol] = grid[row][col] + 1;
                    q.offer(nextRow * n + nextCol);
                }               
            }
        }
    }
}
