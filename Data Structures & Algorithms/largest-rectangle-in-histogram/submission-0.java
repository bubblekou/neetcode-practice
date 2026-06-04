class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int lowest = heights[i];
            for (int j = i; j < n; j++) {
                lowest = Math.min(lowest, heights[j]);
                ans = Math.max(ans, (j - i + 1) * lowest);
            }
        }

        return ans;
    }
}
