class Solution {
    public int distinctSubseqII(String s) {

        long MOD = 1000000007;

        long[] end = new long[26];

        for (char c : s.toCharArray()) {

            int idx = c - 'a';

            long total = 1;

            for (long x : end) {
                total += x;
            }

            end[idx] = total % MOD;
        }

        long ans = 0;

        for (long x : end) {
            ans += x;
        }

        return (int) (ans % MOD);
    }
}