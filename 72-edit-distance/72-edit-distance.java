class Solution {
    public int minDistance(String str1, String str2) {
      int n = str1.length(), m = str2.length();
      int[][] dp = new int[n][m];
      Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
      return f(str1, str2, n - 1, m - 1, dp);
    }
  
    public static int f(String str1, String str2, int n, int m, int[][] dp){
      if(n < 0) return m + 1;
      if(m < 0) return n + 1;

      if(dp[n][m] != -1) return dp[n][m];

      if(str1.charAt(n) == str2.charAt(m)) return dp[n][m] = 
          0 + f(str1, str2, n - 1, m - 1, dp);

      int insert =  1 + f(str1, str2, n, m - 1, dp);
      int delete =  1 + f(str1, str2, n - 1, m, dp);
      int replace = 1 + f(str1, str2, n - 1, m - 1, dp);
      
      return dp[n][m] = Math.min(insert, Math.min(delete, replace));
  }
}