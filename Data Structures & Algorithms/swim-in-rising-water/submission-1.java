class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
          a[2] - b[2]);
        pq.offer(new int[] {0, 0, grid[0][0]});

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[0];
            int j = current[1];
            int dist = current[2];

            if (i == m - 1 && j == n - 1) {
                return dist;
            }

            distance[i][j] = dist;
            for(int[] d : dirs) {
                int nextRow = i + d[0];
                int nextCol = j + d[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;

                int nextDist = Math.max(dist, grid[nextRow][nextCol]);
                if (nextDist >= distance[nextRow][nextCol]) continue;

                pq.offer(new int[] {nextRow, nextCol, nextDist});
            }
        }

        return -1;
    }
}
