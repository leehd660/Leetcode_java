public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            if (maxProfit < prices[i]-prices[i-1]) {
                maxProfit = prices[i]-prices[i-1];
            }
            prices[i] = Math.min(prices[i-1], prices[i]);
        }
        return maxProfit;
    }
}
