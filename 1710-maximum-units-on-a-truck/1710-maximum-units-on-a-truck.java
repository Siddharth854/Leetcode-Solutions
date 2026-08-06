import java.util.*;

class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        // Sort by units per box (descending)
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {

            int boxesTaken = Math.min(truckSize, boxTypes[i][0]);

            totalUnits += boxesTaken * boxTypes[i][1];

            truckSize -= boxesTaken;
        }

        return totalUnits;
    }
}