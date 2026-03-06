import java.util.Stack;
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek() == ch)
            {
                st.pop();
            } else
            {
                st.push(ch);
            }
        }
        String ans = "";

        for(int i = 0; i < st.size(); i++)
        {
            ans += st.get(i);
        }
        return ans;
    }
}