class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int ans = 1;

        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev + 1) {
                count++;
                ans = Math.max(ans, count);
            } else if (nums[i] != prev) {
                count = 1;
            }
            prev = nums[i];
        }

        return ans;
    }
}
