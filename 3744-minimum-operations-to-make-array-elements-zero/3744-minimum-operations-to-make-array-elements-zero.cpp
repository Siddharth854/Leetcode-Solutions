class Solution {
public:
    long long minOperations(vector<vector<int>>& queries) {
        typedef long long LL;
        LL ans = 0;
        for(auto &it: queries) {
            int L = it[0], R = it[1];
            LL tmp = 0, vL = 1, vR = 4; // [vL, vR)
            for(int i = 1; vL <= R; ++i, vL = vR, vR <<= 2) {
                int qL = max((LL)L, vL), qR = min(R + 1LL, vR);
                if(qL < qR)
                    tmp += (qR - qL) * (LL)i;
            }
            ans += (tmp + 1) >> 1;
        }
        return ans;
    }
};