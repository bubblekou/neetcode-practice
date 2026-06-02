class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int ans = 0;
        int minSofar = prices[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, prices[i] - minSofar);
            minSofar = Math.min(minSofar, prices[i]);
        }

        return ans;
    }
}
