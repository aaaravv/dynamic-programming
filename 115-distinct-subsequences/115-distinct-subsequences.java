class Solution {
    public int numDistinct(String t, String s) {
        int lt = t.length(), ls = s.length();
        int[][] dp = new int[lt + 1][ls + 1];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, 0));
        
        for(int i = 0; i <= lt; i++) dp[i][0] = 1;
      
        for(int i = 1; i <= lt; i++){
          for(int j = 1; j <= ls; j++){
            if(t.charAt(i - 1) == s.charAt(j - 1))
              dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            else dp[i][j] = dp[i - 1][j];
          }
        }
        return dp[lt][ls];
    }
}