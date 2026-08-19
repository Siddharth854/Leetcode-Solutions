import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map: row number -> bitmask of reserved seats (bits 2 through 9)
        Map<Integer, Integer> rowMasks = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Ignore seats 1 and 10 as they don't affect 4-person blocks
            if (col >= 2 && col <= 9) {
                rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Start assuming all n rows fit 2 groups
        int maxGroups = 2 * n;

        // Bitmasks representing seat availability (1 << col)
        int leftMask   = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5); // Seats 2, 3, 4, 5
        int rightMask  = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9); // Seats 6, 7, 8, 9
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7); // Seats 4, 5, 6, 7

        for (int mask : rowMasks.values()) {
            boolean leftAvailable = (mask & leftMask) == 0;
            boolean rightAvailable = (mask & rightMask) == 0;

            if (leftAvailable && rightAvailable) {
                // Both blocks fit -> no reduction needed
                continue;
            } else if (leftAvailable || rightAvailable || (mask & middleMask) == 0) {
                // Only 1 group fits (either Left, Right, or Middle)
                maxGroups -= 1;
            } else {
                // No group can fit in this row
                maxGroups -= 2;
            }
        }

        return maxGroups;
    }
}