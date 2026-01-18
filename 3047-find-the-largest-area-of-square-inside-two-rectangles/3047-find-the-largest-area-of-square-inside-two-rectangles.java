class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Compute intersection of rectangles i and j
                int x1 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int x2 = Math.min(topRight[i][0], topRight[j][0]);
                int y1 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int y2 = Math.min(topRight[i][1], topRight[j][1]);
                
                // Check if intersection exists
                if (x1 < x2 && y1 < y2) {
                    int width = x2 - x1;
                    int height = y2 - y1;
                    int side = Math.min(width, height);
                    maxSide = Math.max(maxSide, side);
                }
            }
        }
        
        return maxSide * maxSide;
    }
}