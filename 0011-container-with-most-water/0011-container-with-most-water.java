class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int area = 0, length, width;
        while(left < right)
        {
            width = right - left;
            length = Math.min(height[right],height[left]);
            area = Math.max(area, length*width);
            if(height[left]<height[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
}