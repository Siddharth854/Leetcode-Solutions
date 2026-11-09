class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m+n];
        int i=0,j=0,k=0;
        while(i < m && j<n)
        {
            if(nums1[i] <= nums2[j])
            {
                ans[k] = nums1[i];
                i++;
                k++;
            } else 
            {
                ans[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i < m)
        {
            ans[k++] = nums1[i++];
        }
        
        while(j < n)
        {
            ans[k++] = nums2[j++];
        }
        int size = m + n;
        if(size %2 != 0)
        {
            return ans[size/2];
        }
        else
        {
            return (ans[size/2-1]+ans[size/2])/2.0;
        }
    }
}