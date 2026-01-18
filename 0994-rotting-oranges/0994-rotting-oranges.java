class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int minutes = 0;

        while (true) {
            boolean changed = false;

            // Step 1: Mark fresh oranges that will rot
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        if ((i > 0 && grid[i - 1][j] == 2) ||
                            (i < row - 1 && grid[i + 1][j] == 2) ||
                            (j > 0 && grid[i][j - 1] == 2) ||
                            (j < col - 1 && grid[i][j + 1] == 2)) {

                            grid[i][j] = 3; // will rot next minute
                            changed = true;
                        }
                    }
                }
            }

            // If no oranges rotted this minute
            if (!changed) break;

            // Step 2: Convert all 3 → 2
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }
                }
            }

            minutes++;
        }

        // Step 3: Check for remaining fresh oranges
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}
