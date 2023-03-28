class Solution {
    int n;
    public int mincostTickets(int[] days, int[] costs) {
        n = days.length; 
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return mincostTickets(0, days, costs, dp);
    }
    public int mincostTickets(int i, int[] days, int[] costs, int[] dp) {
        if(i >= n) return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        //1 day pass
        int oneDayPass = costs[0] + mincostTickets(i+1, days, costs, dp);
        
        //7 day pass
        int j = i;
        int nextDayToPurchaseTicket = days[i] + 7;
        while(j < n && days[j] < nextDayToPurchaseTicket) j++;
        
        int sevenDaypass = costs[1] + mincostTickets(j, days, costs, dp);
        
        //30 day pass
        j = i;
        nextDayToPurchaseTicket = days[i] + 30;
        while(j < n && days[j] < nextDayToPurchaseTicket) j++;
        
        int thirtyDayPass = costs[2] + mincostTickets(j, days, costs, dp);
        
        return dp[i] = Math.min(oneDayPass, Math.min(sevenDaypass, thirtyDayPass));
    }
}