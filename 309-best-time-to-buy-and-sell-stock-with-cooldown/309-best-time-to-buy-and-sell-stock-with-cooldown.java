class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
        return f(0, n, 1, prices, dp);
    }
  
     public static int f(int idx, int n, int buy, int[] values, int[][] dp){
        if(idx >= n) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;
        // buy or not buy
        if(buy == 1) profit = 
            Math.max(-values[idx] + 
                     f(idx + 1, n, 0, values, dp), 0 + f(idx + 1, n, 1, values, dp));

        // sell or do not sell
        else profit = 
            Math.max(values[idx] + 
                     f(idx + 2, n, 1, values, dp), 0 + f(idx + 1, n, 0, values, dp));

        return dp[idx][buy] = profit;
    }
}