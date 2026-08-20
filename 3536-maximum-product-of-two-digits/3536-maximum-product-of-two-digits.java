class Solution {
    public int maxProduct(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        Arrays.sort(nums);
        int len = nums.length;
        int max_1 = nums[len-1]-'0';
        int max_2 = nums[len-2]-'0';
        return max_1 * max_2;
    }
}
