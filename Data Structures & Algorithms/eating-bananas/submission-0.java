class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for (int i = 0; i < piles.length; i++) {
            maxSpeed = Math.max(maxSpeed, piles[i]);
        }

        int low = 1, high = maxSpeed;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!canFinish(piles, h, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int needed = 0;
        for (int v : piles) {
            needed += v / k;
            if (v % k > 0) {
                needed++;
            }

            if (needed > h) {
                return false;
            }
        }

        return needed <= h;
    }
}
