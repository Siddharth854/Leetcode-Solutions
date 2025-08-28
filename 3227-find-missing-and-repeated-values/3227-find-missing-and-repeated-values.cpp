class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        vector<int> ans;
        unordered_set<int> s;
        int n = grid.size();
        int a = -1, b = -1;
        int expSum = 0, actualSum = 0;
        int expectedSum = (n * n * (n * n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                actualSum += num;

                if (s.find(num) != s.end()) {
                    a = num;
                } else {
                    s.insert(num);
                }
            }
        }
        b = expectedSum - actualSum + a;

        ans.push_back(a);
        ans.push_back(b);

        return ans;
    }
};
