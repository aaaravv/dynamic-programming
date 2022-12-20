class Solution {
    public String shortestCommonSupersequence(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n+1][m+1];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = 1 + dp[i -1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while(i > 0 && j > 0){
            if(a.charAt(i - 1) == b.charAt(j - 1)){
                ans.append(a.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1]){
                ans.append(a.charAt(i - 1));
                i--;
            }
            else{
                ans.append(b.charAt(j - 1));
                j--;
            }
        }
        
        while(i > 0){
             ans.append(a.charAt(i - 1));
              i--;
        }
        while(j > 0){
            ans.append(b.charAt(j - 1));
            j--;
        }
        
        return ans.reverse().toString();
    }
}