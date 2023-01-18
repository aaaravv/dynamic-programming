class Solution {
    public int minFlipsMonoIncr(String s){
        int[][] dp = new int[s.length() + 1][2];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
        return minFlipsMonoIncr(0, 0, s, dp);
    }
    public int minFlipsMonoIncr(int prev, int curr, String s, int[][] dp){
        if(curr >= s.length()) return 0;

        int flip = Integer.MAX_VALUE, notFlip = Integer.MAX_VALUE;

        if(dp[curr][prev] != -1) return dp[curr][prev];

        if(s.charAt(curr) == '0'){
            if(prev == 0){
                flip = 1 + minFlipsMonoIncr(1, curr + 1, s, dp);
                notFlip = minFlipsMonoIncr(0, curr + 1, s, dp);
            }
            else{
                flip = 1 + minFlipsMonoIncr(1, curr + 1, s, dp);
            }
        }
        else{
            if(prev == 0){
                flip = 1 + minFlipsMonoIncr(0, curr + 1, s, dp);
                notFlip = minFlipsMonoIncr(1, curr + 1, s, dp);
            }
            else{
                notFlip = minFlipsMonoIncr(1, curr + 1, s, dp);
            }
        }
        return dp[curr][prev] = Math.min(flip, notFlip);
    }
}