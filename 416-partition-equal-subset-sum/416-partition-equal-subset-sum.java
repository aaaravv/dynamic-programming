class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, S = Arrays.stream(nums).sum();
        if(S % 2 != 0) return false;
        int dp[][] = new int[n + 1][S/2 + 1];
      
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
        return canPartition(n - 1, S / 2, nums, dp);
    }
  
    public boolean canPartition(int idx, int target, int[] arr, int[][] dp){
        if(target == 0) return true;
        if(idx == 0) return (arr[0] == target);
        
        if(dp[idx][target] != -1) return dp[idx][target] == 0;
        
        boolean notTake = canPartition(idx - 1, target, arr, dp);
        boolean take = false;
        
        if(target >= arr[idx]) take = canPartition(idx - 1, target - arr[idx], arr, dp);  
        
        dp[idx][target] = dp[idx][target] == 0 ? 0 : 1;
        
        return take || notTake;
    }
}