class Solution {
    public int maxCoins(int[] nums) {
        // Go through all the balloon, consider this ballon is the last to burst
        // and then add it together with left and right sub arrays
        int n = nums.length;
        int[][] memo = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(memo[i], -1);
        }

        // for (int i = 0; i < n; i++) {
        //     dp(nums, n, -1, i, n);
        // }

        return dp(nums, n, -1, n, memo);
    }

    private int dp(int[] nums, int n, int left, int right, int[][] memo) {
        if (left == right) {
            // No ballon can burst
            return 0;
        }

        if (memo[left + 1][right + 1] != -1) {
            return memo[left+1][right+1];
        }

        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            int coins = nums[i] * (left < 0 ? 1 : nums[left]) * (right >= n ? 1 : nums[right]);
            coins += dp(nums, n, left, i, memo);
            coins += dp(nums, n, i, right, memo);
            ans = Math.max(ans, coins);
        }

        memo[left+1][right+1] = ans;
        return ans;
    }

    private int ans = 0;

    private int dp_saved(int[] nums, int n, int left, int i, int right) {
        int coins = nums[i] * (left < 0 ? 1 : nums[left]) * (right >= n ? 1 : nums[right]);
        int maxLeft = 0;
        for (int a = left + 1; a < i; a++) {
            maxLeft = Math.max(maxLeft, dp_saved(nums, n, left, a, i));
        }

        int maxRight = 0;
        for (int b = i + 1; b < right; b++) {
            maxRight = Math.max(maxRight, dp_saved(nums, n, i, b, right));
        }

        int current = coins + maxLeft + maxRight;
        ans = Math.max(ans, current);
        return current;
    }
}
