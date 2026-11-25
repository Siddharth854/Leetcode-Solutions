
import java.util.*;

class Solution {
    private int[] nums;
    private final long BASE = 19;
    private final long MOD = 1_000_000_007L;

    private long[] powers;
    private HashMap<Long, Integer> hashValues;

    public int smallestUniqueSubarray(int[] nums) {
        this.nums = nums;

        int n = nums.length;

        powers = new long[n + 1];
        hashValues = new HashMap<>();

        // Precompute powers of BASE
        powers[0] = 1;

        for (int i = 1; i <= n; i++) {
            powers[i] = (powers[i - 1] * BASE) % MOD;
        }

        // Binary search for minimum valid length
        int left = 1;
        int right = n;
        int answer = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (checkUniqueness(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean checkUniqueness(int len) {
        hashValues.clear();

        long currentHash = 0;

        // Calculate hash of the first window
        for (int i = 0; i < len; i++) {
            currentHash = (currentHash * BASE + nums[i]) % MOD;
        }

        hashValues.put(currentHash, 1);

        // Slide the window
        for (int i = 1; i <= nums.length - len; i++) {

            // Remove the contribution of the outgoing element
            long remove = (powers[len - 1] * nums[i - 1]) % MOD;

            currentHash = (currentHash - remove + MOD) % MOD;

            // Add the incoming element
            currentHash = (currentHash * BASE
                    + nums[i + len - 1]) % MOD;

            // Update frequency
            hashValues.put(
                currentHash,
                hashValues.getOrDefault(currentHash, 0) + 1
            );
        }

        // Check whether any subarray occurs exactly once
        for (int frequency : hashValues.values()) {
            if (frequency == 1) {
                return true;
            }
        }

        return false;
    }
}
