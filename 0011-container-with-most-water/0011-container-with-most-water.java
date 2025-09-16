class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int area = 0;
        int lp = 0, rp = height.length-1;
        while(lp < rp)
        {
            int width = rp - lp;
            int length = Math.min(height[lp],height[rp]);
            int curr_water = width * length;
            area = Math.max(area,curr_water);
            if(height[lp]<height[rp])
            {
                lp++;
            }else{
                rp--;
            }
        }
        return area;        
    }
}