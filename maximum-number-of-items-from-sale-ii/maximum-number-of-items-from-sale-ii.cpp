class Solution {
    #define ll long long
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int n=items.size();

        //Step-1: Find cheapest and max_factor O(N)
        int cheapest = INT_MAX;
        int max_factor = INT_MIN;
        for(int i=0;i<n;++i){
            cheapest = min(cheapest,items[i][1]);
            max_factor = max(max_factor,items[i][0]);
        }

        //Step-2: Calculate count of multiples for each factor O(MlogM)
        vector<int> freq(max_factor+1);//Create frequency counter for each factor
        for(int i=0;i<n;++i)
            freq[items[i][0]]++;
        for(int i=1;i<=max_factor;++i){
            if(freq[i]>0){
                for(int index=2*i;index<=max_factor;index+=i)
                    freq[i] += freq[index];
            }
        }

        //Step-3: Iterate for each item and check if including it is profitable over the cheapest ?
        map<ll,ll> cost_count;//Ordered based on increasing price
        for(int i=0;i<n;++i){
            int cost = items[i][1];
            int count = freq[items[i][0]]-1;
            if(count>0 and cost<=2*cheapest)
                cost_count[cost] += count;
        }
        //Step-4: Get total count of books by including optimally
        int total = 0;
        for(auto &[cost,count]: cost_count){
            int include = min<ll>(count,budget/cost);
            total += 2*include;
            budget -= include * cost;
        }
        total += budget/cheapest;//Leftover budget goes to cheapest book
        return total;
    }
};
/*
#JAVA
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Step 1: Find cheapest and max_factor
        int cheapest = Integer.MAX_VALUE;
        int maxFactor = Integer.MIN_VALUE;

        for (int[] item : items) {
            cheapest = Math.min(cheapest, item[1]);
            maxFactor = Math.max(maxFactor, item[0]);
        }

        // Step 2: Calculate count of multiples for each factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        for (int i = 1; i <= maxFactor; i++) {
            if (freq[i] > 0) {
                for (int multiple = 2 * i; multiple <= maxFactor; multiple += i) {
                    freq[i] += freq[multiple];
                }
            }
        }

        // Step 3: Collect profitable pair opportunities
        TreeMap<Long, Long> costCount = new TreeMap<>();

        for (int[] item : items) {
            int cost = item[1];
            int count = freq[item[0]] - 1;

            if (count > 0 && cost <= 2L * cheapest) {
                costCount.put(
                    (long) cost,
                    costCount.getOrDefault((long) cost, 0L) + count
                );
            }
        }

        // Step 4: Buy optimally
        int total = 0;

        for (Map.Entry<Long, Long> entry : costCount.entrySet()) {
            long cost = entry.getKey();
            long count = entry.getValue();

            long include = Math.min(count, budget / cost);

            total += (int) (2 * include);
            budget -= (int) (include * cost);
        }

        total += budget / cheapest;

        return total;
    }
}

#Python
from collections import defaultdict

class Solution:
    def maximumSaleItems(self, items: List[List[int]], budget: int) -> int:
        n = len(items)

        # Step 1: Find cheapest and max_factor
        cheapest = min(cost for _, cost in items)
        max_factor = max(factor for factor, _ in items)

        # Step 2: Calculate count of multiples for each factor
        freq = [0] * (max_factor + 1)

        for factor, _ in items:
            freq[factor] += 1

        for i in range(1, max_factor + 1):
            if freq[i] > 0:
                multiple = 2 * i
                while multiple <= max_factor:
                    freq[i] += freq[multiple]
                    multiple += i

        # Step 3: Collect profitable pair opportunities
        cost_count = defaultdict(int)

        for factor, cost in items:
            count = freq[factor] - 1

            if count > 0 and cost <= 2 * cheapest:
                cost_count[cost] += count

        # Step 4: Buy optimally
        total = 0

        for cost in sorted(cost_count):
            count = cost_count[cost]

            include = min(count, budget // cost)

            total += 2 * include
            budget -= include * cost

        total += budget // cheapest

        return total
*/