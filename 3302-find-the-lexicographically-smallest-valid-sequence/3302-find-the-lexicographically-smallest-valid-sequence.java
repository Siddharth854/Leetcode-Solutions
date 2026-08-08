import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = the position in word1 where word2[j]
        // can be matched while still matching word2[j+1...]
        int[] last = new int[m];

        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        // Build last[]
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // We are allowed to use one mismatch
        boolean mismatchAvailable = true;

        j = 0;

        for (i = 0; i < n && j < m; i++) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Use our one mismatch
            else if (mismatchAvailable) {

                /*
                 * We can use i as a mismatch if:
                 *
                 * 1. This is the last character of word2
                 *    OR
                 *
                 * 2. The next character of word2 can still
                 *    be matched after i.
                 */
                if (j == m - 1 || i < last[j + 1]) {

                    ans[j] = i;
                    j++;

                    mismatchAvailable = false;
                }
            }
        }

        // Could not construct the complete sequence
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}