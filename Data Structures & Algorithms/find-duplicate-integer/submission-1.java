class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int b = 0; b < 32; b++) {
            int mask = 1 << b;
            int x = 0, y = 0;
            for (int i = 1; i < n; i++) {
                if ((mask & i) != 0) x++;
            }

            for (int i = 0; i < n; i++) {
                if ((mask & nums[i]) != 0) y++;
            }

            if (x < y) res |= mask;
        }

        return res;
    }

    public int findDuplicate_naive(int[] nums) {
        int n = nums.length;
        boolean[] taken = new boolean[n];
        for (int v : nums) {
            if (taken[v]) {
                return v;
            }

            taken[v] = true;
        }

        return 0;
    }
}
