class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        
        // Sized to n to avoid overflow if all elements go into one array
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        // Seed initial elements
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        
        // Pointers tracking the size / next free index of each array
        int size1 = 1;
        int size2 = 1;
        
        // Process remaining elements starting from index 2
        for (int i = 2; i < n; i++) {
            // Compare the LAST inserted elements in both arrays
            if (arr1[size1 - 1] > arr2[size2 - 1]) {
                arr1[size1] = nums[i];
                size1++;
            } else {
                arr2[size2] = nums[i];
                size2++;
            }
        }
        
        // Combine arr1 and arr2 into the result array
        int[] result = new int[n];
        int index = 0;
        
        for (int i = 0; i < size1; i++) {
            result[index++] = arr1[i];
        }
        for (int i = 0; i < size2; i++) {
            result[index++] = arr2[i];
        }
        
        return result;
    }
}