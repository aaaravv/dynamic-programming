class Solution {
    int n, m;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));

        return minPathSum(0, 0, grid, dp);
    }
    public int minPathSum(int i, int j, int[][] grid, int[][] dp) {
        if(i == m - 1 && j == n - 1) 
            return dp[i][j] = grid[m-1][n-1];
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(i == m - 1) // same row right col
            return dp[i][j] = grid[i][j] + minPathSum(i, j+1, grid, dp);
        
        if(j == n - 1) // same col down row
            return dp[i][j] = grid[i][j] + minPathSum(i+1, j, grid, dp);
        
        else 
            return dp[i][j] = grid[i][j] + Math.min(minPathSum(i+1, j, grid, dp), minPathSum(i, j+1, grid, dp));
        
    }
}
