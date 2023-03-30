class Solution {    
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> dp = new HashMap<>();
        return solve(s1, s2, dp);
    }
    
    public boolean solve(String s1, String s2, Map<String, Boolean> dp) {
        if(s1.length() != s2.length())
            return false;
        
        if(s1.equals(s2))
            return true;
        
        String key = s1 + "_" + s2;
        
        if(dp.containsKey(key))
            return dp.get(key);
        
        boolean result = false;
        
        int n = s1.length();
        
        for(int i = 1; i < n; i++) {
            boolean notSwap = solve(s1.substring(0, i), s2.substring(0, i), dp) &&
                solve(s1.substring(i, n), s2.substring(i, n), dp);
            
            if(notSwap) {
                result = true;
                break;
            }
            
            boolean swap = solve(s1.substring(0, i), s2.substring(n-i), dp) &&
                solve(s1.substring(i), s2.substring(0, n-i), dp);
            
            if(swap) {
                result = true;
                break;
            }
        }
        
        dp.put(key, result);
        
        return dp.get(key);
    }
}