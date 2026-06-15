class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;
        for (int v : nums) {
            int tmp = curMax * v;
            curMax = Math.max(v, Math.max(v * curMax, v * curMin));
            curMin = Math.min(v, Math.min(tmp, v * curMin));
            res = Math.max(res, curMax);
        }

        return res;
    }
}
