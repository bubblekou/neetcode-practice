class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);

        int[][] memo = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(coins, amount, 0, memo);
    }

    private int dp(int[] coins, int amount, int i, int[][] memo) {
        if (amount == 0) {
            return 1;
        } else if (i == coins.length) {
            return 0;
        } 

        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }

        // pruning, not possible for any changes
        if (amount < coins[i]) {
            return 0;
        }

        int ans = dp(coins, amount, i + 1, memo);
        int balance = amount;
        while (balance >= coins[i]) {
            balance -= coins[i];
            ans += dp(coins, balance, i + 1, memo);
        }

        memo[i][amount] = ans;
        return ans;
    }

}
