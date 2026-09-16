class Solution {

    static final int MOD = 1000000007;

    public int numberOfSets(int n, int k) {

        int[][] dp = new int[n + 1][k + 1];

        // 0 segments can always be formed
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int segs = 1; segs <= k; segs++) {

            int[] prefix = new int[n + 1];

            // Prefix sum starts from dp[1], NOT dp[0]
            for (int i = 1; i <= n; i++) {
                prefix[i] =
                    (prefix[i - 1] + dp[i][segs - 1]) % MOD;
            }

            for (int i = 1; i <= n; i++) {

                dp[i][segs] = dp[i - 1][segs];

                if (i >= 2) {
                    dp[i][segs] =
                        (dp[i][segs] + prefix[i - 1]) % MOD;
                }
            }
        }

        return dp[n][k];
    }
}