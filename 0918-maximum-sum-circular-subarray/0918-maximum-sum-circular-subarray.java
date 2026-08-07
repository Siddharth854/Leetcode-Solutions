class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int ans_1 = 0;
        int ans_2 = 0;
        int maxPrefix = nums[0];
        int maxSubSum = maxPrefix;
        int minPrefix = nums[0];
        int minSubSum = minPrefix;
        int totalSum = 0;
        for(int i=0;i<n;i++)
        {
            totalSum+=nums[i];
        }
        for(int i=1;i<n;i++)
        {
            maxPrefix = Math.max(maxPrefix + nums[i], nums[i]);
            maxSubSum = Math.max(maxPrefix,maxSubSum);

            minPrefix = Math.min(minPrefix + nums[i], nums[i]);
            minSubSum = Math.min(minSubSum,minPrefix);
        }
       if (maxSubSum < 0)
            return maxSubSum;

        return Math.max(maxSubSum, totalSum - minSubSum);
    }
}
