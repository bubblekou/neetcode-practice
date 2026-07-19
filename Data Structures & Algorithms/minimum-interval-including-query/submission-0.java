class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int m = queries.length;
        int[][] indexQueries = new int[m][3];
        for (int i = 0; i < m; i++) {
            indexQueries[i][0] = queries[i];
            indexQueries[i][1] = i;
            indexQueries[i][2] = -1;
        }

        Arrays.sort(indexQueries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[1] - a[0]) - (b[1] - b[0]);
        });

        int i = 0;
        for (int j = 0; j < m; j++) {
            while (i < intervals.length && intervals[i][0] <= indexQueries[j][0]) {
                pq.offer(intervals[i]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < indexQueries[j][0]) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                indexQueries[j][2] = pq.peek()[1] - pq.peek()[0] + 1;
            }
        }

        int[] ans = new int[m];
        for (int j = 0; j < m; j++) {
            ans[indexQueries[j][1]] = indexQueries[j][2];
        }
        return ans;
    }
}
