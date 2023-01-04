class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int S = Arrays.stream(nums).sum();
        if(S - target < 0 || (S - target) % 2 != 0) return 0;
        return f(nums, (S - target) / 2);        
    }
    
    public static int f(int num[], int tar) {
        int n = num.length, dp[][] = new int[n][tar + 1];
        Arrays.stream(dp).forEach(ele -> Arrays.fill(ele, -1));
        return f(n - 1, tar, num, dp);
    }
    
    public static int f(int idx, int k, int[] arr, int[][] dp){
        if(idx == 0){
            if(k == 0 && arr[0] == 0) return 2;
            if(k == 0 || arr[0] == k) return 1;
            return 0;
        }
        if(dp[idx][k] != -1) return dp[idx][k];
        int notTake = f(idx - 1, k, arr, dp);
        int take = 0;
        
        if(k >= arr[idx]) take = f(idx - 1, k - arr[idx], arr, dp);  
        
        return dp[idx][k] = (take + notTake);
    }
}