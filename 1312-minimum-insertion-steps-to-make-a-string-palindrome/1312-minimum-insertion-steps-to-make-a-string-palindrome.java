class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder st = new StringBuilder(s);
        String t = st.reverse().toString();
        int m = t.length();
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
        return n - f(n - 1, m - 1, s, t, dp);       
    }
  
     public static int f(int n, int m, String s, String t, int[][] dp){
       if(n < 0 || m < 0) return 0;
       
       if(dp[n][m] != -1) return dp[n][m];
       
       if(s.charAt(n) == t.charAt(m)) 
           return dp[n][m] = 1 + f(n - 1, m - 1, s, t, dp);
       
       return dp[n][m] = Math.max(f(n, m - 1, s, t, dp), f(n - 1, m, s, t, dp));
     }
}