class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], currMax = 1, currMin = 1;

        for(int num : nums){
            int tmp = currMax * num;
            currMax = Math.max(num, Math.max(num * currMax, num * currMin));
            currMin = Math.min(num, Math.min(tmp, num * currMin));

            res = Math.max(res, currMax);
        }
        return res;
    }
}