class Solution {
    public int climbStairs(int n) {
        int[] values = new int[n + 1];
        values[1] = 1;
        values[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            values[i] = values[i - 1] + values[i - 2];
        }

        return values[n];
    }
}
