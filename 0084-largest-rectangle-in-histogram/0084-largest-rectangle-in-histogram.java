class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];

        //calculate next smaller element
        st.push(n-1);
        nse[n-1] = n;
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            if(st.size()==0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        
        // System.out.println("The Next Smaller Elements (NSE) are: ");
        // for(int i=0;i<n;i++)
        // System.out.print(nse[i]+" ");
        // System.out.println();

        //Emptying Stack//
        while(st.size()>0) st.pop();
        
        //calculate pse[]
        st.push(0);
        pse[0] = -1;
        for(int i=1;i<=n-1;i++)
        {
            while(st.size()>0 && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }
            if(st.size()==0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);        }
        // System.out.println("The Previous Smaller Elements (PSE) are: ");
        // for(int i=0;i<n;i++)
        // {System.out.print(pse[i]+" ");}
        // System.out.println();

        // maximum area of Rectangle //
        int max = -1;
        for(int i=0;i<n;i++)
        {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max,area);
        }
            return max;
    }
}