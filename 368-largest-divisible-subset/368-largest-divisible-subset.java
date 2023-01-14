class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        return longestDivisibleSubset(nums);
    }
    
     public static List<Integer> longestDivisibleSubset(int arr[]) {
            int n = arr.length;
            int[] dp = new int[n];
            int[] hash = new int[n];
            
            int max = 1, lastIdx = 0;
            for(int i = 0; i < n; i++) hash[i] = i;
            Arrays.fill(dp, 1);
            Arrays.sort(arr);
            
            for(int idx = 0; idx < n; idx++){
                for(int prevIdx = 0; prevIdx < idx; prevIdx++){
                    if(arr[idx] % arr[prevIdx] == 0 && 1 + dp[prevIdx] > dp[idx]){
                        dp[idx] = 1 + dp[prevIdx];
                        hash[idx] = prevIdx;
                    }
                }
                if(max < dp[idx]){
                    max = dp[idx];
                    lastIdx = idx;
                }
            }
            List<Integer> lst = new ArrayList<Integer>();
            lst.add(arr[lastIdx]);
            while(hash[lastIdx] != lastIdx){
                lastIdx = hash[lastIdx];
                lst.add(arr[lastIdx]);
            }
            return lst;
    }

}