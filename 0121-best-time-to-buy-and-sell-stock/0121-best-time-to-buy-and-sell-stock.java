class Solution {
    public int maxProfit(int[] prices) {

        int min_Price = prices[0];
        int max_Profit = 0;

        for(int i=1;i<prices.length;i++)
        {
            min_Price = Math.min(min_Price,prices[i]);
            int profit = prices[i] - min_Price;
            max_Profit = Math.max(max_Profit,profit);
        }        
        return max_Profit;
    }
}
