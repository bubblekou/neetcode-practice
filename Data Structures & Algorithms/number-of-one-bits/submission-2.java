class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }

        return res;
    }

    public int hammingWeight2(int n) {
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
