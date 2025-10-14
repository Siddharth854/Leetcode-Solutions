class Solution {
    public boolean validSubarray(List<Integer> nums, int start, int end)
    {
        if (end >= nums.size())
        return false;

        for (int i = start + 1; i <= end; i++)
        {
            if (nums.get(i) - nums.get(i - 1) <= 0)
            return false;
        }

        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        // if subarray size is 4, the answer must be true
        for (int i = 0; i < nums.size() - 2*k + 2; i++)
        {
            // check whether [i, i + k) and [i + k, i + 2k) work

            boolean case1 = validSubarray(nums, i, i + k - 1);
            boolean case2 = validSubarray(nums, i + k, i + 2*k - 1);

            if (case1 && case2)
            return true;
        }

        return false;
    }
}