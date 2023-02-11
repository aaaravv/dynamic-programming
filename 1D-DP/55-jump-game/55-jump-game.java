class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return canJump(nums, 0, n, dp);
    }
    public boolean canJump(int[] nums, int idx, int n, int[] dp){
        if(idx >= n - 1) return true;
        
        if(nums[idx] == 0) {
            dp[idx] = 0;
            return false;
        }
        
        if(dp[idx] != -1)
            return dp[idx] == 1; // destination reachable or not
        
        
        for(int i = 1; i <= nums[idx]; i++)
            if(canJump(nums, idx + i, n, dp)){
                dp[idx+i] = 1;
                return true;
            }
        
        dp[idx] = 0;
        return false;
    }
}