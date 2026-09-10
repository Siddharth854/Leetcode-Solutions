/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Array to store the final answer globally or wrap it inside the class
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        matchingNodesCount = 0; // Reset for multiple test cases
        calculateSubtreeStats(root);
        return matchingNodesCount;
    }

    // Helper method returns int[] where:
    // index 0 -> Subtree Sum
    // index 1 -> Subtree Node Count
    private int[] calculateSubtreeStats(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // Base case: {sum, count}
        }

        // 1. Bottom-up post-order traversal
        int[] leftStats = calculateSubtreeStats(node.left);
        int[] rightStats = calculateSubtreeStats(node.right);

        // 2. Aggregate current subtree data
        int currentSum = node.val + leftStats[0] + rightStats[0];
        int currentCount = 1 + leftStats[1] + rightStats[1];

        // 3. Check matching condition (Java integer division automatically rounds down)
        if (currentSum / currentCount == node.val) {
            matchingNodesCount++;
        }

        // 4. Pass data up to the parent
        return new int[]{currentSum, currentCount};
    }
}