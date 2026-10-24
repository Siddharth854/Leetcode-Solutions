class Solution {
    // Days in each month for a non-leap year
    private final int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Convert all date strings into day-of-year integers
        int startA = convertToDayOfYear(arriveAlice);
        int endA = convertToDayOfYear(leaveAlice);
        int startB = convertToDayOfYear(arriveBob);
        int endB = convertToDayOfYear(leaveBob);

        // Find the overlap interval between Alice's and Bob's stay
        int overlapStart = Math.max(startA, startB);
        int overlapEnd = Math.min(endA, endB);

        // Calculate overlapping days; if no overlap, return 0
        return Math.max(0, overlapEnd - overlapStart + 1);
    }

    private int convertToDayOfYear(String date) {
        // Parse the month and day from the "MM-DD" formatted string
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayCount = 0;
        // Sum up days of all full months before the target month
        for (int i = 0; i < month - 1; i++) {
            dayCount += months[i];
        }
        
        // Add the days of the current month
        return dayCount + day;
    }
}
