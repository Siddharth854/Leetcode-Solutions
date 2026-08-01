class Solution {
    private int start = 0;
    private int maxLength = 1;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(start,start+maxLength);
    }
    public void expand(String s, int left, int right)
    {
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            if(right-left+1>maxLength)
            {
                maxLength = right-left+1;
                start = left;
            }
        left--;
        right++;
        }
    }
}