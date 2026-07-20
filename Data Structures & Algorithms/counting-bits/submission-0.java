class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (i == offset * 2) {
                offset *= 2;
            }
            ans[i] = ans[i - offset] + 1;
        }

        return ans;        
    }
}
