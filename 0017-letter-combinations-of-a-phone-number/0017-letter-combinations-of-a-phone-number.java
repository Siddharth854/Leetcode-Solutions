class Solution {
    String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        possibleWords(digits, "");
        return result;
    }
    void possibleWords(String s, String ans) {
        if (s.length() == 0) {
            result.add(ans);
            return;
        }
        String key = keypad[s.charAt(0) - 48];
        for (int i = 0; i < key.length(); i++) {
            possibleWords(s.substring(1), ans + key.charAt(i));
        }
    }
}
