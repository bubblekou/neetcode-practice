class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> updatedIntervals = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            updatedIntervals.add(intervals[i]);
        }
        updatedIntervals.add(newInterval);

        Collections.sort(updatedIntervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        List<int[]> merged = new ArrayList<>();
        int begin = updatedIntervals.get(0)[0];
        int end = updatedIntervals.get(0)[1];
        for (int i = 1; i < updatedIntervals.size(); i++) {
            if (updatedIntervals.get(i)[0] <= end) {
                end = Math.max(end, updatedIntervals.get(i)[1]);
            } else {
                merged.add(new int[] {begin, end});
                begin = updatedIntervals.get(i)[0];
                end = updatedIntervals.get(i)[1];
            }
        }
        // Last interval
        merged.add(new int[] {begin, end});

        int[][] ans = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            ans[i][0] = merged.get(i)[0];
            ans[i][1] = merged.get(i)[1];
        }

        return ans;
    }
}
