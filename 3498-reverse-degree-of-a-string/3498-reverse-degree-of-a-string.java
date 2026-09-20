class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            // 'a' = 26, 'b' = 25, ..., 'z' = 1
            final int reversePos = 26 - (s.charAt(i) - 'a');
            
            // i is 0-indexed, so the 1-based string position is (i + 1)
            ans += reversePos * (i + 1);
        }
        
        return ans;
    }
}
