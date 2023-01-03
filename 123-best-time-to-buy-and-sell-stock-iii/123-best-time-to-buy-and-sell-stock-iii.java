class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // n : 0 -> n - 1, buy : 0, 1, cap : 0, 1, 2
        int[][][] dp = new int[n][2][3];
        
        for(int[][] row : dp)
            Arrays.stream(row).forEach(ele -> Arrays.fill(ele, -1));
        
        return f(0, 1, 2, n, prices, dp);
    }
  
    public static int f(int idx, int buy, int cap, int n, int[] prices, int[][][] dp){
          // base case
          if(idx == n) return 0;
          if(cap == 0) return 0;

          if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

          int profit = 0;
          if(buy == 1) profit = Math.max(-prices[idx] + 
                                         f(idx + 1, 0, cap, n, prices, dp), 0 + 
                                         f(idx + 1, 1, cap, n, prices, dp));

          else profit = Math.max(prices[idx] + 
                                 f(idx + 1, 1, cap - 1, n, prices, dp), 0 + 
                                 f(idx + 1, 0, cap, n, prices, dp));
          return dp[idx][buy][cap] = profit;
    }
}