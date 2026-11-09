import java.util.Arrays;
class Solution {
    public int minMoves2(int[] nums) {
        // Step 1: Sort the array to easily find the median
        Arrays.sort(nums);
        
        // Step 2: Identify the median element
        int median = nums[nums.length / 2];
        int moves = 0;
        
        // Step 3: Calculate total moves by summing the absolute differences
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }
}
