import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];

        // store last occurrence of each character
        for(int i = 0; i < s.length(); i++)
        {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(visited[ch - 'a'])
                continue;

            while(!st.isEmpty() && 
                ch < st.peek() && 
                lastIndex[st.peek() - 'a'] > i)
            {
                visited[st.pop() - 'a'] = false;
            }

            st.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for(char c : st)
            ans.append(c);

        return ans.toString();
    }
}