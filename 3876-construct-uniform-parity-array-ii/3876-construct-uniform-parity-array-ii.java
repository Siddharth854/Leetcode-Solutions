class Solution {
    public boolean uniformArray(int[] nums1) {

        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num : nums1) {

            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            } else {
                minOdd = Math.min(minOdd, num);
            }
        }

        // All numbers are already even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Otherwise, try to make all numbers odd
        return minOdd < minEven;
    }
}