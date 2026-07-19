class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int value = n;
        while (!seen.contains(value)) {
            if (value == 1) {
                return true;
            }

            int newValue = 0;
            seen.add(value);
            while (value != 0) {
                newValue += Math.pow(value % 10, 2);
                value /= 10;
            }

            value = newValue;
        }

        return false;
    }
}
