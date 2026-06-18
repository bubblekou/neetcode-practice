class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] stock = new int[n + 1];
        int[] money = new int[n + 1];
        stock[1] = -prices[0];
        money[1] = 0;

        for (int i = 1; i < n; i++) {
            // Holding the stock or cooling down (bought stock the day before)
            stock[i + 1] = Math.max(stock[i], money[i - 1] - prices[i]);
            // Keep the month or sell the previously bought stock
            money[i + 1] = Math.max(money[i], stock[i] + prices[i]);
        }

        return money[n];
    }
}
