import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        
        // 1. Precompute all proper divisors for every possible substring length
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 1; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }

        // 2. Precompute cost[i][j]: min changes to make s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            // A substring of length 1 cannot be a semi-palindrome
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j, divisors[j - i + 1]);
            }
        }

        // 3. Dynamic Programming to partition s into k substrings
        // dp[i][p] = min changes to partition prefix s[0..i-1] into p semi-palindromes
        int INF = 1_000_000;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            // Each partition needs at least length 2, so i starts at 2 * p
            for (int i = 2 * p; i <= n; i++) {
                // Try every valid split point m for the p-th substring s[m..i-1]
                for (int m = 2 * (p - 1); m <= i - 2; m++) {
                    if (dp[m][p - 1] != INF) {
                        dp[i][p] = Math.min(dp[i][p], dp[m][p - 1] + cost[m][i - 1]);
                    }
                }
            }
        }

        return dp[n][k];
    }

    private int getSemiPalindromeCost(String s, int start, int end, List<Integer> divs) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;

        for (int d : divs) {
            int changes = 0;
            // Check each of the d interleaved sequences
            for (int offset = 0; offset < d; offset++) {
                int left = start + offset;
                int right = end - (d - 1 - offset);
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}
