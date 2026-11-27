class Solution {
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int n = items.size();
        vector<int> frees(n, 0);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    ++frees[i];
                }
            }
        }

        vector<int> dp(budget + 1, 0);
        for (int i = 0; i < n; ++i) {
            int cost = items[i][1];
            int freeCount = frees[i];

            // First copy (0/1 transition): includes free copies
            for (int b = budget; b >= cost; --b) {
                dp[b] = max(dp[b], dp[b - cost] + 1 + freeCount);
            }

            // Additional copies (unbounded transition): 1 item per copy
            for (int b = cost; b <= budget; ++b) {
                dp[b] = max(dp[b], dp[b - cost] + 1);
            }
        }

        return dp[budget];
    }
};
