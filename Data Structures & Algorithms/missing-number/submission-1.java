class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res += i - nums[i];
        }

        return res;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return (n + 1) * n / 2 - sum;
    }
}
