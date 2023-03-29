class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n-1];
        
        Set<Integer> st = new HashSet<>(); // to track days only the days of traveling
        int[] dp = new int[lastDay+1];
        
        for(int i = 0; i < n; i++)
            st.add(days[i]);
        
        // dp[i] -> min cost of traveling upto ith day from day 1
        
        dp[0] = 0; // cost of reaching 0th day
        
        for(int i = 1; i <= lastDay; i++) {
            if(!st.contains(i)) {// skip this day
                dp[i] = dp[i-1];
                continue;
            } 
            
            dp[i] = Integer.MAX_VALUE;
            
            // 1 day pass
            int oneDayPass = costs[0] + dp[Math.max(0, i-1)]; // reaching i from i-1 by adding costs[0] (1day pass cost)
            
            // 7 day pass
            int sevenDayPass = costs[1] + dp[Math.max(0, i-7)]; // reaching i from i-7 by adding costs[1] (7day pass cost)
            
            // 30 day pass
            int thirtyDayPass = costs[2] + dp[Math.max(0, i-30)]; // reaching i from i-30 by adding costs[2] (30day pass cost)
            
            dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        }
        
        return dp[lastDay];
    }
}