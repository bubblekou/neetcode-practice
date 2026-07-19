class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;
        return n - dfs(intervals, 0, -1);
    }

    private int dfs(int[][] intervals, int i, int prev) {
        if (i == intervals.length) {
            return 0;
        }

        int res = dfs(intervals, i + 1, prev);
        if (prev == -1 || intervals[prev][1] <= intervals[i][0]) {
            res = Math.max(res, 1 + dfs(intervals, i + 1, i));
        }

        return res;
    }

    public int eraseOverlapIntervals_Greedy(int[][] intervals) {
       Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
       int res = 0;
       int prevEnd = intervals[0][1];
       for (int i = 1; i < intervals.length; i++) {
          int start = intervals[i][0];
          int end = intervals[i][1];
          if (start < prevEnd) {
            res++;
          } else {
            prevEnd = end;
          }
       }

       return res;   
    }
}
