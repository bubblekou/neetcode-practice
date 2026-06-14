class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n < 2) {
            // No climb needed
            return 0;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // No cost for stair 0 and 1
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 0; i < n; i++) {
            // One step
            if (i + 1 < n + 1) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + cost[i]);
            }

            // Two steps
            if (i + 2 < n + 1) {
                dp[i + 2] = Math.min(dp[i + 2], dp[i] + cost[i]);
            }
        }

        return dp[n];
    }
}
