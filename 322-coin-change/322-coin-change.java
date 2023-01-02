class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length, dp[][] =  new int[n][amount + 1];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
        int res = f(n - 1, coins, amount, dp);
        if(res >= (int) 1e9) return -1;
        return res;
    }
    
    public static int f(int n, int[] coins, int amount, int[][] dp){
      if(n == 0){
        if(amount % coins[0] == 0) return amount / coins[0];
        else return (int) 1e9;
      };
      
      if(dp[n][amount] != -1) return dp[n][amount];
      
      int notTake = 0 + f(n - 1, coins, amount, dp);
      int take = Integer.MAX_VALUE;
      
      if(coins[n] <= amount) take = 1 + 
        f(n, coins, amount - coins[n], dp);

      return dp[n][amount] = Math.min(take, notTake);
    }
}