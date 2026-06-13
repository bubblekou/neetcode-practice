class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> q = new LinkedList<>();

        Set<Integer> processed = new HashSet<>();
        int freshFruit = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshFruit++;
                } 

                if (grid[i][j] != 2) continue;

                int value = i * n + j;
                q.offer(value);
            }
        }

        if (freshFruit == 0) {
            return 0;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int value = q.poll();
                int row = value / n;
                int col = value % n;
                for (int[] d : dirs) {
                    int nextRow = row + d[0];
                    int nextCol = col + d[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n
                        || grid[nextRow][nextCol] != 1) continue;
                    
                    int nextValue = nextRow * n + nextCol;
                    if (processed.contains(nextValue)) continue;

                    grid[nextRow][nextCol] = 2;
                    q.offer(nextValue);
                    processed.add(nextValue);
                }

            }

            minutes++;
        }

        // System.out.println("freshFruit = " + freshFruit + ", processed size = " + processed.size());
        return freshFruit != processed.size() ? -1 : minutes - 1;
    }
}
