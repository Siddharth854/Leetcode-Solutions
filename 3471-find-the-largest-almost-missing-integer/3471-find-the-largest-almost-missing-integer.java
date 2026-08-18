class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] count = new int[51];

        // Go through every subarray of size k
        for (int i = 0; i <= nums.length - k; i++) {

            // Keep track of values already seen in this window
            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {
                seen[nums[j]] = true;
            }

            // Each value counts only once for this subarray
            for (int x = 0; x <= 50; x++) {
                if (seen[x]) {
                    count[x]++;
                }
            }
        }

        // Find the largest number that appears in exactly one subarray
        for (int x = 50; x >= 0; x--) {
            if (count[x] == 1) {
                return x;
            }
        }

        return -1;
    }
}