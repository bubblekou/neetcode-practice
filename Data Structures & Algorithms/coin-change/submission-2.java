class Solution {

    public int coinChange(int[] coins, int amount) {
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
