class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] count = new int[26];

        // Count characters of s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Find how much of target can be matched
        int matched = 0;

        while (matched < n) {
            int c = target.charAt(matched) - 'a';

            if (count[c] == 0) {
                break;
            }

            count[c]--;
            matched++;
        }

        // Case 1:
        // We could not match target completely.
        // Try making the answer greater at the first mismatch.
        if (matched < n) {

            int current = target.charAt(matched) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Equal prefix
                    ans.append(target, 0, matched);

                    // Make it greater
                    ans.append((char) ('a' + c));
                    count[c]--;

                    // Smallest possible suffix
                    for (int x = 0; x < 26; x++) {
                        while (count[x] > 0) {
                            ans.append((char) ('a' + x));
                            count[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        // Case 2:
        // Target prefix cannot be increased at the mismatch.
        // Backtrack to find an earlier position to increase.
        for (int i = matched - 1; i >= 0; i--) {

            // Restore target[i] to available characters
            int current = target.charAt(i) - 'a';
            count[current]++;

            // Find the smallest character greater than target[i]
            for (int c = current + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Prefix remains equal to target
                    ans.append(target, 0, i);

                    // Make this position greater
                    ans.append((char) ('a' + c));
                    count[c]--;

                    // Fill remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (count[x] > 0) {
                            ans.append((char) ('a' + x));
                            count[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}