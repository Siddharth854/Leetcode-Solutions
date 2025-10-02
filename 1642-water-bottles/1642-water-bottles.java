class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int empty_WB = numBottles;
        while(empty_WB >= numExchange)
        {
            int new_WB = (empty_WB / numExchange);
            result = result + new_WB;
            empty_WB = new_WB + (empty_WB % numExchange);
        }
        return result;
    }
}
