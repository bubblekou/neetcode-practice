class Solution {
    public int reverse(int x) {

        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (res > Integer.MAX_VALUE / 10 || 
                (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            if (res < Integer.MIN_VALUE / 10 ||
               (res == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            res *= 10;
            res += digit;
        }

        return res;

        // if (x < 0) {
        //     return -1 * reverse(-x);
        // }

        // int v = 0;
        // while (x > 0) {
        //     v *= 10;
        //     v += x % 10;
        //     x /= 10;
        // }

        // return v < 0 ? 0 : v;
    }
}
