class Solution {
    public int maximizeSum(int[] nums, int k) {
        int sum=0,max=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            max=nums[i];
        }
        sum = (k*(2*max+(k-1)))/2;
        return sum;
    }
}
