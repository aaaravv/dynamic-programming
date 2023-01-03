class Solution {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) return 0;

      int maxProfit = 0, minAmount = Integer.MAX_VALUE;

      // why DP? What is DP - remembering the past so, here we remembering the min throughout
      for (int i = 0; i < prices.length; i++) {
        minAmount = Math.min(prices[i], minAmount);
        maxProfit = Math.max(maxProfit, prices[i] - minAmount);
      }
      return maxProfit;
	}
    
}