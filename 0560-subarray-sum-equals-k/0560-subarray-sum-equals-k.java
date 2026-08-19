import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cps = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num: nums)
        {
            cps+=num;
            int target = cps - k;
            if(map.containsKey(target))
            {
                count+=map.get(target);
            }
            map.put(cps,map.getOrDefault(cps,0)+1);
        }
        return count;
    }
}