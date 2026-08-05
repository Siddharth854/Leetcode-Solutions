class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum =0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            totalSum=totalSum+nums[i];
        }
        int leftSum=0;
        for(int i=0;i<n;i++)
        {
            totalSum=totalSum-nums[i];
            if(totalSum==leftSum)
            {
                return i;
            }
            leftSum+=nums[i];
        }
        
        return -1;
    }
}
