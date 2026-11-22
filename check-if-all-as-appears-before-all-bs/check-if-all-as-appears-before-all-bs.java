class Solution {
    public boolean checkString(String s) {
        boolean seenB = false;
        
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                seenB = true;
            } else if (seenB) { 
                // Found an 'a' after already seeing a 'b'
                return false;
            }
        }
        
        return true;
    }
}