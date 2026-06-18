class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        return dfs(nums, n, 0, target);
    }

    private int dfs(int[] nums, int n, int i, int target) {
        if (i == n && target == 0) {
            return 1;
        }

        if (i >= n) {
            return 0;
        }

        int ans = dfs(nums, n, i + 1, target - nums[i]);
        ans = dfs(nums, n, i + 1, target + nums[i]);

        return ans;
    }
}
