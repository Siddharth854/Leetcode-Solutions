class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Return true only if rec2 is NOT completely to the left, 
        // right, below, or above rec1.
        return !(rec2[2] <= rec1[0] || // rec2 is completely to the left
                 rec2[0] >= rec1[2] || // rec2 is completely to the right
                 rec2[3] <= rec1[1] || // rec2 is completely below
                 rec2[1] >= rec1[3]);  // rec2 is completely above
    }
}
