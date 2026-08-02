class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int prefix = nums[0];
        int ans = prefix;
        for(int i=1; i<n; i++)
        {
            prefix = Math.max(prefix + nums[i], nums[i]);
            ans = Math.max(ans, prefix);
        }
        return ans;
    }
}