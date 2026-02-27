class Solution {
    public String convert(String s, int numRows) {
        String[] ans = new String[numRows];
        for(int i=0; i<numRows; i++)
        {
            ans[i] = "";
        }
        int i = 0;
        while( i < s.length())
        {
            // vertical printing
            for(int index=0; index < numRows && i < s.length(); index++)
            {
                ans[index] = ans[index] + s.charAt(i++);
            }
            // diagonal printing
            for(int index = numRows-2; index > 0 && i < s.length();index--)
            {
                ans[index] = ans[index] + s.charAt(i++);
            }
        }
        String res = "";
        for(String row : ans)
        {
            res = res + row;
        }
        return res;
    }
}