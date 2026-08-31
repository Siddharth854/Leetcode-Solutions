/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {

            // Check local maximum or local minimum
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                // First critical point
                if (first == -1) {
                    first = index;
                }

                // Calculate distance from previous critical point
                if (last != -1) {
                    minDistance = Math.min(minDistance, index - last);
                }

                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == last) {
            return ans;
        }

        int maxDistance = last - first;

        return new int[]{minDistance, maxDistance};
    }
}