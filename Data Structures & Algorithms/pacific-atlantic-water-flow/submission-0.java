class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        Queue<Integer> q = new LinkedList<>();

        boolean[][] pacific = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            q.offer(i * n);
            pacific[i][0] = true;
        }
        for (int j = 1; j < n; j++) {
            q.offer(j);
            pacific[0][j] = true;
        }
        bfs(heights, m, n, q, pacific);

        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            q.offer(i * n + n - 1);
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n - 1; j++) {
            q.offer((m - 1) * n + j);
            atlantic[m - 1][j] = true;
        }
        bfs(heights, m, n, q, atlantic);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    ans.add(cell);
                }
            }
        }

        return ans;
    }

    private void bfs(int[][] heights, int m, int n, Queue<Integer> q, boolean[][] visited) {
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
                        heights[nextRow][nextCol] < heights[row][col] || 
                        visited[nextRow][nextCol]) continue;

                    visited[nextRow][nextCol] = true;
                    q.offer(nextRow * n + nextCol);
                }
            }
        }
    }

}
