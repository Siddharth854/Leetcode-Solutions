class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        
        // count[0] tracks even prefix sums (initialized to 1 for empty prefix sum 0)
        // count[1] tracks odd prefix sums
        int[] count = {1, 0};
        
        int prefixSum = 0;
        int result = 0;
        
        for (int num : arr) {
            prefixSum += num;
            
            // Determine parity: 0 for even, 1 for odd
            int parity = prefixSum & 1;
            
            // An odd subarray sum requires subtracting a prefix sum of the opposite parity
            result = (result + count[parity ^ 1]) % MOD;
            
            // Record the current prefix sum's parity
            count[parity]++;
        }
        
        return result;
    }
}
