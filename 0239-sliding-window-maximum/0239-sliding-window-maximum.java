import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove elements outside the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Record max once window reaches size k
            if (i >= k - 1) {
                result[index++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}