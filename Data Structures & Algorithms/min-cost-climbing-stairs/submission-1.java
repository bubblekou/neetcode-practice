class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    private int[] memo;
    public int minCostClimbingStairs_top_down(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(dfs(cost, i + 1),
                                     dfs(cost, i + 2));
        return memo[i];
    }

    public int minCostClimbingStairs_bottom_up(int[] cost) {
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
