class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;

        Arrays.sort(nums);

        int l = 0;
        int maxLen = 1;

        for (int r = 0; r < n; r++) {
            while ((long) nums[r] > (long) nums[l] * k) {
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return n - maxLen;
    }
}
