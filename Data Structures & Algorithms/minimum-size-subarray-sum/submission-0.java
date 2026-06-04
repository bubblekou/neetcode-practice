class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int n = nums.length;
        int runningTotal = 0;
        while (j < n) {
            runningTotal += nums[j];
            while (runningTotal >= target) {
                ans = Math.min(ans, j - i + 1);
                runningTotal -= nums[i];
                i++;
            }


            j++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}