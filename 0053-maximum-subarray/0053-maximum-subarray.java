class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i] = Math.max(prefix[i-1]+nums[i],nums[i]);
            ans = Math.max(ans,prefix[i]);
        }
        return ans;
    }
}