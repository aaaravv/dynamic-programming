class Solution {
    public int longestStrChain(String[] arr) {
      int max = 1, n = arr.length;
      int[] dp = new int[n];
      Arrays.fill(dp, 1);
      Arrays.sort(arr, (a, b) -> a.length() - b.length());

      for(int idx = 0; idx < n; idx++){
          for(int prevIdx = 0; prevIdx < idx; prevIdx++){
              if(check(arr[idx], arr[prevIdx]) && 1 + dp[prevIdx] > dp[idx])
                  dp[idx] = 1 + dp[prevIdx];
          }
          max = Math.max(dp[idx], max);
      }
      return max;
    }
  
    public static boolean check(String s1, String s2){
        if(s1.length() != s2.length() + 1) return false;
        int first = 0, second = 0;
        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else first++;
        }
        if(first == s1.length() && second == s2.length()) return true;
        return false;
    }
}