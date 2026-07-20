class Solution {
    public int hammingWeight(int n) {
        int v = n;
        int res = 0;
        while (v > 0) {
            res += v & 1;
            v >>= 1;
        }

        return res;
    }

    // public int hammingWeight(int n) {
    //     return Integer.bitCount(n);
    // }
}
