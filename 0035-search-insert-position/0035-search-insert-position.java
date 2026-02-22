class Solution {
    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;        // Found
            }
            else if (nums[mid] < target) {
                low = mid + 1;     // Search right
            }
            else {
                high = mid - 1;    // Search left
            }
        }

        return low;  // Insertion position
    }
}