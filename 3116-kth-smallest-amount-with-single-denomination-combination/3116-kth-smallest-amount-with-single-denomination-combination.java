class Solution {

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // Count how many valid amounts are <= x
    private long count(long x, int[] coins) {
        int n = coins.length;
        long ans = 0;

        // Inclusion-exclusion
        for (int mask = 1; mask < (1 << n); mask++) {
            long L = 1;
            int bits = 0;
            boolean tooLarge = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    L = lcm(L, coins[i]);

                    // No multiple of L can be <= x
                    if (L > x) {
                        tooLarge = true;
                        break;
                    }
                }
            }

            if (tooLarge) continue;

            long multiples = x / L;

            if ((bits & 1) == 1) {
                ans += multiples;
            } else {
                ans -= multiples;
            }
        }

        return ans;
    }

    public long findKthSmallest(int[] coins, int k) {
        long minCoin = Long.MAX_VALUE;

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        // The kth amount cannot be larger than minCoin * k
        long left = 1;
        long right = minCoin * (long) k;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
