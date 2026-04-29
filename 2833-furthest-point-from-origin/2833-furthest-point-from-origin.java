class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int pos1 = 0; // treat '_' as L
        int pos2 = 0; // treat '_' as R

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                pos1--;
                pos2--;
            } else if (c == 'R') {
                pos1++;
                pos2++;
            } else {
                // '_' case
                pos1--; // assume L
                pos2++; // assume R
            }
        }

        return Math.max(Math.abs(pos1), Math.abs(pos2));
    }
}