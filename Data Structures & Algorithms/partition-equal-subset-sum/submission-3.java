class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public boolean canPartition_top_down(int[] nums) {
        int total = 0;
        for (int v : nums) {
            total += v;
        }

        if (total % 2 == 1) {
            return false;
        }

        int half = total / 2;
        int n = nums.length;
 
        int[][] memo = new int[n][half + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return canMake(nums, 0, half, memo);
    }

    private boolean canMake(int[] nums, int i, int target, int[][] memo) {
        if (target == 0) {
            return true;
        }

        if (i == nums.length || target < 0) {
            return false;
        }

        if (memo[i][target] != -1) {
            return memo[i][target] == 1;
        }

        boolean res = canMake(nums, i + 1, target, memo) || canMake(nums, i + 1, target - nums[i], memo);
        if (res) {
            memo[i][target] = 1;
        } else {
            memo[i][target] = 0;
        }

        return res;
    }
}
