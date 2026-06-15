class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (c <= i) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange_topdown(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dp(coins, memo, amount);
    }

    private int dp(int[] coins, int[] memo, int amount) {
        if (amount == 0) {
            return 0;
        } else if (memo[amount] != -2) {
            return memo[amount];
        }

        // System.out.println("Amount = " + amount);
        int minCoin = Integer.MAX_VALUE;
        for (int c : coins) {
            if (amount - c < 0) continue;
            int sub = dp(coins, memo, amount - c);
            if (sub != -1) {
                minCoin = Math.min(minCoin, sub + 1);
            }
        }

        memo[amount] = minCoin == Integer.MAX_VALUE ?  -1 : minCoin;
        return  memo[amount];
    }
}
