class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        
        // Find the absolute minimum and maximum characters
        char minChar = s.charAt(0);
        char maxChar = s.charAt(0);
        
        for (int i = 1; i < n; i++) {
            char curr = s.charAt(i);
            if (curr < s.charAt(i - 1)) {
                isSorted = false;
            }
            if (curr < minChar) {
                minChar = curr;
            }
            if (curr > maxChar) {
                maxChar = curr;
            }
        }
        
        // Case 0: Already sorted
        if (isSorted) {
            return 0;
        }
        
        // Case -1: Size 2 and out of order (can't select whole string)
        if (n == 2) {
            return -1;
        }
        
        // Case 1: An extreme character is already in its perfect corner home
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        // Case 2: Either an absolute minimum or maximum character exists 
        // somewhere in the middle segment of the string.
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == minChar || s.charAt(i) == maxChar) {
                return 2;
            }
        }
        
        // Case 3: The worst case scenario (e.g., s = "dbca")
        // minChar is stuck at the end AND maxChar is stuck at the beginning.
        return 3;
    }
}
