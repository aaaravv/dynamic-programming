class Solution { // bottom-up
    int n, m;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int[][] dp = new int[m][n];

        // dp[i][j] depicts min path sum to reach [i][j] from [0][0]
        
        dp[0][0] = grid[0][0];
        
        // fill the 1st row
        for(int col = 1; col < n; col++) 
            dp[0][col] = grid[0][col] + dp[0][col-1];
        
        // fill the 1st col
        for(int row = 1; row < m; row++)  
            dp[row][0] = grid[row][0] + dp[row-1][0];
        
        for(int row = 1; row < m; row++)
            for(int col = 1; col < n; col++)
                dp[row][col] = grid[row][col] + Math.min(dp[row-1][col], dp[row][col-1]);
        
        return dp[m-1][n-1];
    }
}