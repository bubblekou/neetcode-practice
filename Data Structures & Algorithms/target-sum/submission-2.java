class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> [] memo = new Map[n];
        for (int i = 0; i < n; i++) {
            memo[i] = new HashMap<Integer, Integer>();
        }

        return dfs(nums, n, 0, target, memo);
    }

    private int dfs(int[] nums, int n, int i, int target, Map<Integer, Integer>[] memo) {
        if (i == n && target == 0) {
            return 1;
        }

        if (i >= n) {
            return 0;
        }

        if (memo[i].containsKey(target)) {
            return memo[i].get(target);
        }

        int ans = dfs(nums, n, i + 1, target - nums[i], memo);
        ans += dfs(nums, n, i + 1, target + nums[i], memo);

        memo[i].put(target, ans);

        return ans;
    }
}
