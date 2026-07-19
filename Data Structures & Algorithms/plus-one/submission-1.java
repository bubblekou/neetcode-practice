class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int carryOver = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carryOver;
            carryOver = digits[i] / 10;
            digits[i] %= 10;

            if (carryOver == 0) {
                return digits;
            }
        }

        int[] copy = new int[n + 1];
        copy[0] = carryOver;
        for (int i = 1; i < n + 1; i++) {
            copy[i] = digits[i - 1];
        }

        return copy;
    }
}
