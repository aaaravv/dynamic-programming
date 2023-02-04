class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;

        if(n == 1) return scores[0]; // return score if only 1 player exists

        int[][] teams = new int[n][2]; // map the ages and scores together
        for(int i = 0; i < n; i++){
            teams[i][0] = ages[i];
            teams[i][1] = scores[i];
        }
        Arrays.sort(teams, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // if two ages are equal sort on scores else on ages (asc)

        int[][] dp = new int[n + 1][n + 1];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));

        return f(0, -1, teams, n, dp);
    }
    public int f(int idx, int prev, int[][] teams, int n, int[][] dp){
        if(idx >= n) return 0;
        
        if(prev != -1 && dp[prev][idx] != -1) return dp[prev][idx];

        int notPick = f(idx + 1, prev, teams, n, dp);
        int pick = Integer.MIN_VALUE;

        if(prev == -1 || teams[idx][0] == teams[prev][0]) // add the score for first index or if 2 consecutive ages are same
            pick = teams[idx][1] + f(idx + 1, idx, teams, n, dp);

        else if(teams[prev][0] < teams[idx][0] && teams[prev][1] <= teams[idx][1]) // add the score if age of prev person is less than person at curr idx &
            pick = teams[idx][1] + f(idx + 1, idx, teams, n, dp); // his score is greater than or equal to prev person

        int res = Math.max(pick, notPick);
        if(prev == -1) return res;
        return dp[prev][idx] = res;
    }
}