class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] res = new boolean[n];
        int maxEnd = 0;
        int i = 0;
        while (i <= maxEnd && maxEnd < n - 1) {
            maxEnd = Math.max(maxEnd, nums[i] + i);
            i++;
        }

        return maxEnd >= n - 1;
    }
}
