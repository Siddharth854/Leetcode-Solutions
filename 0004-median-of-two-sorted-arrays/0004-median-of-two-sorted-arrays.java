class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m + n];
        double sum=0;

         int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merge[k] = nums1[i];
                k++;
                i++;
            } else {
                merge[k] = nums2[j];
                k++;
                j++;
            }
        }

        while (i < m) {
            merge[k++] = nums1[i++];
        }

        while (j < n) {
            merge[k++] = nums2[j++];
        }

        int size = m + n;

        if (size % 2 != 0) {
            return merge[size / 2];
        } else {
            return (merge[size / 2 - 1] + merge[size / 2]) / 2.0;
        }

    }
}