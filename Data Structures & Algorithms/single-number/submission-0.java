class Solution {
    public int singleNumber(int[] nums) {
        int v = nums[0];
        for (int i = 1; i < nums.length; i++) {
            v ^= nums[i];
        }

        return v;
    }
}
