class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int v : nums) {
            total += v;
        }

        if (total % 2 == 1) {
            return false;
        }

        int n = nums.length;
        return canMake(nums, n, total / 2);
    }

    private boolean canMake(int[] nums, int end, int target) {
        if (target == 0) {
            return true;
        }

        if (end < 0) {
            return false;
        }

        return canMake(nums, end - 1, target) || canMake(nums, end - 1, target - nums[end]);
    }
}
