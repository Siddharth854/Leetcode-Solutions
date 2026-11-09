class Solution {
    public int minMoves(int[] nums) {
        // Calculate the sum of all elements in the array
        int sum = Arrays.stream(nums).sum();
        int minValue = Arrays.stream(nums).min().getAsInt();
        int minMoves = sum - minValue * nums.length;
      
        return minMoves;
    }
}
