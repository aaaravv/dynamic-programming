class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
        return lcs(n - 1, m - 1, text1, text2, dp);
    }
  
     public int lcs(int n, int m, String s, String t, int[][] dp){
       if(n < 0 || m < 0) return 0;
       
       if(dp[n][m] != -1) return dp[n][m];
       
       if(s.charAt(n) == t.charAt(m)) return dp[n][m] = 1 + lcs(n - 1, m - 1, s, t, dp);
       
       return dp[n][m] = Math.max(lcs(n, m - 1, s, t, dp), lcs(n - 1, m, s, t, dp));
     }
}