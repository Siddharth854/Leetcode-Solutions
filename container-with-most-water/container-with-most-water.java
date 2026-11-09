width = right - left;
            length = Math.min(height[right],height[left]);
            area = Math.max(area, length*width);
            if(height[left]<height[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        int area = 0, length, width;
        while(left < right)
        {
        int n = height.length;
        int left = 0, right = n-1;
class Solution {
    public int maxArea(int[] height) {