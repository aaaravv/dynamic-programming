class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        
        for(int idx = n - 1; idx >= 0; idx--){
            for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--){
                int notTake = 0 + dp[idx + 1][prevIdx + 1];
                                              
                int take = 0;
                if(prevIdx == -1 || nums[idx] > nums[prevIdx])
                    take = 1 + dp[idx + 1][idx + 1];
                
                dp[idx][prevIdx + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}