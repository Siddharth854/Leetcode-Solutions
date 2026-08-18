class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]+1==nums[i])
            {
                sum+=nums[i];
            }else{
                break;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums)
        {
            set.add(val);
        }
        int x = sum;
        while(set.contains(x))
        {
            x++;
        }
        return x;
    }
}