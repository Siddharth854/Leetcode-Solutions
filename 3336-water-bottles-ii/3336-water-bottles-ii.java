class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        int emptyWB = numBottles;
        while(emptyWB >= numExchange)
        {
            emptyWB = emptyWB - numExchange;
            numExchange = numExchange +1;
            result = result + 1;
            emptyWB = emptyWB + 1;
        }
        return result;
    }
}