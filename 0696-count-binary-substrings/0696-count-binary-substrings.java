class Solution {
    public int countBinarySubstrings(String s) {
        int prevGroup = 0;
        int currentGroup = 1;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentGroup++;
            } else {
                result += Math.min(prevGroup, currentGroup);
                prevGroup = currentGroup;
                currentGroup = 1;
            }
        }

        result += Math.min(prevGroup, currentGroup);
        return result;
    }
}
