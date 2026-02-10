class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            int even = 0, odd = 0;

            for (int j = i; j < n; j++) {
                int val = nums[j];
                freq.put(val, freq.getOrDefault(val, 0) + 1);

                if (freq.get(val) == 1) {
                    if (val % 2 == 0) even++;
                    else odd++;
                }

                if (even == odd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
