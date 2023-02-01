class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        int res = gcd(max, min);
        
        return res;
    }
    public int gcd(int x, int y){
        if(y == 0) return x;
        
        return gcd(y, x % y);
    }
}