class Solution {
    public int findDuplicate(int[] nums) {
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
