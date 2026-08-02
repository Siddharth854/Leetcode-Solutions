class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        int ans = arr[0];
        for(int i=1;i<n;i++)
        {
                    int temp = max;
            max = Math.max(arr[i] , Math.max(max * arr[i] , min * arr[i]));
            min = Math.min(arr[i] , Math.min(temp * arr[i], min * arr[i]));
            ans = Math.max(ans , max);
        }
        return ans;
    }
}
