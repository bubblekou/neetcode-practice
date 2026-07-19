class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        } else if (n == 0) {
            return 1.0;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 1) {
            return x * myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2);
        }
    }
}
